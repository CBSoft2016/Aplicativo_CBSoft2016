package com.applications.fronchetti.cbsoft2016.Adapters;

public class Hotel {
    public String nome;
    public String website;
    public String telefone;
    public String endereco;
    public String imagem;

    public Hotel(String nome, String endereco, String telefone, String website, String imagem){
            this.nome = nome;
            this.website = website;
            this.telefone = telefone;
            this.endereco = endereco;
            this.imagem = imagem;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

