/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestiongastos;

/**
 *
 * @author David
 * @version 1.0 16/12/2023
 */


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * La clase gasto representa un registro con informacion sobre el gasto
 */
class Gasto {
    private String categoria;
    private double monto;
    private String descripcion;

    /**
     * 
     * @param categoria La categoria del gasto
     * @param monto     El monto del gasto
     * @param descripcion  La descripcion del gasto
     */
    public Gasto(String categoria, double monto, String descripcion) {
        this.categoria = categoria;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la categoria del gasto
     * 
     * @return  La categoria del gasto
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Obtiene el monto del gasto
     * @return El monto del gasto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Obtiene la descripcion del gasto
     * @return La descripcion del gasto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Representacion de la Cadena del resumen del gasto
     * @return  Cadena que representa el resumen del gasto
     */
    @Override
    public String toString() {
        return "Categoría: " + categoria + ", Monto: $" + monto + ", Descripción: " + descripcion;
    }
}

/**
 * La clase GestionGasstos gestiona una lista de gastos,permitiendo agregar,mostrar o eliminar el gasto
 * 
 */
public class GestionGastos {
    private ArrayList<Gasto> listaGastos;

    /**
     * Constructor de la clase GestionGastos.Inicializa la lista de gastos
     */
    public GestionGastos() {
        listaGastos = new ArrayList<>();
    }

    /**
     * Agrega un nuevo gasto a la lista
     * @param categoria La categoria del nuevo gasto
     * @param monto     El monto del nuevo gasto
     * @param descripcion La descripcion del nuevo gasto
     */
    public void agregarGasto(String categoria, double monto, String descripcion) {
        Gasto nuevoGasto = new Gasto(categoria, monto, descripcion);
        listaGastos.add(nuevoGasto);
        System.out.println("Gasto agregado: " + nuevoGasto);
    }

    /**
     * Muestra la lista de gastos,o indica que esta vacia si no hay gastos
     */
    public void mostrarGastos() {
        if (listaGastos.isEmpty()) {
            System.out.println("La lista de gastos está vacía.");
        } else {
            System.out.println("Lista de gastos:");
            for (Gasto gasto : listaGastos) {
                System.out.println(gasto);
            }
        }
    }

    /**
     * Elimina un gasto de la lista basandose en su descripcion
     * @param descripcion La descripcion del gasto a eliminar
     */
    public void eliminarGasto(String descripcion) {
        boolean encontrado = false;
        for (Gasto gasto : listaGastos) {
            if (gasto.getDescripcion().equalsIgnoreCase(descripcion)) {
                listaGastos.remove(gasto);
                System.out.println("Gasto eliminado: " + gasto);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Gasto no encontrado.");
        }
    }

   /**
    * Metodo principal que ejecuta un menu interactivo para gestionar gastos.
    * @param args Argumentos de la linea de comandos
    */
    public static void main(String[] args) {
        GestionGastos gestionGastos = new GestionGastos();
        Scanner scanner = new Scanner(System.in);
while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar gasto");
            System.out.println("2. Mostrar gastos");
            System.out.println("3. Eliminar gasto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); //Salto de linea desùes del numero

             switch (opcion) {
            case 1:
                System.out.print("Ingrese la categoría del gasto: ");
                String categoria = scanner.nextLine();

                double monto = 0;
                boolean montoValido = false;

                // Ciclo para asegurarse de que se ingrese un número válido para el monto
                while (!montoValido) {
                    try {
                        System.out.print("Ingrese el monto del gasto: $");
                        monto = Double.parseDouble(scanner.nextLine());
                        montoValido = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingrese un número válido para el monto.");
                    }
                }

                System.out.print("Ingrese la descripción del gasto: ");
                String descripcion = scanner.nextLine();
                gestionGastos.agregarGasto(categoria, monto, descripcion);
                break;
            case 2:
                gestionGastos.mostrarGastos();
                break;
            case 3:
                System.out.print("Ingrese la descripción del gasto a eliminar: ");
                String descripcionEliminar = scanner.nextLine();
                gestionGastos.eliminarGasto(descripcionEliminar);
                break;
            case 4:
                System.out.println("Saliendo del programa.");
                System.exit(0);
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }
}
}
