
import java.util.List;
import java.util.Scanner;

public class Veterinario extends Persona {
    private String especialidad;

    public Veterinario(String nombre, String apellido, String telefono, String especialidad) {
        super(nombre, apellido, telefono);
        this.especialidad = especialidad;
    }

    public static void agregarVeterinario(Scanner scan, List<Veterinario> listaVeterinarios) {
        System.out.println("Ingrese el nombre del veterinario:");
        String nombre = scan.next();
        System.out.println("Ingrese el apellido del veterinario:");
        String apellido = scan.next();
        System.out.println("Ingrese el teléfono del veterinario:");
        String telefono = scan.next();
        System.out.println("Ingrese la especialidad del veterinario:");
        String especialidad = scan.next();

        Veterinario veterinario = new Veterinario(nombre, apellido, telefono, especialidad);
        listaVeterinarios.add(veterinario);
        System.out.println("Veterinario agregado con éxito.");
    }

    public static void verVeterinarios(List<Veterinario> listaVeterinarios) {
        System.out.println("Lista de todos los veterinarios:");
        for (Veterinario veterinario : listaVeterinarios) {
            System.out.println(veterinario);
        }
    }
}
