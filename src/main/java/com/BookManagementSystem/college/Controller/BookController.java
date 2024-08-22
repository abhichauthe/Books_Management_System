package com.BookManagementSystem.college.Controller;

import com.BookManagementSystem.college.Model.Book;
import com.BookManagementSystem.college.Repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController// it's combination of controller and response body where controller takes care of every object
// returns domain object instead of view means it's return the raw data like json file as a http request instead
// of Html page as view. what happen mostly if we are browsing on the internet we often tends to get html
// page as a response .
@RequestMapping("/api/books") // it's Base url for all the methods, that I am going to be writing .
public class BookController {

    @Autowired // Inject the book repository dependency . Allows the controller to perform database operation//without creating the repository instance manually
    private BookRepository bookRepository;


    @GetMapping// GetMapping maps http request to this method
    /*
    No Path specified to it's uses class level path ("api/books")
    return list of all books
    used for retrieving all books in the database.
    */
    public List<Book> getAllBooks(){
        return bookRepository.findAll();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Optional<Book> book = bookRepository.findById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        /*

        if(book.isPresent()){
            return ResponseEntity.ok(book.get());
        }
         return ResponseEntity.notFound().build();
 */
    }
    // Above Both method is to get  a request from the database
    @PostMapping
    public ResponseEntity<Book> createBook(@Valid  @RequestBody Book book){
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);

    }
    // Above method is for create a book in database
   @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id , @Valid @RequestBody Book book) {
       Optional<Book> updatedBook = bookRepository.findById(id);

       if (updatedBook.isPresent()) {

           Book savedBook = updatedBook.get();

           // update the existing book's details

           savedBook.setTitle(book.getTitle());
           savedBook.setAuthor(book.getAuthor());
           savedBook.setIsbn(book.getIsbn());
           savedBook.setPublicationYear(book.getPublicationYear());

           // save the updated Book
           Book UpdatedBook = bookRepository.save(savedBook);

           // return the updated book with ok status
           return ResponseEntity.ok(UpdatedBook);
       } else {
           return ResponseEntity.notFound().build();


       }




   }
    // now we done with the create Read update and now we just left with delete part
    // let's write a delete mapping method for that
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            Book deletedBook = book.get();
            bookRepository.delete(deletedBook);

            return ResponseEntity.ok(deletedBook);
        }
        return ResponseEntity.notFound().build();


    }

    /*
    we have written all the method which perform the crud operations
     */






}
