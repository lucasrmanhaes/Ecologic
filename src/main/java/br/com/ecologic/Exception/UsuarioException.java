package br.com.ecologic.Exception;

public class UsuarioException extends RuntimeException{
    public UsuarioException(String mensagem){
        super(mensagem);
    }
}
