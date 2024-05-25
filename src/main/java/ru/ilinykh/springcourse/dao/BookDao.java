package ru.ilinykh.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.ilinykh.springcourse.models.Book;

import java.util.List;

@Component
public class BookDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book", new BookMapper());
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE book_id=?", new Object[]{id}, new BookMapper())
                .stream().findAny().orElse(null);
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE book SET title=?, author=?, year_of_production=? where book_id=?",
                updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getYearOfProduction(), updatedBook.getBookId());
        System.out.println("HELLO FROM UPDATE Book DAO");
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(title, author, year_of_production) VALUES (?,?,?)", book.getTitle(),
                book.getAuthor(), book.getYearOfProduction());
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM book WHERE book_id=?", id);
    }

}
