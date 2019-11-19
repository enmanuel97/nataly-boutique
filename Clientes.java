public class Clientes
{
    private int numeroCliente;
    private String nombre;
    private String direccion;
    private String telefono;

    public Clientes(int pNumeroCliente, String pNombre, String pDireccion, String pTelefono)
    {
        this.numeroCliente 	= pNumeroCliente;
        this.nombre 		= pNombre;
        this.direccion 		= pDireccion;
        this.telefono 		= pTelefono;
    }

    public int getNumeroCliente()
    {
        return this.numeroCliente;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getDireccion()
    {
        return this.direccion;
    }

    public String getTelefono()
    {
        return this.telefono;
    }
}
