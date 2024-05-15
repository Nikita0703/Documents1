package com.example.documents1.service;

import com.example.documents1.dto.DocumentDTO;
import com.example.documents1.entity.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentService {

    void save(DocumentDTO documentDTO);

    List<DocumentDTO> getAll();

    DocumentDTO getDocById(Long id);

    DocumentDTO getDocByName(String name);

}
