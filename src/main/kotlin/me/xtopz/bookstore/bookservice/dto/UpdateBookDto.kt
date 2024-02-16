package me.xtopz.bookstore.bookservice.dto

import me.xtopz.bookstore.bookservice.entity.Book
import me.xtopz.bookstore.bookservice.entity.Genre

//TODO: implement validation
class UpdateBookDto(
    var title: String? = null,
    var authors: Set<String>? = null,
    var year: Int? = null,
    var genre: Set<Genre>? = null,
    var pageNumber: Int? = null,
    var chapter: Int? = null,
) {
    fun updateEntity(book: Book) {
        title?.also { book.title = it }
        authors?.also { book.authors = it.toHashSet() }
        year?.also { book.publicationYear = it }
        genre?.also { book.genre = it.toHashSet() }
        pageNumber?.also { book.pageNumber = it }
        chapter?.also { book.chapter = it }
    }
}