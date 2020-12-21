import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;

@SuppressWarnings( {"serial", "unused"} )
public class GenericContainer<COMPONENT extends Component> extends JFrame {

	private COMPONENT myComponent;
	
	public GenericContainer( COMPONENT component ) {
		super( "Generic Container" );
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

		JPanel contentPane = (JPanel) getContentPane();
		contentPane.add( component, BorderLayout.CENTER );
		
		this.pack();
		this.setLocationRelativeTo( null );
		
		this.setVisible( true );
	}

	public COMPONENT getMyComponent() {
		return myComponent;
	}
	
	
	public static void main(String[] args) {
		
		GenericContainer<JButton> frame = new GenericContainer<>( new JButton("Click me!") );
		JButton btn = frame.getMyComponent();
		
		GenericContainer<JTree> frame2 = new GenericContainer<>( new JTree() );
		JTree tree = frame2.getMyComponent();
		
		//GenericContainer<String> frame = new GenericContainer<>( "toto" );
		
	}
}

