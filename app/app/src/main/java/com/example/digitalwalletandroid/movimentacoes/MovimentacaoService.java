package com.example.digitalwalletandroid.movimentacoes;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.digitalwalletandroid.util.AbstractService;

public class MovimentacaoService extends AbstractService<Movimentacao> {

    public MovimentacaoService() {
        super("/movimentacoes");
    }
}
