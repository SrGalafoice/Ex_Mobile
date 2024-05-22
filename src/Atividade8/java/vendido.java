package br.edu.fateczl.ingressos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class vendido extends AppCompatActivity {
    private TextView txtVRTipo, txtVRCod, txtVRValorTotal;
    private Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vendido);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtVRCod = findViewById(R.id.txtVRCod);
        txtVRTipo = findViewById(R.id.txtVRTipo);
        txtVRValorTotal = findViewById(R.id.txtVRValorTotal);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(op -> trocar());
        Intent inte = getIntent();
        Bundle bundle = inte.getExtras();

        String tipo = bundle.getString("tipo");
        String cod = bundle.getString("cod_identificador");
        float valor = bundle.getFloat("valor");

        txtVRValorTotal.setText("Valor total: R$" + valor);
        txtVRTipo.setText(tipo);
        txtVRCod.setText("Codigo: " +cod);

    }

    private void trocar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}
