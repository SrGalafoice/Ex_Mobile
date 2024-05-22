package br.edu.fateczl.ingressos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private String cod_identificador = "#092049";
    private float valor;
    private Button btnComprar;
    private RadioButton rbI, rbIV;
    private Ingresso ing;

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
        btnComprar = findViewById(R.id.btnComprar);
        rbI = findViewById(R.id.rbI);
        rbI.setChecked(true);
        rbIV = findViewById(R.id.rbIV);


        btnComprar.setOnClickListener(op -> Comprar());
    }
    public void Comprar(){
        double Taxa = 0.2;
        String tipo;
        if (rbI.isChecked()){
            ing = new Ingresso();
            valor = ing.valorFinal(Taxa);
            tipo = "Ingresso Comum";
        } else {
            ing = new IngressoV();
            valor = ing.valorFinal(Taxa);
            tipo = "Ingresso VIP";
        }
        Bundle bundle = new Bundle();
        bundle.putFloat("valor", valor);
        bundle.putString("cod_identificador", cod_identificador);
        bundle.putString("tipo", tipo);
        troca(bundle);
    }

    private void troca(Bundle bundle) {
        Intent i = new Intent(this, vendido.class);
        i.putExtras(bundle);
        this.finish();
    }
}
