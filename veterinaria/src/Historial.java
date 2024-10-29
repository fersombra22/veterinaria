

import java.util.ArrayList;

public class Historial {
    private ArrayList<Tratamiento> tratamientos;


    // Constructor
    public Historial() {
        this.tratamientos = new ArrayList<>();
    }

    public ArrayList<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(ArrayList<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    // Método para agregar un tratamiento al historial
    public void agregarTratamiento(Tratamiento tratamiento) {
        tratamientos.add(tratamiento);
    }

    // Método para mostrar todos los tratamientos
    public void mostrarTratamientos() {
        if (tratamientos.isEmpty()) {
            System.out.println("No hay tratamientos registrados.");
        } else {
            for (Tratamiento tratamiento : tratamientos) {
                System.out.println(tratamiento);
            }
        }
    }
}

