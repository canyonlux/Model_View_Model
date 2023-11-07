# Model_View_Model
Calculadora de Hipotecas

Este proyecto es una aplicación Android que permite a los usuarios calcular la cuota mensual de una hipoteca basada en el capital solicitado y el plazo para la devolución del préstamo.
Funciones

    Cálculo de la Cuota Hipotecaria: Los usuarios pueden introducir el capital y el plazo (en años) para calcular la cuota mensual de su hipoteca.

    Validación de Entrada: La aplicación ahora incluye una validación de los datos ingresados por el usuario, asegurándose de que el capital es mayor a cero, el plazo está dentro de un rango establecido (mínimo 5 años y máximo 30 años), y que la tasa de interés no sea negativa.

    Manejo de Errores: Si el usuario introduce valores no válidos, se muestran mensajes de error específicos para guiarle hacia una entrada correcta.

Nueva Funcionalidad Añadida

Hemos implementado un nuevo método de validación de datos de entrada antes de realizar el cálculo de la hipoteca. Esto asegura que los cálculos solo se realicen con datos que cumplan con ciertos criterios:

    El capital debe ser mayor que cero.
    El plazo debe ser de al menos 5 años y no más de 30 años.
    La tasa de interés no puede ser negativa.

Cuando los datos no cumplen con estos criterios, la aplicación notifica al usuario mediante mensajes de error, los cuales se presentan a través de la interfaz de usuario para que puedan ser corregidos.
Tecnología

El proyecto está construido con:

    Android SDK
    Java
    Android Lifecycle Components

Instalación

Para correr el proyecto:

    Clonar el repositorio en tu máquina local.
    Abrir el proyecto con Android Studio.
    Ejecutar el proyecto en un emulador de Android o dispositivo físico.

Contribuciones

Las contribuciones son bienvenidas. Por favor, siente libre de forkear y enviar pull requests o abrir issues para sugerencias y mejoras.
