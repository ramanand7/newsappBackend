package com.news.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.app.Entity.ExampleEntity;

public interface ExampleRepository extends JpaRepository<ExampleEntity, Long> {
}
