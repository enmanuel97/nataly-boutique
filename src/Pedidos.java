import java.time.LocalDateTime;
import java.util.List;

public class Pedidos
{
    private int numeroPedido;
    private LocalDateTime currentDate;
    private int numeroCliente;
    private String nombreCliente;
    private String direccionCliente;
    private String telefono;
    private List<SeleccionArticulos> misArticulos;
    private int cantidadArticulos;

    public Pedidos(int pNumeroPedido, LocalDateTime pCurrentDate, int pNumeroCliente, String pNombreCliente, String pDireccionCliente, String pTelefono, List<SeleccionArticulos> pMisArticulos, int pCantidadArticulos)
    {
        this.numeroPedido       = pNumeroPedido;
        this.currentDate        = pCurrentDate;
        this.numeroCliente      = pNumeroCliente;
        this.nombreCliente      = pNombreCliente;
        this.direccionCliente   = pDireccionCliente;
        this.telefono           = pTelefono;
        this.misArticulos       = pMisArticulos;
        this.cantidadArticulos  = pCantidadArticulos;
    }

    public int getNumeroPedido()
    {
        return this.numeroPedido;
    }

    public LocalDateTime getDate()
    {
        return currentDate;
    }

    public int getNumeroCliente()
    {
        return this.numeroCliente;
    }

    public String getNombreCliente()
    {
        return this.nombreCliente;
    }

    public String getDireccionCliente()
    {
        return this.direccionCliente;
    }

    public String getTelefono()
    {
        return this.telefono;
    }

    public List<SeleccionArticulos> getMisArticulos()
    {
        return this.misArticulos;
    }

    public int getCantidadArticulos()
    {
        return this.cantidadArticulos;
    }
}