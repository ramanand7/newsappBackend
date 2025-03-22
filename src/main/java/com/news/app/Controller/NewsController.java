package com.news.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.news.app.Service.NewsService;
import com.news.app.models.NewsResponse;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/fetch")
    public String fetchNews() {
        String[] categories = { "general", "business", "entertainment", "health", "science", "sports", "technology",
                "politics" };
        for (String category : categories) {
            newsService.fetchAndStoreNews(category);
        }
        return "News fetched and stored successfully!";
    }

    @GetMapping("/fetchByCategory")
    public ResponseEntity<List<NewsResponse>> fetchCatergoryNews(@RequestParam String category) {
        return newsService.fetchNewsByCategory(category);
    }

}