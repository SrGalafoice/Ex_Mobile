package br.edu.fateczl.acervo.persistence;

import java.sql.SQLException;

import br.edu.fateczl.acervo.model.Livro;

public interface ILivroDao {
    public LivroDao open() throws SQLException;
    public void close();
}
