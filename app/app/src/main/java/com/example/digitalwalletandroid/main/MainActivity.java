package com.example.digitalwalletandroid.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.digitalwalletandroid.R;
import com.example.digitalwalletandroid.despesas.Despesas;
import com.example.digitalwalletandroid.movimentacoes.Movimentacao;
import com.example.digitalwalletandroid.MovimentacaoActivity;
import com.example.digitalwalletandroid.origem.Origem;
import com.example.digitalwalletandroid.origem.OrigemActivity;

import receitas.Receitas;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MovimentacaoActivity.class));
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        MovimentacaoService servie = new MovimentacaoService();

         List<Movimentacao>  lista =  servie.getAll();
         lista.size();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_movimentacoes) {
            startActivity(new Intent(MainActivity.this, Movimentacao.class));
        } else if (id == R.id.nav_receitas) {
            startActivity(new Intent(MainActivity.this, Receitas.class));
        } else if (id == R.id.nav_despesas) {
            startActivity(new Intent(MainActivity.this, Despesas.class));
        } else if (id == R.id.nav_cadastroMovimentacoes) {
            startActivity(new Intent(MainActivity.this, MovimentacaoActivity.class));
        } else if (id == R.id.nav_cadastroOrigens) {
            startActivity(new Intent(MainActivity.this, OrigemActivity.class));
        } else if (id == R.id.nav_origens) {
            startActivity(new Intent(MainActivity.this, Origem.class));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
