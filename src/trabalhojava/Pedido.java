package trabalhojava;

public class Pedido {

    private int id;
    private int idCliente;
    private int idPizza;
    private double valorTotal;

    private statusEnum status = statusEnum.aberto;

    private enum statusEnum {
        aberto(1),
        caminho(2),
        entregue(3);

        private int value;

        public int getValue() {
            return value;
        }

        private statusEnum(int value) {
            this.value = value;
        }
    };

    public Pedido() {
    }

    public Pedido(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public statusEnum getStatusEnum() {
        return status;
    }

    public void setStatusEnum(statusEnum status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
