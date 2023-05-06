package com.example.democatalogproduct.service.catalog;

import com.example.democatalogproduct.model.Catalog;

import java.util.List;

public interface ICatalogService {
    List<Catalog> findAll();
    void save(Catalog catalog);
    Catalog findById(int id);
    void update(int id,Catalog catalog);
    void deleteById(int id);
}
