public class Revista extends Material {
    private int edicion;
    private String tematica;

    public Revista(String codigo, String titulo, int anio, int edicion, String tematica) {
        super(codigo, titulo, anio);
        this.edicion = edicion;
        this.tematica = tematica;
    }

    @Override
    public String getTipo() { return "Revista"; }
}