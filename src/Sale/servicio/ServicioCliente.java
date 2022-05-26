package Sale.servicio;

import Sale.entidades.Cliente;
import Sale.persistencia.ClienteDAO;
import java.util.Collection;
import java.util.Scanner;

public class ServicioCliente {

    private ClienteDAO cliDAO;

    public ServicioCliente(ClienteDAO cliDAO) {
        this.cliDAO = cliDAO;
    }

    Scanner leer = new Scanner(System.in);

    //metodos para ingresar clientes
    public void ingresarClientes() throws Exception {

        Cliente c1 = new Cliente();
        Collection<Cliente> listaClientes = cliDAO.consultarClientes();

        String swi = "s";
        boolean ciclo = true;

        do {
            System.out.println("S ---> PARA AGREGAR CLIENTE");
            System.out.println("N ---> PARA SALIR");
            swi = leer.next();
            swi = swi.toLowerCase();

            switch (swi) {

                case "s":
                    validarCliente();

                    break;

                case "n":
                    ciclo = false;
                    System.out.println("La opcion elegida es N ");
                    System.out.println("saliendo del modulo INGRESAR CLIENTES");
                    break;

                default:
                    System.out.println("la opcion ingresada es incorrecta");

                    break;

            }

        } while (ciclo == true);

    }

    public void mostrarTodosLosClientes() throws Exception {

        Collection<Cliente> listaClientes = cliDAO.consultarClientes();

        for (Cliente aux : listaClientes) {
            
            System.out.println("---------------------------------------------");

            System.out.println("ID Cliente: " + aux.getId());

            System.out.println("Nombre del cliente: " + aux.getCliente());

            System.out.println("---------------------------------------------");

        }

    }

    public void validarCliente() throws Exception {
        int validacion = 0;

        Cliente c1 = new Cliente();
        Collection<Cliente> listaClientes = cliDAO.consultarClientes();

        System.out.println("ingrese el DNI del cliente");
        c1.setId(leer.nextInt());

        System.out.println("Ingrese el nombre del cliente");
        c1.setCliente(leer.next());

        for (Cliente aux : listaClientes) {

            if (aux.getId() == c1.getId()) {
                validacion = 1;
                System.out.println("El cliente ya se encuentra registrado");
                System.out.println("---------------------------------------------");
                System.out.println("ID Cliente: " + aux.getId());
                System.out.println("Nombre del cliente: " + aux.getCliente());
                System.out.println("---------------------------------------------");

            }
        }

        if (validacion == 0) {
            cliDAO.nuevoCliente(c1);
            System.out.println("---------------------------------------------");
            System.out.println("El cliente fue registrado");
            System.out.println("su lista de clientes actualizada es; ");
            System.out.println("---------------------------------------------");
            mostrarTodosLosClientes();

        }
    }

    // metodos para eliminar clientes
    public void eliminarClienes() throws Exception {
        boolean validar = true;
        
         System.out.println("la lista de clientes actuales es: ");
        mostrarTodosLosClientes();
        

        System.out.println("Ingrese el DNI del cliente a eliminar");
        double codigoParaEliminar = leer.nextDouble();

        Collection<Cliente> listaClientes = cliDAO.consultarClientes();
       
        

        for (Cliente aux : listaClientes) {

            if (aux.getId() == codigoParaEliminar) {
                validar = false;

                System.out.println("El cliente fue eliminado");
                System.out.println(":( :( :( :( :( :(");
                System.out.println("la lista de clientes actuales es: ");
                cliDAO.eliminarClientePorId(codigoParaEliminar);

                mostrarTodosLosClientes();

            }

        }

        if (validar == true) {
            
            System.out.println("el DNI ingresado no pertenece a ningun cliente existente");

        }
    }
    
    

}
