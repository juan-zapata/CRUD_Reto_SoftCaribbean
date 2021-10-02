package com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.repository;

import com.retoTecnicoSoftCaribbean.CRUD_ArbolBinario.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {


}
