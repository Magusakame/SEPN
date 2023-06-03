package SEPN;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setTitle("Tela Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 213, 249));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAnao = new JButton("Servidor");
		btnAnao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginAnao().setVisible(true);
			}
		});
		btnAnao.setBounds(170, 83, 85, 21);
		contentPane.add(btnAnao);
		
		JButton btnEmpresa = new JButton("Empresa");
		btnEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginEmpresa().setVisible(true);
			}
		});
		btnEmpresa.setBounds(170, 151, 85, 21);
		contentPane.add(btnEmpresa);
	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagens/SEPN.png")));
		lblNewLabel.setBounds(-35, 10, 450, 226);
		contentPane.add(lblNewLabel);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaSobre().setVisible(true);
			}
		});
		btnSobre.setBounds(10, 232, 85, 21);
		contentPane.add(btnSobre);
	}
}
