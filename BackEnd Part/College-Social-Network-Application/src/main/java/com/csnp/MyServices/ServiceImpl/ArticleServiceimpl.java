package com.csnp.MyServices.ServiceImpl;

import java.util.List;

import com.csnp.MyRepositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csnp.Enum.Status;
import com.csnp.Exception.ArticleException;
import com.csnp.Models.Article;
import com.csnp.Models.PlacementOfficer;
import com.csnp.Models.Student;
import com.csnp.MyRepositories.PlacementOfficerRepository;
import com.csnp.MyRepositories.StudentRepository;
import com.csnp.MyServices.ArticleService;
@Service
public class ArticleServiceimpl implements ArticleService {

	
	private final StudentRepository studentRepository ;
	private final PlacementOfficerRepository placeOfficerRepository;
	private final ArticleRepository articleRepository;
	
	@Autowired
	public ArticleServiceimpl(StudentRepository studentRepository, PlacementOfficerRepository placementOfficerRepository, ArticleRepository articleRepository) {
		this.studentRepository = studentRepository;
		this.placeOfficerRepository = placementOfficerRepository;
		this.articleRepository = articleRepository;
	}
	@Override
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return articleRepository.findAll();
	}

	@Override
	public String AddArticleForApproval(Student student, Article article, Status status,
			PlacementOfficer placementOfficer) throws ArticleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article getArticleById(Long id) throws ArticleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article updateArticle(Article article) throws ArticleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article getArticleByName(String title) throws ArticleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteArticle(Long id) {
		// TODO Auto-generated method stub
		
	}

}
