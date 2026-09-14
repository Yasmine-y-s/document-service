package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DocumentCreateRequest(
        @NotBlank String title,

        @NotBlank @Pattern(regexp = "^[a-z0-9-]+$") String condition,

        @NotBlank String source,

        @NotBlank @Pattern(regexp = "^https?://.*") String sourceUrl,

        @NotBlank @Pattern(regexp = "^[\\w\\-]+\\.pdf$") String filename) {
}
