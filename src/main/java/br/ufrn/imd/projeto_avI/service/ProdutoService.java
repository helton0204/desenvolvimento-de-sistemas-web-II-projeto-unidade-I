package br.ufrn.imd.projeto_avI.service;

import br.ufrn.imd.projeto_avI.dto.AtualizarProdutoDTO;
import br.ufrn.imd.projeto_avI.dto.ProdutoDTO;
import br.ufrn.imd.projeto_avI.model.ProdutoEntity;
import br.ufrn.imd.projeto_avI.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> getAll() {
        return produtoRepository.findAllActive()
                .stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
    }

    public ProdutoDTO getById(Long id) {
        ProdutoEntity produtoEntity = produtoRepository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new NoSuchElementException("Produto com ID " + id + " não encontrado"));
        return new ProdutoDTO(produtoEntity);
    }

    @Transactional
    public ProdutoDTO createProduto(ProdutoDTO produtoDTO) {
        ProdutoEntity produtoEntity = new ProdutoEntity(produtoDTO);
        ProdutoEntity savedProduto = produtoRepository.save(produtoEntity);
        return new ProdutoDTO(savedProduto);
    }

    @Transactional
    public ProdutoDTO updateProduto(Long id, AtualizarProdutoDTO atualizarProdutoDTO) {
        ProdutoEntity produtoEntity = produtoRepository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new NoSuchElementException("Produto com ID " + id + " não encontrado"));

        produtoEntity.atualizar(atualizarProdutoDTO);
        ProdutoEntity updatedProduto = produtoRepository.save(produtoEntity);
        return new ProdutoDTO(updatedProduto);
    }

    @Transactional
    public void deleteLogicProduto(Long id) {
        ProdutoEntity produtoEntity = produtoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto com ID " + id + " não encontrado"));
        produtoEntity.delete();
        produtoRepository.save(produtoEntity);
    }

    @Transactional
    public void deleteProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        }
        else {
            throw new NoSuchElementException("Produto com ID " + id + " não encontrado");
        }
    }
}
