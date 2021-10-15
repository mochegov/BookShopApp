package com.mochegov.BookShopApp.controllers;

import com.mochegov.BookShopApp.data.BookService;
import com.mochegov.BookShopApp.data.TypeBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("bookDataRecomended", bookService.getBooksData(TypeBooks.RECOMENDED));
        model.addAttribute("bookDataNews",       bookService.getBooksData(TypeBooks.NEWS));
        model.addAttribute("bookDataPopular",    bookService.getBooksData(TypeBooks.POPULAR));

        return "index";
    }
}