package br.com.senai.senai_appmobile.services;

import br.com.senai.senai_appmobile.model.Pedido;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface PedidoService {

    @POST("pedido")
    Call<Void> insere(@Body Pedido pedido);

    @GET("pedido")
    Call<Void> restore(@Body Pedido pedido);

    @PUT("pedido")
    Call<Void>  find(@Body Pedido pedido);

    @DELETE("pedido")
    Call<Pedido> delete(@Body Pedido pedido);

}
