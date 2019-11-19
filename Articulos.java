public class Articulos
{
    private int numeroArticulo;
    private double precio;
    private int cantidadExistencia;

    public Articulos(int pNumeroArticulo, double pPrecio, int pCantidadExistencia)
    {
        this.numeroArticulo = pNumeroArticulo;
        this.precio = pPrecio;
        this.cantidadExistencia = pCantidadExistencia;
    }

    public int getNumeroArticulo()
    {
        return this.numeroArticulo;
    }

    public double getPrecio()
    {
        return this.precio;
    }

    public int getCantidadExistencia()
    {
        return this.cantidadExistencia;
    }
}