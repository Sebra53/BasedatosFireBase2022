package cl.isisur.basedatosfirebase2022.Clases;

public class Usuario {

    private String idUsuario;
    private String nombre;
    private String rut;
    private String ocupacion;


    public Usuario()
    {
        this.idUsuario="";
        this.nombre="";
        this.rut ="";
        this.ocupacion="";
    }


    public Usuario(String idUsuario, String nombre, String rut, String ocupacion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.rut = rut;
        this.ocupacion = ocupacion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
}
