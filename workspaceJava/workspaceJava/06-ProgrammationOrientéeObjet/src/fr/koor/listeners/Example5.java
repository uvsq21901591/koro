package fr.koor.listeners;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example5 extends JFrame {

	private static final long serialVersionUID = -6696154155329026354L;
	
	private JButton btnClickMe = new JButton( "Click me!" );
	private JButton btnPushMe = new JButton( "Push me!" );
	private JButton btnActivateMe = new JButton( "Activate me!" );
	
	
	public Example5() {
		super( "Implémentation d'Interface" );
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout( new FlowLayout() );
		
		contentPane.add( btnClickMe );
		contentPane.add( btnPushMe );
		contentPane.add( btnActivateMe );

		/*btnClickMe.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnClickMeListener( e );
			}
		} );*/
		
		//btnClickMe.addActionListener( (e) -> System.out.println( "Ok 1 " + e.getSource() ) );
		//btnClickMe.addActionListener( e -> System.out.println( "Ok 2 " + e.getSource() ) );
		//btnClickMe.addActionListener( e -> btnClickMeListener( e ) );
		/*btnClickMe.addActionListener( (e) -> {
			System.out.println( "Ok 4 " + e.getSource() );
		} );*/
		btnClickMe.addActionListener( this::btnClickMeListener );
		
		
		this.setSize( 600, 400 );
		this.setLocationRelativeTo( null );
		this.setVisible( true );
	}
	
	private void btnClickMeListener( ActionEvent e ) {
		System.out.println( "Ok 5" );
	}
	

	public static void main(String[] args) {
		new Example5();
	}

}
