package ua.kpi.its.lab.data.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.data.entity.Journal
import ua.kpi.its.lab.data.entity.Article
import ua.kpi.its.lab.data.repo.JournalRepository
import ua.kpi.its.lab.data.repo.ArticleRepository
import ua.kpi.its.lab.data.svc.JournalService
import ua.kpi.its.lab.data.svc.ArticleService

@Service
class JournalServiceImpl(private val repo: JournalRepository) : JournalService {
    override fun create(journal: Journal) = repo.save(journal)
    override fun retrieve(id: Long) = repo.findById(id).orElse(null)
    override fun update(journal: Journal) = repo.save(journal)
    override fun delete(id: Long) = repo.deleteById(id)
}

@Service
class ArticleServiceImpl(private val repo: ArticleRepository) : ArticleService {
    override fun create(article: Article) = repo.save(article)
    override fun retrieve(id: Long) = repo.findById(id).orElse(null)
    override fun update(article: Article) = repo.save(article)
    override fun delete(id: Long) = repo.deleteById(id)
}
