/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

/**
 *
 * @author 1m4ru
 */
@Data
public class Problema {
    
    
    private Integer status;
    private LocalDateTime datahora;
    private String titulo;
    private List<Campo> campos;

    @Data
    public static class Campo {

        private String nome;
        private String mensagens;

        public Campo(String nome, String mensagens) {
            this.nome = nome;
            this.mensagens = mensagens;
        }
        
    }
    
}
