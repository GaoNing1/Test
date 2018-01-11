package java8;


import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * lamdba表达式
 */
public class SwingTest {
	public static void main(String[] args) {
	    JFrame jFrame = new JFrame("My JFrame");
	    JButton jButton = new JButton("My JButton");
	 
//	    jButton.addActionListener(new ActionListener() {
//	      @Override
//	      public void actionPerformed(ActionEvent e) {        
//	        System.out.println("Button Pressed!");
//	      } 
//	    }); 
	    
	    jButton.addActionListener(e -> System.out.println("Button Pressed!"));
	    
	     
	    jFrame.add(jButton); jFrame.pack(); 
	    jFrame.setVisible(true); 
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  }
}
