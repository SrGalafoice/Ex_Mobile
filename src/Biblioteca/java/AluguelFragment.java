package br.edu.fateczl.biblioteca;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.fateczl.biblioteca.model.Aluno;
import br.edu.fateczl.biblioteca.model.Exemplar;

public class AluguelFragment extends Fragment {
    private View view;
    private EditText etDataD, etDataR;
    private Button btnCadastrar, btnBuscar, btnDeletar, btnAtualizar, btnListar;
    private Spinner spAluno, spExemplar;
    private TextView tvRes;
    private Aluno aluno;
    private Exemplar exemplar;
    public AluguelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_aluguel, container, false);

        etDataD= view.findViewById(R.id.etDataD);
        etDataR = view.findViewById(R.id.etDataR);
        spAluno = view.findViewById(R.id.spAluno);
        spExemplar = view.findViewById(R.id.spExemplar);
        btnAtualizar = view.findViewById(R.id.btnAtualizarA);
        btnBuscar = view.findViewById(R.id.btnBuscarA);
        btnCadastrar = view.findViewById(R.id.btnCadastrarA);
        btnDeletar = view.findViewById(R.id.btnDeletarA);
        btnListar = view.findViewById(R.id.btnListarA);
        tvRes = view.findViewById(R.id.tvResAlug);
        tvRes.setMovementMethod(new ScrollingMovementMethod());

        preencheSpinner();

        btnCadastrar.setOnClickListener(op -> Cadastrar());
        btnAtualizar.setOnClickListener(op -> Atualizar());
        btnDeletar.setOnClickListener(op -> Deletar());
        btnBuscar.setOnClickListener(op -> Buscar());
        btnListar.setOnClickListener(op -> Listar());


        return view;
    }

    private void Cadastrar() {
        

    }

    private void Buscar() {

    }

    private void Atualizar() {

    }

    private void Deletar() {

    }

    private void Listar() {

    }

    private void preencheSpinner() {
        spAluno.
    }
}
