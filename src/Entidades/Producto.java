package Entidades;
/**
 *
 * @author franf
 */
import java.util.Random;
public abstract class Producto {
    protected Proveedor proveedor;
    protected String codigoProducto;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio;
    static {
        generadorAleatorio = new Random();
    }
    public Producto(String codigoProducto, String nombre, double precio, Proveedor proveedor){
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
    }
    public Producto(String codigoProducto, String nombre, double precio, String nombreProveedor, String ciudadProveedor, int antiguedadProveedor){
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = new Proveedor(nombreProveedor, ciudadProveedor, antiguedadProveedor);
    }
    public int getCalorias(){
        if (this.calorias == 0){
            this.calorias = generadorAleatorio.nextInt(601) + 200;
        }
        return this.calorias;
    }
    public int getTiempoPreparacion(){
        if (this.tiempoPreparacion == 0){
            this.tiempoPreparacion = generadorAleatorio.nextInt(19) + 2;
        }
        return this.tiempoPreparacion;
    }
    private static String mostrar(Producto producto){
        return "Codigo: " + producto.codigoProducto
                + " - Nombre: " + producto.nombre
                + " - Precio: $" + producto.precio
                + " - Calorias: " + producto.getCalorias()
                + " - Tiempo Preparacion: " + producto.getTiempoPreparacion()
                + " - Proveedor: " + producto.proveedor;
    }
    private static boolean sonIguales(Producto p1, Producto p2){
        return p1.codigoProducto.equals(p2.codigoProducto)
                && Proveedor.sonIguales(p1.proveedor, p2.proveedor);
    }
    @Override
    public boolean equals(Object obj){
        if (obj != null && obj instanceof Producto){
            Producto auxiliar = (Producto) obj;
            return sonIguales(this, auxiliar);
        }
        return false;
    }
    @Override
    public String toString(){
        return mostrar(this);
    }
}
