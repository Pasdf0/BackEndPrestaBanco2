package PrestaBanco.document_service.controller;

import PrestaBanco.document_service.entity.DocumentEntity;
import PrestaBanco.document_service.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    DocumentService documentService;

    @GetMapping("/{id}")
    public ResponseEntity<List<DocumentEntity>> getDocumentsByLoanId(@PathVariable Long id) {
        List<DocumentEntity> documents = documentService.getDocumentByLoan(id);
        return ResponseEntity.ok(documents);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> uploadMultipleFiles (
        @PathVariable Long id,
        @RequestParam("documents") MultipartFile[] files) {
        try {
            documentService.saveDocuments(id, files);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading documents");
        }
    }

    @PutMapping("/")
    public ResponseEntity<DocumentEntity> updateDocument(@RequestBody DocumentEntity document) {
        DocumentEntity updatedDocument = documentService.updateDocument(document);
        return ResponseEntity.ok(updatedDocument);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDocument(@PathVariable Long id) throws Exception {
        documentService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }
}