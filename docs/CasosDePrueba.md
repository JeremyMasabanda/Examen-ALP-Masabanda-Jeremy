# Casos de prueba — AulaLogic (límite de aprobación = 14)

| Caso | Entrada | Resultado esperado | Resultado obtenido | Estado |
|---|---|---|---|---|
| CP01 | Opción 1: E004, Pedro Soto, 14, 14, 14 | Se registra y aparece en el listado | "Estudiante registrado correctamente." | Aprobado |
| CP02 | Opción 1 con código E001 (ya existe) | Mensaje de código duplicado, no se registra | "Error: el codigo ya existe..." | Aprobado |
| CP03 | Calificaciones 25 y luego "abc" | Se vuelve a pedir la nota | "La calificacion debe estar entre 0 y 20." / "Debe ingresar un numero entero." | Aprobado |
| CP04 | E001 con notas 15, 14, 13 (promedio 14.00) | Estado APROBADO | Promedio 14.00 → APROBADO | Aprobado |
| CP05 | Opción 3: E001 | Muestra código, nombre, notas, promedio, máx., mín. y estado | Ficha completa de Ana Torres | Aprobado |
| CP06 | Opción 3: E999 | Mensaje informativo | "No existe un estudiante con el codigo E999." | Aprobado |
| CP07 | Opción 4 sin estudiantes | Mensaje, sin error ni división entre cero | "No hay estudiantes registrados..." | Aprobado |
| CP08 | Registrar E004, opción 6, reiniciar, opción 2 | E004 sigue en la lista, sin duplicados | `estudiantes.txt` con 4 líneas; se recuperan al iniciar | Aprobado |
