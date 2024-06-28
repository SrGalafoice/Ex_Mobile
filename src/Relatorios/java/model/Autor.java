package br.edu.fateczl.relatorios.model;

public class Autor extends Pessoa{
    private String apelido;
    private int Ordem;
    private Boolean Anonimato;

    public Autor() {
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getOrdem() {
        return Ordem;
    }

    public void setOrdem(int ordem) {
        Ordem = ordem;
    }

    public Boolean getAnonimato() {
        return Anonimato;
    }

    public void setAnonimato(Boolean anonimato) {
        Anonimato = anonimato;
    }
}
