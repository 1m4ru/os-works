/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.osworks.api.exceptionhandler;

import br.com.osworks.domain.exception.NegocioException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author 1m4ru
 */
@ControllerAdvice
public class ApiExxceptionHandler extends ResponseEntityExceptionHandler {
    
    @Autowired
    private MessageSource messageSource;
    
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request){
        var status = HttpStatus.BAD_REQUEST;
        
        var problema = new Problema();
        problema.setStatus(status.value());
        problema.setTitulo(ex.getMessage());
        problema.setDatahora(LocalDateTime.now());
        
        return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        
        var campos = new ArrayList<Problema.Campo>();
        
        for(ObjectError error : ex.getBindingResult().getAllErrors()){
            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            
            campos.add(new Problema.Campo(nome, mensagem));
        }
        
        var problema = new Problema();
        problema.setStatus(status.value());
        problema.setTitulo("Um ou mais campos est??o vazios, Favor Preecher! "
                + "Tente novamente");
        problema.setDatahora(LocalDateTime.now());
        problema.setCampos(campos);
        return super.handleExceptionInternal(ex, problema, headers, status, request); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
