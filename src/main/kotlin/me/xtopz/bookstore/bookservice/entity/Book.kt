package me.xtopz.bookstore.bookservice.entity

import jakarta.persistence.*

@Entity
class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    val id: Long,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var isFiction: Boolean,

    @CollectionTable(
        name = "book_author",
    )
    @ElementCollection
    var authors: Set<String>,


    @Enumerated(
        value = EnumType.STRING
    )

    @CollectionTable
    @ElementCollection(targetClass = Genre::class)
    var genre: Set<Genre>,

    @Column
    var chapter: Int,

    @Column(nullable = false)
    var publicationYear: Int,

    @Column
    var pageNumber: Int

)

enum class Genre {

    DETECTIVE,
    FANTASY,
    HORROR,
    THRILLER,
    SLASHER,
    WESTERN,
    COMEDY


}
