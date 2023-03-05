package com.br.guaira.aplicacaobanco;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
      SQLiteDatabase bancoDados= null; //Banco de dados
      Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void abreouCriaBanco()
    {
        try {

        }
        catch (Exception erro)
        {
            mensagemExibir("Erro","Erro ao abrir ou criar o Banco de Dados!"+erro.getMessage());
        }
    }
    public void mensagemExibir(String titulo,String texto){
        AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
        mensagem.setTitle("Aviso");
        mensagem.setMessage("Não há Dados para consultar!");
        mensagem.setNeutralButton("ok",null);
        mensagem.show();
    }
}