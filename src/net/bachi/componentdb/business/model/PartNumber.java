package net.bachi.componentdb.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.TableGenerator;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author Andreas Bachmann
 */
@Entity
@Table(name = "part_number", catalog = "componentdb")
public class PartNumber implements Serializable {
    @Id
    @Column(name = "id")
    @TableGenerator(name="auto", table="sequence", pkColumnName="seq_name", valueColumnName="seq_value", pkColumnValue="SEQ_PART_NUMBER")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartNumber that = (PartNumber) o;

        if (id != that.id) return false;
        if (partNumber != null ? !partNumber.equals(that.partNumber) : that.partNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (partNumber != null ? partNumber.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "component_id", referencedColumnName = "id", nullable = false)
    private Component component;

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
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

    @OneToMany(mappedBy = "partNumber")
    private Collection<Price> prices;

    public Collection<Price> getPrices() {
        return prices;
    }

    public void setPrices(Collection<Price> prices) {
        this.prices = prices;
    }
}
