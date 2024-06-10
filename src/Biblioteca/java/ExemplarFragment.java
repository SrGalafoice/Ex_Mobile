package br.edu.fateczl.biblioteca;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import br.edu.fateczl.biblioteca.model.Exemplar;

public class ExemplarFragment extends Fragment {
private View view;
    private EditText etNome, etCod,etQtdP, etBarras, etEdicao;
    private RadioButton rbLivro, rbRevista;
    private Button btnCadastrar, btnBuscar, btnDeletar, btnAtualizar, btnListar;
    private TextView tvResE;
    private Exemplar exemplar;
    public ExemplarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_exemplar, container, false);

        etNome = view.findViewById(R.id.etNomeE);
        etCod = view.findViewById(R.id.etCodE);
        etQtdP = view.findViewById(R.id.etQtdPag);
        etBarras = view.findViewById(R.id.etBarras);
        etEdicao = view.findViewById(R.id.etEdicao);
        rbLivro = view.findViewById(R.id.rbLivro);
        rbLivro.setChecked(true);
        rbRevista = view.findViewById(R.id.rbRevista);
        btnAtualizar = view.findViewById(R.id.btnAtualizarE);
        btnBuscar = view.findViewById(R.id.btnBuscarE);
        btnCadastrar = view.findViewById(R.id.btnCadastrarE);
        btnDeletar = view.findViewById(R.id.btnDeletarE);
        btnListar = view.findViewById(R.id.btnListarE);
        tvResE = view.findViewById(R.id.tvResE);
        tvResE.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }
}
