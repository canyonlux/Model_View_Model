package com.example.calculadorahipoteca;

public class SimuladorHipoteca {

    // Constantes para las restricciones
    private static final int PLAZO_MINIMO = 5; // Años
    private static final int PLAZO_MAXIMO = 30; // Años

    public static class Solicitud {
        public double capital;
        public int plazo;

        public Solicitud(double capital, int plazo) {
            this.capital = capital;
            this.plazo = plazo;
        }
    }

    interface Callback {
        void cuandoEsteCalculadaLaCuota(double cuota);
        // (i) Los dos metodos de error se pueden simplificar en uno:
        // void cuandoHayaError(Error error);
        void cuandoHayaErrorDeCapitalInferiorAlMinimo(double capitalMinimo);
        void cuandoHayaErrorDePlazoInferiorAlMinimo(int plazoMinimo);
        void cuandoEmpieceElCalculo();
        void cuandoFinaliceElCalculo();
    }

    public void calcular(Solicitud solicitud, Callback callback) {

        callback.cuandoEmpieceElCalculo();

        double interes = 0.01605; // Podría ser un valor dinámico en un caso real.

        try {
            // Simulamos una operación de larga duración.
            Thread.sleep(2500);

            // Validamos los datos de entrada.
            validarDatos(solicitud.capital, solicitud.plazo, interes);

            // Realizamos el cálculo si todo es válido.
            double cuota = solicitud.capital * interes / 12 / (1 - Math.pow(1 + (interes / 12), -solicitud.plazo * 12));
            callback.cuandoEsteCalculadaLaCuota(cuota);

        } catch (InterruptedException e) {
            // Manejar interrupción.
        } catch (IllegalArgumentException e) {
            // Aquí debemos determinar qué tipo de error es para llamar al callback correcto.
            // Por ejemplo:
            if (e.getMessage().contains("El capital debe ser mayor que 0")) {
                callback.cuandoHayaErrorDeCapitalInferiorAlMinimo(0); // Asumiendo que queremos notificar 0 como capital mínimo.
            } else if (e.getMessage().contains("El plazo debe estar entre")) {
                callback.cuandoHayaErrorDePlazoInferiorAlMinimo(PLAZO_MINIMO); // Asumiendo que el error es por el plazo mínimo.
            }
            // Otras validaciones de errores aquí.
        } finally {
            callback.cuandoFinaliceElCalculo();
        }
    }


    // ---------------Método nuevo para validar los datos de entrada-------------------
    public void validarDatos(double capital, int plazo, double tasaInteres) throws IllegalArgumentException {
        if (capital <= 0) {
            throw new IllegalArgumentException("El capital debe ser mayor que 0.");
        }
        if (plazo < PLAZO_MINIMO || plazo > PLAZO_MAXIMO) {
            throw new IllegalArgumentException("El plazo debe estar entre " + PLAZO_MINIMO + " y " + PLAZO_MAXIMO + " años.");
        }
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
        }
    }
}