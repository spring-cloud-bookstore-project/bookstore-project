package me.xtopz.bookstore.bookservice.service

import me.xtopz.bookstore.bookservice.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Service
import java.util.Locale
import kotlin.jvm.optionals.getOrNull

@Service
class BookService {

    @Autowired
    private lateinit var messageSource: MessageSource

    @Autowired
    private lateinit var bookRepository: BookRepository

    fun representBook(bookId: Long, locale: Locale): String {
        val desiredBook = bookRepository.findById(bookId).getOrNull()
            ?: return messageSource.getMessage("book.not-found", null, locale)

        return messageSource.getMessage("book.represent", arrayOf(desiredBook), locale)
    }

}