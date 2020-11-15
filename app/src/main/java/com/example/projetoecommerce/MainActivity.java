package com.example.projetoecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResult = findViewById(R.id.textResult);
    }

    public void consultar(View view) {
        RequestQueue queue = Volley.newRequestQueue(this);
        textResult.setText("Carregando..");
        String url = "http://10.0.2.2:8000/ecommerce/";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            Produto p = new Produto();
                            StringBuilder sb = new StringBuilder();
                            JSONArray produtos = response.getJSONArray("results");

                            for (int i = 0; i < produtos.length(); i++) {
                                JSONObject produto_info = produtos.getJSONObject(i);
                                p.setProdutoNome(produto_info.getString("produto_nome"));
                                p.setProdutoMarca(produto_info.getString("produto_marca"));
                                p.setProdutoCategoria(produto_info.getString("produto_categoria"));
                                p.setProdutoValor(produto_info.getDouble("produto_valor"));
                                p.setProdutoEstoque(produto_info.getInt("produto_estoque"));
                                p.setProdutoAvaliacao(produto_info.getInt("produto_avaliacao"));
                                p.setProdutoGarantia(produto_info.getString("produto_garantia"));


                                sb.append("Produto " + "(" + i + "):" + "\n" + p + "\n\n");
                            }

                            String x = "Lista de produtos:\n\n" + sb.toString();

                            textResult.setText(x);

                        } catch (JSONException e) {
                            textResult.setText(e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textResult.setText(error.getMessage());
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-Api-Key", "DOPxBaqu.xGPzdFbdymRaGDfET9RQbBLsT7kUEkuq");

                return params;
            }
        };

        queue.add(request);
    }
}