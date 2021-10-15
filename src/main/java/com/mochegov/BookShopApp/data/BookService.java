package com.mochegov.BookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*

    // Закрепляем тематику "Лямбда-выражения в Java" :)

    private class RowMapperImpl implements RowMapper {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setId(rs.getInt(("id")));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            book.setPriceold(rs.getString("priceold"));
            book.setPrice(rs.getString("price"));
            book.setDiscount(rs.getInt("discount"));
            book.setBestseller(rs.getBoolean("bestseller"));
            book.setRecomended(rs.getBoolean("recomended"));
            book.setNews(rs.getBoolean("news"));
            book.setPopular(rs.getBoolean("popular"));

            return book;
        }
    }
    */

    public List<Book> getBooksData(TypeBooks typeBooks){
        String sql;
        switch (typeBooks) {
            case RECOMENDED:
                sql = "select * from books where recomended = true";
                break;
            case NEWS:
                sql = "select * from books where news = true";
                break;
            case POPULAR:
                sql = "select * from books where popular = true";
                break;
            default:
                sql = "select * from books";
                break;
        }

        //RowMapperImpl rowMapper = new RowMapperImpl();
        //List<Book> books = jdbcTemplate.query(sql, rowMapper);

        List<Book> books = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt(("id")));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            book.setPriceold(rs.getString("priceold"));
            book.setPrice(rs.getString("price"));
            book.setDiscount(rs.getInt("discount"));
            book.setBestseller(rs.getBoolean("bestseller"));
            book.setRecomended(rs.getBoolean("recomended"));
            book.setNews(rs.getBoolean("news"));
            book.setPopular(rs.getBoolean("popular"));

            return book;
        });

        return new ArrayList<>(books);
    }
}