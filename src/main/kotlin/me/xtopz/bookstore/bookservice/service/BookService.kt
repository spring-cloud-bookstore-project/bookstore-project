package me.xtopz.bookstore.bookservice.service

import me.xtopz.bookstore.bookservice.dto.PostBookDto
import me.xtopz.bookstore.bookservice.dto.UpdateBookDto
import me.xtopz.bookstore.bookservice.entity.Book
import me.xtopz.bookstore.bookservice.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class BookService {

    @Autowired
    private lateinit var bookRepository: BookRepository

    fun findBookById(id: Long): Book? {
        return bookRepository.findById(id).getOrNull()
    }

    fun findAllBooks(): List<Book> {
        return bookRepository.findAll()
    }

    fun createBook(postBookDto: PostBookDto): Long {
        val bookEntity = postBookDto.toBookEntity()
        return bookRepository.save(bookEntity).id!!
    }

    fun deleteBook(id: Long): Boolean {
        val isEntityExists = bookRepository.existsById(id)

        if (isEntityExists) {
            bookRepository.deleteById(id)
        }

        return isEntityExists
    }

    fun updateBook(id: Long, updateBookDto: UpdateBookDto): Boolean {
        val desiredBook = bookRepository.findById(id).getOrNull()

        desiredBook?.also {
            updateBookDto.updateEntity(it)
            bookRepository.save(it)
        }

        return desiredBook != null
    }



}