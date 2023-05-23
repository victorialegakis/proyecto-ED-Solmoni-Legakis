package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Lucas Solmoni & Victoria Legakis
 * 
 * Clase que modela la ventana de la interfaz gráfica que muestra un mensaje al eliminar alumno.
 */

public class AlumnoEliminado extends JFrame {

	private JPanel contentPane;

	/**
	 * Ejecuta la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnoEliminado frame = new AlumnoEliminado(true);
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
	 * @param b boolean que identifica la eliminación del alumno.
	 */
	public AlumnoEliminado(boolean b) {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
			lblNewLabel.setText("El alumno se ha eliminado correctamente");
		} else {
			lblNewLabel.setText("Los datos ingresados son incorrectos, pruebe nuevamente");
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

	}

}