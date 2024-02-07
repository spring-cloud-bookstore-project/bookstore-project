package me.xtopz.bookstore.bookservice.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController {

    @Value("\${hello-message}")
    private lateinit var helloMessage: String

    @GetMapping("/")
    fun splash(): String {
        return helloMessage
    }

}