package gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import excepciones.lista.EmptyListException;
import registrodealumnos.Pair;
import registrodealumnos.Programa;
import tdas.tdadiccionario.IEntry;
import tdas.tdalista.IPosition;
import tdas.tdalista.IPositionList;
import tdasimplementados.diccionario.Entrada;

import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * Clase que modela el menú de opciones.
 * 
 * @author Lucas Solmoni & Victoria Legakis
 *
 */
public class MenuOpciones extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextField_1;
	private JFormattedTextField formattedTextField_2;
	protected int nota;
	protected int lu;
	private static Programa programa;
	private static String materia;

	/**
	 * Ejecuta la aplicación.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOpciones frame = new MenuOpciones(programa, materia);
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
	 * @param nuevoPrograma instancia del programa
	 * @param materia nombre de la materia ingresada
	 */

	public MenuOpciones(Programa nuevoPrograma, String materia) {

		programa = nuevoPrograma;
		MenuOpciones.materia = materia;

		setBounds(100, 100, 944, 670);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 930, 633);

		ImageIcon auxBackground = new ImageIcon(
				MenuOpciones.class.getResource("/gui/imgproject/abstract_background_8.png"));
		ImageIcon background = new ImageIcon(auxBackground.getImage().getScaledInstance(lblNewLabel.getWidth(),
				lblNewLabel.getHeight(), Image.SCALE_SMOOTH));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(29, 43, 869, 43);
		ImageIcon barAux = new ImageIcon(MenuOpciones.class.getResource("/gui/imgproject/descarga.jpg"));
		ImageIcon bar = new ImageIcon(barAux.getImage().getScaledInstance(lblNewLabel_3.getWidth(),
				lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH));

		JLabel lblNewLabel_15 = new JLabel("REGISTRO DE ALUMNOS DE " + materia.toUpperCase());
		lblNewLabel_15.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblNewLabel_15.setForeground(new Color(255, 255, 255));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setBounds(29, 43, 869, 43);
		contentPane.add(lblNewLabel_15);
		lblNewLabel_3.setIcon(bar);

		contentPane.add(lblNewLabel_3);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(29, 62, 869, 518);
		contentPane.add(tabbedPane);

		ImageIcon auxTabs = new ImageIcon(MenuOpciones.class
				.getResource("/gui/imgproject/103-1035002_may-your-holidays-be-dazzling-white-rectangle-with.png"));
		ImageIcon auxTabs2 = new ImageIcon(MenuOpciones.class
				.getResource("/gui/imgproject/103-1035002_may-your-holidays-be-dazzling-white-rectangle-with.png"));
		ImageIcon auxTabs1 = new ImageIcon(MenuOpciones.class
				.getResource("/gui/imgproject/103-1035002_may-your-holidays-be-dazzling-white-rectangle-with.png"));
		ImageIcon auxIcon_1 = new ImageIcon(MenuOpciones.class.getResource(
				"/gui/imgproject/vecteezy_isometric-flat-3d-illustration-concept-of-man-filling_21272478.png"));
		ImageIcon auxIcon_2 = new ImageIcon(MenuOpciones.class.getResource(
				"/gui/imgproject/vecteezy_flat-3d-isometric-illustration-concept-of-educational-online_15593296.png"));
		ImageIcon auxIcon_3 = new ImageIcon(MenuOpciones.class.getResource(
				"/gui/imgproject/vecteezy_isometric-flat-3d-concept-illustration-online-school-student_17310931.png"));

		JPanel panel = new JPanel();
		panel.setForeground(Color.DARK_GRAY);
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Inicio", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Permite agregar o eliminar datos al registro de alumnos.");
		lblNewLabel_1.setBounds(10, 50, 285, 429);
		ImageIcon tabs = new ImageIcon(auxTabs.getImage().getScaledInstance(lblNewLabel_1.getWidth(),
				lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH));

		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setBounds(569, 50, 285, 429);
		ImageIcon tabs2 = new ImageIcon(auxTabs2.getImage().getScaledInstance(lblNewLabel_1_1_1.getWidth(),
				lblNewLabel_1_1_1.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_1_1_1.setIcon(tabs2);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(290, 50, 285, 429);
		ImageIcon tabs1 = new ImageIcon(auxTabs1.getImage().getScaledInstance(lblNewLabel_1_1.getWidth(),
				lblNewLabel_1_1.getHeight(), Image.SCALE_SMOOTH));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(63, 81, 180, 163);
		ImageIcon icon_1 = new ImageIcon(auxIcon_1.getImage().getScaledInstance(lblNewLabel_2.getWidth(),
				lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH));

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(341, 81, 180, 163);
		ImageIcon icon_2 = new ImageIcon(auxIcon_2.getImage().getScaledInstance(lblNewLabel_2_1.getWidth(),
				lblNewLabel_2_1.getHeight(), Image.SCALE_SMOOTH));

		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setBounds(622, 81, 180, 163);
		ImageIcon icon_3 = new ImageIcon(auxIcon_3.getImage().getScaledInstance(lblNewLabel_2_2.getWidth(),
				lblNewLabel_2_2.getHeight(), Image.SCALE_SMOOTH));

		JLabel lblNewLabel_4 = new JLabel("Modificá el registro.");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
				lblNewLabel.setVisible(false);

			}
		});
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(63, 285, 180, 44);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("Consultá data.");
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
				lblNewLabel.setVisible(false);
			}
		});
		lblNewLabel_4_1.setToolTipText("Aquí podes realizar cálculos como notas mínimas, máximas y promedios.");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(341, 285, 180, 44);
		panel.add(lblNewLabel_4_1);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		
		table.setToolTipText("Tabla con la lista completa de alumnos y sus respectivas notas.");
		table.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Legajo", "Nota" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}

		});
		
				table.setBounds(123, 92, 638, 319);
				JScrollPane pane = new JScrollPane(table);
				pane.setBackground(Color.WHITE);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				

		JLabel lblNewLabel_4_2 = new JLabel("Visualizá la lista.");
		lblNewLabel_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
				lblNewLabel.setVisible(false);
				model.setRowCount(0);
				for (IPosition<Pair<Integer, Integer>> pair : programa.visualizarAlumnos()) {
					Object[] fila = new Object[2];
					fila[0] = pair.element().getKey();
					fila[1] = pair.element().getValue();
					model.addRow(fila);
				}
			}
		});
		lblNewLabel_4_2.setToolTipText("Permite ver el registro completo de alumnos y sus respectivas notas.");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(622, 285, 180, 44);
		panel.add(lblNewLabel_4_2);

		panel.add(lblNewLabel_2_2);

		panel.add(lblNewLabel_2_1);

		panel.add(lblNewLabel_2);

		lblNewLabel_2_1.setIcon(icon_2);
		lblNewLabel_2_2.setIcon(icon_3);
		lblNewLabel_2.setIcon(icon_1);

		lblNewLabel_1_1.setIcon(tabs1);

		panel.add(lblNewLabel_1_1);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1.setIcon(tabs);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.DARK_GRAY);
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Modificá", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(0, 0, 864, 490);
		ImageIcon iconPanelModificaAux = new ImageIcon(
				MenuOpciones.class.getResource("/gui/imgproject/abstract_background_8.png"));
		ImageIcon iconPanelModifica = new ImageIcon(iconPanelModificaAux.getImage()
				.getScaledInstance(lblNewLabel_7.getWidth(), lblNewLabel_7.getHeight(), Image.SCALE_SMOOTH));

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(523, 72, 282, 149);
		ImageIcon btnAux = new ImageIcon(MenuOpciones.class.getResource("/gui/imgproject/g20154.png"));
		ImageIcon btnAgregar = new ImageIcon(btnAux.getImage().getScaledInstance(lblNewLabel_5.getWidth(),
				lblNewLabel_5.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_5.setIcon(btnAgregar);

		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setBounds(523, 286, 282, 149);

		ImageIcon btnEliminar = new ImageIcon(btnAux.getImage().getScaledInstance(lblNewLabel_5_1.getWidth(),
				lblNewLabel_5_1.getHeight(), Image.SCALE_SMOOTH));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(UIManager.getBorder("InternalFrame.border"));
		panel_4.setVisible(false);

		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				lblNewLabel.setVisible(true);

			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(102, 204, 0));
		btnNewButton_1.setBounds(716, 11, 130, 43);
		panel_1.add(btnNewButton_1);
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(38, 38, 413, 196);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(UIManager.getBorder("InternalFrame.border"));
		panel_4_1.setVisible(false);
		panel_4_1.setBackground(new Color(255, 255, 255));
		panel_4_1.setBounds(39, 252, 413, 196);
		panel_1.add(panel_4_1);
		panel_4_1.setLayout(null);

		JLabel lblNewLabel_6_1 = new JLabel("ELIMINAR ALUMNOS");
		lblNewLabel_6_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4_1.setVisible(true);
				panel_4.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_6_1.setForeground(new Color(0, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_6_1.setForeground(new Color(255, 255, 255));
			}
		});

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(81, 119, 241, 2);
		panel_4_1.add(separator_2);

		formattedTextField_2 = new JFormattedTextField(createFormater("######"));
		formattedTextField_2.setColumns(7);
		formattedTextField_2.setBorder(null);
		formattedTextField_2.setToolTipText("Ingrese el L.U, compuesto de 6 dígitos.");
		formattedTextField_2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		formattedTextField_2.setBounds(81, 89, 241, 31);
		panel_4_1.add(formattedTextField_2);

		JLabel lblNewLabel_8_2 = new JLabel("Ingresar L.U a continuación:");
		lblNewLabel_8_2.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 11));
		lblNewLabel_8_2.setBounds(81, 66, 241, 14);
		panel_4_1.add(lblNewLabel_8_2);

		JButton btnNewButton_1_1 = new JButton(">>");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String luAux = formattedTextField_2.getText();
				formattedTextField_2.setValue(null);
				if (chequearDatosVacios(luAux)) {
					lu = Integer.valueOf(luAux);
					if (chequearLU(lu)) {
						programa.eliminarAlumno(lu);
						JFrame jFrameIngresado = new AlumnoEliminado(true);
						JLabel jLabelIngresado = new JLabel("El alumno ha sido eliminado correctamente");
						jFrameIngresado.getContentPane().add(jLabelIngresado);
						jFrameIngresado.setTitle("Registro de Alumnos de " + materia);
						jFrameIngresado.setVisible(true);
						panel_4_1.setVisible(false);

					} else {
						AlumnoEliminado alumnoInvalido1 = new AlumnoEliminado(false);
						alumnoInvalido1.setTitle("Registro de Alumnos de " + materia);
						alumnoInvalido1.setVisible(true);
					}
				} else {
					AlumnoEliminado alumnoInvalido2 = new AlumnoEliminado(false);
					alumnoInvalido2.setTitle("Registro de Alumnos de " + materia);
					alumnoInvalido2.setVisible(true);
				}
			}

		});
		btnNewButton_1_1.setBackground(new Color(102, 204, 0));
		btnNewButton_1_1.setBounds(332, 98, 59, 23);
		panel_4_1.add(btnNewButton_1_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(81, 155, 241, 2);
		panel_4.add(separator_1);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(81, 84, 241, 2);
		panel_4.add(separator);

		formattedTextField = new JFormattedTextField(createFormater("######"));
		formattedTextField.setColumns(7);
		formattedTextField.setBorder(null);
		formattedTextField.setToolTipText("Ingrese el L.U, compuesto de 6 dígitos.");
		formattedTextField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		formattedTextField.setBounds(81, 54, 241, 31);
		panel_4.add(formattedTextField);

		formattedTextField_1 = new JFormattedTextField(createFormater("##"));
		formattedTextField_1.setColumns(3);
		formattedTextField_1.setBorder(null);
		formattedTextField_1.setToolTipText("Ingrese una nota del 0 al 10.");
		formattedTextField_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		formattedTextField_1.setBounds(81, 126, 241, 31);
		panel_4.add(formattedTextField_1);
		
		JLabel lblNewLabel_8 = new JLabel("Ingresar L.U a continuación:");
		lblNewLabel_8.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 11));
		lblNewLabel_8.setBounds(81, 31, 241, 14);
		panel_4.add(lblNewLabel_8);

		JLabel lblNewLabel_8_1 = new JLabel("Ingresar nota a continuación:");
		lblNewLabel_8_1.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 11));
		lblNewLabel_8_1.setBounds(81, 101, 241, 14);
		panel_4.add(lblNewLabel_8_1);

		JButton btnNewButton = new JButton(">>");
		btnNewButton.setBackground(new Color(102, 204, 0));
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String luAux = formattedTextField.getText();
				String notaAux = formattedTextField_1.getText();
				formattedTextField.setValue(null);
				formattedTextField_1.setValue(null);
				if (chequearDatosVacios(luAux, notaAux)) {
					lu = Integer.valueOf(luAux);
					nota = Integer.valueOf(notaAux);
					if (chequearNota(nota) && !chequearLU(lu)) {
						programa.ingresarAlumno(lu, nota);
						JFrame jFrameIngresado = new AlumnoIngresado(true, 1);
						jFrameIngresado.setTitle("Registro de Alumnos de " + materia);
						JLabel jLabelIngresado = new JLabel("El alumno ha sido ingresado correctamente");
						jFrameIngresado.getContentPane().add(jLabelIngresado);
						jFrameIngresado.setVisible(true);
						panel_4.setVisible(false);

					} else {
						AlumnoIngresado alumnoInvalido1 = new AlumnoIngresado(false, 2);
						alumnoInvalido1.setTitle("Registro de Alumnos de " + materia);
						alumnoInvalido1.setVisible(true);

					}
				} else {
					AlumnoIngresado alumnoInvalido = new AlumnoIngresado(false, 3);
					alumnoInvalido.setTitle("Registro de Alumnos de " + materia);
					alumnoInvalido.setVisible(true);

				}

			}
		});
		btnNewButton.setBounds(332, 96, 59, 23);
		panel_4.add(btnNewButton);
		lblNewLabel_6_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNewLabel_6_1.setBounds(534, 299, 226, 108);
		panel_1.add(lblNewLabel_6_1);
		lblNewLabel_5_1.setIcon(btnEliminar);
		panel_1.add(lblNewLabel_5_1);

		JLabel lblNewLabel_6 = new JLabel("AGREGAR ALUMNOS");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_6.setForeground(new Color(0, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_6.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4.setVisible(true);
				panel_4_1.setVisible(false);
			}
		});
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(534, 86, 226, 108);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_5);

		lblNewLabel_7.setIcon(iconPanelModifica);
		panel_1.add(lblNewLabel_7);
		ImageIcon btnAux1 = new ImageIcon(MenuOpciones.class.getResource("/gui/imgproject/abstract_background_5.png"));

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.DARK_GRAY);
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Calculá", null, panel_2, null);
		panel_2.setLayout(null);
		ImageIcon icoDecoAux = new ImageIcon(MenuOpciones.class.getResource(
				"/gui/imgproject/vecteezy_flat-isometric-illustration-concept-pile-of-books-and-ideas_6202279.png"));

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 864, 490);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

		ImageIcon btnAux2 = new ImageIcon(MenuOpciones.class.getResource("/gui/imgproject/g20154.png"));
		ImageIcon btnAux3 = new ImageIcon(MenuOpciones.class.getResource("/gui/imgproject/g20154.png"));
		ImageIcon btnAux4 = new ImageIcon(MenuOpciones.class.getResource("/gui/imgproject/g20154.png"));

		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setBounds(255, 88, 240, 99);
		ImageIcon btn2 = new ImageIcon(btnAux2.getImage().getScaledInstance(lblNewLabel_14.getWidth(),
				lblNewLabel_14.getHeight(), Image.SCALE_SMOOTH));

		JLabel lblNewLabel_14_1 = new JLabel("");
		lblNewLabel_14_1.setBounds(255, 209, 240, 99);
		ImageIcon btn3 = new ImageIcon(btnAux3.getImage().getScaledInstance(lblNewLabel_14_1.getWidth(),
				lblNewLabel_14_1.getHeight(), Image.SCALE_SMOOTH));

		JLabel lblNewLabel_12_1 = new JLabel("PROMEDIO DE NOTAS");
		lblNewLabel_12_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaCalculo nuevoCalculo2 = new VentanaCalculo(2, programa);
				nuevoCalculo2.setTitle("Registro de alumnos de " + materia);
				nuevoCalculo2.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_12_1.setForeground(Color.DARK_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_12_1.setForeground(Color.WHITE);
			}
		});

		JLabel lblNewLabel_12 = new JLabel("MINIMA NOTA");
		lblNewLabel_12.setBackground(Color.WHITE);
		lblNewLabel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaCalculo nuevoCalculo = new VentanaCalculo(1, programa);
				nuevoCalculo.setTitle("Registro de alumnos de " + materia);
				nuevoCalculo.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_12.setForeground(Color.DARK_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_12.setForeground(Color.WHITE);
			}
		});

		JLabel lblNewLabel_14_1_1 = new JLabel("");

		lblNewLabel_14_1_1.setBounds(255, 327, 240, 99);
		ImageIcon btn4 = new ImageIcon(btnAux4.getImage().getScaledInstance(lblNewLabel_14_1_1.getWidth(),
				lblNewLabel_14_1_1.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_14_1_1.setIcon(btn4);
		JLabel lblNewLabel_12_1_1 = new JLabel("CONSULTAR NOTA POR L.U");
		lblNewLabel_12_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaCalculo nuevoCalculo3 = new VentanaCalculo(3, programa);
				nuevoCalculo3.setTitle("Registro de alumnos de " + materia);
				nuevoCalculo3.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_12_1_1.setForeground(Color.DARK_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_12_1_1.setForeground(Color.WHITE);
			}
		});

		JLabel lblNewLabel_11_1 = new JLabel("");
		lblNewLabel_11_1.setBounds(536, 223, 250, 203);
		ImageIcon icoDecoAux1 = new ImageIcon(MenuOpciones.class.getResource(
				"/gui/imgproject/vecteezy_concept-illustration-of-isometric-female-student-riding-a_9160122.png"));
		ImageIcon icoDeco1 = new ImageIcon(icoDecoAux1.getImage().getScaledInstance(lblNewLabel_11_1.getWidth(),
				lblNewLabel_11_1.getHeight(), Image.SCALE_SMOOTH));

		JButton btnNewButton_1_2 = new JButton("Volver");
		btnNewButton_1_2.setBounds(675, 11, 130, 43);
		panel_5.add(btnNewButton_1_2);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				lblNewLabel.setVisible(true);
			}
		});
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setBackground(new Color(255, 102, 51));
		lblNewLabel_11_1.setIcon(icoDeco1);
		lblNewLabel_11_1.setBackground(Color.WHITE);
		panel_5.add(lblNewLabel_11_1);

		lblNewLabel_12_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_12_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_1_1.setForeground(Color.WHITE);
		lblNewLabel_12_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_12_1_1.setBounds(224, 342, 271, 54);
		panel_5.add(lblNewLabel_12_1_1);

		panel_5.add(lblNewLabel_14_1_1);

		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_12.setBounds(224, 102, 271, 54);
		panel_5.add(lblNewLabel_12);

		lblNewLabel_12_1.setBackground(Color.WHITE);
		lblNewLabel_12_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_12_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_12_1.setBounds(224, 224, 271, 54);
		panel_5.add(lblNewLabel_12_1);

		lblNewLabel_14_1.setIcon(btn3);
		panel_5.add(lblNewLabel_14_1);
		lblNewLabel_14.setIcon(btn2);

		panel_5.add(lblNewLabel_14);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(-5, 0, 250, 203);
		panel_5.add(lblNewLabel_11);
		ImageIcon icoDeco = new ImageIcon(icoDecoAux.getImage().getScaledInstance(lblNewLabel_11.getWidth(),
				lblNewLabel_11.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_11.setIcon(icoDeco);
		lblNewLabel_11.setBackground(new Color(255, 255, 255));

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(0, 0, 864, 490);
		panel_5.add(lblNewLabel_10);
		ImageIcon backAux = new ImageIcon(MenuOpciones.class.getResource("/gui/imgproject/abstract_background_8.png"));
		ImageIcon back = new ImageIcon(backAux.getImage().getScaledInstance(lblNewLabel_10.getWidth(),
				lblNewLabel_10.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_10.setIcon(back);

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.DARK_GRAY);
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Visualizá", null, panel_3, null);
		panel_3.setLayout(null);

		JComboBox comboBox_1_1 = new JComboBox();

		comboBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filtrar = (String) comboBox_1_1.getSelectedItem();
				int numOpcion = filtrarIndice(filtrar);
				model.setRowCount(0);
				for (Pair<Integer, Integer> pair : programa.notaDet(numOpcion)) {
					Object[] fila = new Object[2];
					fila[0] = pair.getKey();
					fila[1] = pair.getValue();
					model.addRow(fila);
				}

			}
		});

		comboBox_1_1.setForeground(Color.WHITE);
		comboBox_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBox_1_1.setBackground(new Color(153, 204, 255));
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] { "NOTA : 0", "NOTA : 1", "NOTA : 2", "NOTA : 3",
				"NOTA : 4", "NOTA : 5", "NOTA : 6", "NOTA : 7", "NOTA : 8", "NOTA : 9", "NOTA : 10" }));
		comboBox_1_1.setBounds(27, 13, 218, 22);
		panel_3.add(comboBox_1_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filtrar = (String) comboBox_1.getSelectedItem();
				if (filtrar == "TODOS LOS ALUMNOS") {
					model.setRowCount(0);
					for (IPosition<Pair<Integer, Integer>> pair : programa.visualizarAlumnos()) {
						Object[] fila = new Object[2];
						fila[0] = pair.element().getKey();
						fila[1] = pair.element().getValue();
						model.addRow(fila);
					}
				} else if (filtrar == "APROBADOS") {
					model.setRowCount(0);
					for (Pair<Integer, Integer> pair : programa.aprobados()) {
						Object[] fila = new Object[2];
						fila[0] = pair.getKey();
						fila[1] = pair.getValue();
						model.addRow(fila);
					}
				} else {
					model.setRowCount(0);
					for (Pair<Integer, Integer> pair : programa.desaprobados()) {
						Object[] fila = new Object[2];
						fila[0] = pair.getKey();
						fila[1] = pair.getValue();
						model.addRow(fila);
					}
				}
			}
		});
		comboBox_1.setBackground(new Color(153, 204, 255));
		comboBox_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBox_1.setForeground(new Color(255, 255, 255));
		comboBox_1
				.setModel(new DefaultComboBoxModel(new String[] { "TODOS LOS ALUMNOS", "APROBADOS", "DESAPROBADOS" }));
		comboBox_1.setBounds(255, 12, 218, 22);
		panel_3.add(comboBox_1);

		JLabel lblNewLabel_9_1 = new JLabel("NOTA");
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_9_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_9_1.setBounds(505, 100, 153, 27);
		panel_3.add(lblNewLabel_9_1);

		JLabel lblNewLabel_9 = new JLabel("LEGAJO");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_9.setForeground(new Color(0, 0, 51));
		lblNewLabel_9.setBounds(182, 100, 153, 27);
		panel_3.add(lblNewLabel_9);
		

		JButton btnNewButton_1_2_1 = new JButton("Volver");
		btnNewButton_1_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				lblNewLabel.setVisible(true);
			}
		});
		btnNewButton_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_2_1.setBackground(new Color(153, 204, 255));
		btnNewButton_1_2_1.setBounds(716, 11, 89, 23);
		panel_3.add(btnNewButton_1_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(MenuOpciones.class.getResource(
				"/gui/imgproject/vecteezy_gradient-mesh-abstract-background-with-light-color_23217074.jpg")));
		lblNewLabel_3_1.setBounds(123, 100, 638, 25);
		panel_3.add(lblNewLabel_3_1);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mayorOMenor = (String) comboBox.getSelectedItem();
				if (mayorOMenor == "ORDENAR DE MAYOR A MENOR") {
					model.setRowCount(0);
					for (Pair<Integer, Integer> pair : programa.alumnosDeMayorAMenor()) {
						Object[] fila = new Object[2];
						fila[0] = pair.getKey();
						fila[1] = pair.getValue();
						model.addRow(fila);
					}
				}

			}

		});
		comboBox.setBackground(new Color(153, 204, 255));
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "ORDENAR DE MAYOR A MENOR" }));

		comboBox.setBounds(488, 12, 218, 22);
		panel_3.add(comboBox);

		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(0, 0, 864, 490);
		ImageIcon backAux1 = new ImageIcon(MenuOpciones.class.getResource("/gui/imgproject/abstract_background_8.png"));
		ImageIcon back1 = new ImageIcon(backAux1.getImage().getScaledInstance(lblNewLabel_13.getWidth(),
				lblNewLabel_13.getHeight(), Image.SCALE_SMOOTH));
		
				
								
								
	
		pane.setBounds(123, 100, 638, 311);
		panel_3.add(pane);
		lblNewLabel_13.setIcon(back1);
		panel_3.add(lblNewLabel_13);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(background);

	}
	/**
	 * Crea un formatter para un JFormattedTextField
	 * @param i String con formato a establecer para el campo de texto.
	 * @return formatter del campo de texto.
	 */
	private MaskFormatter createFormater(String i) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(i);
		} catch (java.text.ParseException exc) {
			exc.getMessage();

		}
		return formatter;
	}
	
	/**
	 * Verifica que la nota sea válida 
	 * @param nota nota ingresada en el campo de texto.
	 * @return boolean que indica si es válida o no.
	 */

	private boolean chequearNota(int nota) {
		return (nota >= 0 && nota <= 10);
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
	 * Metodo que chequea si el LU o la nota es vacía.
	 * 
	 * @param lu String que representa el LU de un alumno.
	 * @param nota String que representa la nota del alumno.
	 * @return boolean que identifica si alguno de los campos es vacío o no.
	 */

	private boolean chequearDatosVacios(String lu, String nota) {
		return (!lu.isBlank() && !nota.isBlank());
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
	 * Recibe una opcion del JComboBox como String y devuelve un número que representa la nota buscada.
	 * @param filtrar String que representa la opción del JComboBox.
	 * @return nota buscada.
	 */

	private Integer filtrarIndice(String filtrar) {
		Integer i = 0;
		switch (filtrar) {
		case "NOTA : 0": {
			i = 0;
			return i;
		}
		case "NOTA : 1": {
			i = 1;
			return i;
		}
		case "NOTA : 2": {
			i = 2;
			return i;
		}
		case "NOTA : 3": {
			i = 3;
			return i;
		}
		case "NOTA : 4": {
			i = 4;
			return i;
		}
		case "NOTA : 5": {
			i = 5;
			return i;
		}
		case "NOTA : 6": {
			i = 6;
			return i;
		}
		case "NOTA : 7": {
			i = 7;
			return i;
		}
		case "NOTA : 8": {
			i = 8;
			return i;
		}
		case "NOTA : 9": {
			i = 9;
			return i;
		}
		case "NOTA : 10": {
			i = 10;
			return i;
		}
		}
		return i;
	}
}
