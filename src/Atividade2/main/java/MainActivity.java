package br.edu.fateczl.atividade2;

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
    private EditText etA;
    private EditText etB;
    private EditText etC;
    private TextView x1, x2, delta, err;

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
        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        etC = findViewById(R.id.etC);
        android.widget.Button button = findViewById(R.id.button);
        x1 = findViewById(R.id.TxtViewX1);
        x2 = findViewById(R.id.TxtViewX2);
        delta = findViewById(R.id.TxtViewDelta);
        err = findViewById(R.id.TxtViewErr);

        button.setOnClickListener(op -> Calc());
    }
    public void Calc(){
        float A = Float.parseFloat(etA.getText().toString());
        float B = Float.parseFloat(etB.getText().toString());
        float C = Float.parseFloat(etC.getText().toString());
        float calcx1, calcx2, calcdelta = (B * B) - (4 * A * C);
        String res, resdelta, resx1, resx2;
        if (calcdelta < 0){
            res = getString(R.string.Err);
            err.setText(res);

            resdelta = getString(R.string.Delta) + " " + calcdelta;
            delta.setText(resdelta);

            resx1 = getString(R.string.X1) + " " + "0";
            x1.setText(resx1);

            resx2 = getString(R.string.X2) + " " + "0";
            x2.setText(resx2);

        } else if (calcdelta == 0){
            res = "";
            err.setText(res);

            calcx1 = (float) ((-B + Math.sqrt(calcdelta)) / (2*A));
            resx1 = getString(R.string.X1) + " " + calcx1;
            x1.setText(resx1);
            resdelta = getString(R.string.Delta) + " " + calcdelta;
            delta.setText(resdelta);

            resx2 = getString(R.string.X2) + " " + "0";
            x2.setText(resx2);
        } else{
            res = "";
            err.setText(res);

            calcx1 = (float) ((-B + Math.sqrt(calcdelta)) / (2*A));
            calcx2 = (float) ((-B - Math.sqrt(calcdelta)) / (2*A));
            resx1 = getString(R.string.X1) + " " + calcx1;
            x1.setText(resx1);
            resx2 = getString(R.string.X2) + " " + calcx2;
            x2.setText(resx2);

            resdelta = getString(R.string.Delta) + " " + calcdelta;
            delta.setText(resdelta);
        }
    }
}
