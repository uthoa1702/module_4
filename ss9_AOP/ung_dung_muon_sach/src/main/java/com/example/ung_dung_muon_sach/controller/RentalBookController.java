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

import javax.transaction.Transactional;
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
@Transactional
    @GetMapping("/rent/{id}")
    public String rent(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {

        Book book1 = iBookService.findById(id);

        iRentalBookService.setQuantity(book1);
        iBookService.save(book1);

        int rentCode = iRentalBookService.getCode(iRentalBookService.getList());
//        List<BookRenting> bookRentings = iRentalBookService.getList();



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
@Transactional
    @GetMapping("/return/{id}")
    public String returnBook(@PathVariable("id") Integer id) {
        BookRenting bookRenting = iRentalBookService.findById(id);
        Book book = bookRenting.getBook();
        iRentalBookService.setQuantityforReturning(book);
//        book.setQuantity(book.getQuantity() + 1);
        iBookService.save(book);

        iRentalBookService.returnBook(id);

        return "redirect:/rentList";


    }

    @ExceptionHandler({Exception.class})
    public String error() {
        return "error";
    }



}
