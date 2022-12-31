package com.example.myapplication.user;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText name, email, password, c_password;
    private Button btn_daftar;
    private ProgressBar loading;
    private static String URL_REGIST = "http://192.168.0.105//raget_bags/register.php";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loading = findViewById(R.id.loading);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        c_password = findViewById(R.id.c_password);
        btn_daftar = findViewById(R.id.btn_daftar);

        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Daftar();
            }
        });
    }
    private void Daftar(){
        loading.setVisibility(View.VISIBLE);
        btn_daftar.setVisibility(View.GONE);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
         String nama = String.valueOf(name.getText());
         String emaill = String.valueOf(email.getText());
         String pass = String.valueOf(password.getText());

        loading.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url ="https://mobileragetbags.000webhostapp.com/raget_bags/register.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loading.setVisibility(View.GONE);

                           if (response.equals("success")){
                                Toast.makeText(getApplicationContext(),"Registrations Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(RegisterActivity.this,response,Toast.LENGTH_LONG).show();

                            }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.setVisibility(View.GONE);
                Toast.makeText(RegisterActivity.this,error.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                paramV.put("name", nama);
                paramV.put("email", emaill);
                paramV.put("password", pass);
                return paramV;
            }
        };
        queue.add(stringRequest);
    }
}