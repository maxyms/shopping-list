package com.skotarenko.shoppinglist.data.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skotarenko.shoppinglist.data.Item;

public interface ItemRepository extends MongoRepository<Item, String> {
    Item findOne(String id);

    void delete(String id);
}
