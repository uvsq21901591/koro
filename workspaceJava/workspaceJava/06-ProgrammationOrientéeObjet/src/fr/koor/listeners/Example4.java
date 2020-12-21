package fr.koor.listeners;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example4 extends JFrame {

	private static final long serialVersionUID = -6696154155329026354L;
	
	private JButton btnClickMe = new JButton( "Click me!" );
	private JButton btnPushMe = new JButton( "Push me!" );
	private JButton btnActivateMe = new JButton( "Activate me!" );
	
	
	public Example4() {
		super( "Implémentation d'Interface" );
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout( new FlowLayout() );
		
		contentPane.add( btnClickMe );
		contentPane.add( btnPushMe );
		contentPane.add( btnActivateMe );

		btnClickMe.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println( "Ok" );
			}
		} );		
		
		this.setSize( 600, 400 );
		this.setLocationRelativeTo( null );
		this.setVisible( true );
	}
	

	public static void main(String[] args) {
		new Example4();
	}

}
