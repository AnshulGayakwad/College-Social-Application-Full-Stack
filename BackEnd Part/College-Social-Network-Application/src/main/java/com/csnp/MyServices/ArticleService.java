package com.csnp.MyServices;

import com.csnp.Enum.Status;
import com.csnp.Exception.ArticleException;
import com.csnp.Models.Article;
import com.csnp.Models.PlacementOfficer;
import com.csnp.Models.Student;

import java.util.List;

import org.springframework.stereotype.Service;

public interface ArticleService {
    public List<Article> getAllArticles();
    public String AddArticleForApproval(Student student,Article article, Status status, PlacementOfficer placementOfficer) throws ArticleException ;
    public Article getArticleById(Long id) throws ArticleException;
    public Article updateArticle(Article article) throws ArticleException;
    public Article getArticleByName(String title) throws ArticleException;
    public void deleteArticle(Long id);

}