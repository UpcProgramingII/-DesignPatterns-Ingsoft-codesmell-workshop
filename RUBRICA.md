# Rúbrica de evaluación

Puntaje total: **100 puntos**. Cada criterio se asocia a una de las competencias de la actividad.

| Criterio (competencia) | Excelente | Satisfactorio | En desarrollo | Insuficiente |
|---|---|---|---|---|
| **1. Identificación de code smells** (C1) · 25 pts | **25** · Identifica 3 o más smells correctos, con el nombre del catálogo, incluidos los de mayor impacto del caso. | **18** · Identifica 3 smells, pero uno está mal nombrado o confunde dos smells relacionados (p. ej., envidia de características e intimidad inapropiada). | **10** · Identifica 1 o 2 smells correctos. | **0–5** · No identifica smells o describe problemas que no son code smells (estilo, formato). |
| **2. Evidencia** (C2) · 20 pts | **20** · Cada smell tiene archivo, método y líneas, y una evidencia concreta y verificable (número de parámetros, repetición, acceso a datos ajenos, etc.). | **14** · Ubicación correcta, pero la evidencia de algún smell es genérica ("el código es largo"). | **7** · Ubicación incompleta o evidencia que no corresponde al smell nombrado. | **0–3** · Sin evidencia. |
| **3. Consecuencias** (C3) · 15 pts | **15** · Cada consecuencia nombra el atributo de calidad afectado y se conecta con los síntomas reportados o el requerimiento nuevo del caso. | **10** · Nombra atributos de calidad, pero la relación con el contexto del caso es parcial. | **5** · Consecuencias genéricas, sin relación con el caso. | **0–2** · Sin consecuencias. |
| **4. Refactorización y código mejorado** (C4) · 25 pts | **25** · Nombra técnicas de refactorización adecuadas en un orden lógico; el código resuelve los 2 smells de mayor impacto, conserva el comportamiento y no introduce smells nuevos. | **18** · Técnicas adecuadas; el código resuelve los smells pero con omisiones menores o un cambio de comportamiento menor. | **10** · Propuesta correcta en texto, pero el código es incompleto o sólo resuelve un smell. | **0–5** · Sin código, o el código no corresponde a la propuesta. |
| **5. Diagrama de clases mejorado** (C5) · 15 pts | **15** · El diagrama muestra el diseño completo propuesto, con responsabilidades (atributos y métodos clave) y relaciones correctas, y es coherente con el código. | **10** · Diagrama correcto pero incompleto, o con relaciones imprecisas. | **5** · Diagrama que no refleja la refactorización propuesta. | **0–2** · Sin diagrama, o no se visualiza en GitHub. |

## Penalizaciones

| Situación | Efecto |
|---|---|
| Entrega después de cerrado el tiempo (PR abierto tarde) | −10 puntos |
| La verificación automática del PR falla y no se corrige | −5 puntos |
| Contenido copiado de otro equipo | 0 en la actividad para los equipos involucrados |

## Escala de valoración

| Puntaje | Nivel de competencia |
|---|---|
| 90 – 100 | Competencia lograda con nivel sobresaliente |
| 75 – 89 | Competencia lograda |
| 60 – 74 | Competencia en desarrollo |
| 0 – 59 | Competencia no lograda |
