import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mediator extends JPanel implements ActionListener, KeyListener {
  private JTextField ord, antal;
  private JButton print;
  private JTextArea output;
  
  public Mediator() {
    
      
	  
	ord = new JTextField( 10 );
    ord.addKeyListener( this );
    
    antal = new JTextField( 4 );
    antal.addKeyListener( this );
    
    print = new JButton( "Print" );
    print.setEnabled( false );
    print.addActionListener( this );
    
    output = new JTextArea( 10, 20 );
    output.setEditable( false );
    
    /*
     * Layout
     */
    
    setLayout( new BorderLayout() );
    add( new JScrollPane( output ) );
    
    JPanel topPanel = new JPanel();
    topPanel.setLayout( new FlowLayout() );
    topPanel.add( new JLabel( "Ord:" ) );
    topPanel.add( ord );
    topPanel.add( new JLabel( "Antal:" ) );
    topPanel.add( antal );
    topPanel.add( print );
    
    add( topPanel,  BorderLayout.NORTH );
  }
  
  public void actionPerformed( ActionEvent e ) {
    // Dette kan kun være Print-knappen
    
    int n = Integer.parseInt( antal.getText() );
    String tekst = ord.getText();
    
    output.setText( "" );
    for ( int i=0; i<n; i++ )
      output.append( tekst + '\n' );
  }
  
  public void keyReleased( KeyEvent e ) {
    print.setEnabled( printable() );
  }
  
  private boolean printable() {
    try {
      int n = Integer.parseInt( antal.getText() );
      if ( n <= 0 )
        return false;
      
      if ( ord.getText().length() == 0 )
        return false;
      
      return true;
    } catch ( NumberFormatException e ) {
      return false;
    }
  }
  
  /*
   * Nødvendige stubbe fordi vi er KeyListener
   */
  
  public void keyPressed( KeyEvent e ) {
  }
  
  public void keyTyped( KeyEvent e ) {
  }
}