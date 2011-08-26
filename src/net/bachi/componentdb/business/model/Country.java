package net.bachi.componentdb.business.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Andreas Bachmann
 */
@Entity
@Table(name = "country", catalog = "componentdb")
public class Country implements Serializable {

    public Country() {
        //
    }

    public Country(Currency currency, String name, byte[] flag, BigDecimal taxRate) {
        this.currency = currency;
        this.name = name;
        this.flag = flag;
        this.taxRate = taxRate;
    }

    @Id
    @Column(name = "id")
    @TableGenerator(name="auto", table="sequence", pkColumnName="seq_name", valueColumnName="seq_value", pkColumnValue="SEQ_COUNTRY")
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
    @Column(name = "flag")
    private byte[] flag;

    public byte[] getFlag() {
        return flag;
    }

    public void setFlag(byte[] flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "tax_rate")
    private BigDecimal taxRate;

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country that = (Country) o;

        if (id != that.id) return false;
        if (!Arrays.equals(flag, that.flag)) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (taxRate != null ? !taxRate.equals(that.taxRate) : that.taxRate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (flag != null ? Arrays.hashCode(flag) : 0);
        result = 31 * result + (taxRate != null ? taxRate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "currency_id", referencedColumnName = "id", nullable = false)
    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @OneToMany(mappedBy = "country")
    private List<Distributor> distributors;

    public List<Distributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(List<Distributor> distributors) {
        this.distributors = distributors;
    }
}
