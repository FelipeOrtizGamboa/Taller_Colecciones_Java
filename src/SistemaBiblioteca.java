import java.util.*;

public class SistemaBiblioteca {
    // buscar un material por código al instante
    private Map<String, Material> catalogo = new HashMap<>();

    // Fila ordenada de espera por cada material
    private Map<String, List<String>> listaEspera = new HashMap<>();

    // membresías sin repetidos
    private Set<String> miembros = new HashSet<>();


    public void registrarMaterial(Material m) {
        catalogo.put(m.getCodigo(), m);
    }

    public Material buscarMaterial(String codigo) {
        return catalogo.get(codigo); // null si no existe
    }

    public void mostrarCatalogo() {
        for (Map.Entry<String, Material> entrada : catalogo.entrySet()) {
            entrada.getValue().mostrarInfo();
        }
    }


    public void agregarEspera(String codigoMaterial, String usuario) {
        if (!listaEspera.containsKey(codigoMaterial)) {
            listaEspera.put(codigoMaterial, new ArrayList<>());
        }
        listaEspera.get(codigoMaterial).add(usuario); // al final de la fila
    }

    public String siguienteEnEspera(String codigoMaterial) {
        List<String> fila = listaEspera.get(codigoMaterial);
        if (fila == null || fila.isEmpty()) {
            return null; // nadie esperando
        }
        return fila.remove(0); // el primero que llegó
    }


    public boolean registrarMiembro(String usuario) {
        return miembros.add(usuario); // true si era nuevo, false si ya existía
    }

    public boolean tieneMembresia(String usuario) {
        return miembros.contains(usuario);
    }
}