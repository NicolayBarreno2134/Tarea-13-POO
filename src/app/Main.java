package app;

import modelo.*;
import servicio.EmpleadoServicio;
import util.Validador;
import java.util.Scanner;

public class Main {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        EmpleadoServicio servicio = new EmpleadoServicio();
        int opcion = 0;

        do {
            System.out.println("===== CLÍNICA SALUD TOTAL =====");
            System.out.println("1. Registrar médico");
            System.out.println("2. Registrar administrativo");
            System.out.println("3. Mostrar empleados");
            System.out.println("4. Buscar por cédula");
            System.out.println("5. Reemplazar información");
            System.out.println("6. Eliminar registro");
            System.out.println("7. Calcular pagos");
            System.out.println("8. Mostrar estadísticas");
            System.out.println("9. Salir");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: opción inválida.");
                continue;
            }

            switch (opcion) {
                case 1:
                    // Aquí iría el registro de médico con validaciones
                    break;
                case 2:
                    // Aquí iría el registro de administrativo con validaciones
                    break;
                case 3:
                    servicio.mostrarEmpleados();
                    break;
                case 4:
                    System.out.print("Ingrese cédula: ");
                    String cedula = sc.nextLine();
                    Empleado encontrado = servicio.buscarPorCedula(cedula);
                    if (encontrado != null) {
                        encontrado.mostrarInformacion();
                    } else {
                        System.out.println("Registro no encontrado.");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese cédula a eliminar: ");
                    String cedulaEliminar = sc.nextLine();
                    servicio.eliminarEmpleado(cedulaEliminar);
                    System.out.println("Registro eliminado.");
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Error: opción inválida.");
            }
        } while (opcion != 9);
    }
}
