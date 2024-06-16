package br.edu.fateczl.acervo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.sql.SQLException;

import br.edu.fateczl.acervo.controller.DiscoController;
import br.edu.fateczl.acervo.model.Disco;
import br.edu.fateczl.acervo.persistence.DiscoDao;

public class DiscoFragment extends Fragment {
    private View view;
    private EditText etTitulo, etCodigo, etDuracao, etAno, etPrat;
    private TextView tvSaida;
    private Button btnBuscar, btnInserir, btnExcluir, btnAtualizar, btnListar;
    private DiscoController DCont;

    public DiscoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_disco, container, false);
        etTitulo = view.findViewById(R.id.etTituloD);
        etDuracao = view.findViewById(R.id.etDuracao);
        etAno = view.findViewById(R.id.etAnoD);
        etPrat = view.findViewById(R.id.etPratD);
        etCodigo = view.findViewById(R.id.etCodigoD);
        tvSaida = view.findViewById(R.id.tvSaidaD);
        tvSaida.setMovementMethod(new ScrollingMovementMethod());
        btnAtualizar = view.findViewById(R.id.btnAtualizarD);
        btnBuscar = view.findViewById(R.id.btnBuscarD);
        btnExcluir = view.findViewById(R.id.btnExcluirD);
        btnInserir = view.findViewById(R.id.btnInserirD);
        btnListar = view.findViewById(R.id.btnListarD);

        DCont = new DiscoController(new DiscoDao(view.getContext()));

        btnAtualizar.setOnClickListener(op -> acaoAtualizar());
        btnBuscar.setOnClickListener(op -> acaoBuscar());
        btnExcluir.setOnClickListener(op -> acaoExcluir());
        btnInserir.setOnClickListener(op -> acaoInserir());
        btnListar.setOnClickListener(op -> acaoListar());
        return view;
    }

    private void acaoInserir() {
        Disco disco = montaDisco();
        try {
            DCont.Inserir(disco);
            Toast.makeText(view.getContext(), "Disco inserido! :)", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoExcluir() {
        Disco disco = montaDisco();
        try {
            DCont.Excluir(disco);
            Toast.makeText(view.getContext(),"Disco Deletado >:)", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoBuscar() {
        Disco disco = montaDisco();
        try {
            disco = DCont.Buscar(disco);
            if (disco != null) {
                preencheCampos(disco);
            }
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoAtualizar() {
        Disco disco = montaDisco();
        try {
            DCont.Atualizar(disco);
            Toast.makeText(view.getContext(),"Disco Atualizado >:)", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void acaoListar() {
        try {
            List<Disco> discos = DCont.Listar();
            StringBuffer buffer = new StringBuffer();
            for (Disco disco : discos) {
                buffer.append(disco.toString() + "\n");
            }
            tvSaida.setText(buffer.toString());
        } catch (SQLException e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public Disco montaDisco(){
        Disco disco = new Disco();
        String codigo = etCodigo.getText().toString() + "D";
        disco.setTitulo(etTitulo.getText().toString());
        disco.setCodigo(codigo);
        disco.setDuracao(etDuracao.getText().toString());
        disco.setAno(Integer.parseInt(etAno.getText().toString()));
        disco.setNumPrateleira(Integer.parseInt(etPrat.getText().toString()));
        return disco;
    }


    public void preencheCampos(Disco disco) {
        etTitulo.setText(disco.getTitulo());
        etCodigo.setText(disco.getCodigo());
        etDuracao.setText(disco.getDuracao());
        etAno.setText(String.valueOf(disco.getAno()));
        etPrat.setText(String.valueOf(disco.getNumPrateleira()));
    }

    private void limpaCampos() {
        etTitulo.setText("");
        etCodigo.setText("");
        etDuracao.setText("");
        etAno.setText("");
        etPrat.setText("");
    }
}
