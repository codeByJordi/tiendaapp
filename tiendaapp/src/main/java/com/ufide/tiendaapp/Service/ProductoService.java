package com.ufide.tiendaapp.Service;

import com.ufide.tiendaapp.Entity.Producto;
import com.ufide.tiendaapp.Repositoy.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repo;

    public Producto save(Producto p){
        return repo.save(p);
    }
    public Producto findById(long id){
        return repo.findById(id).get();
    }
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
    public List<Producto> findByStockLessThan(int max){
        return repo.findbyStockLessThan(max);
    }
}
