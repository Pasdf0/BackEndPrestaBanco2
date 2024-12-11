package PrestaBanco.document_service.service;

import PrestaBanco.document_service.entity.DocumentEntity;
import PrestaBanco.document_service.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    public ArrayList<DocumentEntity> getDocumentByLoan(Long loanId) {return documentRepository.findByLoan(loanId);}

    public void saveDocuments(Long id, MultipartFile[] files) throws IOException {
        try {
            for (MultipartFile file : files) {
                DocumentEntity document = new DocumentEntity();
                document.setLoanId(id);
                document.setDocument(file.getBytes());
                documentRepository.save(document);
            }
        }
        catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public DocumentEntity updateDocument(DocumentEntity document) { return documentRepository.save(document); }

    public boolean deleteDocument(Long id) throws Exception {
        try {
            documentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
