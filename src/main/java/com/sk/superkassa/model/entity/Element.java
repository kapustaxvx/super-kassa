package com.sk.superkassa.model.entity;

import com.sk.superkassa.model.dto.Value;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

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

    public Element() {
    }

    public Element(Long id, Value value) {
        this.id = id;
        this.value = value;
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
}
