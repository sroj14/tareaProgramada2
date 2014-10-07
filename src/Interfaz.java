import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;                    
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

/**__________________________________________INICIO CLASE INTERFAZ______________________________________________________________*/

public class Interfaz extends JFrame {

/**________________________________________ATRIBUTOS DE LA CLASE INTERFAZ_____________________________________________________*/
    
    /**__________________Etiquetas utilizadas____________________________*/

    private final JLabel titulo = new JLabel("Bienvenido a BAC San Jose");
    private final JLabel cajeros = new JLabel("Cajeros Disponibles");
    private static JLabel imagen = new JLabel();
   
    /**__________________Campos de texto utilizados_____________________*/

    private final JTextField cantidadCajeros = new JTextField(20);
   
    /**___________________Botones utilizados____________________________*/

    private final JButton btHistorial = new JButton("Historial");
    private final JButton btAceptar = new JButton("Aceptar");


/**_____________________________________FIN ATRIBUTOS DE LA CLASE INTERFAZ_____________________________________________________*/
   
/**_____________________________________CONSTRUCTOR DE INTERFAZ________________________________________________________________*/
   
   	public Interfaz (){

/**_____________________________Agregando propiedades de ventana y otros elementos____________________________________________*/	

       setTitle("BAC San Jose");
       setSize(1200,700);
       setLocation(0,0);
       setResizable(true);        
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       btHistorial.setPreferredSize(new Dimension(100,25));
       btAceptar.setPreferredSize(new Dimension(100,25));
       imagen.setPreferredSize(new Dimension(520,320)); 

       titulo.setForeground(Color.RED);
       titulo.setFont(new Font("Arial", Font.BOLD, 15));

       cajeros.setForeground(Color.RED);
       cajeros.setFont(new Font("Arial", Font.BOLD, 15));

       btHistorial.setEnabled(true);
       btAceptar.setEnabled(true);
       titulo.setEnabled(true);
       cajeros.setEnabled(true);
       imagen.setVisible(true);
       cantidadCajeros.setVisible(true); 
       

/**_________________________FIN Agregando propiedades de ventana y otros elementos________________________________________*/



/**______________________________________COLOCANDO LOGO DE INTERFAZ_______________________________________________________*/
  
  ImageIcon iid = new ImageIcon(this.getClass().getResource("/imagenes/logo2.jpg"));

       setIconImage( iid.getImage());  /**establecer imagen como icono*/
      imagen.setIcon(new ImageIcon( iid.getImage()));  


/**____________________________________FIN DE COLOCANDO LOGO DE INTERFAZ__________________________________________________*/



/**_________________________Creando contenedor de elementos en la interfaz________________________________________________*/
      
       Container  contenedor = getContentPane();
       SpringLayout layout =  new SpringLayout();
       contenedor.setLayout(layout); 
   
      
       layout.putConstraint(SpringLayout.WEST, titulo, 10, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, titulo, 7, SpringLayout.NORTH, contenedor);

       layout.putConstraint(SpringLayout.WEST, cajeros, 20, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, cajeros, 47, SpringLayout.NORTH, contenedor);

       layout.putConstraint(SpringLayout.WEST, imagen,970, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, imagen,-72, SpringLayout.NORTH, contenedor);

       layout.putConstraint(SpringLayout.WEST, cantidadCajeros, 20 , SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, cantidadCajeros, 77, SpringLayout.NORTH, contenedor);

       layout.putConstraint(SpringLayout.WEST, btHistorial, 580, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, btHistorial, 556, SpringLayout.NORTH, contenedor);

       layout.putConstraint(SpringLayout.WEST, btAceptar, 380, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, btAceptar, 556, SpringLayout.NORTH, contenedor);



       contenedor.add(titulo);
       contenedor.add(cajeros);
       contenedor.add(imagen);
       contenedor.add(btHistorial);
       contenedor.add(btAceptar);
       contenedor.add(cantidadCajeros);

/**_____________________________________________FIN DE CONTENEDOR__________________________________________________*/

/**_____________________________________________ACCIONES DE LOS ELEMENTOS___________________________________________*/
 	
  /**__________________BOTONES________________________________*/

 	btHistorial.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evento) {  
                         Tabla tabla = new Tabla();      
    }});


 	btAceptar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {  
               
            btHistorial.setVisible(false);
            btAceptar.setVisible(false);
            titulo.setVisible(false);
            cajeros.setVisible(false);
            imagen.setVisible(true);
            cantidadCajeros.setVisible(false);
                 
     }});
/**______________________________________FIN ACCIONES DE LOS ELEMENTOS_______________________________________________*/


}//CIERRA CONSTRUCTOR

/**____________________________________________FIN DE CONSTRUCTOR_____________________________________________________*/

/**_______________________________________________METODO MAIN__________________________________________________________*/

 public static void main(String []args){
        System.out.println (new File (".").getAbsolutePath ());
System.out.println (new File ("/").getAbsolutePath ());
        Interfaz ventana = new Interfaz(); 
        ventana.setVisible(true);

        		
  }
/**_______________________________________________________FIN METODO MAIN______________________________________________________________*/  
 





 }//CIERRA CLASE INTERFA

/**_______________________________________________________CIERRA INTERFAZ______________________________________________________________*/