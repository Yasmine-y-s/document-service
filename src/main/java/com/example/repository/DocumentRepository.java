package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
