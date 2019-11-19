public class SeleccionArticulos
{
    private int numeroArticulo;
    private Articulos[] misArticulos;
    private String description;
    private float tamanio;
    private String color;
    private String seccionBodega;
    private int numeroEstante;
    private int cantidadPedida;
    private int cantidadSurtida;

    public SeleccionArticulos(int pNumeroArticulo)
    {

    }

    public Articulos[] retornarArticulos()
    {
        return misArticulos;
    }
}