package br.ufrn.imd.projeto_avI.controller;

import br.ufrn.imd.projeto_avI.dto.AtualizarProdutoDTO;
import br.ufrn.imd.projeto_avI.dto.ProdutoDTO;
import br.ufrn.imd.projeto_avI.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAll() {
        List<ProdutoDTO> produtos = produtoService.getAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getById(@PathVariable Long id) {
        ProdutoDTO produto = produtoService.getById(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> postProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO savedProduto = produtoService.createProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> putProduto(@PathVariable Long id, @RequestBody AtualizarProdutoDTO atualizarProdutoDTO) {
        ProdutoDTO updatedProduto = produtoService.updateProduto(id, atualizarProdutoDTO);
        return ResponseEntity.ok(updatedProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogicProduto(@PathVariable Long id) {
        produtoService.deleteLogicProduto(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/excusao-definitiva/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }

}