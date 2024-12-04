package PrestaBanco.loan_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    private Long id;
    private byte[] document;
    private Long loanId;
}