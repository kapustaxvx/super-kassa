package com.sk.superkassa.lock;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LocksProvider {
    private final Map<Long, AutoCloseableReentrantLock> modifyLocks = new HashMap<>();

    public AutoCloseableReentrantLock provideModifyLock(Long elementId){
        return modifyLocks.computeIfAbsent(elementId, id -> new AutoCloseableReentrantLock());
    }

}
