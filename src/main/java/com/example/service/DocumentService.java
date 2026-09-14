package com.example.service;

import com.example.dto.DocumentCreateRequest;
import com.example.dto.DocumentResponse;
import com.example.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import com.example.entity.Document;

import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository repository;

    public DocumentService(DocumentRepository repository) {
        this.repository = repository;
    }

    public DocumentResponse createDocument(DocumentCreateRequest request) {

        Document document = new Document();

        document.setTitle(request.title());
        document.setCondition(request.condition());
        document.setSource(request.source());
        document.setSourceUrl(request.sourceUrl());
        document.setFilename(request.filename());

        // Temporary user ID for this learning milestone.
        // Authentication will provide the real user ID later.
        document.setUserId(1L);

        Document savedDocument = repository.save(document);

        return toResponse(savedDocument);
    }

    public List<DocumentResponse> getAllDocuments() {

        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public DocumentResponse getDocument(Long id) {

        Document document = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found: " + id));

        return toResponse(document);
    }

    public void deleteDocument(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Document not found: " + id);
        }

        repository.deleteById(id);
    }

    private DocumentResponse toResponse(Document document) {

        return new DocumentResponse(
                document.getId(),
                document.getTitle(),
                document.getCondition(),
                document.getSource(),
                document.getSourceUrl(),
                document.getFilename());
    }
}