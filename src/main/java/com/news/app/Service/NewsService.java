package com.news.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.news.app.Repository.NewsRepository;
import com.news.app.models.NewsResponse;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String API_KEY = "81d047c6f4eb4a1c9144471071db53e6";
    private static final String BASE_URL = "https://newsapi.org/v2/top-headlines?apiKey=" + API_KEY;

    public void fetchAndStoreNews(String category) {
        String url = BASE_URL + "&category=" + category;
        NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);

        if (response != null && "ok".equals(response.getStatus())) {
            response.setId(category);
            mongoTemplate.save(response, category);
            System.out.println("Stored news for category: " + category);
        } else {
            System.out.println("Failed to fetch news for category: " + category);
        }
    }

    public ResponseEntity<List<NewsResponse>> fetchNewsByCategory(String category) {
        // Fetch data from the collection named after the category
        List<NewsResponse> news = mongoTemplate.findAll(NewsResponse.class, category);

        if (news.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Return 404 if no data is found
        }
        return ResponseEntity.ok(news); // Return 200 OK with the data
    }

}