package com.example.gestionempleados;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionempleados.Adapters.AdapterEmpleado;
import com.example.gestionempleados.Models.Empleado;
import com.example.gestionempleados.Models.Gerente;
import com.example.gestionempleados.Models.Tecnico;
import com.example.gestionempleados.Models.TecnicoSenior;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ListaEmpleadosActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterEmpleado adapter;
    private List<Empleado> empleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_empleados);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear lista de empleados de ejemplo
        empleados = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        // Gerente
        calendar.set(2020, Calendar.JANUARY, 1);
        empleados.add(new Gerente(1, "Ana", "García", 5000, calendar.getTime(),
                "Ventas", 5000, 10));

        // Técnico
        calendar.set(2021, Calendar.MARCH, 15);
        empleados.add(new Tecnico(2, "Carlos", "López", 3000, calendar.getTime(),
                "Redes", "CCNA", 20));

        // Técnico Senior
        calendar.set(2019, Calendar.JUNE, 10);
        empleados.add(new TecnicoSenior(3, "María", "Rodríguez", 4000, calendar.getTime(),
                "Desarrollo", "AWS", 15, 8, 25));

        // Otros empleados
        calendar.set(2022, Calendar.SEPTEMBER, 5);
        empleados.add(new Tecnico(4, "Juan", "Martínez", 3200, calendar.getTime(),
                "Soporte", "MCSA", 10));

        calendar.set(2021, Calendar.DECEMBER, 1);
        empleados.add(new Gerente(5, "Laura", "Sánchez", 5500, calendar.getTime(),
                "TI", 6000, 15));

        adapter = new AdapterEmpleado(empleados, this);
        recyclerView.setAdapter(adapter);
    }
} 