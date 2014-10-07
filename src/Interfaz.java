
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;                    
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JComboBox;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;
/**__________________________________________INICIO CLASE INTERFAZ______________________________________________________________*/


public class Interfaz extends JFrame {

/**________________________________________ATRIBUTOS DE LA CLASE INTERFAZ_____________________________________________________*/
    

    /**__________________Etiquetas utilizadas____________________________*/

    private final JLabel titulo = new JLabel("Bienvenido a BAC San Jose");
    private final JLabel cajeros = new JLabel("Cajeros Disponibles");
    private static JLabel imagen = new JLabel();
    private final JLabel agregarUsuario = new JLabel("Ingrese los Datos del usuario");
    private final JLabel nombreUsuario = new JLabel("Ingrese el nombre: ");
    private final JLabel correoUsuario = new JLabel("Ingrese el correo: ");
    private final JLabel tipoUsuario = new JLabel("Tipo de usuario: ");
    private final JLabel cajerosDisponibles = new JLabel("Cajas Disponibles para clientes:");
    private final JLabel cajerosAtendiento = new JLabel("Cajas Ocupadas:");

    /**__________________Campos de texto utilizados_____________________*/

    private final JTextField cantidadCajeros = new JTextField(20);
    private final JTextField nombre = new JTextField(20);
    private final JTextField correo = new JTextField(20);
   
    /**___________________Botones utilizados____________________________*/

    private final JButton btHistorial = new JButton("Historial");
    private final JButton btAceptar = new JButton("Aceptar");
    private final JButton btAgregarUsuario = new JButton("AGREGAR");
    private final JButton btAgregarCajero = new JButton("Aceptar");
    private final JButton btLiberarCaja = new JButton("Liberar Caja");  
    /**_________________________ComBox___________________________________*/

    String [] usuarios = {"Discapacitado","Adulto Mayor","Mujer Embarazada","Cliente Corporativo", "Cliente Regular"};
    JComboBox combo = new JComboBox(usuarios);
    private static JList<String> listBox;
    private DefaultListModel<String> listModel; 

    private static JList<String> listClientesAtendidos;
    private DefaultListModel<String> listClientes;     

    /**__________________Colas de los Usuarios__________________________*/
    ListaClientes personaDiscapacidad = new ListaClientes();
    ListaClientes personaMayor = new ListaClientes();
    ListaClientes mujerEmbarazada = new ListaClientes();
    ListaClientes clienteCorporativo = new ListaClientes();
    ListaClientes clienteRegular = new ListaClientes();
    ListaCajas cajas = new ListaCajas();
    

    /**________________________Metodo para validar Correos_____________________________*/
  
  public static boolean validateEmail(String email) {
  try{
      String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
      Pattern pattern = Pattern.compile(EMAIL_PATTERN);
      Matcher matcher = pattern.matcher(email);
      return matcher.matches();
  }catch(Exception e){
    e.printStackTrace();
  }
  return false;
}
/**_____________________________________FIN ATRIBUTOS DE LA CLASE INTERFAZ_____________________________________________________*/
   
/**_____________________________________CONSTRUCTOR DE INTERFAZ________________________________________________________________*/
   
   	public Interfaz (){

/**_____________________________Agregando propiedades de ventana y otros elementos____________________________________________*/	

       setTitle("BAC San Jose");
       setSize(1200,700);
       setLocation(0,0);
       setResizable(true);        
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       btAgregarCajero.setPreferredSize(new Dimension(90,25));
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

       listModel = new DefaultListModel<>();
       listBox = new JList<>(listModel);
       listBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       contenedor.add(listBox);
       JScrollPane scroll= new JScrollPane(listBox);
       scroll.setPreferredSize(new Dimension(200,200));

       listClientes = new DefaultListModel<>();
       listClientesAtendidos = new JList<>(listClientes);
       listClientesAtendidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       contenedor.add(listClientesAtendidos);
       JScrollPane scrollClientes = new JScrollPane(listClientesAtendidos);
       scrollClientes.setPreferredSize(new Dimension(200,200));

       layout.putConstraint(SpringLayout.WEST, scrollClientes, 660, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, scrollClientes, 50, SpringLayout.NORTH, contenedor);     
 
       layout.putConstraint(SpringLayout.WEST, scroll, 400, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, scroll, 50, SpringLayout.NORTH, contenedor);     
       
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

       layout.putConstraint(SpringLayout.WEST, btAgregarUsuario, 120, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, btAgregarUsuario, 320, SpringLayout.NORTH, contenedor);

       layout.putConstraint(SpringLayout.WEST, nombre, 140 , SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, nombre, 230, SpringLayout.NORTH, contenedor);

       layout.putConstraint(SpringLayout.WEST, correo, 140 , SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, correo, 260, SpringLayout.NORTH, contenedor);

       layout.putConstraint(SpringLayout.WEST, nombreUsuario, 10 , SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, nombreUsuario, 230, SpringLayout.NORTH, contenedor);

       layout.putConstraint(SpringLayout.WEST, correoUsuario, 10 , SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, correoUsuario, 260, SpringLayout.NORTH, contenedor);


       layout.putConstraint(SpringLayout.WEST, agregarUsuario, 10, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, agregarUsuario, 200, SpringLayout.NORTH, contenedor);

       layout.putConstraint(SpringLayout.WEST, combo, 130, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, combo, 290, SpringLayout.NORTH, contenedor);
       
       layout.putConstraint(SpringLayout.WEST, tipoUsuario, 10, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, tipoUsuario, 290, SpringLayout.NORTH, contenedor);
       
       layout.putConstraint(SpringLayout.WEST, btAgregarCajero, 100, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, btAgregarCajero, 105, SpringLayout.NORTH, contenedor);

       layout.putConstraint(SpringLayout.WEST, cajerosDisponibles, 400, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, cajerosDisponibles, 30, SpringLayout.NORTH, contenedor);

       layout.putConstraint(SpringLayout.WEST, cajerosAtendiento, 660, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, cajerosAtendiento, 30, SpringLayout.NORTH, contenedor);
   
       layout.putConstraint(SpringLayout.WEST, btLiberarCaja, 670, SpringLayout.WEST, contenedor);
       layout.putConstraint(SpringLayout.NORTH, btLiberarCaja, 260, SpringLayout.NORTH, contenedor);    
       
       contenedor.add(cajerosAtendiento);
       contenedor.add(scroll);
       contenedor.add(scrollClientes);
       contenedor.add(titulo);
       contenedor.add(cajeros);
       contenedor.add(imagen);
       contenedor.add(btHistorial);
       contenedor.add(btAceptar);
       contenedor.add(cantidadCajeros);
       contenedor.add(btAgregarUsuario);
       contenedor.add(nombre);
       contenedor.add(correo);
       contenedor.add(correoUsuario);
       contenedor.add(nombreUsuario);
       contenedor.add(agregarUsuario);
       contenedor.add(combo);
       contenedor.add(tipoUsuario);
       contenedor.add(btAgregarCajero);
       contenedor.add(cajerosDisponibles);
       contenedor.add(btLiberarCaja);

/**_____________________________________________FIN DE CONTENEDOR__________________________________________________*/

/**_____________________________________________ACCIONES DE LOS ELEMENTOS___________________________________________*/
 

  /**__________________BOTONES________________________________*/

 	btHistorial.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evento) {  
                         Tabla tabla = new Tabla();      
    }});

  btLiberarCaja.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evento) {  

        public void valueChanged(ListSelectionEvent e) {
           if (listClientesAtendidos.getSelectedIndex()!=-1){
            if (!e.getValueIsAdjusting()) {
              System.out.println(listClientesAtendidos.getSelectedValuesList().get(0));
}}}



  }});

  btAgregarCajero.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evento) {  
          if(cantidadCajeros.getText().equals("")){
             JOptionPane.showMessageDialog( null, "Ingrese la cantidad de cajeros","Dato Invalido",JOptionPane.INFORMATION_MESSAGE );
          }
          else{
            int tamaño = Integer.parseInt(cantidadCajeros.getText());
            for(int i = 0; tamaño>i;i++){
              String numero = Integer.toString(i);
              cajas.insertar("Desocupada","caja"+numero);
            }
            cajas.establecerActual();
           for(int j = 0;j<cajas.obtenerTamaño();j++){
            listModel.addElement(cajas.obtenerActual().obtenerNombre());
            cajas.establecerActualSig();
           }
          }   
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

  btAgregarUsuario.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evento) { 
          if(!validateEmail(correo.getText()) || nombre.getText().equals("") ) {
             JOptionPane.showMessageDialog( null, "Datos Invalidos","Datos Invalidos",JOptionPane.INFORMATION_MESSAGE );
          }

          else{
          if(combo.getSelectedItem() == "Discapacitado"){
             personaDiscapacidad.insertar("Discapacitado",nombre.getText(),correo.getText());
          }
          if(combo.getSelectedItem() == "Adulto Mayor"){
             personaMayor.insertar("Adulto Mayor",nombre.getText(),correo.getText());
          }
          if(combo.getSelectedItem() == "Mujer Embarazada"){
             mujerEmbarazada.insertar("Mujer Embarazada",nombre.getText(),correo.getText());
          }         
          if(combo.getSelectedItem() == "Cliente Corporativo"){
             clienteCorporativo.insertar("Cliente Corporativo",nombre.getText(),correo.getText());
          }     
          if(combo.getSelectedItem() == "Cliente Regular"){
             clienteRegular.insertar("Cliente Regular",nombre.getText(),correo.getText());
          }
       /**   System.out.println("discapacidad "+personaDiscapacidad.obtenerTamaño());
          System.out.println("roco "+personaMayor.obtenerTamaño());  
          System.out.println("madre "+mujerEmbarazada.obtenerTamaño());
          System.out.println("juegavivo "+clienteCorporativo.obtenerTamaño()); 
          System.out.println("pobre "+clienteRegular.obtenerTamaño()); */      
          
          cajas.establecerActual();
          while(personaDiscapacidad.obtenerTamaño() != 0 && cajas.obtenerActual() != null){
            if(cajas.obtenerActual().obtenerEstado() == "Desocupada"){
              personaDiscapacidad.asignarCaja();
              listClientes.addElement(cajas.obtenerActual().obtenerNombre());
              cajas.obtenerActual().establecerEstado("Ocupada");
              cajas.establecerActualSig();
              continue;
            }
            else{
                cajas.establecerActualSig();
            }
          }
 
          cajas.establecerActual();
          while(personaMayor.obtenerTamaño() != 0 && cajas.obtenerActual() != null){
            if(cajas.obtenerActual().obtenerEstado() == "Desocupada"){
              personaMayor.asignarCaja();
              listClientes.addElement(cajas.obtenerActual().obtenerNombre());
              cajas.obtenerActual().establecerEstado("Ocupada");
              cajas.establecerActualSig();
              continue;
            }
            else{
                cajas.establecerActualSig();
            }
          }

          cajas.establecerActual();
          while(mujerEmbarazada.obtenerTamaño() != 0 && cajas.obtenerActual() != null){
            if(cajas.obtenerActual().obtenerEstado() == "Desocupada"){
              mujerEmbarazada.asignarCaja();
              listClientes.addElement(cajas.obtenerActual().obtenerNombre());
              cajas.obtenerActual().establecerEstado("Ocupada");
              cajas.establecerActualSig();
              continue;
            }
            else{
                cajas.establecerActualSig();
            }
          }

          cajas.establecerActual();
          while(clienteCorporativo.obtenerTamaño() != 0 && cajas.obtenerActual() != null){
            if(cajas.obtenerActual().obtenerEstado() == "Desocupada"){
              clienteCorporativo.asignarCaja();
              listClientes.addElement(cajas.obtenerActual().obtenerNombre());
              cajas.obtenerActual().establecerEstado("Ocupada");
              cajas.establecerActualSig();
              continue;
            }
            else{
                cajas.establecerActualSig();
            }
          }

          cajas.establecerActual();
          while(clienteRegular.obtenerTamaño() != 0 && cajas.obtenerActual() != null){
            if(cajas.obtenerActual().obtenerEstado() == "Desocupada"){
              clienteRegular.asignarCaja();
              listClientes.addElement(cajas.obtenerActual().obtenerNombre());
              cajas.obtenerActual().establecerEstado("Ocupada");
              cajas.establecerActualSig();
              continue;
            }
            else{
                cajas.establecerActualSig();
            }
          }     
   
         JOptionPane.showMessageDialog( null, "Su operacion se ha realizado con exito, por favor revise su correo y espere ser atendido ","Datos Invalidos",JOptionPane.INFORMATION_MESSAGE ); 
         


    }}});
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
