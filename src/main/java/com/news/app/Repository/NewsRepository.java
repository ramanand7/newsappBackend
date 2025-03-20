package com.news.app.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<com.news.app.models.NewsResponse, String> {
}