package com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.controller;


import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.arbolBinario.Arbol;
import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.arbolBinario.TadClientes;
import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.dto.ClienteDto;
import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.dto.Mensaje;
import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.entity.Clientes;
import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.service.ClienteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/lista")
    public ResponseEntity<List<Clientes>> list(){
        List<Clientes> list = clienteService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Clientes> getById(@PathVariable("id") int id){
        if(!clienteService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        return new ResponseEntity(arbol.buscarPorNmid(id).obtener(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto){
        if(StringUtils.isBlank(clienteDto.getCus_dsnombres()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Clientes cliente = new Clientes(clienteDto.getCus_nmcliente(), clienteDto.getCus_dsnombres(), clienteDto.getCus_dsapellidos(), clienteDto.getCus_dsdireccion(), clienteDto.getCus_dscorreo(), clienteDto.getCus_cdtelefono(), clienteDto.getCus_cdtelefonoalter(),clienteDto.getCus_cdcelular(), clienteDto.getCus_nmcargo(),clienteDto.getCus_dscargo(), clienteDto.getCus_nmciudad(), clienteDto.getCus_dsciudad(), clienteDto.getCus_fenacimiento(),clienteDto.getCus_genero(), clienteDto.getCus_nmcomunidad(),clienteDto.getCus_dscomunidad(), clienteDto.getCus_dsempresalabora(), clienteDto.getCus_nmdivision(), clienteDto.getCus_dsdivision(), clienteDto.getCus_nmpais(), clienteDto.getCus_dspais(), clienteDto.getCus_hobbies(), clienteDto.getCus_febaja(), clienteDto.getCus_feregistro());
        arbol.insertar(cliente);
        clienteService.save(cliente);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ClienteDto clienteDto) {
        if(!clienteService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

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
}
