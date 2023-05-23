package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import registrodealumnos.Programa;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Lucas Solmoni & Victoria Legakis
 *
 *         Esta clase corresponde a la interfaz gráfica del inicio del programa.
 */

public class UserInterface {

	private Programa nuevoPrograma;

	private JFrame frmRegistro;
	private JTextField txtIngreseElNombre;
	private JButton btnSiguiente;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JTextArea txtrPorFavorIngrese;
	private MenuOpciones opcionesRegistro;

	/**
	 * Permite ejecutar la aplicación.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frmRegistro.setVisible(true);
					window.frmRegistro.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la aplicación.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Inicializa los contenidos del frame.
	 */
	private void initialize() {
		frmRegistro = new JFrame();
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.setResizable(false);
		frmRegistro.getContentPane().setFont(new Font("Century Gothic", Font.PLAIN, 11));
		frmRegistro.setBackground(new Color(173, 216, 230));
		frmRegistro.getContentPane().setBackground(new Color(255, 255, 240));
		frmRegistro.setForeground(new Color(0, 0, 0));
		frmRegistro.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		frmRegistro.setTitle("Registro");
		frmRegistro.setBounds(100, 100, 944, 670);
		frmRegistro.getContentPane().setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				opcionesRegistro.setVisible(true);
			}
		});
		lblNewLabel_1_1.setVisible(false);
		lblNewLabel_1_1.setBounds(519, 426, 45, 44);
		ImageIcon btnVolverAux = new ImageIcon(UserInterface.class.getResource("/gui/imgproject/1177531.png"));
		ImageIcon btnVolver = new ImageIcon(btnVolverAux.getImage().getScaledInstance(lblNewLabel_1_1.getWidth(),
				lblNewLabel_1_1.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_1_1.setIcon(btnVolver);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		frmRegistro.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1 = new JLabel("VOLVER AL MENÚ PRINCIPAL");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(317, 426, 192, 44);
		frmRegistro.getContentPane().add(lblNewLabel_1);

		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(255, 383, 351, 2);
		frmRegistro.getContentPane().add(separator);

		txtrPorFavorIngrese = new JTextArea();
		txtrPorFavorIngrese.setEditable(false);
		txtrPorFavorIngrese.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		txtrPorFavorIngrese.setText("Por favor ingrese a continuación el nombre de la materia que dicta. ");
		txtrPorFavorIngrese.setBounds(223, 277, 474, 22);
		txtrPorFavorIngrese.setOpaque(false);
		frmRegistro.getContentPane().add(txtrPorFavorIngrese);

		lblNewLabel = new JLabel("¡Bienvenido/a al sistema de registro de alumnos!");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(138, 204, 644, 70);
		frmRegistro.getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 24));

		txtIngreseElNombre = new JTextField();
		txtIngreseElNombre.setBorder(null);
		txtIngreseElNombre.setOpaque(false);
		txtIngreseElNombre.setForeground(Color.GRAY);
		txtIngreseElNombre.setToolTipText("Ingrese el nombre de la materia a registrar...");
		txtIngreseElNombre.setFont(new Font("MS PMincho", Font.PLAIN, 14));
		txtIngreseElNombre.setBounds(255, 353, 351, 32);
		frmRegistro.getContentPane().add(txtIngreseElNombre);
		txtIngreseElNombre.setColumns(10);

		btnSiguiente = new JButton("");
		btnSiguiente.setOpaque(false);
		btnSiguiente.setBorder(null);
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setBackground(Color.DARK_GRAY);
		btnSiguiente.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnSiguiente.setBounds(616, 341, 45, 44);
		ImageIcon imgAuxButton = new ImageIcon(UserInterface.class.getResource("/gui/imgproject/1177527.png"));
		ImageIcon imgButton = new ImageIcon(imgAuxButton.getImage().getScaledInstance(btnSiguiente.getWidth(),
				btnSiguiente.getHeight(), Image.SCALE_SMOOTH));
		btnSiguiente.setIcon(imgButton);
		frmRegistro.getContentPane().add(btnSiguiente);

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtIngreseElNombre.getText().toString().equals("")) {
					txtrPorFavorIngrese.setText("No ha ingresado el nombre de la materia. Intente nuevamente.");
				} else {
					abrirOpcionesDeRegistro();
					lblNewLabel_1.setVisible(true);
					lblNewLabel_1_1.setVisible(true);
				}

			}
		});

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 930, 633);
		frmRegistro.getContentPane().add(lblNewLabel_2);
		ImageIcon imgAux = new ImageIcon(UserInterface.class.getResource("/gui/imgproject/abstract_background_5.png"));
		ImageIcon imgBackground = new ImageIcon(imgAux.getImage().getScaledInstance(lblNewLabel_2.getWidth(),
				lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_2.setIcon(imgBackground);

		/**
		 * Creación de un nuevo programa.
		 */
		nuevoPrograma = new Programa(txtIngreseElNombre.getText());

	}
	
	/**
	 * Abre el menú de opciones pasando por parámetro la instancia del programa y el nombre de la materia.
	 */

	protected void abrirOpcionesDeRegistro() {

		String materia = txtIngreseElNombre.getText();
		frmRegistro.setTitle("Registro de alumnos de " + materia);
		txtIngreseElNombre.setVisible(false);
		btnSiguiente.setVisible(false);
		separator.setVisible(false);
		lblNewLabel.setText("Se ha abierto una nueva ventana desplegando el menú de opciones.");
		lblNewLabel.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		txtrPorFavorIngrese.setVisible(false);
		opcionesRegistro = new MenuOpciones(nuevoPrograma, materia);
		opcionesRegistro.setTitle("Registro de alumnos de " + materia);
		opcionesRegistro.setVisible(true);

	}
}
