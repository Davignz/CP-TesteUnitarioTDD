// Davi Gonzaga Ferreira - RM 554890
package org.example;

public class Apdex {
    private int totalAmostras;
    private double satisfatorio;
    private double toleravel;
    private double frustrada;

    public Apdex(int totalAmostras, double satisfatorio, double toleravel, double frustrada) {
        this.totalAmostras = totalAmostras;
        this.satisfatorio = satisfatorio;
        this.toleravel = toleravel;
        this.frustrada = frustrada;
    }

    public double calcularApdex() {
        if (totalAmostras <= 0) throw new IllegalArgumentException("Total de amostras deve ser > 0");
        return (satisfatorio + (toleravel / 2.0)) / totalAmostras;
    }

    public String classificarApdex() {
        double apdex = calcularApdex();
        if (apdex >= 0.94) return "Excelente";
        else if (apdex >= 0.85) return "Bom";
        else if (apdex >= 0.70) return "Regular";
        else return "Ruim";
    }

    public int getTotalAmostras() { return totalAmostras; }
    public double getSatisfatorio() { return satisfatorio; }
    public double getToleravel() { return toleravel; }
    public double getFrustrada() { return frustrada; }
}
