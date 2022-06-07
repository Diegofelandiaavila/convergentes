package co.edu.unipilito;



public class Material {
    private static String material;
    private static String descripcion;
    private static String peso;
    private static String tamano;
    private static String direccion;



    public Material(String material1, String nombre, String kg, String cm, String Direccion) {
        material = material1;
        descripcion = nombre;
        peso = kg;
        tamano = cm;
        direccion = Direccion;
    }







    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material1) {
        Material.material = material1;
    }

    public  String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String nombre) {
        Material.descripcion = nombre;
    }

    public  String getPeso() {
        return peso;
    }

    public  void setPeso(String kg) {
        Material.peso = kg;
    }

    public  String getTamano() {
        return tamano;
    }

    public  void setTamano(String cm) {
        Material.tamano = cm;
    }

    public  String getDireccion() {
        return direccion;
    }

    public  void setDireccion(String Direccion) {
        Material.direccion = Direccion;
    }
}
