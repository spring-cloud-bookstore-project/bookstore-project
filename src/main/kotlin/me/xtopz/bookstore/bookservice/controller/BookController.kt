package me.xtopz.bookstore.bookservice.controller

import me.xtopz.bookstore.bookservice.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController {

    @Autowired
    private lateinit var bookService: BookService

    @GetMapping("/")
    fun getBooks() =
        bookService.findAllBooks()

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): ResponseEntity<Any> {
        val desiredBook = bookService.findBookById(id) ?:
            return ResponseEntity.notFound().build()

        return ResponseEntity.ok(desiredBook)
    }

}