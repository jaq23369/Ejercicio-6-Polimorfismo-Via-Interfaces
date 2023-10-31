/**
 * Estudiante: Joel Antonio Jaquez López
 * Carné: 23369
 * Clase: Programación Orientada a Objetos
 * Ejercicio: Ejercicio 6 de polimorfismo vía interfaces
 * Fecha de inicio: 30/10/2023
 * Fecha de terminación: 31/10/2023
 * 
 * La interfaz DispositivoElectronico define el contrato de comportamiento
 * que deben seguir todos los dispositivos electrónicos en el sistema.
 */
public interface DispositivoElectronico {

    /**
     * Enciende el dispositivo.
     */
    void encender();

    /**
     * Apaga el dispositivo.
     */
    void apagar();

    /**
     * Verifica si el dispositivo está encendido.
     *
     * @return true si el dispositivo está encendido, false si está apagado.
     */
    boolean encendido();

    /**
     * Obtiene información relevante sobre el dispositivo, como su modelo,
     * marca, estado, etc.
     *
     * @return Una cadena de texto que contiene la información del dispositivo.
     */
    String obtenerInformacion();
}

