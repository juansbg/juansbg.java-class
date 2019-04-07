package spaceInvaders.util;

import spaceInvaders.dominio.Usuario;
import java.util.Collection;
import java.util.ArrayList;

public class Constantes {
  public static final int     X_INICIAL                   = 30;   // Posición inicial del primer alien arriba a la izquierda
  public static final int     Y_INICIAL                   = 10;

  public static final int     SEPARACION_LATERAL          = 70;   // Separación entre los aliens
  public static final int     SEPARACION_VERTICAL         = 60;
  public static final boolean ALIENS_BLANCOS              = true;

  public static final int     X_SIZE_VENTANA              = 1200; // Tamaño ventana
  public static final int     Y_SIZE_VENTANA              = 750;

  public static final int     X_SIZE_VENTANA_INICIO       = 600; // Tamaño ventana de inicio
  public static final int     Y_SIZE_VENTANA_INICIO       = 350;

  public static final int     VELOC_PROYEC                = 20;   // Velocidad proyectiles

  public static final int     VELOCIDAD                   = 15;   // Velocidad de nave

  public static final int     NUM_ALIENS                  = 10;   // Num de aliens por fila
  public static final int     VELOCIDAD_ALIENS            = 10;   // Velocidad aliens
  public static int           RATIO_ACTUALIZACION_ALIENS  = 3;

  public static final int     CONTADOR_MOVIMIENTO_INICIAL = (int) ((X_SIZE_VENTANA/2)-150)/VELOCIDAD_ALIENS;
  public static int           CONTADOR_MOVIMIENTO         = CONTADOR_MOVIMIENTO_INICIAL;

  public static final int     CANTIDAD_DISPAROS_ALIENS    = 100;  // Proporción de disparos, debe ser mayor a 50
                                                                  // Cuanto mayor, menos disparos
  public static final int     PUNTOS_ALIEN_UNO            = 20;
  public static final int     PUNTOS_ALIEN_DOS            = 40;
  public static final int     PUNTOS_ALIEN_TRES           = 10;
  public static int           PUNTUACION                  =  0;

  public static int           VIDAS                       =  3;

  public static int           SECUENCIA_MUERTE            =  0;

  public static boolean       READY                       = false;
  public static boolean       PRIMERA_VEZ                 = true;

  public static Usuario       JUGADOR                     = null;
  public static Collection    JUGADORES                   = new ArrayList();

  public static String        JUGADOR_PRIMERO             = null;
  public static String        JUGADOR_SEGUNDO             = null;
  public static String        JUGADOR_TERCERO             = null;
  public static String        JUGADOR_CUARTO              = null;
  public static String        JUGADOR_QUINTO              = null;
}
