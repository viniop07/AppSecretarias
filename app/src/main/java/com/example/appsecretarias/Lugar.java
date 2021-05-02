package com.example.appsecretarias;

public class Lugar {

    String titulo, local;
    double latitude, longitude;

    public Lugar() {
        titulo = "";
        local = "";
        latitude = 0;
        longitude = 0;
    }

    public Lugar(String titulo, String local, double latitude, double longitude) {
        this.titulo = titulo;
        this.local = local;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Lugar(Lugar lugar) {
        this.titulo = lugar.titulo;
        this.local = lugar.local;
        this.latitude = lugar.latitude;
        this.longitude = lugar.longitude;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLogitude() {
        return longitude;
    }

    public void setLogitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return titulo+" ("+ local + ")";
    }
}
