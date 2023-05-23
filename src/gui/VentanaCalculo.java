package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import registrodealumnos.Programa;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Lucas Solmoni & Victoria Legakis
 * 
 * 	Esta clase corresponde a la ventana de la interfaz gráfica que permite consultar data.
 *
 */
public class VentanaCalculo extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1_1;
	private static Programa programa;
	private static int i;

	/**
	 * Permite ejecutar la ventana.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCalculo frame = new VentanaCalculo(i, programa);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame.
	 * 
	 * @param i  Recibe el número de panel a mostrar y opción a ejecutar.
	 * @param nuevoPrograma Recibe la instancia de programa creada en el inicio de la aplicación. 
	 */
	public VentanaCalculo(int i, Programa nuevoPrograma) {
		this.i = i;
		programa = nuevoPrograma;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Consultas - nota mínima, promedio, nota determinada.");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(0, 0, 434, 24);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(VentanaCalculo.class.getResource(
				"/gui/imgproject/vecteezy_gradient-mesh-abstract-background-with-light-color_23217074.jpg")));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 23);
		contentPane.add(lblNewLabel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(0, 0, 434, 261);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("NOTA MINIMA REGISTRADA:");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(23, 11, 383, 32);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(33, 54, 360, 106);
		panel.add(lblNewLabel_3);

		JButton btnVolver_1_1 = new JButton("Volver");
		btnVolver_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVolver_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnVolver_1_1.setBackground(new Color(204, 255, 153));
		btnVolver_1_1.setBounds(168, 202, 96, 20);
		panel.add(btnVolver_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("PROMEDIO DE NOTAS:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(23, 11, 383, 32);
		panel_1.add(lblNewLabel_2_1);

		lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));

		lblNewLabel_3_1.setBackground(Color.WHITE);
		lblNewLabel_3_1.setBounds(33, 54, 360, 106);
		panel_1.add(lblNewLabel_3_1);

		JButton btnVolver_1 = new JButton("Volver");
		btnVolver_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVolver_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnVolver_1.setBackground(new Color(204, 255, 153));
		btnVolver_1.setBounds(166, 202, 96, 20);
		panel_1.add(btnVolver_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("", null, panel_2, null);
		panel_2.setLayout(null);

		lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_3_1_1.setBackground(Color.WHITE);
		lblNewLabel_3_1_1.setBounds(35, 84, 360, 106);
		panel_2.add(lblNewLabel_3_1_1);

		cambiarTab(i);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(55, 71, 264, 2);
		panel_2.add(separator);

		JLabel lblNewLabel_2_1_1 = new JLabel("CONSULTA POR UNA NOTA INDICANDO EL L.U DEL ALUMNO:");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_2_1_1.setBounds(23, 11, 383, 32);
		panel_2.add(lblNewLabel_2_1_1);

		JFormattedTextField formattedTextField = new JFormattedTextField(createFormater("######"));
		formattedTextField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		formattedTextField.setColumns(7);
		formattedTextField.setBorder(null);
		formattedTextField.setBounds(55, 53, 264, 20);
		panel_2.add(formattedTextField);

		JButton btnNewButton = new JButton(">>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String luAux = formattedTextField.getText();
				formattedTextField.setValue(null);
				if (chequearDatosVacios(luAux)) {
					int lu = Integer.valueOf(luAux);
					if (chequearLU(lu)) {
						lblNewLabel_3_1_1.setText("El L.U ingresado  " + lu + " tiene asociada la siguiente nota:  "
								+ programa.consultarNota(lu));
					} else {
						lblNewLabel_3_1_1.setText("El L.U ingresado no está asociado a ningún alumno del registro");
					}
				} else {
					lblNewLabel_3_1_1.setText("El L.U ingresado no es válido. Intente nuevamente");
				}
			}
		});
		btnNewButton.setBackground(new Color(204, 255, 153));
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnNewButton.setBounds(329, 53, 49, 20);
		panel_2.add(btnNewButton);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVolver.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnVolver.setBackground(new Color(204, 255, 153));
		btnVolver.setBounds(163, 201, 96, 20);
		panel_2.add(btnVolver);

	}

	private MaskFormatter createFormater(String i) {
		// TODO Auto-generated method stub
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(i);
		} catch (java.text.ParseException exc) {
			exc.getMessage();

		}
		return formatter;
	}

	private void cambiarTab(int i) {
		tabbedPane.setSelectedIndex(i - 1);
		if (i == 1) {
			modificarMinimaNota();
		} else if (i == 2) {
			modificarPromedio();
		} else {
			modificarConsultarNota();
		}
	}
	
	/**
	 * Metodo que chequea si el LU existe en el registro.
	 * 
	 * @param lu entero que representa el LU de un alumno.
	 * @return boolean que identifica si encontró.
	 */

	private boolean chequearLU(int lu) {
		return programa.chequearLUExistente(lu);
	}
	/**
	 * /**
	 * Metodo que chequea si el LU es vacío.
	 * 
	 * @param lu entero que representa el LU de un alumno.
	 * @return boolean que identifica si es vacío o no.
	 */
	 

	private boolean chequearDatosVacios(String lu) {
		return (!lu.isBlank());
	}
	
	/**
	 * Metodo que establece el texto del panel de mínima nota.
	 */
	private void modificarMinimaNota() {
		double notaMinima = programa.minNota();
		if (notaMinima == -1) {
			lblNewLabel_3.setText("No hay entradas en el registro todavía.");

		} else {
			lblNewLabel_3.setText("La mínima nota del registro es: " + notaMinima);
		}
	}
	/**
	 * Metodo que establece el texto del panel de promedio.
	 */
	private void modificarPromedio() {
		double promedio = programa.calcularPromedio();
		if (promedio == -1) {
			lblNewLabel_3_1.setText("No hay ninguna nota en el registro todavía.");

		} else {
			lblNewLabel_3_1.setText("El promedio de las notas del registro es: " + promedio);
		}
	}
	/**
	 * Metodo que establece el texto del panel de consultar nota antes de que se ingrese un LU.
	 */
	private void modificarConsultarNota() {
		lblNewLabel_3_1_1.setText("Aquí se verá la nota del L.U que ingrese");

	}
}
