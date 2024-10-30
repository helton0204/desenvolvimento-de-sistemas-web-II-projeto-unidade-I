package br.ufrn.imd.projeto_avI.service;

import br.ufrn.imd.projeto_avI.dto.AtualizarClienteDTO;
import br.ufrn.imd.projeto_avI.dto.ClienteDTO;
import br.ufrn.imd.projeto_avI.dto.ProdutoDTO;
import br.ufrn.imd.projeto_avI.model.ClienteEntity;
import br.ufrn.imd.projeto_avI.model.ProdutoEntity;
import br.ufrn.imd.projeto_avI.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired ClienteRepository clienteRepository;

    public List<ClienteDTO> getAll() {
        return clienteRepository.findAllActive()
                .stream()
                .map(ClienteDTO::new)
                .collect(Collectors.toList());
    }


    public ClienteDTO getById(Long id) {
        ClienteEntity clienteEntity = clienteRepository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new NoSuchElementException("Produto com ID " + id + " não encontrado"));
        return new ClienteDTO(clienteEntity);
    }

    @Transactional
    public ClienteDTO createCliente(@Valid ClienteDTO clienteDTO) {
        ClienteEntity clienteEntity = new ClienteEntity(clienteDTO);
        ClienteEntity savedCliente = clienteRepository.save(clienteEntity);
        return new ClienteDTO(savedCliente);
    }

    @Transactional
    public ClienteDTO updateCliente(Long id, AtualizarClienteDTO atualizarClienteDTO) {
        ClienteEntity clienteEntity = clienteRepository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new NoSuchElementException("Produto com ID " + id + " não encontrado"));

        clienteEntity.atualizar(atualizarClienteDTO);
        ClienteEntity updatedCliente = clienteRepository.save(clienteEntity);
        return new ClienteDTO(updatedCliente);
    }

    @Transactional
    public void deleteLogicCliente(Long id) {
        ClienteEntity clienteEntity = clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto com ID " + id + " não encontrado"));
        clienteEntity.delete();
        clienteRepository.save(clienteEntity);
    }

    @Transactional
    public void deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        }
        else {
            throw new NoSuchElementException("Produto com ID " + id + " não encontrado");
        }
    }
}
