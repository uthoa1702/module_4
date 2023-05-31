package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BookRenting;
import com.example.ung_dung_muon_sach.service.IBookService;
import com.example.ung_dung_muon_sach.service.IRentalBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller

public class RentalBookController {
    @Autowired
    private IRentalBookService iRentalBookService;
    @Autowired
    private IBookService iBookService;

    @GetMapping("/")
    public String books(Model model) {
        List<Book> books = iBookService.getList();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/rent/{id}")
    public String rent(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {

        Book book1 = iBookService.findById(id);
        book1.setQuantity(book1.getQuantity() - 1);
        iBookService.save(book1);
        int rentCode;
        List<BookRenting> bookRentings = iRentalBookService.getList();
        boolean check;
        do {
            check = true;
            rentCode = getRandomNumber(10000, 99999);

            for (int i = 0; i < bookRentings.size(); i++) {
                if (bookRentings.get(i).getRentCode() == rentCode) {
                    check = false;
                }
            }
        } while (!check);


        BookRenting bookRenting = new BookRenting(rentCode, book1);
        iRentalBookService.save(bookRenting);
        model.addAttribute("rentCode", bookRenting.getRentCode());
        return "rent-information";
    }

    @GetMapping("/rentList")
    public String rentList(Model model) {
        List<BookRenting> bookRentings = iRentalBookService.getList();
        model.addAttribute("bookRenting", bookRentings);
        return "renting-list";
    }

    @GetMapping("/return/{id}")
    public String returnBook(@PathVariable("id") Integer id) {
        BookRenting bookRenting = iRentalBookService.findById(id);
        Book book = bookRenting.getBook();
        book.setQuantity(book.getQuantity() + 1);
        iBookService.save(book);

        iRentalBookService.returnBook(id);

        return "redirect:/rentList";


    }

    @ExceptionHandler({Exception.class})
    public String error() {
        return "error";
    }


    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
