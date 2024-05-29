package ua.kpi.its.lab.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import ua.kpi.its.lab.data.entity.Journal
import ua.kpi.its.lab.data.entity.Article

interface JournalRepository : JpaRepository<Journal, Long> {
    // додаткові методи, якщо потрібно
}

interface ArticleRepository : JpaRepository<Article, Long> {
    // додаткові методи, якщо потрібно
}
