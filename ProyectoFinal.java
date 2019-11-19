import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class ProyectoFinal
{
    public static List<Clientes> myClients = new ArrayList<Clientes>();
    public static void main(String[] args)
    {
        switchOptions(printMenu());
    }

    public static void switchOptions(int opcion)
    {
        switch(opcion)
        {
            case 1:
                //System.out.println("Felicidades acabas de entrar al lugar de los clientes");
                switchOptionsClients(printClientsMenu());
                break;
            case 2:
                System.out.println("Felicidades acabas de entrar al lugar de los articulos");
                break;
            case 3:
                System.out.println("Felicidades acabas de entrar al lugar de los pedidos");
                break;
            case 4:
                System.out.println("Gracias por utilizar nuestro servicio");
                //exit();
                break;
        }
    }

    public static int printMenu()
    {
        Scanner cn = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("-----Seleccione una opcion----");
            System.out.println("|1-Ingresar clientes         |");
            System.out.println("|2-Ingresar articulos        |");
            System.out.println("|3-Realizar Pedido           |");
            System.out.println("|4-Salir                     |");
            System.out.println("------------------------------");
            option = cn.nextInt();
			if(option < 1 || option > 4)
			{
                cls();
				System.out.println("Opcion no disponible");
			}
        }while(option > 4);

        return option;
    }

    public static void switchOptionsClients(int opcion)
    {
        Scanner cn = new Scanner(System.in);
        switch(opcion)
        {
            case 1:
                boolean validate = false;
                int numeroCliente;
                String nombre;
                String direccion;
                String telefono;
                do{
                    System.out.println("Ingrese el numero del cliente");
                    //myClients.add(new Clientes(4, "dsf", "asdas", "dsad"));
                    validate = true;
                }while(validate == true);

                break;
            case 2:
                System.out.println("Felicidades acabas de entrar al lugar de los articulos");
                break;
            case 3:
                System.out.println("Felicidades acabas de entrar al lugar de los pedidos");
                break;
            case 4:
                System.out.println("Gracias por utilizar nuestro servicio");
                //exit();
                break;
        }
    }

    public static int printClientsMenu()
    {
        Scanner cn = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("-----Seleccione una opcion----");
            System.out.println("|1-Crear Cliente             |");
            System.out.println("|2-Modificar Cliente         |");
            System.out.println("|3-Eliminar Cliente          |");
            System.out.println("|4-Consultar Cliente         |");
            System.out.println("|5-Salir                     |");
            System.out.println("------------------------------");
            option = cn.nextInt();
            if(option < 1 || option > 5)
            {
                cls();
                System.out.println("Opcion no disponible");
            }
        }while(option > 4);

        return option;
    }

    public static void cls()
    {
        try
        {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        catch(Exception E)
        {
            System.out.println(E);
        }
    }

    public static void exit()
    {
        try
        {
            new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
            System.exit(0);
        }catch(Exception E)
        {
            System.out.println(E);
        }
    }
}