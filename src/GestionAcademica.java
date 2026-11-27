import java.util.ArrayList;

public class GestionAcademica {
    private ArrayList<Estudiante> estudiantes;

    public GestionAcademica() {
        estudiantes = new ArrayList<Estudiante>();
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> lista) {
        estudiantes = lista;
    }

    // Devuelve el estudiante con ese codigo, o null si no existe
    public Estudiante buscarPorCodigo(String codigo) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                return estudiantes.get(i);
            }
        }
        return null;
    }

    public boolean existeCodigo(String codigo) {
        return buscarPorCodigo(codigo) != null;
    }

    public void registrar(Estudiante e) {
        estudiantes.add(e);
    }

    public void listar() {
        if (estudiantes.size() == 0) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            for (int i = 0; i < estudiantes.size(); i++) {
                System.out.println(estudiantes.get(i));
            }
        }
    }

    public void mostrarDetalle(Estudiante e) {
        int[] n = e.getNotas();
        System.out.println("Codigo: " + e.getCodigo());
        System.out.println("Nombre: " + e.getNombre());
        System.out.println("Calificaciones: " + n[0] + ", " + n[1] + ", " + n[2]);
        System.out.println("Promedio: " + String.format("%.2f", e.calcularPromedio()));
        System.out.println("Nota maxima: " + e.obtenerNotaMaxima());
        System.out.println("Nota minima: " + e.obtenerNotaMinima());
        System.out.println("Estado: " + e.obtenerEstado());
    }

    public double calcularPromedioGeneral() {
        if (estudiantes.size() == 0) {
            return 0;
        }
        double suma = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            suma = suma + estudiantes.get(i).calcularPromedio();
        }
        return suma / estudiantes.size();
    }

    public int contarAprobados() {
        int contador = 0;
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).obtenerEstado().equals("APROBADO")) {
                contador++;
            }
        }
        return contador;
    }

    // Ordena de mayor a menor promedio (burbuja) en una copia de la lista
    public ArrayList<Estudiante> ordenarPorPromedio() {
        ArrayList<Estudiante> copia = new ArrayList<Estudiante>(estudiantes);
        for (int i = 0; i < copia.size() - 1; i++) {
            for (int j = 0; j < copia.size() - 1 - i; j++) {
                if (copia.get(j).calcularPromedio() < copia.get(j + 1).calcularPromedio()) {
                    Estudiante auxiliar = copia.get(j);
                    copia.set(j, copia.get(j + 1));
                    copia.set(j + 1, auxiliar);
                }
            }
        }
        return copia;
    }

    public void generarReporte() {
        if (estudiantes.size() == 0) {
            System.out.println("No hay estudiantes registrados. No se puede generar el reporte.");
            return;
        }

        int total = estudiantes.size();
        int aprobados = contarAprobados();
        int reprobados = total - aprobados;
        double promedioGeneral = calcularPromedioGeneral();
        double porcentaje = aprobados * 100.0 / total;

        // Busca el promedio mas alto y el mas bajo
        Estudiante mayor = estudiantes.get(0);
        Estudiante menor = estudiantes.get(0);
        for (int i = 1; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).calcularPromedio() > mayor.calcularPromedio()) {
                mayor = estudiantes.get(i);
            }
            if (estudiantes.get(i).calcularPromedio() < menor.calcularPromedio()) {
                menor = estudiantes.get(i);
            }
        }

        System.out.println("===== REPORTE ACADEMICO =====");
        System.out.println("Total de estudiantes: " + total);
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Reprobados: " + reprobados);
        System.out.println("Promedio general: " + String.format("%.2f", promedioGeneral));
        System.out.println("Porcentaje de aprobados: " + String.format("%.2f", porcentaje) + "%");
        System.out.println("Promedio mas alto: " + mayor.getNombre() + " (" + String.format("%.2f", mayor.calcularPromedio()) + ")");
        System.out.println("Promedio mas bajo: " + menor.getNombre() + " (" + String.format("%.2f", menor.calcularPromedio()) + ")");

        System.out.println("--- Promedio inferior al general ---");
        boolean hay = false;
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).calcularPromedio() < promedioGeneral) {
                System.out.println(estudiantes.get(i).getNombre() + " - " + String.format("%.2f", estudiantes.get(i).calcularPromedio()));
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("Ninguno.");
        }

        System.out.println("--- Ordenados de mayor a menor promedio ---");
        ArrayList<Estudiante> ordenados = ordenarPorPromedio();
        for (int i = 0; i < ordenados.size(); i++) {
            System.out.println((i + 1) + ". " + ordenados.get(i).getNombre() + " - " + String.format("%.2f", ordenados.get(i).calcularPromedio()));
        }
    }
}
