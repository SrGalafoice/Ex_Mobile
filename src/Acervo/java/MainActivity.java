package br.edu.fateczl.acervo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment;
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
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            carregaFragment(bundle);
        } else {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, new InicioFragment());
            fragmentTransaction.commit();
        }
    }

    public void carregaFragment(Bundle bundle) {
        String tipo = bundle.getString("tipo");
        if (tipo.equals("livro")){
            fragment = new LivroFragment();
        } else if (tipo.equals("disco")){
            fragment = new DiscoFragment();
        } else if (tipo.equals("pintura")){
            fragment = new PinturaFragment();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Bundle bundle = new Bundle();
        Intent i = new Intent(this, MainActivity.class);
        if (id == R.id.item_livro){
            bundle.putString("tipo", "livro");
            i.putExtras(bundle);
            this.startActivity(i);
            this.finish();
            return true;
        }
        else if (id == R.id.item_disco){
            bundle.putString("tipo", "disco");
            i.putExtras(bundle);
            this.startActivity(i);
            this.finish();
            return true;
        }
        else {
            bundle.putString("tipo", "pintura");
            i.putExtras(bundle);
            this.startActivity(i);
            this.finish();
            return true;
        }
        // return super.onOptionsItemSelected(item);
    }
}
