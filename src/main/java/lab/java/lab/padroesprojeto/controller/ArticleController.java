package lab.java.lab.padroesprojeto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab.java.lab.padroesprojeto.model.Article;
import lab.java.lab.padroesprojeto.model.ArticleRepository;

@RestController
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleRepository repository;
	
	@GetMapping
	public Iterable<Article> getArticles() {
		return repository.findAll();
	}
	
	@PostMapping
	public void saveArticle(@RequestBody Article article) {
		repository.save(article);
	}
	
	@GetMapping("/{id}")
	public Optional<Article> getArticleById(@PathVariable("id") String id){
		return repository.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		repository.deleteById(id);
	}
}
