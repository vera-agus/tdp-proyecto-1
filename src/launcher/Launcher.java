package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SimplePresentationScreen a = new SimplePresentationScreen(new Student(122193,"Vera","Mauricio Agustin","agus22v@outlook.com","https://github.com/vera-agus","/images/fotoPerfil.png"));
            	a.setVisible(true);
            }
        });
    }
}