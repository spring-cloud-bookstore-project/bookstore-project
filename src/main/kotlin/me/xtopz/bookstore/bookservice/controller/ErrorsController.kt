package me.xtopz.bookstore.bookservice.controller

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ErrorsController: ErrorController {

    @GetMapping("**")
    fun notFound(): ResponseEntity<String> {
        return ResponseEntity(
            "404 Not Found",
            HttpStatusCode.valueOf(404)
        )
    }


}