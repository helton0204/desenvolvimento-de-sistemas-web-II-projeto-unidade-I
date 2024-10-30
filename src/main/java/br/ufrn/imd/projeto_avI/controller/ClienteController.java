package br.ufrn.imd.projeto_avI.controller;

import br.ufrn.imd.projeto_avI.dto.AtualizarClienteDTO;
import br.ufrn.imd.projeto_avI.dto.AtualizarProdutoDTO;
import br.ufrn.imd.projeto_avI.dto.ClienteDTO;
import br.ufrn.imd.projeto_avI.dto.ProdutoDTO;
import br.ufrn.imd.projeto_avI.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        List<ClienteDTO> clientes = clienteService.getAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
        ClienteDTO cliente = clienteService.getById(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> postCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO savedCliente = clienteService.createCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> putCliente(@PathVariable Long id, @RequestBody AtualizarClienteDTO atualizarClienteDTO) {
        ClienteDTO updatedCliente = clienteService.updateCliente(id, atualizarClienteDTO);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogicCliente(@PathVariable Long id) {
        clienteService.deleteLogicCliente(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/excusao-definitiva/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

}
