import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class ProyectoFinal
{
    public static List<Clientes> myClients = new ArrayList<Clientes>();
    public static List<Articulos> myProducts = new ArrayList<Articulos>();

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
                switchOptionsProducts(printProductsMenu(true));
                break;
            case 3:
                makeAnOrder();
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
				System.out.println("Opcion no disponible\n");
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
                    cls();
                    int nClienteM;
                    int countResultsM = 0;
                    do{
                        System.out.println("Ingrese el numero del cliente a modificar");
//                        nClienteM = cn.nextInt();
                        nClienteM = Integer.parseInt(cn.nextLine());

                        for(int i = 0; i <= myClients.size() - 1; i++)
                        {
                            if(myClients.get(i).getNumeroCliente() == nClienteM)
                            {
                                String nombreTemporal = myClients.get(i).getNombre();

                                System.out.println("\nIngrese el nombre del cliente");
                                myClients.get(i).setNombre(cn.nextLine());

                                System.out.println("\nIngrese la direccion del cliente");
                                myClients.get(i).setDireccion(cn.nextLine());

                                System.out.println("\nIngrese el telefono del cliente");
                                myClients.get(i).setTelefono(cn.nextLine());
                                countResultsM++;

                                cls();
                                System.out.println("Informacion del cliente "+ nombreTemporal + " ha sido actualizada");
                            }
                        }
                        if(countResultsM == 0)
                        {
                            cls();
                            System.out.println("Cliente no encontrado...!\n");
                        }
                    }while(countResultsM == 0);

                    switchOptionsClients(printClientsMenu(false));
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
                System.out.println("Opcion no disponible\n");
            }
        }while(option > 6);

        return option;
    }

    public static void switchOptionsProducts(int opcion)
    {
        Scanner cn = new Scanner(System.in);
        switch(opcion)
        {
            case 1://Crear Articulo
                cls();
                boolean validate = false;
                int numeroArticulo;
                double precio;
                int cantidadExistencia;

                do{
                    System.out.println("Ingrese el numero del articulo");
                    numeroArticulo = Integer.parseInt(cn.nextLine());

                    if(myProducts.size() > 0)
                    {
                        for(int i = 0; i <= myProducts.size() - 1; i++)
                        {
                            if(myProducts.get(i).getNumeroArticulo() == numeroArticulo)
                            {
                                validate = true;
                                cls();
                                System.out.println("\nYa existe un articulo con este numero...!\n");
                            }
                            else
                            {
                                validate = false;
                            }
                        }
                    }
                }while(validate == true);

                System.out.println("\nIngrese precio del articulo");
                precio = Double.parseDouble(cn.nextLine());

                System.out.println("\nIngrese la cantidad en existencia del articulo");
                cantidadExistencia = Integer.parseInt(cn.nextLine());

                myProducts.add(new Articulos(numeroArticulo, precio, cantidadExistencia));

                cls();
                System.out.println("Articulo Agregado correctamente");
                int addOne;
                do{
                    System.out.println("Deseas agregar otro articulo? (1-Si | 2-No)");
                    addOne = Integer.parseInt(cn.nextLine());
                }while(addOne < 1 || addOne > 2);

                if(addOne == 1)
                {
                    switchOptionsProducts(1);//agregar un articulo
                }
                else
                {
                    switchOptionsProducts(printProductsMenu(true));
                }
                break;

            case 2://Consultar articulo
                if(myProducts.size() > 0)
                {
                    int nArticulo;
                    int countResults = 0;
                    do{
                        cls();
                        System.out.println("Ingrese el numero del articulo a consultar");
                        nArticulo = cn.nextInt();

                        for(int i = 0; i <= myProducts.size() - 1; i++)
                        {
                            if(myProducts.get(i).getNumeroArticulo() == nArticulo)
                            {
                                cls();
                                System.out.println("---------------------------------");
                                myProducts.get(i).displayAllInformation();
                                countResults++;
                                System.out.println("---------------------------------\n");
                            }
                        }
                        if(countResults == 0)
                        {
                            cls();
                            System.out.println("Articulo no encontrado...!\n");
                        }
                    }while(countResults == 0);
                }
                else
                {
                    cls();
                    System.out.println("No tienes ningun articulo agregado");
                    int addOneC;
                    do{
                        System.out.println("Deseas agregar uno? (1-Si | 2-No)");
                        addOneC = Integer.parseInt(cn.nextLine());
                    }while(addOneC < 1 || addOneC > 2);

                    if(addOneC == 1)
                    {
                        switchOptionsProducts(1);//agregar un articulo
                    }
                    else
                    {
                        switchOptionsProducts(printProductsMenu(true));
                    }
                }

                switchOptionsProducts(printProductsMenu(false));
                break;

            case 3://Modificar articulo
                if(myProducts.size() > 0)
                {
                    cls();
                    int nProductM;
                    int countResultsM = 0;
                    do{
                        System.out.println("Ingrese el numero del articulo a modificar");
                        nProductM = Integer.parseInt(cn.nextLine());

                        for(int i = 0; i <= myProducts.size() - 1; i++)
                        {
                            if(myProducts.get(i).getNumeroArticulo() == nProductM)
                            {
                                System.out.println("\nIngrese el precio del articulo");
                                myProducts.get(i).setPrecio(Double.parseDouble(cn.nextLine()));

                                System.out.println("\nIngrese la cantidad en existencia del articulo");
                                myProducts.get(i).setCantidadExistencia(Integer.parseInt(cn.nextLine()));

                                countResultsM++;

                                cls();
                                System.out.println("Informacion del articulo #"+ nProductM + " ha sido actualizada");
                            }
                        }
                        if(countResultsM == 0)
                        {
                            cls();
                            System.out.println("Articulo no encontrado...!\n");
                        }
                    }while(countResultsM == 0);

                    switchOptionsProducts(printProductsMenu(false));
                }
                else
                {
                    cls();
                    System.out.println("No tienes ningun articulo agregado");
                    int addOneM;
                    do{
                        System.out.println("Deseas agregar uno? (1-Si | 2-No)");
                        addOneM = Integer.parseInt(cn.nextLine());
                    }while(addOneM < 1 || addOneM > 2);

                    if(addOneM == 1)
                    {
                        switchOptionsProducts(1);//agregar un articulo
                    }
                    else
                    {
                        switchOptionsProducts(printProductsMenu(true));
                    }
                }
                break;

            case 4://Eliminar Cliente
                if(myProducts.size() > 0)
                {
                    cls();
                    int nProductD;
                    int countResultD = 0;
                    do{
                        System.out.println("Ingrese el numero del articulo a eliminar");
                        nProductD = cn.nextInt();

                        for(int i = 0; i <= myProducts.size() - 1; i++)
                        {
                            if(myProducts.get(i).getNumeroArticulo() == nProductD)
                            {
                                myProducts.remove(i);
                                countResultD++;
                                cls();
                                System.out.println("Articulo Eliminado\n");
                            }
                        }

                        if(countResultD == 0)
                        {
                            cls();
                            System.out.println("Articulo no encontrado...!\n");
                        }
                    }while(countResultD == 0);

                }
                else
                {
                    cls();
                    System.out.println("No tienes ningun articulo agregado");
                    int addOneE;
                    do{
                        System.out.println("Deseas agregar uno? (1-Si | 2-No)");
                        addOneE = Integer.parseInt(cn.nextLine());
                    }while(addOneE < 1 || addOneE > 2);

                    if(addOneE == 1)
                    {
                        switchOptionsProducts(1);//agregar un producto
                    }
                    else
                    {
                        switchOptionsProducts(printProductsMenu(true));
                    }
                }

                switchOptionsProducts(printProductsMenu(false));
                break;

            case 5://Consultar Todos los clientes
                if(myProducts.size() > 0)
                {
                    cls();
                    System.out.println("-------Todos mis articulos-------\n");
                    System.out.println("--------------------------------");
                    for(int i = 0; i <= myProducts.size() - 1; i++)
                    {
                        myProducts.get(i).displayAllInformation();
                        System.out.println("--------------------------------");
                    }
                }
                else
                {
                    cls();
                    System.out.println("No tienes ningun articulo agregado");
                    int addOneA;
                    do{
                        System.out.println("Deseas agregar uno? (1-Si | 2-No)");
                        addOneA = Integer.parseInt(cn.nextLine());
                    }while(addOneA < 1 || addOneA > 2);

                    if(addOneA == 1)
                    {
                        switchOptionsProducts(1);//agregar un articulo
                    }
                    else
                    {
                        switchOptionsProducts(printProductsMenu(true));
                    }
                }
                System.out.println();
                switchOptionsProducts(printProductsMenu(false));
                break;

            case 6:
                switchOptions(printMenu(true));
                break;
        }
    }

    public static int printProductsMenu(boolean clean)
    {
        if(clean == true)
        {
            cls();
        }

        Scanner cn = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("----------Articulos-----------");
            System.out.println("|1-Registrar Articulo        |");
            System.out.println("|2-Consultar Articulo        |");
            System.out.println("|3-Modificar Articulo        |");
            System.out.println("|4-Eliminar Articulo         |");
            System.out.println("|5-Ver todos los Articulo    |");
            System.out.println("|6-Salir                     |");
            System.out.println("------------------------------");
            option = Integer.parseInt(cn.nextLine());;
            if(option < 1 || option > 6)
            {
                cls();
                System.out.println("Opcion no disponible\n");
            }
        }while(option > 6);

        return option;
    }

    public static void makeAnOrder()
    {
        Scanner cn = new Scanner(System.in);

        if(myClients.size() == 0)
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

        if(myProducts.size() == 0)
        {
            cls();
            System.out.println("No tienes ningun articulo agregado");
            int addOneE;
            do{
                System.out.println("Deseas agregar uno? (1-Si | 2-No)");
                addOneE = Integer.parseInt(cn.nextLine());
            }while(addOneE < 1 || addOneE > 2);

            if(addOneE == 1)
            {
                switchOptionsProducts(1);//agregar un producto
            }
            else
            {
                switchOptionsProducts(printProductsMenu(true));
            }
        }

        int nCliente;
        int countResults = 0;

        do{
            cls();
            switchOptionsClients(5);

            System.out.println("\nIngrese el numero del cliente a seleccionar");
            nCliente = Integer.parseInt(cn.nextLine());

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

        List<SeleccionArticulos> products = selectProducto();
    }

    public static List<SeleccionArticulos> selectProducto()
    {
        Scanner cn = new Scanner(System.in);
        List<SeleccionArticulos> products = new ArrayList<SeleccionArticulos>();

        int nArticulo;
        String descripcion;
        String descripcionTamanio;
        String color;
        String seccionBodega;
        int numeroEstante;
        int cantidadPedida;
        int cantidadSurtida;
        int seleccionarOtro = 0;

        do{
            int countResults = 0;
            do{
                cls();
                switchOptionsProducts(5);
                System.out.println("Ingrese el numero del articulo a seleccionar");
                nArticulo = Integer.parseInt(cn.nextLine());

                for(int i = 0; i <= myProducts.size() - 1; i++)
                {
                    if(myProducts.get(i).getNumeroArticulo() == nArticulo)
                    {
                        if(products.size() == 0)
                        {
                            cls();
                            countResults++;
                        }
                        else
                        {
                            for(int j = 0; j <= products.size() - 1; j++)
                            {
                                if(myProducts.get(i).getNumeroArticulo() == products.get(j).getNumeroArticulo())
                                {
                                    countResults = 0;
                                    System.out.println("Ya este producto esta seleccionado");
                                }
                                else
                                {
                                    cls();
                                    countResults++;
                                }
                            }
                        }
                    }
                }

                if(countResults == 0)
                {
                    cls();
                    System.out.println("Articulo no encontrado...!\n");
                }
            }while(countResults == 0);

            System.out.println("El articulo seleccionado fue el " + nArticulo);

            System.out.println("Ingrese la descripcion del articulo");
            descripcion = cn.nextLine();

            System.out.println("Ingrese la descripcion del tamaño del articulo");
            descripcionTamanio = cn.nextLine();

            System.out.println("Ingrese la descripcion del color del articulo");
            color = cn.nextLine();

            System.out.println("Ingrese la seccion de bodega del articulo");
            seccionBodega = cn.nextLine();

            System.out.println("Ingrese el numero de estante articulo");
            numeroEstante = Integer.parseInt(cn.nextLine());

            System.out.println("Ingrese la cantidad pedida del articulo");
            cantidadPedida = Integer.parseInt(cn.nextLine());

            System.out.println("Ingrese la cantidad surtida del articulo");
            cantidadSurtida = Integer.parseInt(cn.nextLine());

            products.add(new SeleccionArticulos(nArticulo, descripcion, descripcionTamanio, color, seccionBodega, numeroEstante, cantidadPedida, cantidadSurtida));

            cls();
            System.out.println("Deseas Seleccionar otro producto? (1-Si | 2-No)");
            seleccionarOtro = Integer.parseInt(cn.nextLine());
        }while(seleccionarOtro != 2);

        return products;
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