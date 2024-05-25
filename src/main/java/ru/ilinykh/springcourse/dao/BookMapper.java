package ru.ilinykh.springcourse.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.ilinykh.springcourse.models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("book_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setYearOfProduction(rs.getInt("year_of_production"));
        return book;
    }
}
