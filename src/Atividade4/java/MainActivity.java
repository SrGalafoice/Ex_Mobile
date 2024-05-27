package com.example.atividade4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {
    private EditText etDia, etMes, etAno;
    private Button btnCalc;
    private TextView txtVRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etAno.findViewById(R.id.etAno);
        etDia.findViewById(R.id.etDia);
        etMes.findViewById(R.id.etMes);
        btnCalc.findViewById(R.id.btnCalcular);
        txtVRes.findViewById(R.id.txtVResultado);

        btnCalc.setOnClickListener(op -> calcular());
    }

    private void calcular() {
        int ano = Integer.parseInt(etAno.getText().toString());
        int mes = Integer.parseInt(etMes.getText().toString());
        int dia = Integer.parseInt(etDia.getText().toString());

        int diaAtual = LocalDateTime.now().getDayOfMonth();
        int mesAtual = LocalDateTime.now().getMonthValue();
        int anoAtual = LocalDateTime.now().getYear();

        int idadeA=0;
        int idadeD=0;
        int idadeM=0;

        idadeA = anoAtual - ano;
        idadeM = ano*12;
        idadeD = (365*ano) + (ano/4);

        String res = "Dias vivos: " + idadeD + "Meses vivos: "+idadeM+"Anos vivos: "+idadeA;
        txtVRes.setText(res);
    }
}
