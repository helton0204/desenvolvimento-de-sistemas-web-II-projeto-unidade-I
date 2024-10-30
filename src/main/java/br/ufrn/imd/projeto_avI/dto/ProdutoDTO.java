package br.ufrn.imd.projeto_avI.dto;

import java.time.LocalDate;

import br.ufrn.imd.projeto_avI.model.GeneroProduto;
import br.ufrn.imd.projeto_avI.model.ProdutoEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(
        Long id,

        @NotBlank(message = "O nome do produto é obrigatório.")
        String nomeProduto,

        @NotBlank(message = "A marca do produto é obrigatória.")
        String marca,

        @NotNull(message = "A data de fabricação é obrigatória.")
        LocalDate dataFabricacao,

        LocalDate dataValidade,

        @NotNull(message = "O gênero do produto é obrigatório.")
        GeneroProduto genero,

        @NotBlank(message = "O lote é obrigatório.")
        String lote
) {
        public ProdutoDTO(ProdutoEntity produto){
                this(
                        produto.getId(),
                        produto.getNomeProduto(),
                        produto.getMarca(),
                        produto.getDataFabricacao(),
                        produto.getDataValidade(),
                        produto.getGenero(),
                        produto.getLote()
                );
        }
}
