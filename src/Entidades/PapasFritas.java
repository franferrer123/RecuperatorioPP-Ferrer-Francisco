package Entidades;
/**
 *
 * @author franf
 */
public class PapasFritas extends Producto implements IVendible {
    private TipoPapas tipoPapas;
    public PapasFritas(String codigoProducto, String nombre, double precio, Proveedor proveedor, TipoPapas tipoPapas){
        super(codigoProducto, nombre, precio, proveedor);
        this.tipoPapas = tipoPapas;
    }
    @Override
    public double getPrecioTotal(){
        double precioTotal = this.precio;
        if (this.tipoPapas == TipoPapas.CLASICAS){
            precioTotal += this.precio * 0.10;
        }
        if (this.tipoPapas == TipoPapas.CON_CHEDDAR){
            precioTotal += this.precio * 0.15;
        }
        if (this.tipoPapas == TipoPapas.CON_BACON){
            precioTotal += this.precio * 0.20;
        }
        return precioTotal;
    }
    @Override
    public boolean equals(Object obj){
        if (super.equals(obj) && obj instanceof PapasFritas){
            PapasFritas auxiliar = (PapasFritas) obj;
            return this.tipoPapas == auxiliar.tipoPapas;
        }
        return false;
    }
    @Override
    public String toString(){
        return super.toString() + " - Tipo Papas: " + this.tipoPapas + " - Precio Total: $" + this.getPrecioTotal();
    }
}