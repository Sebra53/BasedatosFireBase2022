package cl.isisur.basedatosfirebase2022.Clases;

public class Cliente {

    private String idCliente;
    private String nombreC;
    private String rut;
    private String ocupacion;

    public Cliente()
    {
        this.idCliente="";
        this.nombreC="";
        this.rut ="";
        this.ocupacion ="";
    }


    public Cliente(String idCliente, String nombreC, String rut, String ocupacion)
    {
        this.idCliente=idCliente;
        this.nombreC=nombreC;
        this.rut = rut;
        this.ocupacion = ocupacion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getrut() {
        return rut;
    }

    public void setrut(String rut) {
        this.rut = rut;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente='" + idCliente + '\'' +
                ", nombreC='" + nombreC + '\'' +
                ", rut='" + rut + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                '}';
    }


}
