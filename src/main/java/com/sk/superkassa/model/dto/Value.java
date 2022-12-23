package com.sk.superkassa.model.dto;

import java.util.concurrent.atomic.AtomicLong;

public class Value {
    private AtomicLong current;

    public Value() {
    }

    public Value(AtomicLong current) {
        this.current = current;
    }

    public AtomicLong getCurrent() {
        return current;
    }

    public void setCurrent(AtomicLong current) {
        this.current = current;
    }
}
