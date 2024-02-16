package me.xtopz.bookstore.bookservice.dto

import me.xtopz.bookstore.bookservice.entity.Book
import me.xtopz.bookstore.bookservice.entity.Genre

//TODO: implement validation
class PostBookDto(
    private val title: String,
    private val authors: Set<String>,
    private val year: Int,
    private val genre: Set<Genre>,
    private val pageNumber: Int,
    private val chapter: Int? = null,
) {
    fun toBookEntity() = Book(
        title, authors, genre, chapter, year, pageNumber
    )
}