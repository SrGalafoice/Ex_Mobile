package br.edu.fateczl.dados;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RadioButton rb1,rb2,rb3;
    private Button btnJogar;
    private Spinner spnDados;
    private TextView txtvResultado;
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
        rb1 = findViewById(R.id.rb1);
        rb1.setChecked(true);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        btnJogar = findViewById(R.id.btnJogar);
        spnDados = findViewById(R.id.spnTipoDado);
        txtvResultado = findViewById(R.id.txtvResultado);
        spinnerDados();
        btnJogar.setOnClickListener(op -> jogar());

    }
    public void jogar(){
        Random aleatorio = new Random();
        StringBuffer buffer = new StringBuffer();
        Integer TipoDado = (Integer) spnDados.getSelectedItem();
        int cont = 0, num = 0;
        num = OpcaoSelecionada(num);
        while (num != 0){
            buffer.append(aleatorio.nextInt(TipoDado - 1) + 1);
            if (cont < num - 1) buffer.append(", ");

            cont++;
            num--;
        }
        txtvResultado.setText(buffer.toString());
    }
    public int OpcaoSelecionada(int num){
        if (rb1.isChecked()){
            return num = 1;
        } else if (rb2.isChecked()){
            return num = 2;
        } else return num = 3;

    }

    private void spinnerDados() {
        List<Integer> Lados = new ArrayList<>();
        Lados.add(4);
        Lados.add(6);
        Lados.add(8);
        Lados.add(10);
        Lados.add(12);
        Lados.add(20);
        Lados.add(100);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Lados);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnDados.setAdapter(adapter);
    }
}
