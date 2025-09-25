/**
 * PATRÓN DECORATOR - Sistema de Notificaciones
 * 
 * Este ejemplo demuestra el patrón Decorator que permite agregar funcionalidades
 * de manera dinámica a objetos sin modificar su estructura original.
 * 
 * En este caso, tenemos un sistema de notificaciones que puede enviar mensajes
 * a través de múltiples canales (email, SMS, Facebook, Slack, WhatsApp)
 * de forma combinada y flexible.
 */

// ============================================================================
// 1. INTERFAZ PRINCIPAL (Componente Base)
// ============================================================================

/**
 * Interfaz que define el contrato básico para todos los notificadores.
 * Es el "Componente" en el patrón Decorator.
 */
interface Notificador {
    /**
     * Método que debe implementar cualquier notificador para enviar un mensaje.
     * @param mensaje El mensaje que se desea enviar
     */
    void enviar(String mensaje);
}

// ============================================================================
// 2. IMPLEMENTACIÓN CONCRETA (Componente Concreto)
// ============================================================================

/**
 * Implementación básica del notificador.
 * Es el "Componente Concreto" en el patrón Decorator.
 * Proporciona la funcionalidad base de notificación.
 */
class NotificadorBase implements Notificador {
    
    /**
     * Implementación básica del envío de notificaciones.
     * Simplemente imprime el mensaje en consola.
     * @param mensaje El mensaje a notificar
     */
    @Override
    public void enviar(String mensaje) {
        System.out.println("Notificación estándar: " + mensaje);
    }
}

// ============================================================================
// 3. CLASE ABSTRACTA DECORADOR (Decorator Abstracto)
// ============================================================================

/**
 * Clase abstracta que implementa el patrón Decorator.
 * Mantiene una referencia al objeto que está decorando.
 * Es el "Decorator" en el patrón Decorator.
 */
abstract class DecoradorNotificador implements Notificador {
    
    /**
     * Referencia al notificador que está siendo decorado.
     * Puede ser el componente base o otro decorador.
     */
    protected Notificador notificador;

    /**
     * Constructor que recibe el notificador a decorar.
     * @param notificador El notificador que se va a decorar
     */
    public DecoradorNotificador(Notificador notificador) {
        this.notificador = notificador;
    }

    /**
     * Implementación por defecto que delega al notificador decorado.
     * Los decoradores concretos pueden sobrescribir este método.
     * @param mensaje El mensaje a enviar
     */
    @Override
    public void enviar(String mensaje) {
        // Delega la responsabilidad al notificador decorado
        notificador.enviar(mensaje);
    }
}

// ============================================================================
// 4. DECORADORES CONCRETOS (Decoradores Concretos)
// ============================================================================

/**
 * Decorador que agrega funcionalidad de notificación por EMAIL.
 * Extiende DecoradorNotificador para mantener la estructura del patrón.
 */
class NotificadorEmail extends DecoradorNotificador {
    
    /**
     * Constructor que inicializa el decorador con el notificador a decorar.
     * @param notificador El notificador que se va a decorar
     */
    public NotificadorEmail(Notificador notificador) {
        super(notificador);
    }

    /**
     * Sobrescribe el método enviar para agregar funcionalidad de email.
     * Primero ejecuta la cadena de decoradores anterior, luego agrega email.
     * @param mensaje El mensaje a enviar
     */
    @Override
    public void enviar(String mensaje) {
        // 1. Ejecuta toda la cadena de decoradores anterior
        super.enviar(mensaje);
        // 2. Agrega la funcionalidad específica de email
        enviarCorreo(mensaje);
    }

    /**
     * Método privado que simula el envío de correo electrónico.
     * @param mensaje El mensaje a enviar por email
     */
    private void enviarCorreo(String mensaje) {
        System.out.println("Enviando notificación por CORREO: " + mensaje);
    }
}

/**
 * Decorador que agrega funcionalidad de notificación por SMS.
 * Sigue el mismo patrón que NotificadorEmail.
 */
class NotificadorSMS extends DecoradorNotificador {
    
    /**
     * Constructor que inicializa el decorador con el notificador a decorar.
     * @param notificador El notificador que se va a decorar
     */
    public NotificadorSMS(Notificador notificador) {
        super(notificador);
    }

    /**
     * Sobrescribe el método enviar para agregar funcionalidad de SMS.
     * @param mensaje El mensaje a enviar
     */
    @Override
    public void enviar(String mensaje) {
        // Ejecuta la cadena anterior y agrega SMS
        super.enviar(mensaje);
        enviarSMS(mensaje);
    }

    /**
     * Método privado que simula el envío de SMS.
     * @param mensaje El mensaje a enviar por SMS
     */
    private void enviarSMS(String mensaje) {
        System.out.println("Enviando notificación por SMS: " + mensaje);
    }
}

/**
 * Decorador que agrega funcionalidad de notificación por Facebook.
 */
class NotificadorFacebook extends DecoradorNotificador {
    
    public NotificadorFacebook(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        enviarFacebook(mensaje);
    }

    private void enviarFacebook(String mensaje) {
        System.out.println("Enviando notificación por FACEBOOK: " + mensaje);
    }
}

/**
 * Decorador que agrega funcionalidad de notificación por Slack.
 */
class NotificadorSlack extends DecoradorNotificador {
    
    public NotificadorSlack(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        enviarSlack(mensaje);
    }

    private void enviarSlack(String mensaje) {
        System.out.println("Enviando notificación por SLACK: " + mensaje);
    }
}

/**
 * Decorador que agrega funcionalidad de notificación por WhatsApp.
 * Ejemplo de cómo agregar nuevos canales sin modificar código existente.
 */
class NotificadorWhatsApp extends DecoradorNotificador {
    
    public NotificadorWhatsApp(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        // Primero ejecuta toda la cadena de decoradores anterior
        super.enviar(mensaje);
        // Luego agrega el canal de WhatsApp
        enviarWhatsApp(mensaje);
    }

    private void enviarWhatsApp(String mensaje) {
        // Aquí iría la integración real (ej. API de WhatsApp Business/Twilio)
        System.out.println("Enviando notificación por WHATSAPP: " + mensaje);
    }
}

// ============================================================================
// 5. CLIENTE QUE USA EL PATRÓN
// ============================================================================

/**
 * Clase cliente que demuestra cómo usar el patrón Decorator.
 * Aquí se construye la cadena de decoradores y se ejecuta.
 */
class Cliente {
    
    /**
     * Método principal que demuestra el uso del patrón Decorator.
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        
        System.out.println("=== DEMOSTRACIÓN DEL PATRÓN DECORATOR ===\n");
        
        // ================================================================
        // CONSTRUCCIÓN DE LA CADENA DE DECORADORES
        // ================================================================
        
        // 1. Empezamos con el componente base (notificación básica)
        Notificador notificador = new NotificadorBase();
        
        // 2. Envolvemos con decoradores en el orden deseado
        // NOTA: El orden importa - se ejecutan de adentro hacia afuera
        notificador = new NotificadorEmail(notificador);      // Email envuelve la base
        notificador = new NotificadorSMS(notificador);        // SMS envuelve email
        notificador = new NotificadorFacebook(notificador);   // Facebook envuelve SMS
        notificador = new NotificadorSlack(notificador);      // Slack envuelve Facebook
        notificador = new NotificadorWhatsApp(notificador);   // WhatsApp envuelve Slack
        
        // ================================================================
        // EJECUCIÓN DE LA CADENA DE DECORADORES
        // ================================================================
        
        System.out.println("Enviando notificación a través de todos los canales:");
        System.out.println("Orden de ejecución: Base → Email → SMS → Facebook → Slack → WhatsApp\n");
        
        // Al llamar enviar(), se ejecuta toda la cadena de decoradores
        notificador.enviar("¡Alerta de seguridad!");
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
        
        // ================================================================
        // VENTAJAS DEL PATRÓN DECORATOR
        // ================================================================
        
        System.out.println("\nVENTAJAS DEL PATRÓN DECORATOR:");
        System.out.println("1. Flexibilidad: Puedes combinar decoradores en cualquier orden");
        System.out.println("2. Extensibilidad: Agregar nuevos canales sin modificar código existente");
        System.out.println("3. Reutilización: Cada decorador es independiente y reutilizable");
        System.out.println("4. Principio de Responsabilidad Única: Cada decorador tiene una sola responsabilidad");
        System.out.println("5. Principio Abierto/Cerrado: Abierto para extensión, cerrado para modificación");
    }
}
