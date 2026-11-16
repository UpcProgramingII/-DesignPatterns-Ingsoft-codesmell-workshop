# Guía rápida: diagramas de clases en Mermaid

GitHub dibuja automáticamente los bloques que empiezan con ` ```mermaid `. Puedes probar tu diagrama en vivo en [mermaid.live](https://mermaid.live).

## Ejemplo completo

```mermaid
classDiagram
    direction LR

    class MedioPago {
        <<interface>>
        +procesar(Pago pago) Resultado
        +comision(Dinero monto) Dinero
    }
    class PagoTarjeta {
        -DatosTarjeta tarjeta
        +procesar(Pago pago) Resultado
        +comision(Dinero monto) Dinero
    }
    class Dinero {
        <<record>>
        -BigDecimal valor
        -String moneda
        +sumar(Dinero otro) Dinero
    }
    class EstadoPago {
        <<enumeration>>
        APROBADO
        RECHAZADO
    }

    MedioPago <|.. PagoTarjeta : implementa
    PagoTarjeta --> Dinero : usa
    PagoTarjeta ..> EstadoPago
```

## Sintaxis esencial

| Elemento | Sintaxis |
|---|---|
| Visibilidad | `+` público · `-` privado · `#` protegido · `~` paquete |
| Atributo | `-String nombre` |
| Método | `+calcular(int x) double` |
| Genéricos | `List~Pedido~` (se usa `~` en lugar de `<>`) |
| Estereotipo | `<<interface>>`, `<<abstract>>`, `<<enumeration>>`, `<<record>>` |
| Herencia | `Padre <\|-- Hija` |
| Implementación | `Interfaz <\|.. Clase` |
| Asociación | `A --> B` (A conoce a B) |
| Composición | `Todo *-- Parte` |
| Agregación | `Todo o-- Parte` |
| Dependencia | `A ..> B` (A usa a B temporalmente) |
| Multiplicidad | `Cliente "1" --> "0..*" Pedido` |
| Etiqueta en relación | `A --> B : usa` |
| Orientación | `direction LR` (izquierda a derecha) o `direction TB` |
