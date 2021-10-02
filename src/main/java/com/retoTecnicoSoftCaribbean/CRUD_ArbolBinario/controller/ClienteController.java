package com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.controller;


import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.arbolBinario.Arbol;
import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.arbolBinario.TadClientes;
import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.dto.ClienteDto;
import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.dto.Mensaje;
import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.entity.Clientes;
import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.service.ClienteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/appi/cliente")
@CrossOrigin
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    Arbol arbol = new Arbol();



    @Bean
    public ResponseEntity<List<Clientes>> list(){
        List<Clientes> list = clienteService.list();
        for(int i = 0; i<list.size(); i++){
            arbol.insertar(list.get(i));
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Clientes> getById(@PathVariable("id") int id){
        if(arbol.buscarPorNmid(id) == null)
            return new ResponseEntity(new Mensaje("no existe ese cliente"), HttpStatus.NOT_FOUND);
        return new ResponseEntity(arbol.buscarPorNmid(id).obtener(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto){
        if(StringUtils.isAnyBlank(clienteDto.getCus_dsnombres(), clienteDto.getCus_dsapellidos(), clienteDto.getCus_dsdireccion(), clienteDto.getCus_dscorreo(), clienteDto.getCus_cdtelefono(), clienteDto.getCus_cdtelefonoalter(),clienteDto.getCus_cdcelular(), clienteDto.getCus_dscargo(),  clienteDto.getCus_dsciudad(), clienteDto.getCus_genero(),clienteDto.getCus_dscomunidad(), clienteDto.getCus_dsempresalabora(),  clienteDto.getCus_dsdivision(), clienteDto.getCus_dspais(), clienteDto.getCus_hobbies()))
            return new ResponseEntity(new Mensaje("hay un campo vacio"), HttpStatus.BAD_REQUEST);
        if(arbol.buscarPorNmid(clienteDto.getCus_nmcliente()) != null)
            return new ResponseEntity(new Mensaje("ese cliente ya existe"), HttpStatus.BAD_REQUEST);

        Clientes cliente = new Clientes(clienteDto.getCus_nmcliente(), clienteDto.getCus_dsnombres(), clienteDto.getCus_dsapellidos(), clienteDto.getCus_dsdireccion(), clienteDto.getCus_dscorreo(), clienteDto.getCus_cdtelefono(), clienteDto.getCus_cdtelefonoalter(),clienteDto.getCus_cdcelular(), clienteDto.getCus_nmcargo(),clienteDto.getCus_dscargo(), clienteDto.getCus_nmciudad(), clienteDto.getCus_dsciudad(), clienteDto.getCus_fenacimiento(),clienteDto.getCus_genero(), clienteDto.getCus_nmcomunidad(),clienteDto.getCus_dscomunidad(), clienteDto.getCus_dsempresalabora(), clienteDto.getCus_nmdivision(), clienteDto.getCus_dsdivision(), clienteDto.getCus_nmpais(), clienteDto.getCus_dspais(), clienteDto.getCus_hobbies(), clienteDto.getCus_febaja(), clienteDto.getCus_feregistro());
        arbol.insertar(cliente);
        clienteService.save(cliente);
        return new ResponseEntity(new Mensaje("cliente agregado correctamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ClienteDto clienteDto) {
        if(arbol.buscarPorNmid(id) == null)
            return new ResponseEntity(new Mensaje("no existe ese cliente"), HttpStatus.NOT_FOUND);
        if(StringUtils.isAnyBlank(clienteDto.getCus_dsnombres(),clienteDto.getCus_dsapellidos(),clienteDto.getCus_dscorreo(),clienteDto.getCus_dsdireccion(),clienteDto.getCus_cdcelular()))
            return new ResponseEntity(new Mensaje("Hay un campo vacio"), HttpStatus.NOT_FOUND);
        Clientes cliente = clienteService.getOne(id).get();
        TadClientes<Clientes> cl = arbol.getRaiz();
        arbol.modificar(cl,id, clienteDto.getCus_dsnombres(),clienteDto.getCus_dsapellidos(),clienteDto.getCus_dscorreo(),clienteDto.getCus_dsdireccion(),clienteDto.getCus_cdcelular());
        cliente.setCus_dsnombres(clienteDto.getCus_dsnombres());
        cliente.setCus_dsapellidos(clienteDto.getCus_dsapellidos());
        cliente.setCus_dscorreo(clienteDto.getCus_dscorreo());
        cliente.setCus_dsdireccion(clienteDto.getCus_dsdireccion());
        cliente.setCus_cdcelular(clienteDto.getCus_cdcelular());
        clienteService.save(cliente);
        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(arbol.buscarPorNmid(id) == null)
            return new ResponseEntity(new Mensaje("ese cliente no existe"), HttpStatus.NOT_FOUND);
        clienteService.delete(id);
        arbol.eliminar(id);
        return new ResponseEntity(new Mensaje("el cliente ha sido eliminado"), HttpStatus.OK);
    }
}
