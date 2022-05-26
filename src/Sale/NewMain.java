
package Sale;

import Sale.persistencia.ClienteDAO;
import Sale.servicio.ServicioCliente;


public class NewMain {

    
    public static void main(String[] args) throws Exception {
        
        ClienteDAO cliente = new ClienteDAO();
        ServicioCliente ssCliente = new ServicioCliente(cliente);
        
       //ssCliente.ingresarClientes();
        
      //ssCliente.mostrarTodosLosClientes();
        
      ssCliente.eliminarClienes();
      
      
    }
    
}
