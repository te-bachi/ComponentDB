package net.bachi.componentdb.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Basic;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.TableGenerator;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author Andreas Bachmann
 */
@Table(name = "component", catalog = "componentdb")
@Entity
public class Component implements Serializable {

    @Id
    @Column(name = "id")
    @TableGenerator(name="auto", table="sequence", pkColumnName="seq_name", valueColumnName="seq_value", pkColumnValue="SEQ_COMPONENT")
    @GeneratedValue(strategy= GenerationType.TABLE, generator="auto")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "manufacturer")
    private String manufacturer;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "place")
    private String place;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Basic
    @Column(name = "quantity")
    private short quantity;
    
    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Component that = (Component) o;

        if (id != that.id) return false;
        if (quantity != that.quantity) return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (place != null ? !place.equals(that.place) : that.place != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (int) quantity;
        return result;
    }

    @ManyToMany
    @JoinTable(
            name = "component_has_choice",
            joinColumns = { @JoinColumn(name = "component_id") },
            inverseJoinColumns = { @JoinColumn(name = "attribute_choice_id") }
    )
    private Collection<AttributeChoice> attributeChoices;

    public Collection<AttributeChoice> getAttributeChoices() {
        return attributeChoices;
    }

    public void setAttributeChoices(Collection<AttributeChoice> attributeChoices) {
        this.attributeChoices = attributeChoices;
    }

    @OneToMany(mappedBy = "component")
    private Collection<AttributeValue> attributeValues;

    public Collection<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(Collection<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToMany
    @JoinTable(
            name = "component_has_attachment",
            joinColumns = { @JoinColumn(name = "component_id") },
            inverseJoinColumns = { @JoinColumn(name = "attachment_id") }
    )
    private Collection<Attachment> attachments;

    public Collection<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Collection<Attachment> attachments) {
        this.attachments = attachments;
    }

    @ManyToMany
    @JoinTable(
            name = "component_has_group",
            joinColumns = { @JoinColumn(name = "component_id") },
            inverseJoinColumns = { @JoinColumn(name = "attribute_group_id") }
    )
    private Collection<AttributeGroup> attributeGroups;

    public Collection<AttributeGroup> getAttributeGroups() {
        return attributeGroups;
    }

    public void setAttributeGroups(Collection<AttributeGroup> attributeGroups) {
        this.attributeGroups = attributeGroups;
    }

    @OneToMany(mappedBy = "component")
    private Collection<PartNumber> partNumbers;

    public Collection<PartNumber> getPartNumbers() {
        return partNumbers;
    }

    public void setPartNumbers(Collection<PartNumber> partNumbers) {
        this.partNumbers = partNumbers;
    }
}
