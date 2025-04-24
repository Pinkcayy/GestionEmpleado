package com.example.gestionempleados.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionempleados.Activities.ActivityEmpleado;
import com.example.gestionempleados.Models.Empleado;
import com.example.gestionempleados.Models.Gerente;
import com.example.gestionempleados.Models.Tecnico;
import com.example.gestionempleados.Models.TecnicoSenior;
import com.example.gestionempleados.R;

import java.util.List;

public class AdapterEmpleado extends RecyclerView.Adapter<AdapterEmpleado.ViewHolder> {
    private List<Empleado> empleados;
    private Context context;

    public AdapterEmpleado(List<Empleado> empleados, Context context) {
        this.empleados = empleados;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_empleado, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Empleado empleado = empleados.get(position);
        
        // Configurar el texto del tipo de empleado
        String tipoEmpleado = "";
        if (empleado instanceof Gerente) {
            tipoEmpleado = "Gerente";
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorGerente));
        } else if (empleado instanceof TecnicoSenior) {
            tipoEmpleado = "Técnico Senior";
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorTecnicoSenior));
        } else if (empleado instanceof Tecnico) {
            tipoEmpleado = "Técnico";
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorTecnico));
        }

        holder.nombreTextView.setText(empleado.getNombre() + " " + empleado.getApellido());
        holder.tipoTextView.setText(tipoEmpleado);
        holder.salarioTextView.setText("Salario: $" + empleado.calcularSalario());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ActivityEmpleado.class);
            intent.putExtra("empleado", empleado);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return empleados.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreTextView;
        public TextView tipoTextView;
        public TextView salarioTextView;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            tipoTextView = itemView.findViewById(R.id.tipoTextView);
            salarioTextView = itemView.findViewById(R.id.salarioTextView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
