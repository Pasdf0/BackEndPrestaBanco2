package PrestaBanco.document_service.service;

import PrestaBanco.document_service.entity.DocumentEntity;
import PrestaBanco.document_service.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    public ArrayList<DocumentEntity> getDocumentByLoanRequest(Long loanRequestId) {return documentRepository.findByLoanRequest(loanRequestId);}

    public DocumentEntity saveDocument(DocumentEntity document) { return documentRepository.save(document); }

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
