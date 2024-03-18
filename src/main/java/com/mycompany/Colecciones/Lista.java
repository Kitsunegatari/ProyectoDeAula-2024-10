package com.mycompany.Colecciones;

public interface Lista<T> {

    void agregarAlFinal(T valor);

    void agregarAlInicio(T valor);

    void agregarEnELMedio(T valor, int indice);

    T obtenerElementoEnLaPosicion(int indice);

    int buscarElemento(T valor);

    T eliminarElemento(T valor);

    T eliminarElementoEnLaPosicion(int indice);

    boolean estaVacia();

    int tamano();

    void invertir();

    T obtenerCabeza();

    T obtenerCola();

    void ordenarDeMenorAMayor();

    void buscarElementosPares();

    void eliminarElementosDuplicados();

    T eliminarAlInicio();

    T eliminarAlFinal();

    boolean esPar(T valor);

    void rotarLista();

    void fusionarLista(Lista<T> lista1, Lista<T> lista2);

    Lista<T> dividirLista(int indice);

    String mostrarCabeza();//metodo que muestra la cabeza de la lista
}
