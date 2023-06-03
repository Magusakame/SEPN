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
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
public class TelaCadastroAnao extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldSenha;
	private JTextField textFieldCPF;
	private JTextField textFieldIdade;
	private JTextField textFieldCaminhoPDF;
	private JTextField textFieldNomeArquivo;
	private File arquivo;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JLabel lblIdade;
	private JButton btnSalvar;
	private JPasswordField passwordFieldSenha;
	private JButton btnSair;
	private JTextArea textAreaDescricao;
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
	public TelaCadastroAnao() {
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
		textFieldNome.setBounds(10, 33, 146, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(10, 77, 146, 19);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(10, 124, 146, 19);
		contentPane.add(passwordFieldSenha);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setToolTipText("");
		textFieldCPF.setBounds(282, 33, 144, 19);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(282, 77, 34, 19);
		contentPane.add(textFieldIdade);
		textFieldIdade.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 20, 45, 13);
		contentPane.add(lblNome);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 62, 45, 13);
		contentPane.add(lblEmail);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 106, 45, 13);
		contentPane.add(lblSenha);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(282, 20, 45, 13);
		contentPane.add(lblCPF);
		
		lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(282, 62, 45, 13);
		contentPane.add(lblIdade);
		
		JLabel lblDescricao= new JLabel("Descrição:");
		lblDescricao.setBounds(282, 106, 73, 13);
		contentPane.add(lblDescricao);
		
		textAreaDescricao = new JTextArea();
		textAreaDescricao.setBounds(282, 121, 144, 61);
		contentPane.add(textAreaDescricao);
		textAreaDescricao.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarTexto();
			}

			private void salvarTexto() {
			        String Nome = textFieldNome.getText();
			        String Email = textFieldEmail.getText();
			        String Senha = passwordFieldSenha.getText();
			        String CPF = textFieldCPF.getText();
			        String Idade = textFieldIdade.getText();
			        String Descricao = textAreaDescricao.getText();
			        String caminhoPDF = textFieldCaminhoPDF.getText();

			           try {
			        	   FileOutputStream fos = new FileOutputStream(Nome+"anoes.txt", true);
			        	   
			        if (!Nome.isEmpty() && !Email.isEmpty() && !Senha.isEmpty() && !CPF.isEmpty() && !Idade.isEmpty() && !Descricao.isEmpty() && !caminhoPDF.isEmpty()) {
			            	OutputStreamWriter osw = new OutputStreamWriter(fos);
			                BufferedWriter bufferedWriter = new BufferedWriter(osw);
			                bufferedWriter.write(Nome);
			                bufferedWriter.newLine();
			                bufferedWriter.write(Email);			              
			                bufferedWriter.newLine();			                
			                bufferedWriter.write(Senha);
			                bufferedWriter.newLine();
			                bufferedWriter.write(CPF);
			                bufferedWriter.newLine();
			                bufferedWriter.write(Idade);
			                bufferedWriter.newLine();
			                bufferedWriter.write(Descricao);
			                bufferedWriter.newLine();
			                bufferedWriter.write(caminhoPDF);
			                bufferedWriter.newLine();
			                
			                bufferedWriter.close();
			                
			                JOptionPane.showMessageDialog(null, "Cadastro Feito com Sucesso!");
			                textFieldNome.setText("");
			                textFieldEmail.setText("");
			                passwordFieldSenha.setText("");
			                textFieldCPF.setText("");
			                textFieldIdade.setText("");
			                textAreaDescricao.setText("");
			                textFieldCaminhoPDF.setText("");

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
	        
		
		
		textFieldCPF.addKeyListener(new KeyAdapter() {
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
		
		textFieldIdade.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // Verifica se o caractere digitado não é um número
                if (!Character.isDigit(c)) {
                    // Se não for um número, não permite a entrada
                    e.consume();
                }
            }
        });
		
		btnSalvar.setBounds(282, 232, 85, 21);
		contentPane.add(btnSalvar);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(e-> {
			dispose();
		
		});
		
		btnSair.setForeground(Color.RED);
		btnSair.setBounds(10, 232, 85, 21);
		contentPane.add(btnSair);
		
		JLabel lblAnexarPDF = new JLabel("Anexar URL do Currículo:");
		lblAnexarPDF.setBounds(10, 153, 150, 25);
		contentPane.add(lblAnexarPDF);

		textFieldCaminhoPDF = new JTextField();   
		textFieldCaminhoPDF.setBounds(10, 175, 146, 22);
		contentPane.add(textFieldCaminhoPDF);
		textFieldCaminhoPDF.setColumns(10);
		
	}
	
}