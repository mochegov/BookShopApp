package com.mochegov.BookShopApp.controllers;

import com.mochegov.BookShopApp.data.AuthorService;
import com.mochegov.BookShopApp.data.AuthorsGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/bookshop")
public class AuthorsPageController {

    AuthorService authorService;

    @Autowired
    public AuthorsPageController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String autorsPage(Model model){
        Map<String, AuthorsGroup> authorsMap = authorService.getAuthorsMap();
        model.addAttribute ("authorsMap", authorsMap);

        return "/authors/index";
    }
}
