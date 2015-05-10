import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 JFrame frame = new JFrame();
		    frame.setTitle( "CopyPaste Maskine" );
		    frame.getContentPane().setLayout( new BorderLayout() );
		    frame.getContentPane().add( new Mediator() );
		    frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
		    frame.pack();
		    frame.setVisible( true );
	}

}
