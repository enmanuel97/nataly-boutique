import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class ProyectoFinal
{
    public static List<Clientes> myClients = new ArrayList<Clientes>();

    public static void main(String[] args)
    {
        System.out.println("######################################################################");
        System.out.println("             Proyecto Final de Lenguaje de Programacion 2            ");
        System.out.println("  Desarrollado por Jesus Enmanuel De La Cruz | Matricula: 100367458  ");
        System.out.println("######################################################################\n");
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
            System.out.println("|1-Administrar mis Clientes  |");
            System.out.println("|2-Administrar mis Articulos |");
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
            case 1://Crear Cliente
                cls();
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
                                cls();
                                System.out.println("\nYa existe un cliente con este numero...!\n");
                            }
                            else
                            {
                                validate = false;
                            }
                        }
                    }
                }while(validate == true);

                System.out.println("\nIngrese el nombre del cliente");
                nombre = cn.nextLine();

                System.out.println("\nIngrese la direccion del cliente");
                direccion = cn.nextLine();

                System.out.println("\nIngrese el telefono del cliente");
                telefono = cn.nextLine();

                myClients.add(new Clientes(numeroCliente, nombre, direccion, telefono));

                cls();
                System.out.println("Cliente Agregado correctamente");
                int addOne;
                do{
                    System.out.println("Deseas agregar otro? (1-Si | 2-No)");
                    addOne = Integer.parseInt(cn.nextLine());
                }while(addOne < 1 || addOne > 2);

                if(addOne == 1)
                {
                    switchOptionsClients(1);//agregar un cliente
                }
                else
                {
                    switchOptionsClients(printClientsMenu(true));
                }
            break;

            case 2://Consultar Cliente
                if(myClients.size() > 0)
                {
                    int nCliente;
                    int countResults = 0;
                    do{
                        cls();
                        System.out.println("Ingrese el numero del cliente a consultar");
                        nCliente = cn.nextInt();

                        for(int i = 0; i <= myClients.size() - 1; i++)
                        {
                            if(myClients.get(i).getNumeroCliente() == nCliente)
                            {
                                cls();
                                System.out.println("---------------------------------");
                                myClients.get(i).displayAllInformation();
                                countResults++;
                                System.out.println("---------------------------------\n");
                            }
                        }
                        if(countResults == 0)
                        {
                            cls();
                            System.out.println("Cliente no encontrado...!\n");
                        }
                    }while(countResults == 0);
                }
                else
                {
                    cls();
                    System.out.println("No tienes ningun cliente agregado");
                    int addOneC;
                    do{
                        System.out.println("Deseas agregar uno? (1-Si | 2-No)");
                        addOneC = Integer.parseInt(cn.nextLine());
                    }while(addOneC < 1 || addOneC > 2);

                    if(addOneC == 1)
                    {
                        switchOptionsClients(1);//agregar un cliente
                    }
                    else
                    {
                        switchOptionsClients(printClientsMenu(true));
                    }
                }

                switchOptionsClients(printClientsMenu(false));
            break;

            case 3://Modificar Cliente
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
                                System.out.println("\nIngrese el nombre del cliente");
                                myClients.get(i).setNombre(cn.nextLine());

                                System.out.println("\nIngrese la direccion del cliente");
                                myClients.get(i).setDireccion(cn.nextLine());

                                System.out.println("\nIngrese el telefono del cliente");
                                myClients.get(i).setTelefono(cn.nextLine());
                                countResultsM++;

                                cls();
                                System.out.println("Informacion del cliente "+myClients.get(i).getNombre() + " ha sido actualizada");
                            }
                        }
                        if(countResultsM == 0)
                        {
                            cls();
                            System.out.println("Cliente no encontrado...!\n");
                        }
                    }while(countResultsM == 0);
                }
                else
                {
                    cls();
                    System.out.println("No tienes ningun cliente agregado");
                    int addOneM;
                    do{
                        System.out.println("Deseas agregar uno? (1-Si | 2-No)");
                        addOneM = Integer.parseInt(cn.nextLine());
                    }while(addOneM < 1 || addOneM > 2);

                    if(addOneM == 1)
                    {
                        switchOptionsClients(1);//agregar un cliente
                    }
                    else
                    {
                        switchOptionsClients(printClientsMenu(true));
                    }
                }
            break;

            case 4://Eliminar Cliente
                if(myClients.size() > 0)
                {
                    cls();
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
                                cls();
                                System.out.println("Cliente Eliminado\n");
                            }
                        }

                        if(countResultD == 0)
                        {
                            cls();
                            System.out.println("Cliente no encontrado...!\n");
                        }
                    }while(countResultD == 0);

                }
                else
                {
                    cls();
                    System.out.println("No tienes ningun cliente agregado");
                    int addOneE;
                    do{
                        System.out.println("Deseas agregar uno? (1-Si | 2-No)");
                        addOneE = Integer.parseInt(cn.nextLine());
                    }while(addOneE < 1 || addOneE > 2);

                    if(addOneE == 1)
                    {
                        switchOptionsClients(1);//agregar un cliente
                    }
                    else
                    {
                        switchOptionsClients(printClientsMenu(true));
                    }
                }

                switchOptionsClients(printClientsMenu(false));
                break;

            case 5://Consultar Todos los clientes
                if(myClients.size() > 0)
                {
                    cls();
                    System.out.println("-------Todos mis clientes-------\n");
                    System.out.println("--------------------------------");
                    for(int i = 0; i <= myClients.size() - 1; i++)
                    {
                        //System.out.println(myClients.get(i).getNombre());
                        myClients.get(i).displayAllInformation();
                        System.out.println("--------------------------------");
                    }
                }
                else
                {
                    cls();
                    System.out.println("No tienes ningun cliente agregado");
                    int addOneA;
                    do{
                        System.out.println("Deseas agregar uno? (1-Si | 2-No)");
                        addOneA = Integer.parseInt(cn.nextLine());
                    }while(addOneA < 1 || addOneA > 2);

                    if(addOneA == 1)
                    {
                        switchOptionsClients(1);//agregar un cliente
                    }
                    else
                    {
                        switchOptionsClients(printClientsMenu(true));
                    }
                }
                System.out.println();
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
            option = Integer.parseInt(cn.nextLine());;
            if(option < 1 || option > 6)
            {
                cls();
                System.out.println("Opcion no disponible");
            }
        }while(option > 6);

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