package com.example.documents1.repository;

import com.example.documents1.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Long> {
    Optional<Document> findByName(String name);

}
