package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;

import com.uem.model.Order;
import com.uem.model.Article;

public class OrderTest {
    
    @Test 
    public void testGrossTotal() {
        Article art1 = new Article("movil", 2, 100.00, 10.00);
        Article art2 = new Article("tablet", 3, 300.00, 20.00);

        List<Article> listaPrueba = new ArrayList<>();
        listaPrueba.add(art1);
        listaPrueba.add(art2);

        Order pruebaPedido = new Order("1", listaPrueba);
        double pruebaPrecioFinal = pruebaPedido.getGrossTotal();

        assertEquals(1100.00, pruebaPrecioFinal, 0.01);
    }

    @Test
    public void testDiscountedTotal() {
        Article art1 = new Article("movil", 2, 100.00, 10.00);
        Article art2 = new Article("tablet", 3, 300.00, 20.00);

        List<Article> listaPrueba = new ArrayList<>();
        listaPrueba.add(art1);
        listaPrueba.add(art2);

        Order pruebaPedido = new Order("1", listaPrueba);
        double pruebaPrecioFinal = pruebaPedido.getDiscountedTotal();

        assertEquals(900.00, pruebaPrecioFinal, 0.01);
    }

    @Test
    public void testGettersAndSetters() {
        List<Article> listaPrueba = new ArrayList<>();
        Order pruebaPedido = new Order("1", listaPrueba);

        List<Article> nuevaLista = new ArrayList<>();
        nuevaLista.add(new Article("funda", 1, 15.00, 0.00));

        pruebaPedido.setIdPedido("2");
        pruebaPedido.setArticulos(nuevaLista);

        assertEquals("2", pruebaPedido.getIdPedido());
        assertEquals(1, pruebaPedido.getArticulos().size());
    }

    @Test
    public void testToString() {
        List<Article> listaPrueba = new ArrayList<>();
        Order pruebaPedido = new Order("1", listaPrueba);

        String esperado = "Order [idPedido=1, articulos=[]]";
        assertEquals(esperado, pruebaPedido.toString());
    }
}