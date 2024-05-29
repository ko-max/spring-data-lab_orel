package ua.kpi.its.lab.data.entity

import jakarta.persistence.*
import java.util.*

@Entity
data class Journal(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val title: String,
    val subject: String,
    val language: String,
    val foundationDate: Date,
    val issn: String,
    val recommendedPrice: Double,
    val periodicity: Boolean,

    @OneToMany(mappedBy = "journal", cascade = [CascadeType.ALL], orphanRemoval = true)
    val articles: MutableList<Article> = mutableListOf()
) : Comparable<Journal> {
    override fun compareTo(other: Journal): Int {
        val titleComparison = title.compareTo(other.title)
        return if (titleComparison != 0) titleComparison else id.compareTo(other.id)
    }
}

@Entity
data class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val title: String,
    val author: String,
    val writingDate: Date,
    val wordCount: Int,
    val referenceCount: Int,
    val originalLanguage: Boolean,

    @ManyToOne
    @JoinColumn(name = "journal_id")
    val journal: Journal
) : Comparable<Article> {
    override fun compareTo(other: Article): Int {
        val titleComparison = title.compareTo(other.title)
        return if (titleComparison != 0) titleComparison else id.compareTo(other.id)
    }
}
