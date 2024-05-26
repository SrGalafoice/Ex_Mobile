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


public class RetanguloFragment extends Fragment {
    private EditText etBase, etAltura;
    private Button btnArea, btnPerimetro;
    private TextView txtVResultadoR;
    private View view;
    private Retangulo retangulo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_retangulo, container, false);
        etAltura = view.findViewById(R.id.etAltura);
        etBase = view.findViewById(R.id.etBase);
        btnArea = view.findViewById(R.id.btnArea);
        btnPerimetro = view.findViewById(R.id.btnPerimetro);
        txtVResultadoR = view.findViewById(R.id.txtVResultadoR);
        btnPerimetro.setOnClickListener(op -> Perimetro());
        btnArea.setOnClickListener(op -> Area());

        return view;
    }

    private void Perimetro() {
        SetRetangulo();
        IGeometriaController Ig = new RetanguloController();
         float Perimetro = 0;
        Perimetro = Ig.calcPerimetro(retangulo);
        txtVResultadoR.setText("Resultado Perimetro = " + String.valueOf(Perimetro));
        limpar();
    }

    private void limpar() {
        etBase.setText("");
        etAltura.setText("");
    }

    private void SetRetangulo() {
        retangulo = new Retangulo();
        retangulo.setAltura(Float.parseFloat(etAltura.getText().toString()));
        retangulo.setBase(Float.parseFloat(etBase.getText().toString()));
    }

    private void Area() {
        SetRetangulo();
        IGeometriaController Ig = new RetanguloController();
        float Area = 0;
        Area = Ig.calcArea(retangulo);
        txtVResultadoR.setText("Resultado Area = " + String.valueOf(Area));
        limpar();
    }
}
