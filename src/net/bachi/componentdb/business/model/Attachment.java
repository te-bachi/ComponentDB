package net.bachi.componentdb.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Basic;
import javax.persistence.ManyToMany;
import javax.persistence.Lob;
import javax.persistence.FetchType;
import javax.persistence.TableGenerator;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author Andreas Bachmann
 */
@Entity
@Table(name = "attachment", catalog = "componentdb")
public class Attachment implements Serializable {
    @Id
    @Column(name = "id")
    @TableGenerator(name="auto", table="sequence", pkColumnName="seq_name", valueColumnName="seq_value", pkColumnValue="SEQ_ATTACHMENT")
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
    @Column(name = "type")
    private byte type;
    
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "content_type")
    private String contentType;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "content")
    private byte[] content;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment that = (Attachment) o;

        if (id != that.id) return false;
        if (type != that.type) return false;
        if (!Arrays.equals(content, that.content)) return false;
        if (contentType != null ? !contentType.equals(that.contentType) : that.contentType != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) type;
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + (content != null ? Arrays.hashCode(content) : 0);
        return result;
    }

    @ManyToMany(mappedBy = "attachments")
    private List<Component> components;

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
