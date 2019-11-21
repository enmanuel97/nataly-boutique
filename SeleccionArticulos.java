public class SeleccionArticulos
{
    private int numeroArticulo;
    private String descripcion;
    private String descripcionTamanio;
    private String color;
    private String seccionBodega;
    private int numeroEstante;
    private int cantidadPedida;
    private int cantidadSurtida;

    public SeleccionArticulos(int pNumeroArticulo, String pDescription, String pDescripcionTamanio, String pColor, String pSeccionBodega, int pNumeroEstante, int pCantidadPerdida, int pCantidadSurtida)
    {
        this.numeroArticulo     = pNumeroArticulo;
        this.descripcion        = pDescription;
        this.descripcionTamanio = pDescripcionTamanio;
        this.color              = pColor;
        this.seccionBodega      = pSeccionBodega;
        this.numeroEstante      = pNumeroEstante;
        this.cantidadPedida     = pCantidadPerdida;
        this.cantidadSurtida    = pCantidadSurtida;
    }

    public int getNumeroArticulo()
    {
        return this.numeroArticulo;
    }

    public int getNumeroEstante()
    {
        return this.numeroEstante;
    }

    public int getCantidadPedida()
    {
        return this.cantidadPedida;
    }

    public int getCantidadSurtida()
    {
        return this.cantidadSurtida;
    }

    public String getSeccionBodega()
    {
        return this.seccionBodega;
    }

    public String getDescripcion()
    {
        return this.descripcion;
    }

    public String getDescripcionTamanio()
    {
        return this.descripcionTamanio;
    }

    public String getColor()
    {
        return this.color;
    }
}