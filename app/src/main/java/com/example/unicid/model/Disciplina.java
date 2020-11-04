package com.example.unicid.model;

public class Disciplina {

    private int Id;
    private String nome;
    private double a1;
    private double a2;
    private double af;

    public Disciplina(){

    }

    public Disciplina(int id, String diciplina, double a1, double a2, double af) {
        Id = id;
        this.nome = diciplina;
        this.a1 = a1;
        this.a2 = a2;
        this.af = af;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getA1() {
        return a1;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public double getA2() {
        return a2;
    }

    public void setA2(double a2) {
        this.a2 = a2;
    }

    public double getAf() {
        return af;
    }

    public void setAf(double af) {
        this.af = af;
    }
}

