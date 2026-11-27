# Examen-ALP-Masabanda-Jeremy

**Estudiante:** Jeremy Masabanda

**Asignatura:** Algoritmos y Lógica de Programación — UTA / FISEI / Ingeniería de Software

**Variante asignada:** X — promedio mínimo de aprobación: 14

## Descripción del problema
AulaLogic es un sistema por consola que registra estudiantes con tres calificaciones, calcula promedio, nota máxima/mínima y estado académico, genera un reporte del curso y guarda los datos en  `datos/estudiantes.txt`.

## Compilación y ejecución
Desde la carpeta raíz del proyecto (Java 11 o superior):

```bash
mkdir out
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

## Funcionalidades
- Registro con validación (código único, sin vacíos ni `;`, notas 0–20).
- Promedio con decimales, nota máxima/mínima y estado APROBADO/REPROBADO.
- Listado y búsqueda por código.
- Reporte: totales, aprobados/reprobados, promedio general, porcentaje, mayor y menor promedio, estudiantes bajo el promedio y ranking descendente.
- Persistencia con `BufferedWriter`/`BufferedReader`, carga automática al iniciar y guardado al salir.

## Limitaciones
- En empates de máximo/mínimo se muestra el primer estudiante registrado.
- Las líneas inválidas del archivo se omiten con un aviso.
