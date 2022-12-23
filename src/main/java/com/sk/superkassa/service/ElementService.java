package com.sk.superkassa.service;

import com.sk.superkassa.model.dto.ModifyRequest;
import com.sk.superkassa.model.dto.Value;

public interface ElementService {
    Value modifyValue(ModifyRequest request) throws Exception;

    Value getById(Long id);
}
