package SEPN;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JPasswordField;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class TelaCadastroEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldSenha;
	private JTextField textFieldCNPJ;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JButton btnSalvar;
	private JPasswordField passwordFieldSenha;
	private JButton btnSair;
	private JLabel lblSEPN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAnao frame = new TelaCadastroAnao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 * @return 
	 */
	public TelaCadastroEmpresa() {
		setTitle("Tela de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 213, 249));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 51, 146, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(10, 113, 146, 19);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(10, 174, 146, 19);
		contentPane.add(passwordFieldSenha);
		
		textFieldCNPJ = new JTextField();
		textFieldCNPJ.setToolTipText("");
		textFieldCNPJ.setBounds(282, 51, 144, 19);
		contentPane.add(textFieldCNPJ);
		textFieldCNPJ.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 31, 45, 13);
		contentPane.add(lblNome);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 90, 45, 13);
		contentPane.add(lblEmail);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 151, 45, 13);
		contentPane.add(lblSenha);
		
		JLabel lblCNPJ = new JLabel("CNPJ:");
		lblCNPJ.setBounds(282, 28, 45, 13);
		contentPane.add(lblCNPJ);
		
	
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarTexto();
			}

			private void salvarTexto() {
			        String Nome = textFieldNome.getText();
			        String Email = textFieldEmail.getText();
			        String Senha = passwordFieldSenha.getText();
			        String CNPJ = textFieldCNPJ.getText();
			           try {
			  			 FileOutputStream fos = new FileOutputStream(Email+"empresa.txt", true);
	                
			        if (!Nome.isEmpty() && !Email.isEmpty() && !Senha.isEmpty() && !CNPJ.isEmpty()) {
			        	
			            	OutputStreamWriter osw = new OutputStreamWriter(fos);
			                BufferedWriter bufferedWriter = new BufferedWriter(osw);
			                bufferedWriter.write(Nome);
			                bufferedWriter.newLine();
			                bufferedWriter.write(Email);			              
			                bufferedWriter.newLine();			                
			                bufferedWriter.write(Senha);
			                bufferedWriter.newLine();
			                bufferedWriter.write(CNPJ);
			                bufferedWriter.newLine();
			                
			                bufferedWriter.close();
			                
			            
			     	        
			                JOptionPane.showMessageDialog(null, "Cadastro Feito com Sucesso!");
			                textFieldNome.setText("");
			                textFieldEmail.setText("");
			                passwordFieldSenha.setText("");
			                textFieldCNPJ.setText("");
			            } else {
							JOptionPane.showMessageDialog(null, "Por Favor, Preencha todos os campos");	
				        }
			        }
			        catch (IOException ex) {
							JOptionPane.showMessageDialog(null, "Erro ao Salvar os Dados");	
			                ex.printStackTrace();
			            }
			        }
		});
	        
		
		
		textFieldCNPJ.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // Verifica se o caractere digitado não é um número
                if (!Character.isDigit(c)) {
                    // Se não for um número, consome o evento (não permite a entrada)
                    e.consume();
                }
            }
        });
		
		btnSalvar.setBounds(282, 173, 85, 21);
		contentPane.add(btnSalvar);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(e-> {
			dispose();
		
		});
		
		btnSair.setForeground(Color.RED);
		btnSair.setBounds(10, 232, 85, 21);
		contentPane.add(btnSair);
		
		lblSEPN = new JLabel("");
		lblSEPN.setIcon(new ImageIcon(TelaCadastroEmpresa.class.getResource("/Imagens/SEPN.png")));
		lblSEPN.setBounds(-51, -10, 533, 263);
		contentPane.add(lblSEPN);
		
		
	}
	

}
