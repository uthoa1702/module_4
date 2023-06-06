package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BookRenting;
import com.example.ung_dung_muon_sach.repository.IRentalBookRepository;
import com.example.ung_dung_muon_sach.service.IRentalBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalBookService implements IRentalBookService {
    @Autowired
    private IRentalBookRepository iRentalBookRepository;


    @Override
    public void save(BookRenting bookRenting) {
        iRentalBookRepository.save(bookRenting);
    }

    @Override
    public List<BookRenting> getList() {
        return iRentalBookRepository.findAll();
    }

    @Override
    public BookRenting findById(Integer id) {
        return iRentalBookRepository.findById(id).get();
    }

    @Override
    public void returnBook(Integer id) {
        iRentalBookRepository.deleteById(id);
    }

    @Override
    public int getCode(List<BookRenting> bookRentings) {
        boolean check;
        int rentCode;
        do {
            check = true;
            rentCode = getRandomNumber(10000, 99999);

            for (int i = 0; i < bookRentings.size(); i++) {
                if (bookRentings.get(i).getRentCode() == rentCode) {
                    check = false;
                }
            }
        } while (!check);
        return rentCode;
    }

    @Override
    public void setQuantity(Book book1) {
        book1.setQuantity(book1.getQuantity() -1);
    }

    @Override
    public void setQuantityforReturning(Book book) {
        book.setQuantity(book.getQuantity()+1);
    }


    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
