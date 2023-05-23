package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import registrodealumnos.Programa;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Clase que modela la ventana de la interfaz gráfica que muestra un mensaje al ingresar alumno.
 *  
 * @author Lucas Solmoni & Victoria Legakis
 * 
 * 
 */
public class AlumnoIngresado extends JFrame {

	private JPanel contentPane;
	private static int i;

	/**
	 * Ejecuta la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnoIngresado frame = new AlumnoIngresado(true, i);
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
	 * @param b boolean que identifica el ingreso del alumno.
	 * @param i entero que identifica el mensaje a mostrar al ingresar un alumno.
	 */
	public AlumnoIngresado(boolean b, int i) {
		AlumnoIngresado.i = i;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(27, 80, 399, 70);
		contentPane.add(lblNewLabel);

		if (b) {
			lblNewLabel.setText("El alumno se ha ingresado correctamente");
		} else {
			lblNewLabel.setText("Los datos ingresados son incorrectos, pruebe nuevamente.");
		}

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		btnNewButton.setBackground(new Color(102, 102, 204));
		btnNewButton.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 11));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(179, 161, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(59, 35, 311, 34);
		contentPane.add(lblNewLabel_1);

		if (i == 1) {
			lblNewLabel_1.setText("ALUMNO INGRESADO");

		} else if (i == 2) {
			lblNewLabel_1.setText("LU YA INGRESADO O NOTA INVALIDA");
		} else {
			lblNewLabel_1.setText("CAMPOS VACIOS");
		}

	}
}
