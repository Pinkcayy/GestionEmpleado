package com.example.gestionempleados.Models;

import java.util.Date;

public class Gerente extends Empleado {
    private String departamento;
    private double bonoAnual;
    private int cantidadSubordinados;

    public Gerente(int id, String nombre, String apellido, double salarioBase, Date fechaContratacion,
                  String departamento, double bonoAnual, int cantidadSubordinados) {
        super(id, nombre, apellido, salarioBase, fechaContratacion);
        this.departamento = departamento;
        this.bonoAnual = bonoAnual;
        this.cantidadSubordinados = cantidadSubordinados;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + (bonoAnual / 12);
    }

    // Getters y Setters
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getBonoAnual() {
        return bonoAnual;
    }

    public void setBonoAnual(double bonoAnual) {
        this.bonoAnual = bonoAnual;
    }

    public int getCantidadSubordinados() {
        return cantidadSubordinados;
    }

    public void setCantidadSubordinados(int cantidadSubordinados) {
        this.cantidadSubordinados = cantidadSubordinados;
    }
} 