package br.edu.fateczl.acervo.controller;

import java.sql.SQLException;
import java.util.List;

public interface IController<T> {
    public void Inserir(T t) throws SQLException;
    public void Excluir(T t) throws SQLException;
    public void Atualizar(T t) throws SQLException;
    public T Buscar(T t) throws SQLException;
    public List<T> Listar() throws SQLException;
}
