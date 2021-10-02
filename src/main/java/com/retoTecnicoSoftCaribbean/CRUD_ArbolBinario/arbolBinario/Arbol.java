package com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.arbolBinario;

import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.entity.Clientes;

public class Arbol {

    private TadClientes<Clientes> raiz;

    public TadClientes<Clientes> getRaiz(){
        return raiz;
    }

    public void insertar(Clientes c){
        if(raiz == null){
            raiz = new ClienteImplArbol<>(c);
        }else{
            insertar(raiz, c);
        }
    }

    private void insertar(TadClientes<Clientes> raiz, Clientes c){
        if(c.getId()<raiz.obtener().getId()){
            if(raiz.izq()==null){
                raiz.enIzq(new ClienteImplArbol<>(c));
            }else {
                insertar(raiz.izq(),c);
            }
        }else{
            if(raiz.der()==null){
                raiz.enDer(new ClienteImplArbol<>(c));
            }else {
                insertar(raiz.der(),c);
            }
        }
    }

    public TadClientes<Clientes> buscarPorNmid(int id){
        if(raiz == null){
            return null;
        }else{
            return buscar(raiz, id);
        }
    }

    private TadClientes<Clientes> buscar(TadClientes<Clientes> raiz, int id){
        if(id == raiz.obtener().getId()){
            return raiz;
        }else{
            if(id<raiz.obtener().getId()){
                if(raiz.izq()==null){
                    return null;
                }else{
                    return buscar(raiz.izq(), id);
                }
            }else{
                if(raiz.der()==null){
                    return null;
                }else{
                    return buscar(raiz.izq(), id);
                }
            }
        }
    }

    public void modificar(TadClientes<Clientes> c, int id, String nombre, String apellido, String correo, String direccion, String celular){
        if(buscarPorNmid(id) != null){
            if(c.obtener().getId()==id){
                c.obtener().setCus_dsnombres(nombre);
                c.obtener().setCus_dsapellidos(apellido);
                c.obtener().setCus_dscorreo(correo);
                c.obtener().setCus_dsdireccion(direccion);
                c.obtener().setCus_cdcelular(celular);
            }

        }
    }

    public void eliminar(int x){
        if(buscarPorNmid(x) != null){
            raiz = eliminar(raiz,x);
        }
    }

    private TadClientes<Clientes> eliminar(TadClientes<Clientes> raiz, int x){
        if(raiz.obtener().getId() == x){
            return borrar(raiz, x);
        }else{
            if(x<raiz.obtener().getId()){
                raiz.enIzq(eliminar(raiz.izq(),x));
            }else{
                raiz.enDer(eliminar(raiz.der(),x));
            }
        }
        return raiz;
    }

    private TadClientes<Clientes> borrar(TadClientes<Clientes> raiz, int x){
        if(raiz.izq() == null && raiz.der() == null){
            return null;
        }else{
            if(raiz.izq() == null){
                return raiz.der();
            }else{
                if(raiz.der() == null){
                    return raiz.izq();
                }else{
                    TadClientes<Clientes> may = numeroMayor(raiz.izq());
                    raiz.modificar(may.obtener());
                    raiz.enIzq(eliminar(raiz.izq(),may.obtener().getId()));
                    return raiz;
                }
            }
        }
    }

    public TadClientes<Clientes> numeroMayor(TadClientes<Clientes> raiz){
        if(raiz != null){
            if(raiz.der() != null){
                return numeroMayor(raiz.der());
            }else{
                return raiz;
            }
        }else{
            return null;
        }
    }
}