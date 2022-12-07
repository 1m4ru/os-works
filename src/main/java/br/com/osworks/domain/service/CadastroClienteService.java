/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.osworks.domain.service;

import br.com.osworks.domain.exception.NegocioException;
import br.com.osworks.domain.model.Cliente;
import br.com.osworks.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 1m4ru
 */
@Service
public class CadastroClienteService {

   @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) throws Exception {
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
        
        if(clienteExistente != null && !clienteExistente.equals(cliente)) {
           throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
        }
        return clienteRepository.save(cliente);
        
    }
    
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }

}
