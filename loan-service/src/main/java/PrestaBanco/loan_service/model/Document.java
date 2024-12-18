package PrestaBanco.loan_service.model;

public class Document {
    private Long id;
    private byte[] document;
    private Long loanId;

    public Document() {
    }

    public Document(Long loanId, byte[] document, Long id) {
        this.loanId = loanId;
        this.document = document;
        this.id = id;
    }

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