package com.example.dto;

public record DocumentResponse(
        Long id,
        String title,
        String condition,
        String source,
        String sourceUrl,
        String filename) {
}
