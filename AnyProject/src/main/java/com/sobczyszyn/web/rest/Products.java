package com.sobczyszyn.web.rest;

import com.sobczyszyn.web.repos.Product;
import com.sobczyszyn.web.repos.SimpleProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/products")
public class Products {
    @Autowired
    private SimpleProductRepository products;

    //@PostConstruct
//    public void init() {
//        products.saveAndFlush(new Product("nam1").withDescription("description of product A"));
//        products.saveAndFlush(new Product("nam2").withDescription("description of product B"));
//    }

    @RequestMapping(method = GET)
    public List<Product> getAll() {
        return products.findAll();
    }

    @RequestMapping(method = GET, value = "{id}")
    public Product getById(@PathVariable("id") Integer id) {
        Product product = products.findOne(id);
        if (product == null) {
            throw new ProductNotFound(id);
        }
        return product;
    }
}
