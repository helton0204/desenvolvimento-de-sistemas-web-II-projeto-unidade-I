package br.ufrn.imd.projeto_avI.dto;

import br.ufrn.imd.projeto_avI.model.GeneroProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AtualizarProdutoDTO(
    String nomeProduto,
    String marca,
    LocalDate dataFabricacao,
    LocalDate dataValidade,
    GeneroProduto genero,
    String lote
    ) {

}
