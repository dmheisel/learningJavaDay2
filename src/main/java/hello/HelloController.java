package hello;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.jdbc.core.JdbcTemplate;
import hello.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/book")
    public List<Book> getAllBooks() {
        String query = "SELECT * FROM books";
        List<Book> books = jdbcTemplate.query(
            query, new BookRowMapper());
          return books;
    }

    @PostMapping("/book") // PostMapping takes care of Post routes to /book
    public void addBook(@RequestBody Book newBook) {
        //creates the "addBook function, which makes a Book object called NewBook off the @RequestBody sent in as JSON data"
        //access the Book class .getTitle() and getAuthor() to get the newBook's title and author
        String query = "INSERT into books (title, author) values(\'" + newBook.getTitle() + "\', \'"
                + newBook.getAuthor() + "\')";
        try {
            jdbcTemplate.update(query);
        } catch (RuntimeException exception) {
            System.err.println(exception);
            throw exception;
        } // still need to figure out sanitation!
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable int id) {
        String query = "DELETE FROM books WHERE id = ?";
        try {
            jdbcTemplate.update(query, id);
        } catch (RuntimeException exception) {
            System.err.println(exception);
            throw exception;
        }
    }
}
