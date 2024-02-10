package me.xtopz.bookstore.bookservice.controller

import me.xtopz.bookstore.bookservice.service.BookService
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Locale

@RestController
@RequestMapping("/books")
class BookController {

    private lateinit var bookService: BookService

    @GetMapping("/about/{id}")
    fun about(
        @PathVariable id: Long,
        @RequestHeader(
            name = "Accept-Language",
            required = false
        ) locale: Locale

    ): String {
        return bookService.representBook(id, locale)
    }

}