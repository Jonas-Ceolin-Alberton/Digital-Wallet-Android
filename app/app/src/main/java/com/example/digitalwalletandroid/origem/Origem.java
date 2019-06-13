package com.example.digitalwalletandroid.origem;

public class Origem{
    private Long id;
    private String nome;

    public  Origem(String nome){
        this.nome = nome;
    }

    public  Origem(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
