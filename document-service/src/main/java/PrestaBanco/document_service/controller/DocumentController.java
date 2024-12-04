package PrestaBanco.document_service.controller;

import PrestaBanco.document_service.entity.DocumentEntity;
import PrestaBanco.document_service.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    DocumentService documentService;

    @GetMapping("/{id}")
    public ResponseEntity<List<DocumentEntity>> getDocumentsByLoanId(@PathVariable Long id) {
        List<DocumentEntity> documents = documentService.getDocumentByLoanRequest(id);
        return ResponseEntity.ok(documents);
    }

    @PostMapping("/")
    public ResponseEntity<?> uploadMultipleFiles (@RequestBody List<DocumentEntity> documents) {
        for (DocumentEntity doc : documents) {
            documentService.saveDocument(doc);
        }
        return ResponseEntity.ok("Documentos guardados exitosamente");
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