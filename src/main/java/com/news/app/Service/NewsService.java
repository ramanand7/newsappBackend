package com.news.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.news.app.Repository.NewsRepository;
import com.news.app.models.NewsResponse;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_KEY = "81d047c6f4eb4a1c9144471071db53e6";
    private static final String BASE_URL = "https://newsapi.org/v2/top-headlines?apiKey=" + API_KEY;

    public void fetchAndStoreNews(String category) {
        String url = BASE_URL + "&category=" + category;
        NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);

        if (response != null && "ok".equals(response.getStatus())) {
            response.setId(category); // Set category as the ID for uniqueness
            newsRepository.save(response);
            System.out.println("Stored news for category: " + category);
        } else {
            System.out.println("Failed to fetch news for category: " + category);
        }
    }
}