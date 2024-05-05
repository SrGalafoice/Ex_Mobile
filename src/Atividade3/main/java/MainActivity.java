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
    private EditText etGas, etEta;
    private TextView Resposta;

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
        etGas = findViewById(R.id.etGas);
        etEta = findViewById(R.id.etEta);
        Button button = findViewById(R.id.BtnCalc);
        Resposta = findViewById(R.id.TxtResp);

        button.setOnClickListener(op -> Calcular());
    }
    public void Calcular(){
        double Gas = Double.parseDouble(etGas.getText().toString());
        double Eta = Double.parseDouble(etEta.getText().toString());
        double Calc = Gas * 0.7;
        if (Eta <= Calc) Resposta.setText("Etanol");
        else Resposta.setText("Gasolina");
    }
}
