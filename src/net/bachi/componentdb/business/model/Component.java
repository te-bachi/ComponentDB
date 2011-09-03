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
import java.util.List;

/**
 * @author Andreas Bachmann
 */
@Table(name = "component", catalog = "componentdb")
@Entity
public class Component implements Serializable {

    public Component() {

    }

    public Component(Category category, Manufacturer manufacturer, Distributor distributor, String partNumber, String name, String description, String place, short quantity) {
        this(category, manufacturer, distributor, partNumber, name, description, place, quantity, null, null);
    }

    public Component(Category category, Manufacturer manufacturer, Distributor distributor, String partNumber, String name, String description, String place, short quantity, List<AttributeValue> attributeValues, List<Attachment> attachments) {
        this.category = category;
        this.manufacturer = manufacturer;
        this.distributor = distributor;
        this.partNumber = partNumber;
        this.name = name;
        this.description = description;
        this.place = place;
        this.quantity = quantity;
        this.attributeValues = attributeValues;
        this.attachments = attachments;
    }

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
    @Column(name = "part_number")
    private String partNumber;

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
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

        Component component = (Component) o;

        if (id != component.id) return false;
        if (quantity != component.quantity) return false;
        if (description != null ? !description.equals(component.description) : component.description != null)
            return false;
        if (name != null ? !name.equals(component.name) : component.name != null) return false;
        if (partNumber != null ? !partNumber.equals(component.partNumber) : component.partNumber != null) return false;
        if (place != null ? !place.equals(component.place) : component.place != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (partNumber != null ? partNumber.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (int) quantity;
        return result;
    }

    @Override
    public String toString() {
        return "{ " + id + ", " + name + ", " + category.getName() + " }";
    }

    @ManyToOne
    @JoinColumn(name = "distributor_id", referencedColumnName = "id", nullable = false)
    private Distributor distributor;

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    @OneToMany(mappedBy = "component")
    private List<Price> prices;

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
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

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id", nullable = false)
    private Manufacturer manufacturer;

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @ManyToMany
    @JoinTable(
            name = "component_has_value",
            joinColumns = { @JoinColumn(name = "component_id") },
            inverseJoinColumns = { @JoinColumn(name = "attribute_value_id") }
    )
    private List<AttributeValue> attributeValues;

    public List<AttributeValue> getAttributeValues() {
        return this.attributeValues;
    }

    public void setAttributeValues(List<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }

    @ManyToMany
    @JoinTable(
            name = "component_has_attachment",
            joinColumns = { @JoinColumn(name = "component_id") },
            inverseJoinColumns = { @JoinColumn(name = "attachment_id") }
    )
    private List<Attachment> attachments;

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
