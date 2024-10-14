package cl.isisur.basedatosfirebase2022.Clases;

public class Producto {
    private String idProducto;
    private String nombre;
    private String precio;

    public Producto()
    {
        this.idProducto="";
        this.nombre="";
        this.precio ="";
    }


    public Producto(String idAutor, String nombre, String precio)
    {
        this.idProducto=idAutor;
        this.nombre=nombre;
        this.precio = precio;
    }

    public String getIdAutor() {
        return idProducto;
    }

    public void setIdAutor(String idAutor) {
        this.idProducto = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAutor='" + idProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estado='" + precio + '\'' +
                '}';
    }

}
