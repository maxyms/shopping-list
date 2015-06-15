package com.skotarenko.shoppinglist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skotarenko.shoppinglist.data.Item;
import com.skotarenko.shoppinglist.data.db.ItemRepository;

@RestController
@RequestMapping("/api/items")
public class ItemRestController {
    @Autowired
    private ItemRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getAll() {
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Item get(@PathVariable String id) {
        return repo.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item create(@RequestBody Item contact) {
        return repo.save(contact);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Item update(@PathVariable String id, @RequestBody Item item) {
        Item update = repo.findOne(id);
        update.setName(item.getName());
        update.setPrice(item.getPrice());
        return repo.save(update);
    }
}