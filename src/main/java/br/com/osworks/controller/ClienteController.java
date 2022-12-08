/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.osworks.controller;

import br.com.osworks.domain.model.Cliente;
import br.com.osworks.domain.repository.ClienteRepository;
import br.com.osworks.domain.service.CadastroClienteService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 1m4ru
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
  
    
    @Autowired
    private  ClienteRepository clienteRepository;
    
    @Autowired
    private CadastroClienteService cadastroClienteService;
            
    @GetMapping
    public List<Cliente> listar(){
      return clienteRepository.findAll();
     }
    
    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
       if(cliente.isPresent()){
           return ResponseEntity.ok(cliente.get());
       }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) throws Exception{
        return cadastroClienteService.salvar(cliente);
    }
    
    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, 
            @RequestBody Cliente cliente) throws Exception{
        
        if(clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        
        cliente.setId(clienteId);
        cadastroClienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }
    
    @DeleteMapping("/{ClienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId){
        if(clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        cadastroClienteService.excluir(clienteId);
        return ResponseEntity.noContent().build();
    }
    
}
