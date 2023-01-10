package com.sk.superkassa.model.entity;

import com.sk.superkassa.model.dto.Value;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sk_example_table")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Element {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type = "jsonb")
    @Column(name = "obj", columnDefinition = "jsonb")
    private Value value;
    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    public Element() {
    }

    public Element(Value value, Integer version) {
        this.value = value;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
