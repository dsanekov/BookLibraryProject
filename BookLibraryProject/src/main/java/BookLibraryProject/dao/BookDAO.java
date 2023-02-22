package BookLibraryProject.dao;

import BookLibraryProject.models.Book;
import BookLibraryProject.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }
    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }
    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(name,author,year) VALUES(?, ?, ?)", book.getName(), book.getAuthor(),book.getYear());
    }
    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE book SET name=?, author=?, year=? WHERE id=?", updatedBook.getName(), updatedBook.getAuthor(),updatedBook.getYear(), id);
    }
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }
    public Optional<Person> getPersonByBookId(int bookId){
        return jdbcTemplate.query("SELECT person.* FROM book JOIN person ON book.person_id = person.id WHERE book.id=?"
                        ,new Object[]{bookId},new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }
    public void makeBookFree(int bookId){
        jdbcTemplate.update("UPDATE book SET person_id=NULL WHERE id=?",bookId);
    }
    public void makeBookUsedByPerson(int bookId, Person person){
        jdbcTemplate.update("UPDATE book SET person_id=? WHERE id=?",person.getId(),bookId);
    }
}
