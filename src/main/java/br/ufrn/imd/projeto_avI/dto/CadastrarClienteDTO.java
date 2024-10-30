package br.ufrn.imd.projeto_avI.dto;

import br.ufrn.imd.projeto_avI.model.GeneroCliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record CadastrarClienteDTO(
        @NotBlank(message = "O nome do cliente é obrigatório.")
        String nome,

        @NotBlank(message = "O CPF é obrigatório.")
        String cpf,

        @NotNull(message = "O gênero do cliente é obrigatório.")
        GeneroCliente genero,

        @NotNull(message = "A data de nascimento é obrigatória.")
        LocalDate dataNascimento
) {}
