package com.example.atividade6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.atividade6.model.ProfessorHorista;
import com.example.atividade6.model.ProfessorTitular;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbTitular, rbHorista;
    private EditText etAnos, etSalario, etHoras, etValorHorista;
    private Button btnCalc;
    private TextView txtVRes;

    ProfessorHorista horista=new ProfessorHorista();
    ProfessorTitular titular=new ProfessorTitular();

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
        rbTitular.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    etAnos.setVisibility(View.VISIBLE);
                    etSalario.setVisibility(View.VISIBLE);
                    btnCalc.setOnClickListener(op -> calcTitular());
                }else{
                    etAnos.setVisibility(View.INVISIBLE);
                    etSalario.setVisibility(View.INVISIBLE);
                    txtVRes.setText(" ");
                }

            }
        });

        rbHorista.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    etHoras.setVisibility(View.VISIBLE);
                    etValorHorista.setVisibility(View.VISIBLE);
                    btnCalc.setOnClickListener(op -> calcHorista());
                }else{
                    etHoras.setVisibility(View.INVISIBLE);
                    etValorHorista.setVisibility(View.INVISIBLE);
                    txtVRes.setText(" ");
                }
            }
        });
    }

    private void calcTitular() {
        String texto;

        texto = etSalario.getText().toString();
        titular.setSalario(Double.parseDouble(texto));

        texto = etAnos.getText().toString();
        titular.setAnosInstituicao(Integer.parseInt(texto));
        double bonus = (titular.getAnosInstituicao()/5) * 0.05;

        Double total = titular.getSalario() * (bonus+1);
        txtVRes.setText(total.toString());
    }
    private void calcHorista() {
        String texto;
        texto = etHoras.getText().toString();
        horista.setHorasAula(Integer.parseInt(texto));
        texto = etValorHorista.getText().toString();
        horista.setValorHoraAula(Double.parseDouble(texto));
        Double total = horista.getValorHoraAula() * horista.getHorasAula();
        txtVRes.setText(total.toString());
    }
}
