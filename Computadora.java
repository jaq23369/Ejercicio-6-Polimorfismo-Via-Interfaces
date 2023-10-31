/**
 * Estudiante: Joel Antonio Jaquez López
 * Carné: 23369
 * Clase: Programación Orientada a Objetos
 * Ejercicio: Ejercicio 6 de polimorfismo vía interface
 * Fecha de inicio: 30/10/2023
 * Fecha de terminación: 31/10/2023
 * 
 * La clase Computadora representa un dispositivo de computadora en el sistema.
 */
public class Computadora implements DispositivoElectronico {
    private String marca;     // Marca de la computadora
    private boolean encendido; // Estado de la computadora (encendida o apagada)

    /**
     * Constructor para la clase Computadora.
     *
     * @param marca La marca de la computadora.
     */
    public Computadora(String marca) {
        this.marca = marca;
        this.encendido = false; // Estado inicial: apagada
    }

    /**
     * Obtiene la marca de la computadora.
     *
     * @return La marca de la computadora.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca de la computadora.
     *
     * @param marca La nueva marca de la computadora.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Enciende la computadora, cambiando su estado a encendida.
     */
    @Override
    public void encender() {
        this.encendido = true;
    }

    /**
     * Apaga la computadora, cambiando su estado a apagada.
     */
    @Override
    public void apagar() {
        this.encendido = false;
    }

    /**
     * Verifica si la computadora está encendida.
     *
     * @return true si la computadora está encendida, false si está apagada.
     */
    @Override
    public boolean encendido() {
        return this.encendido;
    }

    /**
     * Obtiene información relevante sobre la computadora, incluyendo su marca
     * y estado actual.
     *
     * @return Una cadena de texto que contiene la información de la computadora.
     */
    @Override
    public String obtenerInformacion() {
        return "Marca de la computadora: " + this.marca + " - Estado: " + (this.encendido ? "Encendida" : "Apagada");
    }
}
