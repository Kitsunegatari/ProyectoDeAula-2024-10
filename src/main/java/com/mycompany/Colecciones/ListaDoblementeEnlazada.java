package com.mycompany.Colecciones;

public class ListaDoblementeEnlazada<T>/*<T extends Comparable<T>>*/ implements Lista<T> {

    private Nodo<T> cabeza;//Nodo inicial
    private Nodo<T> cola;//Nodo final
    private int tamano;

    public ListaDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
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
    public void agregarAlFinal(T valor) {//metodo para agregar al final
        Nodo<T> nuevoNodo = new Nodo<>(valor, null, cola);//creamos el nodo que se va añadir
        if (cola != null) {//verificar si esta vacia
            cola.setSiguiente(nuevoNodo);//agregamos el nodo
        }
        cola = nuevoNodo;//indicamos que este va a ser la cabeza
        if (cabeza == null) {//verificamos si es el unico nodo
            cabeza = nuevoNodo;//de ser asi  indicamos que tambien sera la cabeza
        }
        tamano++;//actualizamos el valor del tamaño
    }

    @Override
    public void agregarAlInicio(T valor) {//metodo para agregar al inicio
        Nodo<T> nuevoNodo = new Nodo<>(valor, cabeza, null);//creamos el nodo que se va añadir
        if (cabeza != null) {//verificar si esta vacia
            cabeza.setAnterior(nuevoNodo);//agregamos el nodo
        }
        cabeza = nuevoNodo;//indicamos que este va a ser la cabeza
        if (cola == null) {//verificamos si es el unico nodo
            cola = nuevoNodo;//de ser asi  indicamos que tambien sera la cola
        }
        tamano++;//actualizamos el valor del tamaño
    }

    @Override
    public void agregarEnELMedio(T valor, int indice) {
        Nodo<T> nodoNuevo = new Nodo<>(valor);
        if (indice < 0) {
            throw new IndexOutOfBoundsException("El indice no puede ser negativo");
        }
        if (cabeza == null || indice == 0) {
            nodoNuevo.siguiente = cabeza;
            if (cabeza != null) {
                cabeza.anterior = nodoNuevo;
            }
            cabeza = nodoNuevo;
            if (cola == null) {
                cola = nodoNuevo;
            }
            return;
        }
        if (indice == tamano()) {
            nodoNuevo.anterior = cola;
            cola.siguiente = nodoNuevo;
            cola = nodoNuevo;
            return;
        }
        int desdeCabeza = indice;
        int desdeCola = tamano() - indice;
        if (desdeCabeza <= desdeCola) {
            Nodo<T> actual = cabeza;
            while (desdeCabeza > 1) {
                actual = actual.siguiente;
                desdeCabeza--;
            }
            nodoNuevo.siguiente = actual.siguiente;
            nodoNuevo.anterior = actual;
            actual.siguiente.anterior = nodoNuevo;
            actual.siguiente = nodoNuevo;
        } else {
            Nodo<T> actual = cola;
            while (desdeCola > 1) {
                actual = actual.anterior;
                desdeCola--;
            }
            nodoNuevo.siguiente = actual;
            nodoNuevo.anterior = actual.anterior;
            actual.anterior.siguiente = nodoNuevo;
            actual.anterior = nodoNuevo;
        }
        tamano++;
    }

    @Override
    public T obtenerElementoEnLaPosicion(int indice) {
        if (indice < 0 || indice >= tamano()) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        if (indice == 0) {
            return cabeza.valor;
        }
        if (indice == tamano() - 1) {
            return cola.valor;
        }
        int desdeCabeza = indice;
        int desdeCola = tamano() - 1;

        Nodo<T> actual;
        if (desdeCabeza <= desdeCola) {
            actual = cabeza;
            while (desdeCabeza > 0) {
                actual = actual.siguiente;
                desdeCabeza--;
            }
        } else {
            actual = cola;
            while (desdeCola > 0) {
                actual = actual.anterior;
                desdeCola--;
            }
        }
        return actual.valor;
    }

    @Override
    public int buscarElemento(T valor) {//metodo de busqueda de valor
        Nodo<T> actual = cabeza;//nodo de busqueda
        int indice = 0;//inicializar posicion a retornar
        while (actual != null) {//recorremos la estructura
            if (actual.getValor().equals(valor)) {//comprobamos con el metodo equals ya que == falla
                return indice;//retornamos posicion de encontrarla
            }
            actual = actual.getSiguiente();//sino seguimos buscando

            indice++;//actualizando posicion de busqueda
        }

        return -1;//retorno de valor no existente
    }

    @Override
    public T eliminarElemento(T valor) {
        if (cabeza == null) {
            return null;
        }
        Nodo<T> actual = cabeza;
        if (cabeza.valor.equals(valor)) {
            T valorEliminado = cabeza.valor;
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            }
            if (cabeza == null) {
                cola = null;
            }
            return valorEliminado;
        }

        if (cola.valor.equals(valor)) {
            T valorEliminado = cola.valor;
            cola = cola.anterior;
            cola.siguiente = null;
            return valorEliminado;
        }
        while (actual != null && !actual.valor.equals(valor)) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            actual = cola;
            while (actual != null && !actual.valor.equals(valor)) {
                actual = actual.anterior;
            }
            if (actual == null) {
                return null;
            }
        }
        actual.anterior.siguiente = actual.siguiente;
        actual.siguiente.anterior = actual.anterior;
        tamano--;
        return actual.valor;

    }

    @Override
    public T eliminarElementoEnLaPosicion(int indice) {
        if (indice < 0 || indice >= tamano()) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        T valorEliminado;

        if (indice == 0) {
            valorEliminado = cabeza.valor;
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            }
            if (cabeza == null) {
                cola = null;
            }
            return valorEliminado;
        }
        if (indice == tamano() - 1) {
            valorEliminado = cola.valor;
            cola = cola.anterior;
            if (cola != null) {
                cola.siguiente = null;
            }
            if (cola == null) {
                cabeza = null;
            }
            return valorEliminado;
        }
        int desdeCabeza = indice;
        int desdeCola = tamano() - indice - 1;
        if (desdeCabeza <= desdeCola) {
            Nodo<T> actual = cabeza;
            while (desdeCabeza > 0) {
                actual = actual.siguiente;
                desdeCabeza--;
            }
            valorEliminado = actual.valor;
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        } else {
            Nodo<T> actual = cola;
            while (desdeCola > 0) {
                actual = actual.anterior;
                desdeCola--;
            }
            valorEliminado = actual.valor;
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
        tamano--;
        return valorEliminado;

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
        if (cola != null) {//verifico si esta vacia
            return cola.getValor();
        }
        return null;
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
                    /*if (actual.compareTo(index) > 0) {
                        temp = actual.valor;
                        actual.valor = index.valor;
                        index.valor = temp;
                    }*/
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
    public T eliminarAlInicio() {//metodo para eliminar al inicio
        if (cabeza == null) {//verificamos si esta vacia
            return null;
        }
        T valorEliminado = cabeza.valor;
        Nodo<T> nuevoNodo = cabeza.siguiente;//el nodo siguiente a la cabeza para su respectiva eliminacion
        if (nuevoNodo != null) {//verificamos si hay mas de un nodo
            nuevoNodo.anterior = null;//indicamos que la antigua cabeza ya no esta enlazada
        }
        if (cabeza == cola) {//verificar si solo hay un nodo
            cola = null;//indicando que la estructura queda vacia
        }
        cabeza = nuevoNodo;//al eliminar al nodo indicamos cual sera la nueva cabeza
        tamano--;//actualizamos el tamaño de la estructura
        return valorEliminado;
    }

    @Override
    public T eliminarAlFinal() {//metodo para eliminar al inicio
        if (cola == null) {//verificamos si esta vacia
            return null;
        }
        T valorEliminado = cola.valor;
        Nodo<T> nuevoNodo = cola.anterior;//el nodo anterior a la cola para su respectiva eliminacion
        if (nuevoNodo != null) {//verificamos si hay mas de un nodo
            nuevoNodo.siguiente = null;//indicamos que la antigua cola ya no esta enlazada
        }
        if (cola == cabeza) {//verificar si solo hay un nodo
            cabeza = null;//indicando que la estructura queda vacia
        }
        cola = nuevoNodo;//al eliminar al nodo indicamos cual sera la nueva cola

        tamano--;//actualizamos el tamaño de la estructura
        return valorEliminado;
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
        ListaDoblementeEnlazada listaActual = new ListaDoblementeEnlazada<T>();//instanciamos la futura lista a crear
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

    public static class Nodo<T>/*<T extends Comparable<T>> implements Comparable<Nodo<T>>*/ {

        private T valor;
        private Nodo<T> siguiente;
        private Nodo<T> anterior;

        public Nodo(T valor) {
            this(valor, null, null);
        }

        public Nodo(T valor, Nodo<T> siguiente, Nodo<T> anterior) {
            this.valor = valor;
            this.siguiente = siguiente;
            this.anterior = anterior;
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

        public Nodo<T> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<T> anterior) {
            this.anterior = anterior;
        }

        /*@Override
        public int compareTo(Nodo<T> other) {
            return this.valor.compareTo(other.valor);
        }*/

    }

}
