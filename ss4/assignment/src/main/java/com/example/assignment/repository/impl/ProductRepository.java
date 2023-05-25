package com.example.assignment.repository.impl;

import com.example.assignment.model.Product;
import com.example.assignment.repository.BaseRepository;
import com.example.assignment.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository implements IProductRepository {
//    static List<Product> productList = new ArrayList<>();
//
//    static {
//        productList.add(new Product(1, "Trà sữa Olong", 50.0, "ngon lắm đó mọi người ơi, best seller của quán em đọ", "GongChaTea"));
//        productList.add(new Product(2, "Trà sữa Jasmine Tea", 40.0, "ngon lắm đó mọi người ơi, best seller của quán em đọ", "GongChaTea"));
//    }

    @Override
    public List<Product> getList() {
        List<Product> productLists = BaseRepository.entityManager.createQuery("select p from Product p", Product.class).getResultList();

        return productLists;
    }

    @Override
    public boolean save(Product product) {
        boolean check = true;
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
        return check;
    }

    @Override
    public boolean update(Product product) {
        boolean check = true;
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
        return check;
    }

    @Override
    public boolean delete(Integer id) {
        boolean check = true;
        Product product = findById(id);
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(product);
        transaction.commit();
        return check;
    }

    @Override
    public Product findById(Integer id) {
        Product product = BaseRepository.entityManager.find(Product.class,id);
        return product;
    }

    @Override
    public List<Product> search(String search) {
        List<Product> productLists = BaseRepository.entityManager.createQuery("select p from Product p where p.name like : searchs ", Product.class).setParameter("searchs", '%' + search + '%').getResultList();
        return productLists;
    }
}
