package com.ufide.tiendaapp.Repositoy;

import com.ufide.tiendaapp.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
