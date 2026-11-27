public class Estudiante {
    // Limite de aprobacion segun la variante (A=11, B=12, C=13, D=14, E=15, F=16, G=17, H=18)
    public static final int LIMITE_APROBACION = 14;

    private String codigo;
    private String nombre;
    private int[] notas;

    public Estudiante(String codigo, String nombre, int[] notas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getNotas() {
        return notas;
    }

    // Suma las notas y divide para 3.0 (decimal), asi no hay division entera
    public double calcularPromedio() {
        int suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma = suma + notas[i];
        }
        return suma / 3.0;
    }

    public int obtenerNotaMaxima() {
        int max = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > max) {
                max = notas[i];
            }
        }
        return max;
    }

    public int obtenerNotaMinima() {
        int min = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < min) {
                min = notas[i];
            }
        }
        return min;
    }

    // Si el promedio es mayor o igual al limite, aprueba
    public String obtenerEstado() {
        if (calcularPromedio() >= LIMITE_APROBACION) {
            return "APROBADO";
        } else {
            return "REPROBADO";
        }
    }

    public String toString() {
        String prom = String.format("%.2f", calcularPromedio());
        return codigo + " | " + nombre + " | Notas: " + notas[0] + ", " + notas[1] + ", " + notas[2]
                + " | Promedio: " + prom + " | " + obtenerEstado();
    }
}
