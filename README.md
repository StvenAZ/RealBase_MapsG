# Monitoreo en Tiempo Real con Real TimeDatabase
## Descripción
Este proyecto es una aplicación móvil desarrollada en Android que permite realizar el monitoreo de coordenadas GPS en tiempo real utilizando Firebase Real Time Database. A medida que el usuario mueve su dispositivo móvil, las coordenadas (latitud y longitud) se actualizan dinámicamente en la base de datos y se reflejan en un marcador dentro de Google Maps.

## Funcionalidades

1. **Actualización en Tiempo Real**
   - Las coordenadas GPS del dispositivo se sincronizan automáticamente con Firebase Real Time Database.
   - El marcador en Google Maps se actualiza según las nuevas coordenadas.

2. **Integración con Google Maps**
   - Implementación de `SupportMapFragment` para la visualización del mapa en la aplicación.
   - Marcador dinámico que muestra la posición actualizada en el mapa.

3. **Interfaz de Usuario (UI)**
   - Diseño simple y funcional para mostrar la latitud y longitud actuales.
   - Elementos visuales configurados mediante `LinearLayout` para mantener la estructura organizada.


## Capturas de Pantalla y Explicación

### 1. Pantalla Principal
![image](https://github.com/user-attachments/assets/ac0c0002-e45c-42ed-965c-580f547a5ad3)
- **Descripción:** Ubicación inicial del marcador

  
![image](https://github.com/user-attachments/assets/7e105305-a085-4763-859d-82d782c36b29)
- **Descripción:** Coordenadas correspondiente al mapa


### 2. Actualización del Marcador en base al desplazamiento 
![image](https://github.com/user-attachments/assets/ab665584-2aa7-4b0c-a7ab-ff98041a9251)
- **Descripción: **Nueva ubicación

  
![image](https://github.com/user-attachments/assets/dc6b87ca-1f13-49c5-9309-393cf9f05053)
- **Descripción: **Coordenada actualizada


- **Descripción:** Los datos recibidos en Firebase se actualizan en tiempo real según el desplazamiento del marcador de GoogleMaps.

