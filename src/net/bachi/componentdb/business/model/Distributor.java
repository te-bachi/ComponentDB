package net.bachi.componentdb.business.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Andreas Bachmann
 */
@Entity
@Table(name = "distributor", catalog = "componentdb")
public class Distributor implements Serializable {

    public Distributor() {
        //
    }

    public Distributor(Country country, String name, byte[] picture, boolean withTaxes) {
        this.country = country;
        this.name = name;
        this.picture = picture;
        this.withTaxes = withTaxes;
    }

    @Id
    @Column(name = "id")
    @TableGenerator(name="auto", table="sequence", pkColumnName="seq_name", valueColumnName="seq_value", pkColumnValue="SEQ_DISTRIBUTOR")
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
    @Column(name = "picture")
    private byte[] picture;

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "with_taxes")
    private boolean withTaxes;

    public boolean isWithTaxes() {
        return withTaxes;
    }

    public void setWithTaxes(boolean withTaxes) {
        this.withTaxes = withTaxes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Distributor that = (Distributor) o;

        if (id != that.id) return false;
        if (withTaxes != that.withTaxes) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (!Arrays.equals(picture, that.picture)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (picture != null ? Arrays.hashCode(picture) : 0);
        result = 31 * result + (withTaxes ? 1 : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "distributor")
    private Collection<PartNumber> partNumbers;

    public Collection<PartNumber> getPartNumbers() {
        return partNumbers;
    }

    public void setPartNumbers(Collection<PartNumber> partNumbers) {
        this.partNumbers = partNumbers;
    }
}
