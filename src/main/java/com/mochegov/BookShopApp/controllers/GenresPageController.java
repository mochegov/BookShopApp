package com.mochegov.BookShopApp.controllers;

import com.mochegov.BookShopApp.data.Genre;
import com.mochegov.BookShopApp.data.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bookshop")
public class GenresPageController {
    private final GenreService genreService;

    @Autowired
    public GenresPageController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public String genresPage(Model model){
        List<Genre> genres = genreService.getGenresData(0, 1);
        model.addAttribute("genres", genres);

        // Отладочная печать иерархической структуры жанров
        genreService.PrintGenres(genres);

        return "/genres/index";
    }
}
