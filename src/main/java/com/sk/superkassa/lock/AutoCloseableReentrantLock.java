package com.sk.superkassa.lock;

import java.util.concurrent.locks.ReentrantLock;

public class AutoCloseableReentrantLock extends ReentrantLock implements AutoCloseable {
    public AutoCloseableReentrantLock open(){
        this.lock();
        return this;
    }

    @Override
    public void close() {
        this.unlock();
    }
}