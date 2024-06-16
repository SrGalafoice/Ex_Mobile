package br.edu.fateczl.acervo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.acervo.controller.LivroController;
import br.edu.fateczl.acervo.model.Livro;
import br.edu.fateczl.acervo.persistence.LivroDao;

public class LivroFragment extends Fragment {
private View view;
private EditText etTitulo, etCodigo, etEdicao, etAno, etPrat;
private TextView tvSaida;
private Button btnBuscar, btnInserir, btnExcluir, btnAtualizar, btnListar;
private LivroController LCont;

    public LivroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_livro, container, false);
        etTitulo = view.findViewById(R.id.etTituloL);
        etEdicao = view.findViewById(R.id.etEdicao);
        etAno = view.findViewById(R.id.etAnoL);
        etPrat = view.findViewById(R.id.etPratL);
        etCodigo = view.findViewById(R.id.etCodigoL);
        tvSaida = view.findViewById(R.id.tvSaidaL);
        tvSaida.setMovementMethod(new ScrollingMovementMethod());
        btnAtualizar = view.findViewById(R.id.btnAtualizarL);
        btnBuscar = view.findViewById(R.id.btnBuscarL);
        btnExcluir = view.findViewById(R.id.btnExcluirL);
        btnInserir = view.findViewById(R.id.btnInserirL);
        btnListar = view.findViewById(R.id.btnListarL);

        LCont = new LivroController(new LivroDao(view.getContext()));

        btnAtualizar.setOnClickListener(op -> acaoAtualizar());
        btnBuscar.setOnClickListener(op -> acaoBuscar());
        btnExcluir.setOnClickListener(op -> acaoExcluir());
        btnInserir.setOnClickListener(op -> acaoInserir());
        btnListar.setOnClickListener(op -> acaoListar());
        return view;
    }

    private void acaoInserir() {
        Livro livro = montaLivro();
        try{
            LCont.Inserir(livro);
            Toast.makeText(view.getContext(), "Livro inserido! :)", Toast.LENGTH_LONG).show();
        }catch (SQLException e){
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoExcluir() {
        Livro livro = montaLivro();
        try{
            LCont.Excluir(livro);
            Toast.makeText(view.getContext(),"Livro Deletado >:)", Toast.LENGTH_LONG).show();
        }catch (SQLException e){
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoBuscar() {
        Livro livro = montaLivro();
        try{
            livro = LCont.Buscar(livro);
            if (livro != null){
                preencheCampos(livro);
            }
        }catch (SQLException e){
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoAtualizar() {
        Livro livro = montaLivro();
        try{
            LCont.Atualizar(livro);
            Toast.makeText(view.getContext(),"Livro Atualizado >:)", Toast.LENGTH_LONG).show();
        }catch (SQLException e){
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoListar() {
        try{
            List<Livro> livros = LCont.Listar();
            StringBuffer buffer = new StringBuffer();
            for (Livro lulu : livros){
                buffer.append(lulu.toString() + "\n");
            }
            tvSaida.setText(buffer.toString());
        }catch (SQLException e){
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public Livro montaLivro(){
        Livro livro = new Livro();
        String codigo = etCodigo.getText().toString() + "L";
        livro.setTitulo(etTitulo.getText().toString());
        livro.setCodigo(codigo);
        livro.setTitulo(etEdicao.getText().toString());
        livro.setAno(Integer.parseInt(etAno.getText().toString()));
        livro.setNumPrateleira(Integer.parseInt(etPrat.getText().toString()));
        return livro;
    }
    public void preencheCampos(Livro livro){
        etTitulo.setText(livro.getTitulo());
        etCodigo.setText(livro.getCodigo());
        etEdicao.setText(livro.getEdicao());
        etAno.setText(String.valueOf(livro.getAno()));
        etPrat.setText(String.valueOf(livro.getAno()));
    }
    private void limpaCampos(){
        etTitulo.setText("");
        etCodigo.setText("");
        etEdicao.setText("");
        etAno.setText("");
        etPrat.setText("");
    }

}
