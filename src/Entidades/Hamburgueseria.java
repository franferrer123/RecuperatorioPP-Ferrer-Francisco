package Entidades;
/**
 *
 * @author franf
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
public class Hamburgueseria implements Iterable<Producto> {
    private String nombre;
    private int capacidad;
    private Collection<Producto> productos;
    public Hamburgueseria(String nombre){
        this.nombre = nombre;
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }
    public Hamburgueseria(String nombre, int capacidad){
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }
    private boolean sonIguales(Producto p){
        for(Producto producto : this.productos){
            if(producto.equals(p)){
                return true;
            }
        }
        return false;
    }
    public void agregar(Producto p){
        if(this.productos.size() < this.capacidad){
            if(!this.sonIguales(p)){
                this.productos.add(p);
                System.out.println("Producto agregado");
            }else{
                System.out.println("El producto ya existe");
            }
        }else{
            System.out.println("Capacidad maxima alcanzada");
        }
    }
    private double getPrecioProductos(TipoProducto tipoProducto){
        double acumulador = 0;
        for(Producto producto : this.productos){
            if(tipoProducto == TipoProducto.HAMBURGUESAS && producto instanceof Hamburguesa){
                acumulador += ((IVendible)producto).getPrecioTotal();
            }
            if(tipoProducto == TipoProducto.PAPAS && producto instanceof PapasFritas){
                acumulador += ((IVendible)producto).getPrecioTotal();
            }
            if(tipoProducto == TipoProducto.AMBAS){
                acumulador += ((IVendible)producto).getPrecioTotal();
            } 
        }
        return acumulador;
    }
    private double getPrecioDeHamburguesas(){
        return this.getPrecioProductos(TipoProducto.HAMBURGUESAS);
    }
    private double getPrecioDePapas(){
        return this.getPrecioProductos(TipoProducto.PAPAS);
    }
    private double getPrecioTotal(){
        return this.getPrecioProductos(TipoProducto.AMBAS);
    }
    public Producto getProductoMasCaro(){
        Producto productoMasCaro = null;
        for(Producto producto : this.productos){
            if(productoMasCaro == null){
                productoMasCaro = producto;
            }else{
                if(((IVendible) producto).getPrecioTotal() > ((IVendible) productoMasCaro).getPrecioTotal()){
                    productoMasCaro = producto;
                }
            }
        }
        return productoMasCaro;
    }
    @Override
    public Iterator<Producto> iterator(){
        return this.productos.iterator();
    }
    @Override
    public String toString(){
        String retornar = "";
        retornar += "HAMBURGUESERIA: " + this.nombre;
        retornar += "CAPACIDAD: " + this.capacidad;
        retornar += "CANTIDAD DE PRODUCTOS: " + this.productos.size();
        for(Producto producto : this.productos){
            retornar += producto.toString();
        }
        retornar += "TOTAL HAMBURGUESAS: $" + this.getPrecioDeHamburguesas();
        retornar += "TOTAL PAPAS: $" + this.getPrecioDePapas();
        retornar += "TOTAL GENERAL: $" + this.getPrecioTotal();
        return retornar;
    }
}



