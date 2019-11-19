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

    public void setNombre(String pNombre)
    {
        this.nombre = pNombre;
    }

    public String getDireccion()
    {
        return this.direccion;
    }

    public void setDireccion(String pDireccion)
    {
        this.direccion = pDireccion;
    }

    public String getTelefono()
    {
        return this.telefono;
    }

    public void setTelefono(String pTelefono)
    {
        this.telefono = pTelefono;
    }

    public void displayAllInformation()
    {
        System.out.println("# de Cliente: " + this.numeroCliente);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Telefono: " + this.telefono);
    }
}
