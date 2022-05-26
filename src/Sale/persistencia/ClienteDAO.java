
package Sale.persistencia;

import Sale.entidades.Cliente;
import java.util.ArrayList;
import java.util.Collection;


public final class ClienteDAO extends Dao {
    
    public void nuevoCliente (Cliente cliente){
        try {
            
            String sql = "INSERT INTO cliente (id, nombre_cliente) VALUES ("+cliente.getId() + ",'" +cliente.getCliente()+"');";
            System.out.println(sql);
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
        }
       
    }
    
    public Collection<Cliente> consultarClientes (){
        Collection<Cliente> listaClientes = new ArrayList();
        Cliente cliente = null;
        
        try {
            String sql = "SELECT * FROM cliente;";
           
            consultarBase(sql);
            
            while (resultado.next()) { 
                cliente = new Cliente();
                cliente.setId(resultado.getInt(1));
                cliente.setCliente(resultado.getString(2));
                
                listaClientes.add(cliente);                       
            }
            
            desconectarBase();
            
           
        } catch (Exception e) {
        }
        
        
        
       return listaClientes;
    }
    
    
    // metodos para eliminar clientes por id=dni
    
    public void eliminarClientePorId(double id){
        
        try {
            String sql = "DELETE FROM cliente WHERE id = " +id+";";

            insertarModificarEliminar(sql);
            
            
        } catch (Exception e) {
        }
        
        
       
    }
    
}
