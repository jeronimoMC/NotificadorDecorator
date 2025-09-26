/**
 * Sistema de Notificaciones usando el patrón Decorator
 * Permite combinar múltiples canales de notificación de forma flexible
 */

// Interfaz base que define el contrato para todos los notificadores
interface Notificador {
    void enviar(String mensaje);
}

// Implementación básica del notificador
class NotificadorBase implements Notificador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Notificación estándar: " + mensaje);
    }
}

// Clase abstracta que implementa el patrón Decorator
abstract class DecoradorNotificador implements Notificador {
    protected Notificador notificador; // Referencia al notificador que está siendo decorado

    public DecoradorNotificador(Notificador notificador) {
        this.notificador = notificador;
    }

    @Override
    public void enviar(String mensaje) {
        notificador.enviar(mensaje); // Delega al notificador decorado
    }
}

// Decorador que agrega funcionalidad de notificación por email
class NotificadorEmail extends DecoradorNotificador {
    public NotificadorEmail(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje); // Ejecuta la cadena anterior
        enviarCorreo(mensaje); // Agrega funcionalidad de email
    }

    private void enviarCorreo(String mensaje) {
        System.out.println("Enviando notificación por CORREO: " + mensaje);
    }
}

// Decorador que agrega funcionalidad de notificación por SMS
class NotificadorSMS extends DecoradorNotificador {
    public NotificadorSMS(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje); // Ejecuta la cadena anterior
        enviarSMS(mensaje); // Agrega funcionalidad de SMS
    }

    private void enviarSMS(String mensaje) {
        System.out.println("Enviando notificación por SMS: " + mensaje);
    }
}

// Decorador que agrega funcionalidad de notificación por Facebook
class NotificadorFacebook extends DecoradorNotificador {
    public NotificadorFacebook(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje); // Ejecuta la cadena anterior
        enviarFacebook(mensaje); // Agrega funcionalidad de Facebook
    }

    private void enviarFacebook(String mensaje) {
        System.out.println("Enviando notificación por FACEBOOK: " + mensaje);
    }
}

// Decorador que agrega funcionalidad de notificación por Slack
class NotificadorSlack extends DecoradorNotificador {
    public NotificadorSlack(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje); // Ejecuta la cadena anterior
        enviarSlack(mensaje); // Agrega funcionalidad de Slack
    }

    private void enviarSlack(String mensaje) {
        System.out.println("Enviando notificación por SLACK: " + mensaje);
    }
}

// Decorador que agrega funcionalidad de notificación por WhatsApp
class NotificadorWhatsApp extends DecoradorNotificador {
    public NotificadorWhatsApp(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje); // Ejecuta la cadena anterior
        enviarWhatsApp(mensaje); // Agrega funcionalidad de WhatsApp
    }

    private void enviarWhatsApp(String mensaje) {
        System.out.println("Enviando notificación por WHATSAPP: " + mensaje);
    }
}

// Clase cliente que demuestra el uso del patrón Decorator
class Cliente {
    public static void main(String[] args) {
        // Construcción de la cadena de decoradores
        Notificador notificador = new NotificadorBase();
        notificador = new NotificadorEmail(notificador);      // Agrega email
        notificador = new NotificadorSMS(notificador);        // Agrega SMS
        notificador = new NotificadorFacebook(notificador);   // Agrega Facebook
        notificador = new NotificadorSlack(notificador);      // Agrega Slack
        notificador = new NotificadorWhatsApp(notificador);    // Agrega WhatsApp

        // Al enviar, se ejecuta toda la cadena de decoradores
        notificador.enviar("¡Alerta de seguridad!");
    }
}