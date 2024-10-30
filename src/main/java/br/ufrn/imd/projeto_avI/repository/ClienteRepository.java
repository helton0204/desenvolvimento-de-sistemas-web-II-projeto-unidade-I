package br.ufrn.imd.projeto_avI.repository;

import br.ufrn.imd.projeto_avI.model.ClienteEntity;
import br.ufrn.imd.projeto_avI.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    @Query("SELECT c FROM ClienteEntity c WHERE c.ativo = true")
    List<ClienteEntity> findAllActive();

    Optional<ClienteEntity> findByIdAndAtivoTrue(Long id);
}
