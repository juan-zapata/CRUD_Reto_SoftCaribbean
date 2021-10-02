package com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.arbolBinario;

public class ClienteImplArbol<E> implements TadClientes<E> {

    E dato;
    TadClientes<E> izq;
    TadClientes<E> der;

    public ClienteImplArbol(E dato) {
        this.dato = dato;
    }

    @Override
    public E obtener() {
        return dato;
    }

    @Override
    public TadClientes<E> izq() {
        return izq;
    }

    @Override
    public TadClientes<E> der() {
        return der;
    }

    @Override
    public void enIzq(TadClientes<E> x) {
        izq = x;

    }

    @Override
    public void enDer(TadClientes<E> x) {
        der = x;
    }

    @Override
    public void modificar(E x) {
        dato = x;
    }
}
