package mb1;

import java.awt.Container;
import javax.swing.JFrame;



public class okno extends JFrame{
	public okno() {
		
		// создание окна приложения
		this.setBounds(0,0,900,600);         
		setTitle("sea-battle\"морской бой\"");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//создание панели игрового поля
		pole pan=new pole();
		Container cont=getContentPane();
		cont.add(pan);
		setVisible(true);
		 
		
	}	
	
}


//this.setBounds(0,0,900,600);