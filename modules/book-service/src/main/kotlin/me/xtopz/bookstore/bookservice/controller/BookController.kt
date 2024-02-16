package me.xtopz.bookstore.bookservice.controller

import me.xtopz.bookstore.bookservice.dto.PostBookDto
import me.xtopz.bookstore.bookservice.dto.UpdateBookDto
import me.xtopz.bookstore.bookservice.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @PostMapping("/")
    fun postBook(@RequestBody postBookDto: PostBookDto): Map<String, Long> {
        val bookId = bookService.createBook(postBookDto)
        return mapOf("bookId" to bookId)
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Long, @RequestBody updateBookDto: UpdateBookDto): ResponseEntity<Any> {
        if (bookService.deleteBook(id)) {
            return ResponseEntity.noContent().build()
        }
        return ResponseEntity.notFound().build()
    }

    @PatchMapping("/{id}")
    fun patchBook(@PathVariable id: Long, @RequestBody updateBookDto: UpdateBookDto): ResponseEntity<Any> {
        if (bookService.updateBook(id, updateBookDto)) {
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }


}