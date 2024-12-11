package PrestaBanco.document_service.repository;

import PrestaBanco.document_service.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
    @Query("SELECT e FROM DocumentEntity e WHERE e.loanId = :loanId")
    ArrayList<DocumentEntity> findByLoan(@Param("loanId") Long loanId);
}