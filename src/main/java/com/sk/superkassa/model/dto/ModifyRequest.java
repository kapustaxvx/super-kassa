package com.sk.superkassa.model.dto;

public class ModifyRequest {

    private Long id;
    private Long add;

    public ModifyRequest() {
    }

    public ModifyRequest(Long id, Long add) {
        this.id = id;
        this.add = add;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdd() {
        return add;
    }

    public void setAdd(Long add) {
        this.add = add;
    }
}
