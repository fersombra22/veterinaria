
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        List<Mascota> listaMascotas = new ArrayList<>();
        List<Cliente> listaClientes = new ArrayList<>();
        List<Veterinario> listaVeterinarios = new ArrayList<>();

        // Agregar dos veterinarios iniciales
        listaVeterinarios.add(new Veterinario("Juan", "Pérez", "123456789", "Enfermedades y Vacunas"));
        listaVeterinarios.add(new Veterinario("Ana", "Gómez", "987654321", "Operaciones"));

        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Agregar mascota");
            System.out.println("3. Agregar motivo de la consulta");
            System.out.println("4. Ver todas las mascotas");
            System.out.println("5. Ver todos los clientes");
            System.out.println("6. Ver historial de tratamiento de una mascota");
            System.out.println("7. Salir");

            int opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    Cliente.agregarCliente(scan, listaClientes);
                    break;
                case 2:
                    Cliente.agregarMascota(scan, listaMascotas, listaClientes);
                    break;
                case 3:
                    Mascota.agregarMotivoConsulta(scan, listaMascotas, listaVeterinarios);
                    break;
                case 4:
                    Mascota.verMascotas(listaMascotas);
                    break;
                case 5:
                    Cliente.verClientes(listaClientes);
                    break;
                case 6:
                    System.out.println("Seleccione una mascota por su número:");
                    for (int i = 0; i < listaMascotas.size(); i++) {
                        System.out.println((i + 1) + ". " + listaMascotas.get(i).getNombre());
                    }
                    int indiceMascota = scan.nextInt() - 1;

                    if (indiceMascota >= 0 && indiceMascota < listaMascotas.size()) {
                        System.out.println("Historial de " + listaMascotas.get(indiceMascota).getNombre() + ":");
                        listaMascotas.get(indiceMascota).getHistorial().mostrarTratamientos();
                    } else {
                        System.out.println("Número de mascota no válido.");
                    }
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scan.close();
    }
}
