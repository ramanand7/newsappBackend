package com.news.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.news.app.Entity.ExampleEntity;
import com.news.app.Service.ExampleService;

import java.util.List;

@RestController
@RequestMapping("/api/examples")
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    // GET endpoint to retrieve all entities
    @GetMapping
    public List<ExampleEntity> getAllExamples() {
        return exampleService.findAll();
    }

    // POST endpoint to add a new entity
    @PostMapping
    public void addExample(@RequestBody ExampleEntity exampleEntity) {
        exampleService.saveExample(exampleEntity);
    }
}
