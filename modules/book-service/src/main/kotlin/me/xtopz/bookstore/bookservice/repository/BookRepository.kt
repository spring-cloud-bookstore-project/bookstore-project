package me.xtopz.bookstore.bookservice.repository

import me.xtopz.bookstore.bookservice.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: JpaRepository<Book, Long> {

}