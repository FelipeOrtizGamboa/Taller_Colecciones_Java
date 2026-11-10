public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // catálogo
        sistema.registrarMaterial(new Libro("BK-001", "Clean Code", 2008, "Robert Martin", "978-0132350884"));
        sistema.registrarMaterial(new Libro("BK-002", "Effective Java", 2018, "Joshua Bloch", "978-0134685991"));
        sistema.registrarMaterial(new Revista("RV-001", "Wired", 2024, 15, "Tecnología"));
        sistema.registrarMaterial(new Revista("RV-002", "Nature", 2024, 8, "Ciencias"));

        Material encontrado = sistema.buscarMaterial("BK-001");
        encontrado.mostrarInfo();

        Material noExiste = sistema.buscarMaterial("XX-999");
        System.out.println("Código inexistente: " + noExiste); // null, no explota

        // lista de espera
        encontrado.setDisponible(false); // se presta
        sistema.agregarEspera("BK-001", "Ana");
        sistema.agregarEspera("BK-001", "Luis");
        sistema.agregarEspera("BK-001", "María");
        System.out.println("Sigue: " + sistema.siguienteEnEspera("BK-001")); // Ana
        System.out.println("Sigue: " + sistema.siguienteEnEspera("BK-001")); // Luis

        // membresías
        System.out.println(sistema.registrarMiembro("Ana"));   // true
        System.out.println(sistema.registrarMiembro("Luis"));  // true
        System.out.println(sistema.registrarMiembro("María")); // true
        System.out.println(sistema.registrarMiembro("Ana"));   // false (duplicado)
        System.out.println("¿Ana es miembro? " + sistema.tieneMembresia("Ana"));     // true
        System.out.println("¿Pedro es miembro? " + sistema.tieneMembresia("Pedro")); // false

        sistema.mostrarCatalogo();
    }
}