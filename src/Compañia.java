public class Compañia {

    private String nombre;
    private Vuelo listaVuelos[] = new Vuelo[10];
    private int numVuelo = 0;

    public Compañia(String nombre) {
        this.nombre = nombre;
    }

    public Compañia(String nombre, Vuelo[] v) {
        this.nombre = nombre;
        listaVuelos = v;
        numVuelo = v.length;
    }

    public void insertarVuelo(Vuelo v){
        listaVuelos[numVuelo] = v;
        numVuelo++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumVuelo() {
        return numVuelo;
    }

    public Vuelo getVuelo(int i){
        return listaVuelos[i];
    }

    public Vuelo getVuelo(String id){
        boolean encontrado = false;
        int i = 0;
        Vuelo vuelo = null;

        while ((!encontrado) && (1 < listaVuelos.length)){
            if(id.equals(vuelo.getIdentificador())){
                encontrado = true;
                vuelo = listaVuelos[i];
            }
            i++;
        }
        return vuelo;
    }
}
