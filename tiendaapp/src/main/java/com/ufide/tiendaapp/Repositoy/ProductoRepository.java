package com.ufide.tiendaapp.Repositoy;

import com.ufide.tiendaapp.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> { //cada inicio de letra debe de ser en mayuscula 'findByS'
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByStockLessThan(int max);
    List<Producto> findByCategoria(String categoria);
}
