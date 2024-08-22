package com.BookManagementSystem.college.Repository;

import com.BookManagementSystem.college.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {


}
