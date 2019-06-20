package br.com.senai.senai_appmobile.model;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.senai.senai_appmobile.R;

public class AdapterPedidoPersonalizado extends BaseAdapter {

    private final List<Pedido> pedidos;
    private final Activity activity;

    public AdapterPedidoPersonalizado(List<Pedido> pedidos, Activity activity) {
        this.pedidos = pedidos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return pedidos.size();
    }

    @Override
    public Object getItem(int position) {
        return pedidos.get(position);
    }

    //Não utilizamos id nesse caso
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater()
                .inflate(R.layout.activity_lista_pedidos, parent, false);
        Pedido pedido = pedidos.get(position);

        TextView nome = (TextView) view.findViewById(R.id.activity_formulario_pedido_cliente);
        TextView data = (TextView) view.findViewById(R.id.activity_formulario_pedido_valor);
        TextView valor = (TextView) view.findViewById(R.id.activity_formulario_pedido_valor);

        nome.setText(pedido.getNome());
        data.setText(pedido.getData());
        valor.setText(pedido.getValor());

        return view;
    }


}
