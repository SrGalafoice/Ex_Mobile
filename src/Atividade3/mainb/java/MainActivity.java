package com.example.atividade3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etQuant, etKm;
    private Button btnCalc;
    private TextView txtVResultado;

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
        etQuant.findViewById(R.id.etQuant);
        etKm.findViewById(R.id.etKm);
        btnCalc.findViewById(R.id.btnCalc);
        txtVResultado.findViewById(R.id.txtVResultado);

        btnCalc.setOnClickListener(op -> calcular());
    }

    private void calcular() {
        double Km = Double.parseDouble(etKm.getText().toString());
        double tanque = Double.parseDouble(etQuant.getText().toString());

        double Resultado = (Km * tanque) / 1000;
        String res = "Esse veiculo percorre = " + Resultado + " metros com o tanque cheio";

        txtVResultado.setText(res);
    }
}
