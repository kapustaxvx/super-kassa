package com.sk.superkassa.controller;

import com.sk.superkassa.model.dto.ModifyRequest;
import com.sk.superkassa.model.dto.Value;
import com.sk.superkassa.service.ElementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping()
public class ElementController {
    private final ElementService elementService;

    public ElementController(ElementService elementService) {
        this.elementService = elementService;
    }

    @PostMapping(value = "/modify")
    public ResponseEntity<Value> modifyValue (@RequestBody ModifyRequest request) throws Exception {
        return ok().body(elementService.modifyValue(request));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Value> get(@PathVariable("id") Long id){
        return ok().body(elementService.getById(id));
    }
}
