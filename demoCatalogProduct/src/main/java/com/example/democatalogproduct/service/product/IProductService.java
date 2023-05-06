package com.example.democatalogproduct.service.product;

import com.example.democatalogproduct.model.Catalog;
import com.example.democatalogproduct.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(int id,Product product);
    void deleteById(int id);
}
