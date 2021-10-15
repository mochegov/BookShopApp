package com.mochegov.BookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.*;

@Service
public class AuthorService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Получить список первых букв ФИО авторов в верхнем регистре
    public List<String> getFirstLetters() {
        String sql = "select upper(substr(a.AUTHOR, 1, 1)) as FL from authors a group by upper(substr(a.AUTHOR, 1, 1))";

        List<String> letters = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
            return rs.getString("FL");
        });

        return new ArrayList<>(letters);
    }

    // Получить список авторов по первой букве ФИО
    public List<String> getAuthorsByLetter(String letter) {
        String sql = "select a.AUTHOR from AUTHORS a where upper(substr(a.AUTHOR, 1, 1)) = '" + letter + "'";

        List<String> authors = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
            return rs.getString("AUTHOR");
        });

        return new ArrayList<>(authors);
    }

    // Получение карты с авторами, где в качестве ключа - первая буква, а значение - ссылка + список авторов
    public Map<String, AuthorsGroup> getAuthorsMap() {
        Map<String, AuthorsGroup> authorsMap = new HashMap<>();
        List<String> letters = getFirstLetters();

        for (String letter : letters) {
            authorsMap.put(letter, new AuthorsGroup(letter, getAuthorsByLetter(letter)));
        }

        return authorsMap;
    }
}
