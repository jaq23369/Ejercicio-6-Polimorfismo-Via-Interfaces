import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Estudiante: Joel Antonio Jaquez López
 * Carné: 23369
 * Clase: Programación Orientada a Objetos
 * Ejercicio: Ejercicio 6 de polimorfismo vía intefaces
 * Fecha de inicio: 30/10/2023
 * Fecha de terminación: 31/10/2023
 * 
 * La clase Main es el punto de entrada del programa y gestiona la interacción
 * con el usuario y la funcionalidad del sistema.
 */
public class Main {
    private static List<DispositivoElectronico> dispositivos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while(continuar) {
            mostrarMenu();
            int opcion = obtenerOpcion(scanner);

            switch(opcion) {
                case 1:
                    agregarDispositivo(scanner);
                    break;
                case 2:
                    mostrarInformacionDeDispositivos();
                    break;
                case 3:
                    guardarEnCSV();
                    System.out.println("Dispositivos guardados en un archivo CSV.");
                    break;
                case 4:
                    cargarDesdeCSV();
                     System.out.println("Dispositivos cargados desde un archivo CSV.");
                    break;
                case 5:
                    continuar = false;
                    System.out.println("¡Gracias por utilizar ElectroTech! Hasta pronto.");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Muestra el menú de opciones para el usuario.
     */
    private static void mostrarMenu() {
        System.out.println("1. Agregar dispositivo");
        System.out.println("2. Mostrar información de dispositivos");
        System.out.println("3. Guardar en CSV");
        System.out.println("4. Cargar desde CSV");
        System.out.println("5. Salir");
    }

    /**
     * Obtiene la opción seleccionada por el usuario.
     *
     * @param scanner El objeto Scanner utilizado para la entrada de usuario.
     * @return El número de opción seleccionado.
     */
    private static int obtenerOpcion(Scanner scanner) {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    /**
     * Permite al usuario agregar un dispositivo (teléfono o computadora) al sistema.
     *
     * @param scanner El objeto Scanner utilizado para la entrada de usuario.
     */
    private static void agregarDispositivo(Scanner scanner) {
        System.out.println("1. Teléfono");
        System.out.println("2. Computadora");
        System.out.print("Seleccione el tipo de dispositivo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir el '\n' que queda pendiente

        if (tipo == 1) {
            System.out.print("Ingrese el modelo del teléfono: ");
            String modelo = scanner.nextLine();
            dispositivos.add(new Telefono(modelo));
        } else if (tipo == 2) {
            System.out.print("Ingrese la marca de la computadora: ");
            String marca = scanner.nextLine();
            dispositivos.add(new Computadora(marca));
        }
    }

    /**
     * Muestra información detallada de todos los dispositivos en el sistema
     * y realiza la validación de elementos encendidos y apagados.
     */
    private static void mostrarInformacionDeDispositivos() {
    if (dispositivos.isEmpty()) {
        System.out.println("No hay dispositivos para mostrar.");
    } else {
        System.out.println("Información de dispositivos:");
        for (DispositivoElectronico dispositivo : dispositivos) {
            String estado = dispositivo.encendido() ? "Encendido" : "Apagado";
            System.out.println(dispositivo.obtenerInformacion() + " - Estado: " + estado);
        }

        // Validación de elementos encendidos y apagados
        int encendidos = 0;
        int apagados = 0;

        for (DispositivoElectronico dispositivo : dispositivos) {
            if (dispositivo.encendido()) {
                encendidos++;
            } else {
                apagados++;
            }
        }

        System.out.println("Elementos encendidos: " + encendidos);
        System.out.println("Elementos apagados: " + apagados);
    }
}


    /**
     * Guarda la información de los dispositivos en un archivo CSV.
     */
    private static void guardarEnCSV() {
        try (FileWriter writer = new FileWriter("DispositivosNuevos.csv")) {
            for (DispositivoElectronico dispositivo : dispositivos) {
                if (dispositivo instanceof Telefono) {
                    writer.write("Telefono," + ((Telefono) dispositivo).getModelo() + "\n");
                } else if (dispositivo instanceof Computadora) {
                    writer.write("Computadora," + ((Computadora) dispositivo).getMarca() + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al guardar en CSV: " + e.getMessage());
        }
    }

    /**
     * Carga información de dispositivos desde un archivo CSV proporcionado por el usuario.
     */
    private static void cargarDesdeCSV() {
        dispositivos.clear();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, ingrese el nombre del archivo CSV que desea cargar: ");
        String nombreArchivo = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals("Telefono")) {
                    dispositivos.add(new Telefono(parts[1]));
                } else if (parts[0].equals("Computadora")) {
                    dispositivos.add(new Computadora(parts[1]));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar desde CSV: " + e.getMessage());
        }
    }
}