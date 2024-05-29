package ua.kpi.its.lab.data.svc

import ua.kpi.its.lab.data.entity.Journal
import ua.kpi.its.lab.data.entity.Article

interface JournalService {
    fun create(journal: Journal): Journal
    fun retrieve(id: Long): Journal?
    fun update(journal: Journal): Journal
    fun delete(id: Long)
}

interface ArticleService {
    fun create(article: Article): Article
    fun retrieve(id: Long): Article?
    fun update(article: Article): Article
    fun delete(id: Long)
}
