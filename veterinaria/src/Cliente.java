

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Persona {
    private String direccion;
    private List<Mascota> mascotas;

    public Cliente(String nombre, String apellido, String telefono, String direccion) {
        super(nombre, apellido, telefono);
        this.direccion = direccion;
        this.mascotas = new ArrayList<>();
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public void mostrarMascotas() {
        System.out.println("Mascotas de " + getNombre() + ":");
        for (Mascota mascota : mascotas) {
            mascota.mostrarMascota();
        }
    }

    public static void agregarCliente(Scanner scan, List<Cliente> listaClientes) {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scan.next();
        System.out.println("Ingrese el apellido del cliente:");
        String apellido = scan.next();
        System.out.println("Ingrese el teléfono del cliente:");
        String telefono = scan.next();
        System.out.println("Ingrese la dirección del cliente:");
        String direccion = scan.next();

        Cliente cliente = new Cliente(nombre, apellido, telefono, direccion);
        listaClientes.add(cliente);
        System.out.println("Cliente agregado con éxito.");
    }

    public static void agregarMascota(Scanner scan, List<Mascota> listaMascotas, List<Cliente> listaClientes) {
        System.out.println("Seleccione un cliente por su número:");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println((i + 1) + ". " + listaClientes.get(i).getNombre());
        }
        int indiceCliente = scan.nextInt() - 1;

        System.out.println("Ingrese el nombre de la mascota:");
        String nombre = scan.next();
        System.out.println("Ingrese la edad de la mascota:");
        int edad = scan.nextInt();
        System.out.println("Ingrese el tipo de mascota:");
        String tipo = scan.next();
        System.out.println("Ingrese el sexo de la mascota:");
        String sexo = scan.next();
        System.out.println("Ingrese el peso de la mascota:");
        double peso = scan.nextDouble();

        Mascota mascota = new Mascota(nombre, edad, tipo, sexo, peso);
        listaMascotas.add(mascota);
        listaClientes.get(indiceCliente).agregarMascota(mascota);
        System.out.println("Mascota agregada con éxito al cliente.");
    }

    public static void verClientes(List<Cliente> listaClientes) {
        System.out.println("Lista de todos los clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
            cliente.mostrarMascotas();
        }
    }
}
