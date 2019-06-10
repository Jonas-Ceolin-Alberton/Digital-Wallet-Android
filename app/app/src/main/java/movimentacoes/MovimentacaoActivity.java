package movimentacoes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.digitalwallet.R;

public class MovimentacaoActivity extends AppCompatActivity{

    private String array_spinner[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movimentacao);

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

}