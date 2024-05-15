package com.example.documents1.controller;

import com.example.documents1.dto.DocumentDTO;
import com.example.documents1.entity.Document;
import com.example.documents1.service.DocumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;

    @GetMapping("/all")
    public String get(Model model){
        model.addAttribute("documents",documentService.getAll());
        return "docsList";
    }

    @PostMapping("/addDoc")
    public String AddDoc(@Valid DocumentDTO documentDTO, BindingResult result){
        if (result.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            for (FieldError error : result.getFieldErrors()) {
                errorMessage.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("<br>");
            }
            return "Error: " + errorMessage;
        }
        documentService.save(documentDTO);
        return "redirect:/api/v1/all";
    }

    @GetMapping("/add")
    public String Add(Model model){
        return "add";
    }

    @GetMapping("/edit/{id}")
    public String editDoc(@PathVariable Long id, Model model) {
        DocumentDTO document = documentService.getDocById(id);
        model.addAttribute("document", document);
        return "edit";
    }

    @GetMapping("/searchDoc")
    public String searchDoc(@RequestParam(value = "name", required = false)String name, Model model) {
        DocumentDTO doc = documentService.getDocByName(name);
        model.addAttribute("document", doc);
        return "edit";
    }
}



