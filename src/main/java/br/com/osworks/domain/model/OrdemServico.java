/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.osworks.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author 1m4ru
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private String descricao;
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private StatusOrdemServico status;
    
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFinalizacao;

}
