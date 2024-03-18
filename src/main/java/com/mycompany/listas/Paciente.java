
package com.mycompany.listas;


public class Paciente {
    private String nombres;
    private String apellidos;
    private int edad;
    private int identificacion;
    private int numeroDeTelefono;
    private int ID;

    public Paciente(String nombres, String apellidos, int edad, int identificacion, int numeroDeTelefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.identificacion = identificacion;
        this.numeroDeTelefono = numeroDeTelefono;
        this.ID = ID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(int numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public void pagarTicket(){
    
    }
    
    public void registrarOrden(){
    
    }
    
    public void autorizarExamen(){
    
    }

    
}
