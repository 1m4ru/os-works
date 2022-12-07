/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.osworks.domain.repository;

import br.com.osworks.domain.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 1m4ru
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    List<Cliente> findBynome(String nome);
    List<Cliente> findByNomeContaining(String nome);
    Cliente findByEmail(String email);
}
