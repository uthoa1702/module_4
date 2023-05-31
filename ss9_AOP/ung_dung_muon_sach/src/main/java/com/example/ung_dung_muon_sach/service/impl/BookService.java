package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.repository.IBookRepository;
import com.example.ung_dung_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public List<Book> getList() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void save(Book book1) {
        iBookRepository.save(book1);
    }
}
