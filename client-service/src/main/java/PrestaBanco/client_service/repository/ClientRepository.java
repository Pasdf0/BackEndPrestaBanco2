package PrestaBanco.client_service.repository;

import PrestaBanco.client_service.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    @Query("SELECT e FROM ClientEntity e WHERE e.email = :email")
    ClientEntity findByEmail(@Param("email") String email);
}
