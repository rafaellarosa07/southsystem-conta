package com.southsystem.api.job.conta.enums;

public enum TipoConta {

    C("C"), E("E");


    String nome;

    TipoConta(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public static TipoConta getByEnumString(String sigla) {
        for(TipoConta  tipo : TipoConta.values()) {
            if(tipo.toString().equals(sigla)) {
                return tipo;
            }
        }
        return null;
    }

}
