package net.bachi.componentdb.business.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author Andreas Bachmann
 */
@Entity
@Table(name = "attribute_choice", catalog = "componentdb")
public class AttributeChoice implements Serializable {

    public AttributeChoice() {
        //
    }

    public AttributeChoice(Attribute attribute, String choice) {
        this.attribute = attribute;
        this.choice = choice;
    }

    @Id
    @Column(name = "id")
    @TableGenerator(name="auto", table="sequence", pkColumnName="seq_name", valueColumnName="seq_value", pkColumnValue="SEQ_ATTRIBUTE_CHOICE")
    @GeneratedValue(strategy= GenerationType.TABLE, generator="auto")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "choice")
    private String choice;

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttributeChoice that = (AttributeChoice) o;

        if (id != that.id) return false;
        if (choice != null ? !choice.equals(that.choice) : that.choice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (choice != null ? choice.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "id", nullable = false)
    private Attribute attribute;

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    @ManyToMany(mappedBy = "attributeChoices")
    private Collection<Component> components;

    public Collection<Component> getComponents() {
        return components;
    }

    public void setComponent(Collection<Component> components) {
        this.components = components;
    }
}