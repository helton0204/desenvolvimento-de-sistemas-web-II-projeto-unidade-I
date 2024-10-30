package br.ufrn.imd.projeto_avI.model;

import br.ufrn.imd.projeto_avI.dto.AtualizarClienteDTO;
import br.ufrn.imd.projeto_avI.dto.AtualizarProdutoDTO;
import br.ufrn.imd.projeto_avI.dto.ClienteDTO;
import br.ufrn.imd.projeto_avI.dto.ProdutoDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private GeneroCliente genero;

    private LocalDate dataNascimento;

    private Boolean ativo;

    public ClienteEntity(ClienteDTO clienteDTO) {
        this.nome = clienteDTO.nome();
        this.cpf = clienteDTO.cpf();
        this.genero = clienteDTO.genero();
        this.dataNascimento = clienteDTO.dataNascimento();
        this.ativo = true;
    }

    public void atualizar(AtualizarClienteDTO atualizarClienteDTO) {
        if(atualizarClienteDTO.nome() != null) {
            this.nome = atualizarClienteDTO.nome();
        }
        if(atualizarClienteDTO.cpf() != null) {
            this.cpf = atualizarClienteDTO.cpf();
        }
        if(atualizarClienteDTO.genero() != null) {
            this.genero = atualizarClienteDTO.genero();
        }
        if(atualizarClienteDTO.dataNascimento() != null) {
            this.dataNascimento = atualizarClienteDTO.dataNascimento();
        }
    }

    public void delete() {
        this.ativo = false;
    }
}
