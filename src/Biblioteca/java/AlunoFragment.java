package br.edu.fateczl.biblioteca;

import android.database.SQLException;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.fateczl.biblioteca.model.Aluno;

public class AlunoFragment extends Fragment {

    private View view;
    private EditText etNome, etRA,etEmail;
    private Button btnCadastrar, btnBuscar, btnDeletar, btnAtualizar, btnListar;
    private TextView tvResA;
    private Aluno aluno;

    public AlunoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_aluno, container, false);


        etNome = view.findViewById(R.id.etNome);
        etRA = view.findViewById(R.id.etRA);
        etEmail = view.findViewById(R.id.etEmail);
        btnAtualizar = view.findViewById(R.id.btnAtualizarA);
        btnBuscar = view.findViewById(R.id.btnBuscarA);
        btnCadastrar = view.findViewById(R.id.btnCadastrarA);
        btnDeletar = view.findViewById(R.id.btnDeletarA);
        btnListar = view.findViewById(R.id.btnListarA);
        tvResA = view.findViewById(R.id.tvResA);
        tvResA.setMovementMethod(new ScrollingMovementMethod());

        btnCadastrar.setOnClickListener(op -> Cadastrar());
        btnAtualizar.setOnClickListener(op -> Atualizar());
        btnDeletar.setOnClickListener(op -> Deletar());
        btnBuscar.setOnClickListener(op -> Buscar());
        btnListar.setOnClickListener(op -> Listar());
        return view;
    }

    private void Cadastrar() {
        }

    private void limpaCampos() {
        etNome.setText("");
        etRA.setText("");
        etEmail.setText("");
    }


    private void Atualizar() {
    }

    private void Deletar() {
    }

    private void Buscar() {
    }

    private void Listar() {
    }

}
