
package Sale.entidades;


public class Cliente {
    int id;
    String cliente;

    public Cliente() {
    }

    public Cliente(int id, String cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", cliente=" + cliente + '}';
    }
    
    
    
}
