package com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.arbolBinario;

public interface TadClientes<E> {
    E obtener();
    TadClientes<E> izq();
    TadClientes<E> der();
    void enIzq(TadClientes<E> x);
    void enDer(TadClientes<E> x);
    void modificar(E x);
}
