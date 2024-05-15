package com.example.documents1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "mydocuments1")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int number;

    @Column(updatable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private String type;

    @Column(columnDefinition = "text",nullable = false)
    private String documentText;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    public Document(String name, int number, LocalDateTime createdDate, String type, String documentText) {
        this.name = name;
        this.number = number;
        this.createdDate = createdDate;
        this.type = type;
        this.documentText = documentText;
    }
}
