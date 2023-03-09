 package com.br.guaira.aplicacaobanco;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtNome,edtEndereco,edtTelefone;
    Button btCadastro,btConsulta,btVoltar,btRegAnt,btProxReg,btMenuPrincipal,btGravar;
    TextView tvNome,tvEndereco,tvTelefone;
      SQLiteDatabase bancoDados= null; //Banco de dados
      Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        chamaMenuPrincipal();
        abreouCriaBanco();
    }
    public void abreouCriaBanco()
    {
        try {
                String nomeBanco = "bancoEstoque";
                //Cria ou abre o banco de dados!
                bancoDados = openOrCreateDatabase(nomeBanco , MODE_WORLD_READABLE , null );
                String sql = "CREATE TABLE IF NO EXISTS pessoas"+"(id INTEGER PRIMARY KEY, nome TEXT, endereco TEXT"+"telefone TEXT);";
                bancoDados.execSQL(sql);
                mensagemExibir("Banco","Banco Criado com Sucesso!");
        }
        catch (Exception erro)
        {
            mensagemExibir("Erro","Erro ao abrir ou criar o Banco de Dados!"+erro.getMessage());
        }
    }
    public void mensagemExibir(String titulo,String texto){
        AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
        mensagem.setTitle(titulo);
        mensagem.setMessage(texto);
        mensagem.setNeutralButton("ok",null);
        mensagem.show();
    }
    public void chamaCadastro() {
        setContentView(R.layout.cadastro);
        inicializacaoObjetos();
        listeners();
    }
    public void inicializacaoObjetos() {
        try {
            btCadastro = (Button) findViewById(R.id.btTelaCadastro);
            btConsulta = (Button) findViewById(R.id.btTelaConsulta);
            //Objetos da Tela Consulta
            btVoltar = (Button) findViewById(R.id.btVoltar);
            btRegAnt = (Button) findViewById(R.id.btRegAnt);
            btProxReg = (Button) findViewById(R.id.btProxReg);
            //Objetos da Tela Cadastro
            btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);
            btGravar = (Button) findViewById(R.id.btGravar);
            tvNome = (TextView) findViewById(R.id.tvNome);
            tvEndereco = (TextView) findViewById(R.id.tvEndereco);
            tvTelefone = (TextView) findViewById(R.id.tvTelefone);
        } catch (Exception erro) {
            mensagemExibir("Erro", "Deu Erro ao gravar os Dados");
        }
    }
    public void listeners() {
        try {  //Try para os dois botoes da tela cadastro

            btMenuPrincipal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chamaMenuPrincipal();
                }
            });
            btGravar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //gravarRegistro();

                }
            });
        } catch (Exception erro) {

        }
        try { //try para os dois botoes da MainActivty
            btConsulta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chamaConsulta();
                }
            });

            btCadastro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chamaCadastro();
                }
            });
        }
        catch (Exception erro) {
        }
        try { //Try para os botoes da tela consulta
            btProxReg.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
              //      if (posicao == contadorRegistros)
                     //   return;
                //    posicao++;
                  //  regAuxiliar = regAuxiliar.proximoRegistro;
                    //Nao sei se é pra carregar a inicializacao de objetos aqui, testando ...
                    inicializacaoObjetos();
                    //mostrarDados();
                }
            });
            btRegAnt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
               //     if (posicao ==1)
                   //     return;
                 //   posicao--;
                   // regAuxiliar = regAuxiliar.registroAnterior;
                    //Nao sei se é pra carregar a inicializacao de objetos aqui, testando ...
                   inicializacaoObjetos();
                    //mostrarDados();
               /*Subtistuido pelo metodo mostrarDados(){
                tvNome.setText(regAuxiliar.nome);
                tvEndereco.setText(regAuxiliar.endereco);
                tvTelefone.setText(regAuxiliar.telefone);*/

                }
            });
            btVoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chamaMenuPrincipal();
                }
            });
        }
        catch (Exception erro){}
    }
    public void chamaConsulta() {

  //      if (contadorRegistros ==0){

    //        mensagemExibir("Aviso","Não possui registros gravados!");
      //      chamaMenuPrincipal();

        //posicao=1;
        setContentView(R.layout.consulta);
        inicializacaoObjetos();
      //  regAuxiliar = primeiroRegistro;
      //  mostrarDados();

    }
    public void chamaMenuPrincipal() {
        setContentView(R.layout.activity_main);
        inicializacaoObjetos();
        listeners();
    }
}