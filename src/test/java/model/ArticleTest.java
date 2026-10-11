package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.uem.model.Article;

public class ArticleTest {
    
    @Test 
    public void testGrossAmount() {
        Article pruebaArticulo = new Article("Camiseta", 3, 25.25, 10.00);
        double pruebaPrecio = pruebaArticulo.getGrossAmount();
        assertEquals(75.75, pruebaPrecio, 0.01);
    }

    @Test 
    public void testDiscountedAmount() {
        Article pruebaArticulo2 = new Article("Iphone 17 Pro Max", 3, 1250.00, 50.00);
        double pruebaPrecio2 = pruebaArticulo2.getDiscountedAmount();
        assertEquals(1875.00, pruebaPrecio2, 0.01);
    }

    @Test
    public void testGettersAndSetters() {
        Article pruebaArticulo = new Article("Raton", 1, 15.00, 0.00);
        
        pruebaArticulo.setNombre("Teclado");
        pruebaArticulo.setCantidad(2);
        pruebaArticulo.setPrecio(45.50);
        pruebaArticulo.setDescuento(5.00);

        assertEquals("Teclado", pruebaArticulo.getNombre());
        assertEquals(2, pruebaArticulo.getCantidad());
        assertEquals(45.50, pruebaArticulo.getPrecio(), 0.01);
        assertEquals(5.00, pruebaArticulo.getDescuento(), 0.01);
    }
}