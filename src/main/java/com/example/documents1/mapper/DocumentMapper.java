package com.example.documents1.mapper;

import com.example.documents1.dto.DocumentDTO;
import com.example.documents1.entity.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocumentMapper {

    public Document toDocument(DocumentDTO documentDTO){
        Document document = Document.builder().id(documentDTO.getId()).name(documentDTO.getName())
                .number(documentDTO.getNumber())
                .createdDate(documentDTO.getCreatedDate())
                .type(documentDTO.getType())
                .documentText(documentDTO.getDocumentText())
                .build();
        return document;
    }

    public DocumentDTO toDocumentDTO(Document document){
        DocumentDTO documentDTO = DocumentDTO.builder().id(document.getId()).name(document.getName())
                .number(document.getNumber())
                .createdDate(document.getCreatedDate())
                .type(document.getType())
                .documentText(document.getDocumentText())
                .build();
        return documentDTO;
    }

    public List<Document> toDocumentList(List<DocumentDTO> dtoList){
        List<Document> docList = new ArrayList<>();
        for (DocumentDTO dto:dtoList){
            docList.add(toDocument(dto));
        }
        return docList;
    }

    public List<DocumentDTO> toDocumentDTOList(List<Document> docs){
        List<DocumentDTO> dtos = new ArrayList<>();
        for (Document doc:docs){
            dtos.add(toDocumentDTO(doc));
        }
        return dtos;
    }
}
