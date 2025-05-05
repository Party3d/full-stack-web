package com.exemplo.app.service;

import com.exemplo.app.dto.ItemDTO;
import com.exemplo.app.model.Item;
import com.exemplo.app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    private ItemDTO toDTO(Item item) {
        ItemDTO dto = new ItemDTO();
        dto.setId(item.getId());
        dto.setNome(item.getNome());
        dto.setDescricao(item.getDescricao());
        return dto;
    }

    private Item fromDTO(ItemDTO dto) {
        Item item = new Item();
        item.setId(dto.getId());
        item.setNome(dto.getNome());
        item.setDescricao(dto.getDescricao());
        return item;
    }

    public List<ItemDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<ItemDTO> findById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    public ItemDTO create(ItemDTO dto) {
        Item item = fromDTO(dto);
        return toDTO(repository.save(item));
    }

    public Optional<ItemDTO> update(Long id, ItemDTO dto) {
        return repository.findById(id).map(existing -> {
            existing.setNome(dto.getNome());
            existing.setDescricao(dto.getDescricao());
            return toDTO(repository.save(existing));
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}