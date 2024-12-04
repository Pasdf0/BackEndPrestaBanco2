package PrestaBanco.loan_service.repository;

import PrestaBanco.loan_service.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, Long> {

    @Query("SELECT e FROM LoanEntity e WHERE e.execId IS NULL")
    ArrayList<LoanEntity> findAllNew();

    @Query("SELECT e FROM LoanEntity e WHERE e.execId = :execId")
    ArrayList<LoanEntity> findByExecId(@Param("execId") Long execId);

    @Query("SELECT e FROM LoanEntity e WHERE e.clientId = :clientId")
    ArrayList<LoanEntity> findByClientId(@Param("clientId") Long clientId);
}