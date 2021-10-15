package com.mochegov.BookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class GenreService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GenreService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Печать иерархической структуры жанров для отладки
    public void PrintGenres(List<Genre> genres){
        if (!genres.isEmpty()){
            for (Genre genre: genres){
                String ShiftLeft = "";
                for (int i = 0; i <= genre.getLevel(); i++) {
                    ShiftLeft = ShiftLeft + "  ";
                }
                Logger.getLogger(GenreService.class.getName()).info(ShiftLeft + genre.getName());
                PrintGenres(genre.getGenres());
            }
        }
    }

    public List<Genre> getGenresData(int parent_id, int level) {
        String sql = "select * from genres where parent_id = " + parent_id + " and level = " + level;

        List<Genre> genres = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
            Genre genre = new Genre();
            genre.setId(rs.getInt("id"));
            genre.setName(rs.getString("genre"));
            genre.setParent_id(rs.getInt("parent_id"));
            genre.setLevel(rs.getInt("level"));

            return genre;
        });

        if (!genres.isEmpty()) {
            for (Genre genre: genres) {
                List<Genre> childGenres = getGenresData(genre.getId(), level + 1);
                genre.setGenres(childGenres);
            }
        }

        return new ArrayList<>(genres);
    }
}