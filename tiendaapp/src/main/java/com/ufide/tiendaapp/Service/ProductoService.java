package com.ufide.tiendaapp.Service;

import com.ufide.tiendaapp.Entity.Producto;
import com.ufide.tiendaapp.Repositoy.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repo;

    public Producto save(Producto p){
        if(p.getPrecio() < 0) throw new IllegalArgumentException("Precio negativo");
        if(p.getStock() <= 0) throw new IllegalArgumentException("Stock no puede ser 0");
        return repo.save(p);
    }
    public Optional<Producto> findById(long id){
        return repo.findById(id);
    } //optional nos permite poner .if else
    public List<Producto> findAll(){
        return repo.findAll();
    }
    public void delete(Producto p){
        repo.delete(p);
    }
    public List<Producto> findByName(String name){
        return repo.findByNombreContainingIgnoreCase(name);
    }
    public List<Producto> findByCategoria(String categoria){
        return repo.findByCategoria(categoria);
    }
    public List<Producto> findByStockLessThan(){
        return repo.findByStockLessThan(5);
    }
}
