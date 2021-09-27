package gui;

import java.awt.Dimension;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textFieldLU;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldGithub;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setIconImage(new ImageIcon(getClass().getResource("/images/tdp.png")).getImage());
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 285));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(UIManager.getBorder("EditorPane.border"));
		tabInformation = new JPanel();
		tabInformation.setBorder(null);
		tabInformation.setPreferredSize(new Dimension(425, 250));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel lblNewLabel = new JLabel("LU:");
		
		JLabel lblNewLabel_AP = new JLabel("Apellido:");
		
		JLabel lblNewLabel_Nom = new JLabel("Nombre");
		
		JLabel lblNewLabel_URL = new JLabel("Github URL:");
		
		JLabel lblNewLabel_Email = new JLabel("E-Mail:");
		
		textFieldLU = new JTextField();
		textFieldLU.setColumns(10);
		textFieldLU.setText(""+studentData.getId());
		textFieldLU.setEditable(false);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setText(studentData.getLastName());
		textFieldApellido.setEditable(false);

		JTextField textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setText(studentData.getFirstName());
		textFieldNombre.setEditable(false);
		
	
		
		
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setText(studentData.getMail());
		textFieldEmail.setEditable(false);
		
		textFieldGithub = new JTextField();
		textFieldGithub.setColumns(10);
		textFieldGithub.setText(studentData.getGithubURL());
		textFieldGithub.setEditable(false);
		
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_AP)
						.addComponent(lblNewLabel_Nom)
						.addComponent(lblNewLabel_Email)
						.addComponent(lblNewLabel_URL))
					.addGap(23)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldGithub, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldLU, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textFieldLU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_AP)
						.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_Nom)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_Email)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldGithub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_URL))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		tabInformation.setLayout(gl_tabInformation);
				
		//Fecha y hora 		
		Date fecha = new Date();
		int dia = fecha.getDate();	//retorna el dia correspondiente al mes
		int mes = fecha.getMonth()+1; //retorna los meses del aï¿½o entre 0-11
		int anio = fecha.getYear()+1900; //retorna los aï¿½os concurriodos luego del 1900
		String calendario = dia+"/"+mes+"/"+anio;
		int h = fecha.getHours();  //retorna la hora correspondiente 	
		int m = fecha.getMinutes();	//retorna los minutos correspondientes
		int s = fecha.getSeconds();	//retonrna los segudnos correspondientes 
		String hora = h+":"+m+":"+s;
		JLabel lblNewLabel_5 = new JLabel("Esta ventana fue generada el "+calendario+" a las "+hora+".");
		
		//Imagen de perfil del alumno
		JPanel panelImagen = new JPanel();	//Panel para imagen de perfil				
		JLabel imagen = new JLabel("");		//Imagen de perfil
		imagen.setHorizontalAlignment(SwingConstants.CENTER);		
		GroupLayout gl_panelImagen = new GroupLayout(panelImagen);
		gl_panelImagen.setHorizontalGroup(
			gl_panelImagen.createParallelGroup(Alignment.LEADING)
				.addComponent(imagen, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
		);
		gl_panelImagen.setVerticalGroup(
			gl_panelImagen.createParallelGroup(Alignment.LEADING)
				.addComponent(imagen, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
		);
				
		ImageIcon Img = new ImageIcon(getClass().getResource(studentData.getPathPhoto()));
		imagen.setIcon(Img);
		panelImagen.setLayout(gl_panelImagen);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelImagen, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblNewLabel_5))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(panelImagen, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
					.addGap(15))
		);
		contentPane.setLayout(gl_contentPane);		
	}
}