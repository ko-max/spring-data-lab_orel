package ua.kpi.its.lab.data

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import ua.kpi.its.lab.data.entity.Journal
import ua.kpi.its.lab.data.entity.Article
import ua.kpi.its.lab.data.svc.impl.JournalServiceImpl
import ua.kpi.its.lab.data.svc.impl.ArticleServiceImpl
import java.util.*

fun main() {
    val context = AnnotationConfigApplicationContext("ua.kpi.its.lab.data")
    val journalService = context.getBean(JournalServiceImpl::class.java)
    val articleService = context.getBean(ArticleServiceImpl::class.java)

    // Створюємо 5 журналів та додаткові статті
    val journal1 = Journal(
        title = "Nature",
        subject = "Natural Sciences",
        language = "English",
        foundationDate = Date(1869, 11, 4),
        issn = "0028-0836",
        recommendedPrice = 199.0,
        periodicity = true
    )
    val journal2 = Journal(
        title = "Science",
        subject = "General Science",
        language = "English",
        foundationDate = Date(1880, 7, 3),
        issn = "0036-8075",
        recommendedPrice = 299.0,
        periodicity = true
    )

    val journal3 = Journal(
        title = "The Lancet",
        subject = "Medicine",
        language = "English",
        foundationDate = Date(1823, 10, 5),
        issn = "0140-6736",
        recommendedPrice = 249.0,
        periodicity = true
    )

    val journal4 = Journal(
        title = "National Geographic",
        subject = "Geography, Science, History",
        language = "English",
        foundationDate = Date(1888, 9, 22),
        issn = "0027-9358",
        recommendedPrice = 129.0,
        periodicity = true
    )

    val journal5 = Journal(
        title = "Scientific American",
        subject = "Science and Technology",
        language = "English",
        foundationDate = Date(1845, 8, 28),
        issn = "0036-8733",
        recommendedPrice = 199.0,
        periodicity = true
    )
    val article1 = Article(
        title = "Climate Change",
        author = "John Doe",
        writingDate = Date(2023, 1, 1),
        wordCount = 5000,
        referenceCount = 50,
        originalLanguage = true,
        journal = journal1
    )

    // Додаємо створені журнали та статті в БД
    journalService.create(journal1)
    journalService.create(journal2)
    journalService.create(journal3)
    journalService.create(journal4)
    journalService.create(journal5)
    articleService.create(article1)

    println("Retrieved journal: $journal3")

    // Видаляємо журнал з індексом 4
    journalService.delete(4)
}
