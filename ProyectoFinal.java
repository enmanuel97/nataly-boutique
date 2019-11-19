import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class ProyectoFinal
{
    public static List<Clientes> myClients = new ArrayList<Clientes>();

    public static void main(String[] args)
    {
        System.out.println("#####################################################################");
        System.out.println("             Proyecto Final de Lenguaje de Programacion 2           ");
        System.out.println(" Desarrollador por Jesus Enmanuel De La Cruz | Matricula: 100367458 ");
        System.out.println("#####################################################################\n");
        switchOptions(printMenu(false));
    }

    public static void switchOptions(int opcion)
    {
        switch(opcion)
        {
            case 1:
                switchOptionsClients(printClientsMenu(true));
                break;
            case 2:
                System.out.println("Felicidades acabas de entrar al lugar de los articulos");
                break;
            case 3:
                System.out.println("Felicidades acabas de entrar al lugar de los pedidos");
                break;
            case 4:
                System.out.println("Gracias por utilizar nuestro servicio");
                break;
        }
    }

    public static int printMenu(boolean clear)
    {
        if(clear == true)
        {
            cls();
        }

        Scanner cn = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("--------Menu Principal--------");
            System.out.println("|1-Agregar clientes          |");
            System.out.println("|2-Agregar articulos         |");
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
                    numeroCliente = Integer.parseInt(cn.nextLine());

                    if(myClients.size() > 0)
                    {
                        for(int i = 0; i <= myClients.size() - 1; i++)
                        {
                            if(myClients.get(i).getNumeroCliente() == numeroCliente)
                            {
                                validate = true;
                                System.out.println("\nYa existe un cliente con este numero...!");
                            }
                        }
                    }
                }while(validate == true);

                System.out.println("Ingrese el nombre del cliente");
                nombre = cn.nextLine();

                System.out.println("Ingrese la direccion del cliente");
                direccion = cn.nextLine();

                System.out.println("Ingrese el telefono del cliente");
                telefono = cn.nextLine();

                myClients.add(new Clientes(numeroCliente, nombre, direccion, telefono));

                switchOptionsClients(printClientsMenu(true));
            break;

            case 2:
                if(myClients.size() > 0)
                {
                    int nCliente;
                    int countResults = 0;
                    do{
                        System.out.println("Ingrese el numero del cliente a consultar");
                        nCliente = cn.nextInt();

                        for(int i = 0; i <= myClients.size() - 1; i++)
                        {
                            if(myClients.get(i).getNumeroCliente() == nCliente)
                            {
                                myClients.get(i).displayAllInformation();
                                countResults++;
                            }
                        }
                        if(countResults == 0)
                        {
                            System.out.println("Cliente no encontrado...!");
                        }
                    }while(countResults == 0);
                }
                else
                {
                    System.out.println("No tienes ningun cliente agregado");
                }

                switchOptionsClients(printClientsMenu(false));
            break;

            case 3:
                if(myClients.size() > 0)
                {
                    int nClienteM;
                    int countResultsM = 0;
                    do{
                        System.out.println("Ingrese el numero del cliente a modificar");
                        nClienteM = cn.nextInt();

                        for(int i = 0; i <= myClients.size() - 1; i++)
                        {
                            if(myClients.get(i).getNumeroCliente() == nClienteM)
                            {
                                System.out.println("Ingrese el nombre del cliente");
                                nombre = cn.nextLine();

                                System.out.println("Ingrese la direccion del cliente");
                                direccion = cn.nextLine();

                                System.out.println("Ingrese el telefono del cliente");
                                telefono = cn.nextLine();
                                countResultsM++;
                            }
                        }
                        if(countResultsM == 0)
                        {
                            System.out.println("Cliente no encontrado...!\n");
                        }
                    }while(countResultsM == 0);
                }
                else
                {
                    System.out.println("No tienes ningun cliente agregado");
                }
            break;

            case 4:
                if(myClients.size() > 0)
                {
                    int nClienteD;
                    int countResultD = 0;
                    do{
                        System.out.println("Ingrese el numero del cliente a eliminar");
                        nClienteD = cn.nextInt();

                        for(int i = 0; i <= myClients.size() - 1; i++)
                        {
                            if(myClients.get(i).getNumeroCliente() == nClienteD)
                            {
                                myClients.remove(i);
                                countResultD++;
                            }
                        }

                        if(countResultD == 0)
                        {
                            System.out.println("Cliente no encontrado...!");
                        }
                    }while(countResultD == 0);

                }else
                {
                    System.out.println("No tienes ningun cliente agregado");
                }

                switchOptionsClients(printClientsMenu(false));
                break;

            case 5:
                if(myClients.size() > 0)
                {
                    for(int i = 0; i <= myClients.size() - 1; i++)
                    {
                        System.out.println(myClients.get(i).getNombre());
                    }
                }else
                {
                    System.out.println("No tienes ningun cliente agregado");
                }

                switchOptionsClients(printClientsMenu(false));
            break;

            case 6:
                switchOptions(printMenu(true));
            break;
        }
    }

    public static int printClientsMenu(boolean clean)
    {
        if(clean == true)
        {
            cls();
        }

        Scanner cn = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("-----------Clientes-----------");
            System.out.println("|1-Registrar Cliente         |");
            System.out.println("|2-Consultar Cliente         |");
            System.out.println("|3-Modificar Cliente         |");
            System.out.println("|4-Eliminar Cliente          |");
            System.out.println("|5-Ver todos los clientes    |");
            System.out.println("|6-Salir                     |");
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