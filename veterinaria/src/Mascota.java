
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Mascota {
    private String nombre; // Nombre de la mascota
    private int edad; // Edad de la mascota
    private String tipo; // Tipo de mascota (perro, gato, etc.)
    private String sexo; // Sexo de la mascota
    private double peso; // Peso de la mascota
    private Historial historial; // Historial de tratamientos

    // Constructor parametrizado
    public Mascota(String nombre, int edad, String tipo, String sexo, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
        this.sexo = sexo;
        this.peso = peso;
        this.historial = new Historial(); // Inicializar el historial
    }

    // Constructor vacío
    public Mascota() {
        this.historial = new Historial(); // Inicializar el historial
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Historial getHistorial() {
        return historial;
    }

    // Método para mostrar información de la mascota
    public void mostrarMascota() {
        System.out.println("El nombre es: " + nombre);
        System.out.println("La edad de la mascota es: " + edad + " años");
        System.out.println("El tipo de mascota es: " + tipo);
        System.out.println("El sexo de la mascota es: " + sexo);
        System.out.println("El peso de la mascota es: " + peso + " kg");
    }

    // Método para agregar un tratamiento al historial
    public void agregarTratamiento(Tratamiento tratamiento) {
        if (historial != null) {
            historial.agregarTratamiento(tratamiento);
        } else {
            System.out.println("El historial no está inicializado.");
        }
    }

    // Método estático para mostrar todas las mascotas
    public static void verMascotas(List<Mascota> listaMascotas) {
        System.out.println("Lista de todas las mascotas:");
        for (Mascota mascota : listaMascotas) {
            mascota.mostrarMascota(); // Llama al método de instancia para mostrar
            System.out.println(); // Añade una línea en blanco para mejor legibilidad
        }
    }

    // Método para agregar motivo de consulta
    public static void agregarMotivoConsulta(Scanner scan, List<Mascota> listaMascotas, List<Veterinario> listaVeterinarios) {
        System.out.println("Seleccione una mascota por su número:");
        for (int i = 0; i < listaMascotas.size(); i++) {
            System.out.println((i + 1) + ". " + listaMascotas.get(i).getNombre());
        }
        int indiceMascota = scan.nextInt() - 1;

        if (indiceMascota >= 0 && indiceMascota < listaMascotas.size()) {
            System.out.println("Ingrese el motivo de la consulta:");
            String motivo = scan.next();

            // Asignar el veterinario (por defecto Juan)
            Veterinario veterinario = listaVeterinarios.get(0); // Juan por defecto
            System.out.println("¿Requiere tratamiento? (si/no)");
            String requiereTratamiento = scan.next();

            if (requiereTratamiento.equalsIgnoreCase("si")) {
                System.out.println("Ingrese el diagnóstico:");
                String diagnostico = scan.next();
                Tratamiento tratamiento = new Tratamiento(motivo, diagnostico, LocalDateTime.now());
                listaMascotas.get(indiceMascota).agregarTratamiento(tratamiento);
            } else {
                // Si no requiere tratamiento, solo agregar el motivo con diagnóstico "Sin tratamiento"
                Tratamiento tratamiento = new Tratamiento(motivo + " - Sin tratamiento", "Sin diagnóstico", LocalDateTime.now());
                listaMascotas.get(indiceMascota).agregarTratamiento(tratamiento);
            }

            System.out.println("Motivo de la consulta agregado.");
        } else {
            System.out.println("Número de mascota no válido.");
        }
    }
}
