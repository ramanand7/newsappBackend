package com.news.app.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "news_articles") // Collection name in MongoDB
public class NewsResponse {
    @Id
    private String id;
    private String status;
    private int totalResults;
    private List<Article> articles;

    @Data
    public static class Article {
        private Source source;
        private String author;
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private String publishedAt;
        private String content;

        @Data
        public static class Source {
            private String id;
            private String name;
        }
    }
}