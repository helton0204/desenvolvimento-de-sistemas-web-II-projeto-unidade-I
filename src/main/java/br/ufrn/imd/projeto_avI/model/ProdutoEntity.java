package br.ufrn.imd.projeto_avI.model;

import br.ufrn.imd.projeto_avI.dto.AtualizarProdutoDTO;
import br.ufrn.imd.projeto_avI.dto.ProdutoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;

    private String marca;

    private LocalDate dataFabricacao;

    private LocalDate dataValidade;

    @Enumerated(EnumType.STRING)
    private GeneroProduto genero;

    private String lote;

    private Boolean ativo;

    public ProdutoEntity(ProdutoDTO produtoDTO) {
        this.nomeProduto = produtoDTO.nomeProduto();
        this.marca = produtoDTO.marca();
        this.dataFabricacao = produtoDTO.dataFabricacao();
        this.dataValidade = produtoDTO.dataValidade();
        this.genero = produtoDTO.genero();
        this.lote = produtoDTO.lote();
        this.ativo = true;
    }

    public void atualizar(AtualizarProdutoDTO atualizarProdutoDTO) {
        if(atualizarProdutoDTO.nomeProduto() != null) {
            this.nomeProduto = atualizarProdutoDTO.nomeProduto();
        }
        if(atualizarProdutoDTO.marca() != null) {
            this.marca = atualizarProdutoDTO.marca();
        }
        if(atualizarProdutoDTO.dataFabricacao() != null) {
            this.dataFabricacao = atualizarProdutoDTO.dataFabricacao();
        }
        if(atualizarProdutoDTO.dataValidade() != null) {
            this.dataValidade = atualizarProdutoDTO.dataValidade();
        }
        if(atualizarProdutoDTO.genero() != null) {
            this.genero = atualizarProdutoDTO.genero();
        }
        if(atualizarProdutoDTO.lote() != null) {
            this.lote = atualizarProdutoDTO.lote();
        }
    }

    public void delete() {
        this.ativo = false;
    }
}