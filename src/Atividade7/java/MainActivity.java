package br.edu.fateczl.banco;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etValor, etNumConta, etNome;
    private TextView txtVNome, txtVErr, txtVNumConta, txtVSaldo;
    private RadioButton rbCP;
    private RadioButton rbCE;
    private Button btnAdd, btnSacar, btnDepositar, btnAtualizar;
    private ContaPoupanca contap;
    private ContaEspecial contae;

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
        rbCP = findViewById(R.id.rbCP);
        rbCP.setChecked(true);
        rbCE = findViewById(R.id.rbCE);
        etNome = findViewById(R.id.eTNome);
        etValor = findViewById(R.id.etValor);
        etNumConta = findViewById(R.id.etNumConta);
        btnAdd = findViewById(R.id.btnAdd);
        btnSacar = findViewById(R.id.btnSacar);
        btnDepositar = findViewById(R.id.btnDepositar);
        txtVErr = findViewById(R.id.txtVErr);
        txtVNumConta = findViewById(R.id.txtVNum);
        txtVNome = findViewById(R.id.TxtVNome);
        txtVSaldo = findViewById(R.id.txtVSaldo);
        btnAdd.setOnClickListener(op -> adicionar());
        btnSacar.setOnClickListener(op -> Sacar());
        btnDepositar.setOnClickListener(op -> Depositar());
        btnAtualizar.setOnClickListener(op -> Atualizar());



    }

    private void Atualizar() {
        if(rbCP.isChecked()){
            txtVNome.setText(contap.getCliente());
            txtVNumConta.setText(contap.getNum_conta());
            txtVSaldo.setText("R$"+(int) contap.getSaldo() + " (+ o Rendimento de: R$" + (contap.calcNovoSaldo(6.17)) +" ao mes)");
        } else {
            txtVNome.setText(contae.getCliente());
            txtVNumConta.setText(contae.getNum_conta());
            txtVSaldo.setText("R$"+(int) contae.getSaldo());
        }
    }

    public void adicionar(){
        if (rbCP.isChecked()){
            contap = new ContaPoupanca();
            contap.setCliente(etNome.getText().toString());
            contap.setSaldo(0);
            contap.setNum_conta(Integer.parseInt(etNumConta.getText().toString()));
            contap.setDia_rendimento(31);
        } else{
             contae = new ContaEspecial();
            contae.setCliente(etNome.getText().toString());
            contae.setSaldo(0);
            contae.setNum_conta(Integer.parseInt(etNumConta.getText().toString()));
            contae.setLimite(2000);
        }
        Atualizar();
    }

    private void Depositar() {
        float valor = Float.parseFloat(etValor.getText().toString());
        if(rbCP.isChecked()){
            contap.setSaldo(contap.depositar(valor));
        } else contae.depositar(valor);
        Atualizar();
    }

    private void Sacar() {
        float valor = Float.parseFloat(etValor.getText().toString());
        if (rbCP.isChecked() && valor <= contap.saldo){
            contap.setSaldo(contap.sacar(valor));
        } else if (rbCP.isChecked() && valor > contap.saldo){
            txtVErr.setText("Erro: Valor maior que saldo disponível");
            return;
        } else{
            if((contae.saldo - valor) >= contae.getLimite()){
                contae.setSaldo(contae.sacar(valor));
            }
        }
        Atualizar();
    }
}
