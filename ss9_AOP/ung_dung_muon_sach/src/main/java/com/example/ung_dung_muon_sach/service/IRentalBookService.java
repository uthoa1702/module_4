package com.example.ung_dung_muon_sach.service;


import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BookRenting;

import java.util.List;

public interface IRentalBookService {

    void save(BookRenting bookRenting);

    List<BookRenting> getList();

    BookRenting findById(Integer id);

    void returnBook(Integer id);

    int checkCode(List<BookRenting> bookRentings);
}
