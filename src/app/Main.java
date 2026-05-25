package app;

import modelo.*;
import servicio.EmpleadoServicio;
import util.Validador;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
            System.out.print("Opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: opción inválida.");
                continue;
            }

            switch (opcion) {
                case 1: // Registrar médico
                    try {
                        System.out.print("Ingrese cédula: ");
                        String cedulaMedico = sc.nextLine();
                        if (servicio.buscarPorCedula(cedulaMedico) != null) {
                            System.out.println("Error: cédula duplicada.");
                            break;
                        }

                        System.out.print("Ingrese nombre: ");
                        String nombreMedico = sc.nextLine();
                        if (nombreMedico.isEmpty()) {
                            System.out.println("Error: nombre vacío.");
                            break;
                        }

                        System.out.print("Ingrese edad: ");
                        int edadMedico = Integer.parseInt(sc.nextLine());
                        if (!Validador.validarEdad(edadMedico)) {
                            System.out.println("Error: edad inválida.");
                            break;
                        }

                        System.out.print("Ingrese teléfono: ");
                        String telefonoMedico = sc.nextLine();
                        if (!Validador.validarTelefono(telefonoMedico)) {
                            System.out.println("Error: teléfono inválido.");
                            break;
                        }

                        System.out.print("Ingrese correo: ");
                        String correoMedico = sc.nextLine();
                        if (!Validador.validarCorreo(correoMedico)) {
                            System.out.println("Error: correo inválido.");
                            break;
                        }

                        System.out.print("Ingrese especialidad: ");
                        String especialidad = sc.nextLine();
                        if (especialidad.isEmpty()) {
                            System.out.println("Error: especialidad vacía.");
                            break;
                        }

                        System.out.print("Ingrese número de pacientes atendidos: ");
                        int pacientes = Integer.parseInt(sc.nextLine());
                        if (pacientes <= 0) {
                            System.out.println("Error: pacientes debe ser mayor a cero.");
                            break;
                        }

                        System.out.print("Ingrese valor consulta: ");
                        double valorConsulta = Double.parseDouble(sc.nextLine());
                        if (valorConsulta <= 0) {
                            System.out.println("Error: valor consulta debe ser mayor a cero.");
                            break;
                        }

                        Medico medico = new Medico(cedulaMedico, nombreMedico, edadMedico,
                                telefonoMedico, correoMedico, especialidad, pacientes, valorConsulta);
                        servicio.registrarEmpleado(medico);
                        System.out.println("Médico registrado correctamente.");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: dato numérico inválido.");
                    }
                    break;

                case 2: // Registrar administrativo
                    try {
                        System.out.print("Ingrese cédula: ");
                        String cedulaAdmin = sc.nextLine();
                        if (servicio.buscarPorCedula(cedulaAdmin) != null) {
                            System.out.println("Error: cédula duplicada.");
                            break;
                        }

                        System.out.print("Ingrese nombre: ");
                        String nombreAdmin = sc.nextLine();
                        if (nombreAdmin.isEmpty()) {
                            System.out.println("Error: nombre vacío.");
                            break;
                        }

                        System.out.print("Ingrese edad: ");
                        int edadAdmin = Integer.parseInt(sc.nextLine());
                        if (!Validador.validarEdad(edadAdmin)) {
                            System.out.println("Error: edad inválida.");
                            break;
                        }

                        System.out.print("Ingrese teléfono: ");
                        String telefonoAdmin = sc.nextLine();
                        if (!Validador.validarTelefono(telefonoAdmin)) {
                            System.out.println("Error: teléfono inválido.");
                            break;
                        }

                        System.out.print("Ingrese correo: ");
                        String correoAdmin = sc.nextLine();
                        if (!Validador.validarCorreo(correoAdmin)) {
                            System.out.println("Error: correo inválido.");
                            break;
                        }

                        System.out.print("Ingrese departamento: ");
                        String departamento = sc.nextLine();
                        if (departamento.isEmpty()) {
                            System.out.println("Error: departamento vacío.");
                            break;
                        }

                        System.out.print("Ingrese horas trabajadas: ");
                        int horas = Integer.parseInt(sc.nextLine());
                        if (horas <= 0) {
                            System.out.println("Error: horas trabajadas debe ser mayor a cero.");
                            break;
                        }

                        System.out.print("Ingrese valor por hora: ");
                        double valorHora = Double.parseDouble(sc.nextLine());
                        if (valorHora <= 0) {
                            System.out.println("Error: valor hora debe ser mayor a cero.");
                            break;
                        }

                        Administrativo admin = new Administrativo(cedulaAdmin, nombreAdmin, edadAdmin,
                                telefonoAdmin, correoAdmin, departamento, horas, valorHora);
                        servicio.registrarEmpleado(admin);
                        System.out.println("Administrativo registrado correctamente.");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: dato numérico inválido.");
                    }
                    break;

                case 3: // Mostrar empleados
                    servicio.mostrarEmpleados();
                    break;

                case 4: // Buscar por cédula
                    System.out.print("Ingrese cédula: ");
                    String cedula = sc.nextLine();
                    Empleado encontrado = servicio.buscarPorCedula(cedula);
                    if (encontrado != null) {
                        encontrado.mostrarInformacion();
                    } else {
                        System.out.println("Registro no encontrado.");
                    }
                    break;

                case 5: // Reemplazar información
                    System.out.print("Ingrese cédula del empleado a modificar: ");
                    String cedulaModificar = sc.nextLine();
                    Empleado empleadoModificar = servicio.buscarPorCedula(cedulaModificar);

                    if (empleadoModificar == null) {
                        System.out.println("Registro no encontrado.");
                        break;
                    }

                    try {
                        System.out.print("Ingrese nuevo nombre: ");
                        String nuevoNombre = sc.nextLine();
                        if (nuevoNombre.isEmpty()) {
                            System.out.println("Error: nombre vacío.");
                            break;
                        }

                        System.out.print("Ingrese nueva edad: ");
                        int nuevaEdad = Integer.parseInt(sc.nextLine());
                        if (!Validador.validarEdad(nuevaEdad)) {
                            System.out.println("Error: edad inválida.");
                            break;
                        }

                        System.out.print("Ingrese nuevo teléfono: ");
                        String nuevoTelefono = sc.nextLine();
                        if (!Validador.validarTelefono(nuevoTelefono)) {
                            System.out.println("Error: teléfono inválido.");
                            break;
                        }

                        System.out.print("Ingrese nuevo correo: ");
                        String nuevoCorreo = sc.nextLine();
                        if (!Validador.validarCorreo(nuevoCorreo)) {
                            System.out.println("Error: correo inválido.");
                            break;
                        }

                        // Si es médico
                        if (empleadoModificar instanceof Medico) {
                            System.out.print("Ingrese nueva especialidad: ");
                            String nuevaEspecialidad = sc.nextLine();
                            if (nuevaEspecialidad.isEmpty()) {
                                System.out.println("Error: especialidad vacía.");
                                break;
                            }

                            System.out.print("Ingrese nuevo número de pacientes atendidos: ");
                            int nuevosPacientes = Integer.parseInt(sc.nextLine());
                            if (nuevosPacientes <= 0) {
                                System.out.println("Error: pacientes debe ser mayor a cero.");
                                break;
                            }

                            System.out.print("Ingrese nuevo valor consulta: ");
                            double nuevoValorConsulta = Double.parseDouble(sc.nextLine());
                            if (nuevoValorConsulta <= 0) {
                                System.out.println("Error: valor consulta debe ser mayor a cero.");
                                break;
                            }

                            // Crear nuevo objeto y reemplazar
                            Medico nuevoMedico = new Medico(cedulaModificar, nuevoNombre, nuevaEdad,
                                    nuevoTelefono, nuevoCorreo, nuevaEspecialidad, nuevosPacientes, nuevoValorConsulta);

                            servicio.eliminarEmpleado(cedulaModificar);
                            servicio.registrarEmpleado(nuevoMedico);
                            System.out.println("Información del médico reemplazada correctamente.");
                        }

                        // Si es administrativo
                        else if (empleadoModificar instanceof Administrativo) {
                            System.out.print("Ingrese nuevo departamento: ");
                            String nuevoDepartamento = sc.nextLine();
                            if (nuevoDepartamento.isEmpty()) {
                                System.out.println("Error: departamento vacío.");
                                break;
                            }

                            System.out.print("Ingrese nuevas horas trabajadas: ");
                            int nuevasHoras = Integer.parseInt(sc.nextLine());
                            if (nuevasHoras <= 0) {
                                System.out.println("Error: horas trabajadas debe ser mayor a cero.");
                                break;
                            }

                            System.out.print("Ingrese nuevo valor por hora: ");
                            double nuevoValorHora = Double.parseDouble(sc.nextLine());
                            if (nuevoValorHora <= 0) {
                                System.out.println("Error: valor hora debe ser mayor a cero.");
                                break;
                            }

                            // Crear nuevo objeto y reemplazar
                            Administrativo nuevoAdmin = new Administrativo(cedulaModificar, nuevoNombre, nuevaEdad,
                                    nuevoTelefono, nuevoCorreo, nuevoDepartamento, nuevasHoras, nuevoValorHora);

                            servicio.eliminarEmpleado(cedulaModificar);
                            servicio.registrarEmpleado(nuevoAdmin);
                            System.out.println("Información del administrativo reemplazada correctamente.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Error: dato numérico inválido.");
                    }
                    break;


                case 6: // Eliminar registro
                    System.out.print("Ingrese cédula a eliminar: ");
                    String cedulaEliminar = sc.nextLine();
                    servicio.eliminarEmpleado(cedulaEliminar);
                    System.out.println("Registro eliminado.");
                    break;

                case 7: // Calcular pagos
                    for (Empleado e : servicio.getEmpleados()) {
                        System.out.println("Empleado: " + e.getNombre() + " → Pago: " + e.calcularPago());
                    }
                    break;

                case 8: // Mostrar estadísticas
                    int totalMedicos = 0, totalAdmins = 0;
                    double totalPagoMedicos = 0, totalPagoAdmins = 0;
                    Empleado mayorIngreso = null;

                    for (Empleado e : servicio.getEmpleados()) {
                        if (e instanceof Medico) {
                            totalMedicos++;
                            totalPagoMedicos += e.calcularPago();
                        } else if (e instanceof Administrativo) {
                            totalAdmins++;
                            totalPagoAdmins += e.calcularPago();
                        }
                        if (mayorIngreso == null || e.calcularPago() > mayorIngreso.calcularPago()) {
                            mayorIngreso = e;
                        }
                    }

                    System.out.println("Total médicos: " + totalMedicos);
                    System.out.println("Total administrativos: " + totalAdmins);
                    System.out.println("Total empleados: " + servicio.getEmpleados().size());
                    System.out.println("Pago total médicos: " + totalPagoMedicos);
                    System.out.println("Pago total administrativos: " + totalPagoAdmins);
                    if (mayorIngreso != null) {
                        System.out.println("Empleado con mayor ingreso: " + mayorIngreso.getNombre() +
                                " → " + mayorIngreso.calcularPago());
                    }
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
