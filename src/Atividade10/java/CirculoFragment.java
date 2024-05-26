package br.edu.fateczl.atividade10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import br.edu.fateczl.atividade10.Controller.IGeometriaController;
import br.edu.fateczl.atividade10.Controller.RetanguloController;


public class CirculoFragment extends Fragment {
    private EditText etRaio;
    private Button btnArea, btnPerimetro;
    private TextView txtVResultadoC;
    private View view;
    private Circulo circulo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_circulo, container, false);
        etRaio = view.findViewById(R.id.etRaio);
        btnArea = view.findViewById(R.id.btnArea);
        btnPerimetro = view.findViewById(R.id.btnPerimetro);
        txtVResultadoC = view.findViewById(R.id.txtVResultadoC);
        btnPerimetro.setOnClickListener(op -> Perimetro());
        btnArea.setOnClickListener(op -> Area());

        return view;
    }
    private void Perimetro() {
        SetCirculo();
        IGeometriaController Ig = new RetanguloController();
        float Perimetro = 0;
        Perimetro = Ig.calcPerimetro(circulo);
        txtVResultadoC.setText("Resultado Perimetro = " + String.valueOf(Perimetro));
        limpar();
    }

    private void limpar() {
        etRaio.setText("");
    }

    private void SetCirculo() {
        circulo = new Circulo();
        circulo.setRaio(Float.parseFloat(etRaio.getText().toString()));
    }

    private void Area() {
        SetCirculo();
        IGeometriaController Ig = new RetanguloController();
        float Area = 0;
        Area = Ig.calcArea(circulo);
        txtVResultadoC.setText("Resultado Area = " + String.valueOf(Area));
        limpar();
    }
}
