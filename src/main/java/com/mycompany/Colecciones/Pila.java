package com.mycompany.Colecciones;

public class Pila<T extends Comparable<T>> implements Lista<T> {

    private Nodo<T> tope;
    private int tamano;

    public Pila() {//constrructor
        this.tamano = 0;
    }

    public Pila(Nodo<T> tope) {//constructor despeus de un elemento
        this.tope = null;
    }

    @Override
    public boolean estaVacia() {
        return tamano == 0;
    }

    @Override
    public int tamano() {
        return tamano;
    }

    @Override
    public void agregarAlFinal(T valor) {//insercion
        Nodo nuevoNodo = new Nodo(valor);//nodo a agregar
        if (estaVacia()) {//verificar si esta vacia
            tope = nuevoNodo;//si solo es un nodo
        } else {
            nuevoNodo.setSiguiente(tope);//mas de un nodo
            tope = nuevoNodo;//actualiza enlace
        }
        tamano++;//actualizar tamaño
    }

    @Override
    public void agregarAlInicio(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarEnELMedio(T valor, int indice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T obtenerElementoEnLaPosicion(int indice) {//optener tope
        if (estaVacia()) {//ver si esta vacia
            throw new IllegalStateException("La pila esta vacia");
        }
        return tope.getValor();//retornar valor del tope
    }

    @Override
    public int buscarElemento(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T eliminarElemento(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T eliminarElementoEnLaPosicion(int indice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void invertir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T obtenerCabeza() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T obtenerCola() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ordenarDeMenorAMayor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void buscarElementosPares() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarElementosDuplicados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T eliminarAlInicio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T eliminarAlFinal() {//eliminacion de tioi FILO
        if (estaVacia()) {//ver si esta vacia
            throw new IllegalStateException("La pila esta vacia");
        }
        T valor = tope.getValor();//guardar valor 
        tope = tope.getSiguiente();//eliminado
        tamano--;//actualizar tamaño
        return valor;//retornamos valor
    }

    @Override
    public boolean esPar(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void rotarLista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void fusionarLista(Lista<T> lista1, Lista<T> lista2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lista<T> dividirLista(int indice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String mostrarCabeza() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>> {//clase nodo

        T valor;//valor generico
        Nodo<T> siguiente;//Nodo direccional

        public Nodo(T valor) {//constructor de nodo
            this(valor, null);
        }

        public Nodo(T valor, Nodo<T> siguiente) {//mas de un nodo
            this.valor = valor;
            this.siguiente = siguiente;
        }

        public T getValor() {//Obtener valor
            return valor;
        }

        public void setValor(T valor) {//asignar valor
            this.valor = valor;
        }

        public Nodo<T> getSiguiente() {//obtener nodo nodo
            return siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente) {//Asignar nodo
            this.siguiente = siguiente;
        }

        @Override
        public int compareTo(Nodo<T> other) {
            return this.valor.compareTo(other.valor);
        }

    }
}
