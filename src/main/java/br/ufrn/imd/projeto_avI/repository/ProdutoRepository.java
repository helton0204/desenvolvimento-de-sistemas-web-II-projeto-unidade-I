package br.ufrn.imd.projeto_avI.repository;

import br.ufrn.imd.projeto_avI.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    @Query("SELECT p FROM ProdutoEntity p WHERE p.ativo = true")
    List<ProdutoEntity> findAllActive();

    Optional<ProdutoEntity> findByIdAndAtivoTrue(Long id);
}
