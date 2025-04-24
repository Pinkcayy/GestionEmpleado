package com.example.gestionempleados.Activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.gestionempleados.Models.Empleado;
import com.example.gestionempleados.Models.Gerente;
import com.example.gestionempleados.Models.Tecnico;
import com.example.gestionempleados.Models.TecnicoSenior;
import com.example.gestionempleados.R;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ActivityEmpleado extends AppCompatActivity {
    private TextView nombreTextView;
    private TextView tipoTextView;
    private TextView salarioTextView;
    private TextView fechaContratacionTextView;
    private TextView detallesTextView;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado);

        nombreTextView = findViewById(R.id.nombreTextView);
        tipoTextView = findViewById(R.id.tipoTextView);
        salarioTextView = findViewById(R.id.salarioTextView);
        fechaContratacionTextView = findViewById(R.id.fechaContratacionTextView);
        detallesTextView = findViewById(R.id.detallesTextView);
        cardView = findViewById(R.id.cardView);

        Empleado empleado = (Empleado) getIntent().getSerializableExtra("empleado");
        if (empleado != null) {
            mostrarDetallesEmpleado(empleado);
        }
    }

    private void mostrarDetallesEmpleado(Empleado empleado) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        
        // Configurar el tipo de empleado
        String tipoEmpleado = "";
        if (empleado instanceof Gerente) {
            tipoEmpleado = "Gerente";
            cardView.setCardBackgroundColor(getResources().getColor(R.color.colorGerente));
        } else if (empleado instanceof TecnicoSenior) {
            tipoEmpleado = "Técnico Senior";
            cardView.setCardBackgroundColor(getResources().getColor(R.color.colorTecnicoSenior));
        } else if (empleado instanceof Tecnico) {
            tipoEmpleado = "Técnico";
            cardView.setCardBackgroundColor(getResources().getColor(R.color.colorTecnico));
        }

        nombreTextView.setText(empleado.getNombre() + " " + empleado.getApellido());
        tipoTextView.setText(tipoEmpleado);
        salarioTextView.setText("Salario: $" + empleado.calcularSalario());
        fechaContratacionTextView.setText("Fecha de contratación: " + dateFormat.format(empleado.getFechaContratacion()));

        StringBuilder detalles = new StringBuilder();
        
        if (empleado instanceof Gerente) {
            Gerente gerente = (Gerente) empleado;
            detalles.append("Departamento: ").append(gerente.getDepartamento()).append("\n");
            detalles.append("Bono Anual: $").append(gerente.getBonoAnual()).append("\n");
            detalles.append("Subordinados: ").append(gerente.getCantidadSubordinados());
        } else if (empleado instanceof TecnicoSenior) {
            TecnicoSenior senior = (TecnicoSenior) empleado;
            detalles.append("Especialidad: ").append(senior.getEspecialidad()).append("\n");
            detalles.append("Certificación: ").append(senior.getNivelCertificacion()).append("\n");
            detalles.append("Horas Extra: ").append(senior.getHorasExtra()).append("\n");
            detalles.append("Proyectos Completados: ").append(senior.getProyectosCompletados()).append("\n");
            detalles.append("Clientes Atendidos: ").append(senior.getClientesAtendidos());
        } else if (empleado instanceof Tecnico) {
            Tecnico tecnico = (Tecnico) empleado;
            detalles.append("Especialidad: ").append(tecnico.getEspecialidad()).append("\n");
            detalles.append("Certificación: ").append(tecnico.getNivelCertificacion()).append("\n");
            detalles.append("Horas Extra: ").append(tecnico.getHorasExtra());
        }

        detallesTextView.setText(detalles.toString());
    }
}
