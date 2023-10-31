/**
 * Estudiante: Joel Antonio Jaquez López
 * Carné: 23369
 * Clase: Programación Orientada a Objetos
 * Ejercicio: Ejercicio 6 de polimorfismo vía interfaces
 * Fecha de inicio: 30/10/2023
 * Fecha de terminación: 31/10/2023
 * 
 * La clase Telefono representa un dispositivo de teléfono en el sistema.
 */
public class Telefono implements DispositivoElectronico {
    private String modelo;     // Modelo del teléfono
    private boolean encendido; // Estado del teléfono (encendido o apagado)

    /**
     * Constructor para la clase Telefono.
     *
     * @param modelo El modelo del teléfono.
     */
    public Telefono(String modelo) {
        this.modelo = modelo;
        this.encendido = false; // Estado inicial: apagado
    }

    /**
     * Obtiene el modelo del teléfono.
     *
     * @return El modelo del teléfono.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del teléfono.
     *
     * @param modelo El nuevo modelo del teléfono.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Enciende el teléfono, cambiando su estado a encendido.
     */
    @Override
    public void encender() {
        this.encendido = true;
    }

    /**
     * Apaga el teléfono, cambiando su estado a apagado.
     */
    @Override
    public void apagar() {
        this.encendido = false;
    }

    /**
     * Verifica si el teléfono está encendido.
     *
     * @return true si el teléfono está encendido, false si está apagado.
     */
    @Override
    public boolean encendido() {
        return this.encendido;
    }

    /**
     * Obtiene información relevante sobre el teléfono, incluyendo su modelo
     * y estado actual.
     *
     * @return Una cadena de texto que contiene la información del teléfono.
     */
    @Override
    public String obtenerInformacion() {
        return "Modelo del teléfono: " + this.modelo + " - Estado: " + (this.encendido ? "Encendido" : "Apagado");
    }
}
