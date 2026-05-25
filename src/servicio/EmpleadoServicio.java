package servicio;

import modelo.Empleado;
import java.util.ArrayList;

public class EmpleadoServicio {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void registrarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void mostrarEmpleados() {
        for (Empleado e : empleados) {
            e.mostrarInformacion();
            System.out.println("-------------------");
        }
    }

    public Empleado buscarPorCedula(String cedula) {
        for (Empleado e : empleados) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    public void eliminarEmpleado(String cedula) {
        empleados.removeIf(e -> e.getCedula().equals(cedula));
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
}
