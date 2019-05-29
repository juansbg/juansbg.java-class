package spaceInvaders.dominio;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.net.URL;
/**Clase dedicada a todos los objetos existentes dentro del juego, que tendran una posicion (x e y),
 *y tendran tres imagenes, ya que la mayoria de objetos necesitaran ir cambiando de sprite.
 */
public abstract class ObjetoJuego {
  /**Variable estatica para conseguir la imagen 1 desde cualquier parte del programa,
  * por ejemplo: getImagen(ObjetoJuego.IM1)*/
  public static int IM1 = 0;
  /**Variable estatica para conseguir la imagen 2 desde cualquier parte del programa,
  * por ejemplo: getImagen(ObjetoJuego.IM2)*/
  public static int IM2 = 1;
  /**Variable estatica para conseguir la imagen 3 desde cualquier parte del programa,
  * por ejemplo: getImagen(ObjetoJuego.IM3)*/
  public static int IM3 = 2;
  /**Coordenada x de posicion del objeto.*/
  private int x;
  /**Coordenada y de posicion del objeto.*/
  private int y;
  /**Altura de las imagenes del objeto*/
  private int altura;
  /**Ancho de las imagenes del objeto*/
  private int ancho;
  /**Imagen 1 del objeto*/
  private Image imagen1;
  /**Imagen 2 del objeto*/
  private Image imagen2;
  /**Imagen 3 del objeto*/
  private Image imagen3;
  /**Variable indicadora de la visibilidad del objeto*/
  private boolean visible;
  /**Contructor por excelencia que sera heredado por todos los objetos del juego.
    *@param dirImagen1 Sera un String con el path de la Primera imagen del objeto.
    *@param dirImagen2 Sera un String con el path de la Segunda imagen del objeto.
    *@param dirImagen3 Sera un String con el path de la Tercera imagen del objeto.
  */
  public ObjetoJuego(String dirImagen1, String dirImagen2, String dirImagen3){
    this.importarImagenes(dirImagen1,dirImagen2,dirImagen3);
    this.setVisible(true);
    // Color HEX Recursos: 3ffc4a
  }
  /**Utilizado para conseguir la posicion x del objeto dentro del marco del juego.
  *@return Posicion x dentro del canvas.
  */
  public int getX(){
    return x;
  }
  /**Utilizado para conseguir la posicion y del objeto dentro del marco del juego.
  *@return Posicion y dentro del canvas.
  */
  public int getY(){
    return y;
  }
  /**Utilizado para conseguir el tamaño vertical de la imagen utilizada.
  *@return La altura de la imagen.
  */
  public int getAltura(){
    return altura;
  }
  /**Utilizado para conseguir el tamaño horizontal de la imagen utilizada.
  *@return El ancho de la imagen.
  */
  public int getAncho(){
    return ancho;
  }
  /**Informara del estado de la visibilidad del objeto.
  *@return Booleana que sera True si es visible y False al contrario.
  */
  public boolean isVisible(){
    return visible;
  }
  /**Modificar la posicion lateral del objeto.
  *@param i La nueva posicion x del objeto
  */
  public void setX(int i){
    this.x = i;
  }
  /**Modificar la posicion vertical del objeto.
  *@param i La nueva posicion y del objeto
  */
  public void setY(int i){
    this.y = i;
  }
  /**Modificar la visibilidad del objeto.
  *@param v La nueva visibilidad del objeto
  */
  public void setVisible(boolean v){
    this.visible = v;
  }
  /**Modificar las imagenes del objeto.
  *@param dirImagen1 Sera un String con el path de la Primera imagen del objeto.
  *@param dirImagen2 Sera un String con el path de la Segunda imagen del objeto.
  *@param dirImagen3 Sera un String con el path de la Tercera imagen del objeto.
  */
  public void importarImagenes(String dirImagen1, String dirImagen2, String dirImagen3){
    ImageIcon ic1 = new ImageIcon(dirImagen1);
    ImageIcon ic2 = new ImageIcon(dirImagen2);
    ImageIcon ic3 = new ImageIcon(dirImagen3);
    imagen1 = ic1.getImage();
    imagen2 = ic2.getImage();
    imagen3 = ic3.getImage();
    ancho = (int) imagen1.getWidth(null);
    altura = (int) imagen1.getHeight(null);
  }
  /**Conseguir la imagen numero n del objeto, este metodo es utilizado por el canvas para pintarlo.
  *@param im Numero 1, 2, o 3 dependiendo de a cual de las imagenes se quiere acceder.
  *@return La imagen deseada.
  */
  public Image getImagen(int im){
    Image imagen = null;      // Mirar
    if(im == IM1) {
      imagen = this.imagen1;
    }else if(im == IM2) {
      imagen = this.imagen2;
    }else if(im == IM3) {
      imagen = this.imagen3;
    }
    return imagen;
  }
  /**Cambiar la imagen numero n del objeto, utilizado por el canvas para pintarlo.
  *@param im Numero 1, 2, o 3 dependiendo de a cual de las imagenes se quiere acceder.
  *@param imagen La nueva imagen que queremos poner.
  */
  public void setImagen(int im, Image imagen){
    if(im==1){
      this.imagen1 = imagen;
    } else if(im==2){
      this.imagen2 = imagen;
    } else if(im==3){
      this.imagen3 = imagen;
    }
  }
}
