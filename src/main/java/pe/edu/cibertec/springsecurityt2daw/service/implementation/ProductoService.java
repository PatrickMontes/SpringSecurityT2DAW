package pe.edu.cibertec.springsecurityt2daw.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.springsecurityt2daw.model.Producto;
import pe.edu.cibertec.springsecurityt2daw.repository.ProductoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public Producto crearProducto(Producto producto) {
        producto.setNombre(producto.getNombre());
        return productoRepository.save(producto);
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto actualizarProducto(Long id, Producto producto) {
        Producto productoActual = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productoActual.setNombre(producto.getNombre());

        return productoRepository.save(productoActual);
    }

}