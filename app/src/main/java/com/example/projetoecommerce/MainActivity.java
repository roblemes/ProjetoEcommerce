package com.example.projetoecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
    EditText inputNome;
    EditText inputMarca;
    EditText inputCategoria;
    EditText inputValor;
    EditText inputEstoque;
    EditText inputAvaliacao;
    EditText inputGarantia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResult = findViewById(R.id.textResult);
        inputNome = findViewById(R.id.inputNome);
        inputMarca = findViewById(R.id.inputMarca);
        inputCategoria = findViewById(R.id.inputCategoria);
        inputValor = findViewById(R.id.inputValor);
        inputEstoque = findViewById(R.id.inputEstoque);
        inputAvaliacao = findViewById(R.id.inputAvaliacao);
        inputGarantia = findViewById(R.id.inputGarantia);
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

    public void addProduto(View view) {
        RequestQueue queue = Volley.newRequestQueue(this);
        //textResult.setText("Carregando..");

        String url = "http://10.0.2.2:8000/ecommerce/";

        final String nomeP = inputNome.getText().toString();
        String marcaP = inputMarca.getText().toString();
        String catP = inputCategoria.getText().toString();
        String valorP = inputValor.getText().toString();
        String estoqueP = inputEstoque.getText().toString();
        String avalP = inputAvaliacao.getText().toString();
        String garantiaP = inputGarantia.getText().toString();
        JSONObject produto = new JSONObject();

        try {
            produto.put("produto_nome", nomeP);
            produto.put("produto_marca", marcaP);
            produto.put("produto_categoria", catP);
            produto.put("produto_valor", valorP);
            produto.put("produto_estoque", estoqueP);
            produto.put("produto_avaliacao", avalP);
            produto.put("produto_garantia", garantiaP);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                url,
                produto,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        textResult.setText(response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textResult.setText(error.getMessage());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-Api-Key", "JISBaIhz.yJTHqlcL0xjdfWOgMzDOXTxzPYy4aAMm");

                return params;
            }
        };
        queue.add(request);


    }

}