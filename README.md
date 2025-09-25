# Patrón Decorator - Sistema de Notificaciones

Este repositorio contiene la implementación del patrón Decorator aplicado a un sistema de notificaciones que permite enviar mensajes a través de múltiples canales de forma flexible y combinable.

## 📁 Archivos del Proyecto

### `NotificadorDecorator.java`
Versión original del código con comentarios sutiles y naturales. Ideal para uso en producción o como referencia limpia del patrón.

### `NotificadorDecorator_Educativo.java`
Versión educativa con comentarios detallados y explicaciones paso a paso. Perfecta para estudiar y entender completamente cómo funciona el patrón Decorator.

## 🚀 Cómo Ejecutar

```bash
# Compilar el código
javac NotificadorDecorator.java
# o
javac NotificadorDecorator_Educativo.java

# Ejecutar
java Cliente
```

## 🎯 ¿Qué es el Patrón Decorator?

El patrón Decorator permite agregar funcionalidades a objetos de manera dinámica sin modificar su estructura original. Es como "envolver" un objeto con capas de funcionalidad adicional.

## 🏗️ Estructura del Código

- **`Notificador`** - Interfaz base que define el contrato
- **`NotificadorBase`** - Implementación básica
- **`DecoradorNotificador`** - Clase abstracta decorador
- **Decoradores Concretos:**
  - `NotificadorEmail`
  - `NotificadorSMS`
  - `NotificadorFacebook`
  - `NotificadorSlack`
  - `NotificadorWhatsApp`

## 💡 Ventajas del Patrón

1. **Flexibilidad** - Combina decoradores en cualquier orden
2. **Extensibilidad** - Agregar nuevos canales sin modificar código existente
3. **Reutilización** - Cada decorador es independiente
4. **Principio de Responsabilidad Única** - Cada clase tiene una sola responsabilidad
5. **Principio Abierto/Cerrado** - Abierto para extensión, cerrado para modificación

## 📚 Uso Educativo

Este proyecto es ideal para:
- Estudiar el patrón Decorator
- Entender la composición sobre herencia
- Aprender sobre principios SOLID
- Ver ejemplos prácticos de patrones de diseño

## 🔧 Requisitos

- Java 8 o superior
- Compilador javac
