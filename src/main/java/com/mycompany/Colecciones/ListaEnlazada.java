package com.mycompany.Colecciones;

public class ListaEnlazada<T extends Comparable<T>> implements Lista<T> {

    private Nodo<T> cabeza;
    private int tamano;

    public ListaEnlazada() {
        this.cabeza = null;
        this.tamano = 0;
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
    public void agregarAlFinal(T valor) { //agregando al final
        if (cabeza == null) { // si esta vacio se agrega como la cabeza
            cabeza = new Nodo<>(valor);
            return;
        }
        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {//de lo contrario recorremos la estrucutura hasta que llegamos al limite 
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(new Nodo<>(valor));//en ese momento agregamos el nuevo nodo
        tamano++;

    }

    @Override
    public void agregarAlInicio(T valor) {//agregando al inicio
        Nodo<T> nuevoNodo = new Nodo<>(valor, cabeza);// se instancia el nodo indicando el valor que tendra almacenado y que su siguiente tiene que ser la cabeza
        cabeza = nuevoNodo;//ya hecho se establece que este nodo es la nueva cabeza
        tamano++;
    }

    @Override
    public void agregarEnELMedio(T valor, int indice) {//insercion de un nodo
        if (indice == 0) {//si el indice es 0 usamos el metodo de agregar al inicio
            agregarAlInicio(valor);
            return;
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice - 1; i++) { // recorremos la estructura hasta la posicion indicada
            if (actual == null) {//verificando que la posicion no exceda el tamaño de la estructura
                throw new IndexOutOfBoundsException();
            }
            actual = actual.getSiguiente();
        }
        Nodo<T> nuevoNodo = new Nodo<>(valor, actual.getSiguiente());
        actual.setSiguiente(nuevoNodo);//encontrada la posicion anterior de nuestro indice se inserta el nodo dejando claro sus señalamientos
        tamano++;
    }

    @Override
    public T obtenerElementoEnLaPosicion(int indice) {//retornar el valor que contiene el nodo del indice indicado
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {// recorremos la estructura hasta encontrar el indice espicificado
            if (actual == null) {// verificando que el indice no pase los limites
                throw new IndexOutOfBoundsException();
            }
            actual = actual.getSiguiente();
        }

        return actual.getValor();//se retorna el valor del indice

    }

    @Override
    public int buscarElemento(T valor) {
        Nodo<T> actual = cabeza;
        int indice = 0;
        while (actual != null) {//no sabemos hasta donde hay que ir por lo que recorremos hasta el limite
            if (actual.getValor() == valor) {//buscamos el valor ingresado hasta que halla coincidencia
                return indice;//al encontrar retornamos
            }
            actual = actual.getSiguiente();
            indice++;//de lo contrario avanzamos al siguiente nodo y aumentamos indice ya que no era la posicion anteriormente comparada
        }
        return -1;//al no haber coincidencia -1 y se acabo
    }

    @Override
    public T eliminarElemento(T valor) {//eliminar nodo por su valor
        if (cabeza == null) {//vemos si la estructura esta vacia
            return null;
        }
        if (cabeza.getValor() == valor) {//comparamos haber si la cabeza es el objetivo a eliminar
            valor = cabeza.getValor();
            cabeza = cabeza.getSiguiente();//de ser cierto se establece una nueva cabeza
            return valor;
        }
        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {//recorremos hasta los limites
            if (actual.getSiguiente().getValor() == valor) {//preguntamos si el nodo siguiente es el que vamos a eliminar
                valor = actual.getSiguiente().getValor();
                actual.setSiguiente(actual.getSiguiente().getSiguiente());//de ser asi apuntamos a su posterior a manera de eliminacion
                return valor;
            }
            actual = actual.getSiguiente();//se cambia de nodo hasta encontrar el predilecto
        }
        tamano--;
        return null;
    }

    @Override
    public T eliminarElementoEnLaPosicion(int indice) {//eliminar nodo por su indice
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {//recorremos hasta el indice ya dicho
            if (actual == null) {//verificando que este exista en la estructura
                throw new IndexOutOfBoundsException();
            }
            actual = actual.getSiguiente();
        }
        eliminarElemento(actual.getValor());//al ser encontrado usamos el metodo de eliminar antes establecido
        tamano--;
        return actual.getValor();//retornamos el valor eliminado
    }

    @Override
    public void invertir() {//metodo de poner las cosas de cabeza o al reves
        Nodo<T> actual = cabeza;
        while (actual != null) {//recorremos toda la estructura
            eliminarElemento(actual.getValor());//elimino el nodo
            if (actual == cabeza) {
                agregarAlFinal(actual.getValor());//la cabeza la agrego al final
                actual = actual.getSiguiente();
            }
            agregarAlInicio(actual.getValor());//el resto lo agrego como si fuera la primera
            actual = actual.getSiguiente();
        }
    }

    @Override
    public T obtenerCabeza() {//retorna la cabeza
        if (cabeza != null) {//compruebo si esta vacia
            return cabeza.getValor();//retorno el valor de la cabeza
        }
        return null;//retorno si esta vacia
    }

    @Override
    public T obtenerCola() {//retorno la cola
        if (cabeza == null) {//verifico si esta vacia
            return null;
        }
        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {//recorro toda la estructura
            actual = actual.getSiguiente();
        }
        return actual.getValor();//retorno el valor del ultimo nodo obtenido
    }

    @Override
    public void ordenarDeMenorAMayor() {
        Nodo<T> actual = cabeza;
        Nodo<T> index;
        T temp;
        if (cabeza == null) {
            return;
        } else {
            while (actual != null) {
                index = actual.siguiente;
                while (index != null) {
                    if (actual.compareTo(index) > 0) {
                        temp = actual.valor;
                        actual.valor = index.valor;
                        index.valor = temp;
                    }
                    index = index.siguiente;
                }
                actual = actual.siguiente;
            }
        }
    }

    @Override
    public void buscarElementosPares() {//metodo de busqueda
        Nodo<T> actual = cabeza;
        while (actual != null) {//recorre estructura
            if (esPar(actual.getValor())) {//busco valor que cumpla las condiciones
                System.out.println(actual.getValor());//imprimo los valores que cumplen los requisitos
            }
            actual = actual.getSiguiente();
        }
    }

    @Override
    public boolean esPar(T valor) {//metodo adicional para tomar abstraer los que cumplen el requisito
        if (valor instanceof Integer) {
            return ((Integer) valor) % 2 == 0;
        }
        return false;
    }

    @Override
    public void eliminarElementosDuplicados() {//metodo que elimina valores repetidos
        Nodo<T> actual = cabeza;
        Nodo<T> duplicado = cabeza.getSiguiente();
        while (actual != null && duplicado != null) {//se recorre la estructura siempre comparando dos valores

            while (duplicado != null) {//se compara un valor con los demas 
                if (actual.getValor() == duplicado.getValor()) {
                    eliminarElemento(duplicado.getValor());//se va eliminando si cumple la igualdad
                }
                duplicado = duplicado.getSiguiente();
            }
            actual = actual.getSiguiente();
            duplicado = actual.getSiguiente();

        }
    }

    @Override
    public String toString() {// metodo de muestra de estructura como cadena de strings
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = cabeza;
        while (actual != null) {
            sb.append(actual.getValor());
            if (actual.getSiguiente() != null) {
                sb.append(" -> ");
            }
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    @Override
    public T eliminarAlInicio() {//metodo para eliminar al inicio
        if (cabeza == null) {//verificamos si esta vacia
            return null;
        }
        T valorEliminado = cabeza.valor;
        Nodo<T> nuevoNodo = cabeza.siguiente;//el nodo siguiente a la cabeza para su respectiva eliminacion
        cabeza = nuevoNodo;//al eliminar al nodo indicamos cual sera la nueva cabeza
        tamano--;//actualizamos el tamaño de la estructura
        return valorEliminado;
    }

    @Override
    public T eliminarAlFinal() {//metodo para eliminar al inicio

        tamano--;//actualizamos el tamaño de la estructura
        return eliminarElementoEnLaPosicion(tamano() - 1);
    }

    @Override
    public void rotarLista() {//metodo para mover la lista un nodo adelante
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
        } else {
            return;
        }

    }

    @Override
    public void fusionarLista(Lista<T> lista1, Lista<T> lista2) {//metodo de fusion de dos listas circulares
        if (lista2.obtenerCabeza() != null) {//verificamos que no este vacia
            Nodo actual = (Nodo) lista2.obtenerCabeza();//nodo de union
            do {
                agregarAlInicio((T) actual.valor);//se va fusionando
                actual = actual.siguiente;//proximo valor a añadir
            } while (actual != lista2.obtenerCabeza());//hasta no llegar a la cabeza de uroboros
        }
    }

    @Override
    public Lista<T> dividirLista(int indice) {//metodo de division de una lista a dos
        ListaEnlazada listaActual = new ListaEnlazada<T>();//instanciamos la futura lista a crear
        if (cabeza == null || cabeza.siguiente == cabeza) {//verificar si hay mas de un nodo para dividir
            return listaActual;
        }
        Nodo pasado = null;//nodo anterior
        Nodo actual = cabeza;//nodo busqueda
        for (int i = 0; i < indice; i++) {//recorremos la estructura hasta el indice de division
            pasado = actual;//actualizando el ultimo nodo de una lista
            actual = actual.siguiente;//buscando
        }
        listaActual.cabeza = actual;//actualizando enlace
        pasado.siguiente = cabeza;
        actual = cabeza;
        while (actual.siguiente != cabeza) {//recorriendo estructura
            actual = actual.siguiente;
        }
        actual.siguiente = listaActual.cabeza;//indicando nueva cabeza de otra lista

        tamano = indice + 1;//estableciendo tamaños
        listaActual.tamano = tamano - indice - 1;

        return listaActual;//retornando lista porcionada
    }

    @Override
    public String mostrarCabeza() {//metodo para mostrar cabeza de uroboros
        StringBuilder sb = new StringBuilder();
        sb.append(((Object) cabeza.valor)/*.getNombre()*/);
        return sb.toString();
    }

    public static class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>> {

        private T valor;
        private Nodo<T> siguiente;

        public Nodo(T valor) {
            this(valor, null);
        }

        public Nodo(T valor, Nodo<T> siguiente) {
            this.valor = valor;
            this.siguiente = siguiente;
        }

        public T getValor() {
            return valor;
        }

        public void setValor(T valor) {
            this.valor = valor;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
        }

        @Override
        public int compareTo(Nodo<T> other) {
            return this.valor.compareTo(other.valor);
        }

    }
}
