package programa.gui;

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



public class AlumnoEliminado extends JFrame {

	private JPanel contentPane;

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

	
	public AlumnoEliminado(boolean b) {

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
