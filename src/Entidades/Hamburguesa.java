package Entidades;
/**
 *
 * @author franf
 */
public class Hamburguesa extends Producto implements IVendible {
    private TipoHamburguesa tipoHamburguesa;
    private TamanioHamburguesa tamanio;
    public Hamburguesa(String codigoProducto, String nombre, double precio, Proveedor proveedor, TipoHamburguesa tipoHamburguesa, TamanioHamburguesa tamanio){
        super(codigoProducto, nombre, precio, proveedor);
        this.tipoHamburguesa = tipoHamburguesa;
        this.tamanio = tamanio;
    }
    @Override
    public double getPrecioTotal(){
        double precioTotal = this.precio;
        if(this.tamanio == TamanioHamburguesa.CHICA){
            precioTotal += this.precio * 0.05;
        }
        if(this.tamanio == TamanioHamburguesa.MEDIANA){
            precioTotal += this.precio * 0.10;
        }
        if(this.tamanio == TamanioHamburguesa.GRANDE){
            precioTotal += this.precio * 0.20;
        }
        return precioTotal;
    }
    @Override
    public boolean equals(Object obj){
        if (super.equals(obj) && obj instanceof Hamburguesa){
            Hamburguesa auxiliar = (Hamburguesa) obj;
            return this.tipoHamburguesa == auxiliar.tipoHamburguesa && this.tamanio == auxiliar.tamanio;
        }
        return false;
    }
    @Override
    public String toString(){
        return super.toString() + " - Tipo Hamburguesa: " + this.tipoHamburguesa + " - Tamaño: " + this.tamanio + " - Precio Total: $" + this.getPrecioTotal();
    }
}    

