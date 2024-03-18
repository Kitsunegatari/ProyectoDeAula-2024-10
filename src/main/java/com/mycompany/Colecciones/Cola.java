package com.mycompany.Colecciones;

public class Cola<T extends Comparable<T>> implements Lista<T> {

    private Nodo<T> frente;//frente de la cola
    private Nodo<T> finalCola;//final de la cola
    private int tamano;

    public Cola() {//constructor
        this.frente = null;
        this.finalCola = null;
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
    public void agregarAlFinal(T valor) {//metodo de incersion en la cola
        Nodo nuevoNodo = new Nodo(valor);//nodo a agregar
        if (estaVacia()) {//verificar si esta vacia
            frente = nuevoNodo;//establecer valores de ser el unico
            finalCola = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);//de lo contrario su insercion es al final
            finalCola = nuevoNodo;//actualizamos enlace
        }
        tamano++;
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
    public T obtenerElementoEnLaPosicion(int indice) {//mostrar el nodo que esta al frente de la cola
        if (estaVacia()) {//verificar si esta vacia
            throw new IllegalStateException("La cola esta vacia");
        }
        return frente.valor;//retornar valor del frente
    }

    @Override
    public int buscarElemento(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T eliminarElemento(T valor) {// metodo de eliminacion de elemento debido a la implementacion
        if (estaVacia()) {//ver si esta vacia
            System.out.println("La cola esta vacia");
            return null;
        }
        if (frente.valor.equals(valor)) {//de ser el valor del frente se utiliza el metodo ya implementado
            eliminarAlInicio();
            return frente.valor;
        }
        Nodo anterior = null;//nodos de busqueda
        Nodo actual = frente;

        while (actual != null && actual.valor.equals(valor)) {//buscador
            anterior = actual;
            actual = actual.siguiente;
        }
        T valorEliminado = valor;
        if (actual == null) {//de no ser encontrado se informa
            System.out.println("El elemento no esta presente en la cola");
            return null;
        }

        anterior.siguiente = actual.siguiente;//actualizar enlace
        if (actual == finalCola) {//de ser el valor del final se utiliza el metodo ya implementado
            finalCola = anterior;
        }
        return valorEliminado;
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
    public T eliminarAlInicio() {//Metodo para eliminar la frente de la cola
        if (estaVacia()) {//verificar si esta vacia
            throw new IllegalStateException("La cola esta vacia");
        }
        T valor = frente.valor;//se guarda el valor a eliminar
        frente = frente.siguiente;//Se establece el nuevo frente
        if (frente == null) {//de quedar vacio se establece enlace nulo
            finalCola = null;
        }
        tamano--;
        return valor;//retornamos el valor eliminado
    }

    @Override
    public T eliminarAlFinal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
