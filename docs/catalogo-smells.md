# Catálogo rápido de code smells

Usa estos nombres en tu solución. Cada entrada indica cómo reconocer el smell y qué refactorizaciones lo resuelven habitualmente.

| Code smell | Cómo reconocerlo | Refactorizaciones típicas |
|---|---|---|
| **Datos expuestos (falta de encapsulamiento)** | Campos públicos o con visibilidad de paquete; getters que devuelven colecciones mutables; otras clases cambian el estado directamente. | *Encapsulate Field*, *Encapsulate Collection*, *Remove Setting Method* |
| **Método largo** | Un método hace varias cosas; tiene comentarios que separan "secciones"; mezcla niveles de abstracción. | *Extract Method*, *Decompose Conditional*, *Replace Temp with Query* |
| **Clase larga** | Muchos campos y métodos; nombres genéricos (`Manager`, `Util`); grupos de métodos que no comparten datos. | *Extract Class*, *Extract Subclass* |
| **Lista larga de parámetros** | Métodos con 4 o más parámetros, a menudo del mismo tipo, o que reciben `null` según el caso. | *Introduce Parameter Object*, *Preserve Whole Object* |
| **Envidia de características** | Un método usa más los datos de otra clase que los de la suya (muchos `otro.getX()`). | *Move Method*, *Extract Method* + *Move Method* |
| **Intimidad inapropiada** | Dos clases manipulan mutuamente sus detalles internos; dependencias en ambos sentidos. | *Move Method/Field*, *Change Bidirectional Association to Unidirectional*, *Extract Class* |
| **Grupo de datos (data clump)** | Los mismos 2–4 datos viajan siempre juntos (fecha inicio/fin, monto/moneda, datos de tarjeta). | *Introduce Parameter Object*, *Extract Class* |
| **Obsesión por primitivos** | `String`, `int` o `double` representan conceptos del dominio: dinero en `double`, estados en `String`, registros armados con texto. | *Replace Primitive with Object*, *Replace Type Code with Enum/Class* |
| **Switch repetido** | El mismo `switch` o cadena de `if` sobre un "tipo" aparece en varios lugares. | *Replace Conditional with Polymorphism*, *Replace Type Code with Subclasses / Strategy* |
| **Cirugía escopeta** | Un único cambio funcional obliga a modificar muchas clases o métodos. | *Move Method*, *Move Field*, *Combine Functions into Class* |
| **Clase divergente** | Una clase cambia por razones distintas (impuestos, base de datos, formato del PDF…). | *Extract Class*, *Split Phase* |
| **Modelo anémico** | Las entidades sólo tienen getters/setters; las reglas de negocio viven en servicios. | *Move Method* hacia la entidad, *Remove Setting Method*, introducir *Value Objects* |
| **Comentarios desodorante** | Comentarios que explican **qué** hace el código porque el código no se entiende; comentarios desactualizados. | *Extract Method*, *Rename*, *Extract Variable*, *Replace Magic Number with Constant* |

## Atributos de calidad internos

| Atributo | Pregunta clave |
|---|---|
| **Mantenibilidad** | ¿Qué tan fácil es entender, corregir y modificar el código? |
| **Extensibilidad** | ¿Puedo agregar comportamiento nuevo sin modificar el existente? |
| **Reusabilidad** | ¿Puedo usar este componente en otro contexto? |
| **Testeabilidad** | ¿Puedo probar esta unidad de forma aislada? |
