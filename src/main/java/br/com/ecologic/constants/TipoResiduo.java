package br.com.ecologic.constants;

public enum TipoResiduo {
    RECICLAVEIS("Reciclaveis"),
    ORGANICOS("Organicos");

    private String descricao;

    TipoResiduo(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
