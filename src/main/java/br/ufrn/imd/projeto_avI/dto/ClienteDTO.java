package br.ufrn.imd.projeto_avI.dto;

import br.ufrn.imd.projeto_avI.model.ClienteEntity;
import br.ufrn.imd.projeto_avI.model.GeneroCliente;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClienteDTO(
    Long id,

    @NotBlank(message = "O nome do cliente é obrigatório.")
    String nome,

    @NotBlank(message = "O CPF é obrigatório.")
    String cpf,

    @NotNull(message = "O gênero do cliente é obrigatório.")
    GeneroCliente genero,

    @NotNull(message = "A data de nascimento é obrigatória.")
    LocalDate dataNascimento

) {
    public ClienteDTO(ClienteEntity cliente){
        this(
            cliente.getId(),
            cliente.getNome(),
            cliente.getCpf(),
            cliente.getGenero(),
            cliente.getDataNascimento()
        );
    }
}
