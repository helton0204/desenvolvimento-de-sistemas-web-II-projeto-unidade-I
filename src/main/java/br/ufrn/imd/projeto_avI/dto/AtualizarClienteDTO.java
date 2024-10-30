package br.ufrn.imd.projeto_avI.dto;

import br.ufrn.imd.projeto_avI.model.GeneroCliente;

import java.time.LocalDate;

public record AtualizarClienteDTO(
        String nome,
        String cpf,
        GeneroCliente genero,
        LocalDate dataNascimento
) {
}
