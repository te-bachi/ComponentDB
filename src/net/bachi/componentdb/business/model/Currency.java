package net.bachi.componentdb.business.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author Andreas Bachmann
 */
@Entity
@Table(name = "currency", catalog = "componentdb")
public class Currency implements Serializable {

    public Currency() {
        //
    }

    public Currency(String name, BigDecimal rate) {
        this.name = name;
        this.rate = rate;
    }


    @Id
    @Column(name = "id")
    @TableGenerator(name="auto", table="sequence", pkColumnName="seq_name", valueColumnName="seq_value", pkColumnValue="SEQ_CURRENCY")
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
    @Column(name = "rate")
    private BigDecimal rate;

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency that = (Currency) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "currency")
    private Collection<Country> countries;

    public Collection<Country> getCountries() {
        return countries;
    }

    public void setCountries(Collection<Country> countries) {
        this.countries = countries;
    }
}
