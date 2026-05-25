# Sistema de Gestión de Personal - Clínica Salud Total

Este proyecto en **Java** aplica los principios de la **Programación Orientada a Objetos (POO)** y el manejo de excepciones para construir un sistema de gestión de personal en una clínica privada.

---

## Conceptos Fundamentales

### 1. Herencia
La **herencia** permite que una clase hija reutilice atributos y métodos de una clase padre.  
En este sistema:
- `Empleado` es la clase padre.
- `Medico` y `Administrativo` heredan de `Empleado`.

Ejemplo:
```java
public class Medico extends Empleado { ... }
2. Encapsulamiento
El encapsulamiento protege los atributos de una clase usando modificadores de acceso (private) y permitiendo el acceso controlado mediante métodos (getters y setters).
Esto asegura que los datos no puedan ser modificados directamente sin validación.

Ejemplo:

java
private String cedula;
public String getCedula() { return cedula; }
3. Polimorfismo
El polimorfismo permite que diferentes clases hijas implementen un mismo método de manera distinta.
En este sistema, tanto Medico como Administrativo redefinen el método calcularPago() según sus reglas.

Ejemplo:

java
ArrayList<Empleado> empleados = new ArrayList<>();
empleados.add(new Medico(...));
empleados.add(new Administrativo(...));

for (Empleado e : empleados) {
    System.out.println(e.calcularPago()); // Se ejecuta según el tipo real
}
4. Excepciones
Las excepciones controlan errores en tiempo de ejecución evitando que el programa se detenga abruptamente.
Se usan try-catch para capturar errores en:

Menú

Conversiones (Integer.parseInt, Double.parseDouble)

Datos numéricos

Búsquedas

Ejemplo:

java
try {
    int opcion = Integer.parseInt(sc.nextLine());
} catch (NumberFormatException e) {
    System.out.println("Error: opción inválida.");
}
5. Conversiones
Las conversiones permiten transformar tipos de datos:

String → int con Integer.parseInt()

String → double con Double.parseDouble()

Casting explícito (int), (double)

Ejemplo:

java
String edad = "25";
int e = Integer.parseInt(edad);

double numero = 15.99;
int entero = (int) numero; // Resultado: 15
6. Validaciones
Las validaciones garantizan que los datos ingresados sean correctos:

Edad entre 1 y 149.

Cédula única (no duplicada).

Campos obligatorios no vacíos (nombre, correo, especialidad, departamento).

Correo debe contener @ y ..

Teléfono solo números.

Valores numéricos mayores a cero.

👉 Ejemplo:

java
