  package br.edu.fateczl.relatorios.model;

import java.time.LocalDate;

public class Contrato {
    private LocalDate datainicio, datafim;
    private Cliente cliente;
    private String codigo;

    public Contrato() {
    }

    public LocalDate getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(LocalDate datainicio) {
        this.datainicio = datainicio;
    }

    public LocalDate getDatafim() {
        return datafim;
    }

    public void setDatafim(LocalDate datafim) {
        this.datafim = datafim;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "data inicio: " + datainicio +
                ", data fim: " + datafim +
                ", " + cliente.getNome() +
                ", " + codigo  +
                '}';
    }
}
