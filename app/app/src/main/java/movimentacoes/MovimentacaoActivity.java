package movimentacoes;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.digitalwallet.R;

public class MovimentacaoActivity extends AppCompatActivity{

    private String array_spinner[];
    private DrawerLayout ndrawerLayout;
    private ActionBarDrawerToggle ntoggle;
    private Toolbar nToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movimentacao);

        nToolbar = (Toolbar) findViewById(R.id.tipoOrigem);
        setSupportActionBar(nToolbar);

        ndrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ntoggle = new ActionBarDrawerToggle(this, ndrawerLayout, R.string.abrir, R.string.fechar);

        ndrawerLayout.addDrawerListener(ntoggle);
        ntoggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        array_spinner = new String[2];
        array_spinner[0]="Receita";
        array_spinner[1]="Despesa";
        Spinner s = (Spinner) findViewById(R.id.tipoMovSpinner);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        Movimentacao mov =  new Movimentacao();
        mov.setTipoMovimentacao(Movimentacao.TipoMovimentacao.DESPESA);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(ntoggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}