package com.exemplo.app.controller;

import com.exemplo.app.dto.ItemDTO;
import com.exemplo.app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/itens")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping
    public List<ItemDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ItemDTO getById(@PathVariable Long id) {
        return service.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }

    @PostMapping
    public ItemDTO create(@RequestBody ItemDTO item) {
        return service.create(item);
    }

    @PutMapping("/{id}")
    public ItemDTO update(@PathVariable Long id, @RequestBody ItemDTO item) {
        return service.update(id, item)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}