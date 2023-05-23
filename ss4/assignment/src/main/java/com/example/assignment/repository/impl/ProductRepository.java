package com.example.assignment.repository.impl;

import com.example.assignment.model.Product;
import com.example.assignment.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository implements IProductRepository {
    static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Trà sữa Olong", 50.0,"ngon lắm đó mọi người ơi, best seller của quán em đọ","GongChaTea"));
        productList.add(new Product(2,"Trà sữa Jasmine Tea", 40.0,"ngon lắm đó mọi người ơi, best seller của quán em đọ","GongChaTea"));
    }

    @Override
    public List<Product> getList() {
        return productList;
    }

    @Override
    public boolean save(Product product) {
        boolean check = true;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId()==productList.get(i).getId()){
                check = false;
                break;
            }
        }
        if (check){
            productList.add(product);
        }
        return check;
    }

    @Override
    public boolean update(Product product) {
        boolean check = true;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId()==productList.get(i).getId()){
                productList.set(i,product);
                break;
            }else {
                check = false;
            }
        }
        return check;
    }

    @Override
    public boolean delete(Integer id) {
        boolean check = true;
        for (int i = 0; i < productList.size(); i++) {
            if (Objects.equals(id, productList.get(i).getId())){
                productList.remove(productList.get(i));
                check = true;
                break;
            }
            else {
                check=false;
            }
        }
        return check;
    }

    @Override
    public Product findById(Integer id) {
        Product product = new Product();
        for (int i = 0; i < productList.size(); i++) {
            if (Objects.equals(id, productList.get(i).getId())){
                product = productList.get(i);
            }
        }
        return product;
    }
}
