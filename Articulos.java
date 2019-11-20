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

    public void setPrecio(double pPrecio)
    {
        this.precio = pPrecio;
    }

    public void setCantidadExistencia(int pCantidadExistencia)
    {
        this.cantidadExistencia = pCantidadExistencia;
    }

    public int getCantidadExistencia()
    {
        return this.cantidadExistencia;
    }

    public void displayAllInformation()
    {
        System.out.println("# de Articulo           : " + this.numeroArticulo);
        System.out.println("Precio                  : " + this.precio);
        System.out.println("Cantidad en Existencia  : " + this.cantidadExistencia);
    }
}