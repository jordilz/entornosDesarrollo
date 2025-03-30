package practica2;
import java.util.Scanner;

/**
 * Clase Notas para gestionar las calificaciones de un estudiante.
 * Permite ingresar, validar, calcular y mostrar las notas finales.
 *  
 * @author jordi
 * @version 1.0
 */
public class Notas {
    /** Nota de la unidad formativa 1 */
    private double uf1;
    /** Nota de la unidad formativa 2 */
    private double uf2;
    /** Nota de la unidad formativa 3 */
    private double uf3;
    /** Acumulado de la nota 1 */
    private double acu1;
    /** Acumulado de la nota 2 */
    private double acu2;
    /** Acumulado de la nota 3 */
    private double acu3;
    /** Nota definitiva */
    private double def;
    /** Objeto Scanner para la entrada de datos */
    private Scanner entrada;

    /**
     * Constructor que inicializa el Scanner.
     */
    public Notas() {
        entrada = new Scanner(System.in);
    }

    /**
     * Solicita al usuario que ingrese las notas y las valida.
     */
    public void ingresarNotas() {
        System.out.println("Ingrese las notas del estudiante (entre 0 y 10)");

        do {
            System.out.print("Ingrese nota 1: ");
            uf1 = entrada.nextDouble();
        } while (!validarNota(uf1));

        do {
            System.out.print("Ingrese nota 2: ");
            uf2 = entrada.nextDouble();
        } while (!validarNota(uf2));

        do {
            System.out.print("Ingrese nota 3: ");
            uf3 = entrada.nextDouble();
        } while (!validarNota(uf3));
    }

    /**
     * Valida que una nota esté en el rango de 0 a 10.
     * 
     * @param nota La nota a validar.
     * @return true si la nota es válida, false en caso contrario.
     */
    private boolean validarNota(double nota) {
        if (nota < 0 || nota > 10) {
            System.out.println("Error: la nota debe estar entre 0 y 10.");
            return false;
        }
        return true;
    }

    /**
     * Calcula la nota definitiva basándose en los acumulados.
     */
    public void calcularNotas() {
        acu1 = uf1 * 0.35;
        acu2 = uf2 * 0.35;
        acu3 = uf3 * 0.30;
        def = acu1 + acu2 + acu3;
    }

    /**
     * Muestra en pantalla las notas ingresadas y el resultado final.
     */
    public void mostrarResultados() {
        System.out.println("\nNotas ingresadas:");
        System.out.println("Nota 1 = " + uf1);
        System.out.println("Nota 2 = " + uf2);
        System.out.println("Nota 3 = " + uf3);

        System.out.println("\nAcumulado:");
        System.out.println("Acumulado 1 = " + acu1);
        System.out.println("Acumulado 2 = " + acu2);
        System.out.println("Acumulado 3 = " + acu3);

        System.out.println("\nNota definitiva: " + def);
    }

    /**
     * Verifica si el estudiante aprobó o reprobó.
     */
    public void verificarAprobacion() {
        if (def >= 5) {
            System.out.println("¡Aprobado!");
        } else {
            System.out.println("Suspendió.");
        }
    }

    /**
     * Método principal que ejecuta el flujo del programa.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Notas fc = new Notas();

        fc.ingresarNotas();
        fc.calcularNotas();
        fc.mostrarResultados();
        fc.verificarAprobacion();

        // Cerrar el Scanner
        fc.cerrarScanner();
    }

    /**
     * Cierra el objeto Scanner para liberar recursos.
     */
    public void cerrarScanner() {
        entrada.close();
    }
}
