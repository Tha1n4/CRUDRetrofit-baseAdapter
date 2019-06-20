package br.com.senai.senai_appmobile.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.senai.senai_appmobile.R;
import br.com.senai.senai_appmobile.dao.PedidoDAO;
import br.com.senai.senai_appmobile.model.AdapterPedidoPersonalizado;
import br.com.senai.senai_appmobile.model.Pedido;

public class ListaPedidosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Pedidos";
    private final PedidoDAO dao = new PedidoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_pedidos); //AQUI PEGA O TEXTO ESCRITO NO LAYOUT E PERMITE COLOCA-LO NA TELA

        configuraFabNovoPedido();

        setTitle(TITULO_APPBAR); //Aqui muda o nome da AppBar para o que for passado no parametro
        //Lista para preencher o textViews que possuem na Activity

        List<Pedido> pedidos = todosPedidos();

        ListView listaPedidos = (ListView) findViewById(R.id.activity_lista_pedidos_listview);
        AdapterPedidoPersonalizado adapter = new AdapterPedidoPersonalizado(pedidos, this);
        listaPedidos.setAdapter(adapter);

    }

    private void configuraFabNovoPedido() {
        FloatingActionButton botaoNovoPedido = findViewById(R.id.activity_lista_pedidos_fab_novo_pedido);
        //Cria uma variável do tipo do botão para que seja pegado o estado de click dele
        botaoNovoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Aqui realiza a ação quando clicar no botão
                abreFormularioPedidoActivity();
            }
        });
    }

    private void abreFormularioPedidoActivity() {
        startActivity(new Intent(ListaPedidosActivity.this, FormularioPedidoActivity.class
        ));
    }

    @Override
    protected void onResume() {

        super.onResume();
        configuraLista();

    }

    private void configuraLista() {
        ListView listaPedidos = findViewById(R.id.activity_lista_pedidos_listview);

        listaPedidos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.allPedidos()));
    }

    private List<Pedido> todosPedidos() {
        return new ArrayList<>(Arrays.asList(
                new Pedido("Thaina", "20/06/2019", "11.99"),
                new Pedido("Severo", "11/11/2017", "32.40"),
                new Pedido("Thor", "12/12/2012", "100.99")));
    }
}
