# Actividad práctica: Code smells y deuda técnica

**Curso:** Ingeniería de Software · **Modalidad:** equipos de 2 o 3 estudiantes · **Duración:** 30 minutos · **Lenguaje:** Java 17+

En esta actividad analizarás un componente de software real (simplificado) que ya está en producción y que acumula deuda técnica. Tu tarea es actuar como el equipo de revisión de código: **encontrar los code smells, demostrar con evidencia que existen, explicar qué consecuencias tienen y proponer cómo eliminarlos**, mejorando tanto el código como el diagrama de clases.

---

## Competencias que se evalúan

Al terminar la actividad deberás demostrar que puedes:

| # | Competencia | Cómo se evidencia |
|---|---|---|
| C1 | **Identificar** code smells en código Java orientado a objetos | Nombras correctamente los smells usando el catálogo del curso |
| C2 | **Justificar** cada hallazgo con evidencia objetiva | Indicas archivo, método y líneas, y explicas el síntoma concreto |
| C3 | **Analizar** el impacto de la deuda técnica | Relacionas cada smell con atributos de calidad y con los problemas del contexto |
| C4 | **Aplicar** técnicas de refactorización | Escribes código mejorado que conserva el comportamiento |
| C5 | **Modelar** el diseño resultante | Presentas el diagrama de clases del diseño propuesto |

---

## Los cinco casos

Cada caso es un componente de un sistema distinto. Todos contienen **al menos tres** code smells del catálogo.

| Caso | Sistema | Componente analizado |
|---|---|---|
| [Caso 1](casos/caso-01-matricula/README.md) | Sistema académico universitario | Servicio de matrícula financiera |
| [Caso 2](casos/caso-02-pagos/README.md) | Tienda virtual (e-commerce) | Procesamiento de pagos |
| [Caso 3](casos/caso-03-citas-medicas/README.md) | IPS (servicios de salud) | Agenda de citas médicas |
| [Caso 4](casos/caso-04-domicilios/README.md) | App de domicilios | Asignación de repartidores |
| [Caso 5](casos/caso-05-facturacion/README.md) | Software de facturación electrónica | Generación de facturas |

### Asignación de casos

Cada equipo resuelve **un solo caso**, según su número de equipo:

| Equipo | 1, 6, 11, 16 | 2, 7, 12, 17 | 3, 8, 13, 18 | 4, 9, 14, 19 | 5, 10, 15, 20 |
|---|---|---|---|---|---|
| **Caso** | 1 | 2 | 3 | 4 | 5 |

> El docente puede cambiar esta asignación. Si te sobra tiempo, puedes revisar otro caso, pero sólo se califica el asignado.

---

## Preparación (antes de iniciar el cronómetro)

1. Haz **fork** de este repositorio en tu cuenta de GitHub (un solo integrante por equipo).
2. Agrega a tus compañeros como colaboradores del fork (*Settings → Collaborators*).
3. Crea una rama con el nombre `equipo-NN` (por ejemplo, `equipo-07`).
4. Copia la plantilla en la carpeta de tu equipo:

   ```bash
   mkdir -p soluciones/equipo-07
   cp PLANTILLA_SOLUCION.md soluciones/equipo-07/SOLUCION.md
   ```

Puedes trabajar directamente en el editor web de GitHub (tecla `.` en el repositorio) si no tienes el entorno local listo.

---

## Desarrollo de la actividad (30 minutos)

| Tiempo | Paso | Qué hacer |
|---|---|---|
| 0 – 5 min | **1. Comprender** | Lee el contexto, los *síntomas reportados*, el diagrama y el código de tu caso. |
| 5 – 13 min | **2. Identificar y evidenciar** | Encuentra al menos **3 code smells**. Para cada uno anota archivo, método, líneas y el síntoma que lo delata. |
| 13 – 18 min | **3. Analizar consecuencias** | Explica qué atributo de calidad afecta cada smell y cómo explica los síntomas reportados o dificulta el requerimiento nuevo. |
| 18 – 27 min | **4. Refactorizar** | Nombra las técnicas de refactorización, escribe el **código mejorado** de los 2 smells de mayor impacto y dibuja el **diagrama de clases mejorado** en Mermaid. |
| 27 – 30 min | **5. Entregar** | Revisa la lista de verificación de la plantilla, haz *commit* y abre el *Pull Request*. |

> **Alcance:** no es necesario reescribir todo el componente. El código mejorado debe resolver como mínimo los **dos smells de mayor impacto**. El diagrama, en cambio, debe mostrar el **diseño completo** que propones.

---

## Entrega

1. Completa `soluciones/equipo-NN/SOLUCION.md` siguiendo la [plantilla](PLANTILLA_SOLUCION.md).
2. (Opcional) Si escribes clases Java completas, ubícalas en `soluciones/equipo-NN/src/`.
3. Haz *commit* y *push* de tu rama:

   ```bash
   git add soluciones/equipo-07
   git commit -m "Equipo 07 - Caso 2: análisis de code smells"
   git push origin equipo-07
   ```

4. Abre un **Pull Request** hacia la rama `main` del repositorio del curso con el título `Equipo NN - Caso X`.

Al abrir el PR, una verificación automática (GitHub Actions) revisa que tu archivo tenga todas las secciones, al menos un bloque de código Java y un diagrama Mermaid. **Si la verificación falla, revisa el mensaje y corrige antes de que termine el tiempo.**

La calificación se hace con la [rúbrica](RUBRICA.md).

---

## Material de apoyo permitido

- [Catálogo rápido de code smells](docs/catalogo-smells.md) (definiciones y refactorizaciones típicas).
- [Guía rápida de diagramas de clases en Mermaid](docs/guia-mermaid.md).
- El material de consulta del curso sobre code smells, antipatrones y refactorización.

## Estructura del repositorio

```
.
├── README.md                    ← estás aquí
├── PLANTILLA_SOLUCION.md        ← copia este archivo para tu entrega
├── RUBRICA.md                   ← criterios de evaluación
├── casos/
│   ├── caso-01-matricula/       ← README.md (contexto + diagrama) y src/ (código)
│   ├── caso-02-pagos/
│   ├── caso-03-citas-medicas/
│   ├── caso-04-domicilios/
│   └── caso-05-facturacion/
├── docs/
│   ├── catalogo-smells.md
│   └── guia-mermaid.md
├── soluciones/                  ← aquí va la carpeta de tu equipo
└── .github/                     ← verificación automática y plantilla de PR
```

## Compilar el código de los casos (opcional)

```bash
javac -d out $(find casos -name "*.java")
```
