package com.example.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirest.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
