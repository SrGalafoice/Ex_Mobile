package br.edu.fateczl.acervo;

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

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.acervo.controller.PinturaController;
import br.edu.fateczl.acervo.model.Pintura;
import br.edu.fateczl.acervo.persistence.PinturaDao;

public class PinturaFragment extends Fragment {
    private EditText etTitulo, etCodigo, etArtista, etAno, etPrat;
    private TextView tvSaida;
    private Button btnBuscar, btnInserir, btnExcluir, btnAtualizar, btnListar;

    private View view;
    private String codigo;
    private PinturaController PCont;
    public PinturaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pintura, container, false);
        etTitulo = view.findViewById(R.id.etTituloP);
        etArtista = view.findViewById(R.id.etArtista);
        etAno = view.findViewById(R.id.etAnoP);
        etPrat = view.findViewById(R.id.etPratP);
        etCodigo = view.findViewById(R.id.etCodigoP);
        tvSaida = view.findViewById(R.id.tvSaidaP);
        tvSaida.setMovementMethod(new ScrollingMovementMethod());
        btnAtualizar = view.findViewById(R.id.btnAtualizarP);
        btnBuscar = view.findViewById(R.id.btnBuscarP);
        btnExcluir = view.findViewById(R.id.btnExcluirP);
        btnInserir = view.findViewById(R.id.btnInserirP);
        btnListar = view.findViewById(R.id.btnListarP);

        PCont = new PinturaController(new PinturaDao(view.getContext()));
        btnAtualizar.setOnClickListener(op -> acaoAtualizar());
        btnBuscar.setOnClickListener(op -> acaoBuscar());
        btnExcluir.setOnClickListener(op -> acaoExcluir());
        btnInserir.setOnClickListener(op -> acaoInserir());
        btnListar.setOnClickListener(op -> acaoListar());
        return view;
    }

    private void acaoInserir() {
        Pintura pintura = montaPintura();
        try {
            PCont.Inserir(pintura);
            Toast.makeText(view.getContext(), "Pintura inserida! :)", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoExcluir() {
        Pintura pintura = montaPintura();
        try {
            PCont.Excluir(pintura);
            Toast.makeText(view.getContext(),"Pintura Deletada >:)", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoBuscar() {
        Pintura pintura = montaPintura();
        try {
            pintura = PCont.Buscar(pintura);
            if (pintura != null) {
                preencheCampos(pintura);
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoAtualizar() {
        Pintura pintura = montaPintura();
        try {
            PCont.Atualizar(pintura);
            Toast.makeText(view.getContext(),"Pintura Atualizada >:)", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoListar() {
        try {
            List<Pintura> pinturas = PCont.Listar();
            StringBuffer buffer = new StringBuffer();
            for (Pintura pintura : pinturas) {
                buffer.append(pintura.toString() + "\n");
            }
            tvSaida.setText(buffer.toString());
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public Pintura montaPintura() {
        Pintura pintura = new Pintura();
        pintura.setTitulo(etTitulo.getText().toString());
        pintura.setCodigo(codigo);
        pintura.setArtista(etArtista.getText().toString());
        pintura.setAno(Integer.parseInt(etAno.getText().toString()));
        pintura.setNumPrateleira(Integer.parseInt(etPrat.getText().toString()));
        return pintura;
    }
    private void montaCodigo() {
        codigo = etCodigo.getText().toString() + "P";
    }

    public void preencheCampos(Pintura pintura) {
        etTitulo.setText(pintura.getTitulo());
        etCodigo.setText(pintura.getCodigo());
        etArtista.setText(pintura.getArtista());
        etAno.setText(String.valueOf(pintura.getAno()));
        etPrat.setText(String.valueOf(pintura.getNumPrateleira()));
    }

    private void limpaCampos() {
        etTitulo.setText("");
        etCodigo.setText("");
        etArtista.setText("");
        etAno.setText("");
        etPrat.setText("");
    }
    }
