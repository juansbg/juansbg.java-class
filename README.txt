README Space Invaders 2019 v1.0

ARCHIVOS DE LA PRÁCTICA
-------------------------------------------------------------------------------
Todo el contenido a entregar se encuentra en los archivos ZIP con los nombres
correspondientes a los necesarios para la entrega. Las demás carpetas del github
tienen el siguiente contenido:
  - DISTRIBUCIÓN:   Ésta carpeta contiene el producto final, el jar y los
                    archivos de guardado, así como el leaderboard en HTML.
  - DOCUMENTACIÓN:  Ésta carpeta contiene el javadoc generado de todos los
                    archivos java. En información adicional se encuentran las
                    clases documentadas de manera extensa, con descripciones en
                    métodos y atributos.
  - spaceInvaders:  Ésta carpeta contiene la totalidad de los archivos .java y
                    .class. Contiene la totalidad del proyecto, dividido en
                    paquetes, y con los recursos gráficos creados para el juego.

INSTRUCCIONES
-------------------------------------------------------------------------------
Al iniciar el juego la primera vez, simplemente debemos introducir un nombre de
jugador y presionar enter o darle al botón 'start'. A partir de este punto
estaremos jugando al juego, nuestra puntuación aparecerá arriba a la izquierda
en azul. En verde aparecerá la puntuación HI-SCORE guardada en memoria.
El usuario controlará la nave en la parte inferior de la pantalla e intentará
disparar a los alienígenas antes de que le maten a el. La nave puede sufrir 3
impactos de proyectiles, nuestras vidas restantes aparecerán en la esquina
superior derecha.
Si se desea borrar las puntuaciones guardadas bastará con eliminar el archivo de
nombre 'usuarios.spa' contenido en la carpeta 'datos', o renombrarlo para
guardarlas.

CONTROLES
-------------------------------------------------------------------------------
- Flecha derecha    --> Movimiento a derecha
- Flecha izquierda  --> Movimiento a izquierda
- Espacio           --> Disparar

LEADERBOARD
-------------------------------------------------------------------------------
La carpeta leaderboard contiene en versión txt y HTML una lista actualizada de
los 60 mejores jugadores guardados en memoria. Esta lista se actualiza al
finalizar cada partida.

INFORMACIÓN ADICIONAL
-------------------------------------------------------------------------------
Clases documentadas al completo con Javadoc:  spaceInvaders.dominio.ObjetoJuego
                                              spaceInvaders.dominio.Volador

KNOWN BUGS
-------------------------------------------------------------------------------
En algunos sistemas Windows, el botón RESTART no consigue reiniciar el juego
sino solo cerrarlo. Sistemas macOS y Linux no tienen este problema. Una posible
solución es ejecutar el jar desde el terminal.
La resolución de algunas pantallas de menor tamaño pueden resultar en la nave
desapareciendo de la pantalla y como resultado siendo invencible.
