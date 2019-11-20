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
}