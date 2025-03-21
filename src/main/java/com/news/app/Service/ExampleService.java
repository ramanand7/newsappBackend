package com.news.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.app.Entity.ExampleEntity;
import com.news.app.Repository.ExampleRepository;

import java.util.List;

@Service
public class ExampleService {
    @Autowired
    private ExampleRepository repository;

    public List<ExampleEntity> findAll() {
        return repository.findAll();
    }

    public void saveExample(ExampleEntity entity) {
        repository.save(entity);
    }
}
