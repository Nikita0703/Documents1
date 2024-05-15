package com.example.documents1.service;

import com.example.documents1.dto.DocumentDTO;
import com.example.documents1.entity.Document;
import com.example.documents1.mapper.DocumentMapper;
import com.example.documents1.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService{
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    @Override
    public void save(DocumentDTO documentDTO) {
        documentRepository.save(documentMapper.toDocument(documentDTO));
    }

    @Override
    public List<DocumentDTO> getAll() {
        return documentMapper.toDocumentDTOList(documentRepository.findAll());
    }

    @Override
    public DocumentDTO getDocById(Long id) {
        return documentMapper.toDocumentDTO(documentRepository.findById(id).orElse(null));
    }

    @Override
    public DocumentDTO getDocByName(String name) {
        return documentMapper.toDocumentDTO(documentRepository.findByName(name).orElse(null));
    }
}
