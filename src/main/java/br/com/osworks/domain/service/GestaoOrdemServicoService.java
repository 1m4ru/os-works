/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.osworks.domain.service;

import br.com.osworks.domain.exception.NegocioException;
import br.com.osworks.domain.model.Cliente;
import br.com.osworks.domain.model.OrdemServico;
import br.com.osworks.domain.model.StatusOrdemServico;
import br.com.osworks.domain.repository.ClienteRepository;
import br.com.osworks.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 1m4ru
 */
@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
   
    public OrdemServico criar(OrdemServico ordemServico) {
        Cliente cliente =  clienteRepository.findById(ordemServico.getCliente().getId())
                    .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
        
        ordemServico.setCliente(cliente);
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());
        
        
        return ordemServicoRepository.save(ordemServico);

    }

}
