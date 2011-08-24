package net.bachi.componentdb.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Basic;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author Andreas Bachmann
 */
@Entity
@Table(name = "category", catalog = "componentdb")
public class Category implements Serializable {

    public Category() {
        //
    }

    public Category(String name) {
        this(null, name);
    }

    public Category(Category parentCategory, String name) {
        this.name = name;
        this.parentCategory = parentCategory;
    }

    @Id
    @Column(name = "id")
    @TableGenerator(name="auto", table="sequence", pkColumnName="seq_name", valueColumnName="seq_value", pkColumnValue="SEQ_CATEGORY")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category that = (Category) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Category parentCategory;

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    @OneToMany(mappedBy = "parentCategory")
    private Collection<Category> childCategories;

    public Collection<Category> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(Collection<Category> childCategories) {
        this.childCategories = childCategories;
    }

    @OneToMany(mappedBy = "category")
    private Collection<Component> components;

    public Collection<Component> getComponents() {
        return components;
    }

    public void setComponents(Collection<Component> components) {
        this.components = components;
    }
}
