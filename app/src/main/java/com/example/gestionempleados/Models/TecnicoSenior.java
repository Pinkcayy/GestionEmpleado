package com.example.gestionempleados.Models;

import java.util.Date;

public class TecnicoSenior extends Tecnico {
    private int proyectosCompletados;
    private int clientesAtendidos;

    public TecnicoSenior(int id, String nombre, String apellido, double salarioBase, Date fechaContratacion,
                        String especialidad, String nivelCertificacion, int horasExtra,
                        int proyectosCompletados, int clientesAtendidos) {
        super(id, nombre, apellido, salarioBase, fechaContratacion, especialidad, nivelCertificacion, horasExtra);
        this.proyectosCompletados = proyectosCompletados;
        this.clientesAtendidos = clientesAtendidos;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (proyectosCompletados * 100) + (clientesAtendidos * 50);
    }

    // Getters y Setters
    public int getProyectosCompletados() {
        return proyectosCompletados;
    }

    public void setProyectosCompletados(int proyectosCompletados) {
        this.proyectosCompletados = proyectosCompletados;
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }

    public void setClientesAtendidos(int clientesAtendidos) {
        this.clientesAtendidos = clientesAtendidos;
    }
} 