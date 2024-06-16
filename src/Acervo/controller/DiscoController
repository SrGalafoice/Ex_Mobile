package br.edu.fateczl.acervo.controller;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.acervo.model.Disco;
import br.edu.fateczl.acervo.persistence.DiscoDao;

public class DiscoController implements IController<Disco> {
    private DiscoDao DD;
    public DiscoController(DiscoDao DD){
        this.DD = DD;
    }

    @Override
    public void Inserir(Disco disco) throws SQLException {
        if (DD.open() == null){
            DD.open();
        }
        DD.insert(disco);
        DD.close();
    }

    @Override
    public void Excluir(Disco disco) throws SQLException {
        if (DD.open() == null){
            DD.open();
        }
        DD.delete(disco);
        DD.close();
    }

    @Override
    public void Atualizar(Disco disco) throws SQLException {
        if (DD.open() == null){
            DD.open();
        }
        DD.update(disco);
        DD.close();
    }

    @Override
    public Disco Buscar(Disco disco) throws SQLException {
        if (DD.open() == null){
            DD.open();
        }
        return DD.findOne(disco);
    }

    @Override
    public List<Disco> Listar() throws SQLException {
        if (DD.open() == null){
            DD.open();
        }
        return DD.findAll();
    }
}
