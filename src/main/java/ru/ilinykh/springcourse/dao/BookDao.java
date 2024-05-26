package ru.ilinykh.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.ilinykh.springcourse.models.Book;
import ru.ilinykh.springcourse.models.Person;

import java.util.List;
import java.util.Optional;

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
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(title, author, year_of_production) VALUES (?,?,?)", book.getTitle(),
                book.getAuthor(), book.getYearOfProduction());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE book_id=?", id);
    }

    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("select p.* from book b join person p on b.person_id = p.person_id where b.book_id=?",
                new Object[]{id}, new PersonMapper()).stream().findAny();
    }

    public void assign(int id, Person selectedPerson) {
        jdbcTemplate.update("UPDATE book SET person_id=? where book_id=?", selectedPerson.getId(), id);
    }

    public void release(int id) {
        jdbcTemplate.update("UPDATE book set person_id=NULL where book_id=?", id);
    }

}
