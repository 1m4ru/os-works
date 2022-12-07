/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.osworks.domain.exception;

/**
 *
 * @author 1m4ru
 */
public class NegocioException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    
    public NegocioException(String message){
        super(message);
    }
}
