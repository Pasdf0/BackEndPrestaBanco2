package PrestaBanco.document_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "document")
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private byte[] document;
    private Long loanId;

    public DocumentEntity() {
    }

    public DocumentEntity(Long id, byte[] document, Long loanId) {
        this.id = id;
        this.document = document;
        this.loanId = loanId;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }
}