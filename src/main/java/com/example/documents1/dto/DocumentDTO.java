package com.example.documents1.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentDTO {

    private Long id;

    @NotEmpty
    private String name;

    private int number;

    private LocalDateTime createdDate;

    @NotEmpty
    private String type;

    @NotEmpty
    private String documentText;

    public DocumentDTO(String name, int number, LocalDateTime createdDate, String type, String documentText) {
        this.name = name;
        this.number = number;
        this.createdDate = createdDate;
        this.type = type;
        this.documentText = documentText;
    }
}
