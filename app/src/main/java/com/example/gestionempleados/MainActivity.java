package com.example.gestionempleados;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnVerEmpleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVerEmpleados = findViewById(R.id.btnVerEmpleados);
        btnVerEmpleados.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListaEmpleadosActivity.class);
            startActivity(intent);
        });
    }
}