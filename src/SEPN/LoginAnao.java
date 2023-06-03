package SEPN;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LoginAnao extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldNome;
	private JPasswordField passwordFieldSenha;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginAnao frame = new LoginAnao();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    void BuscarArquivo() {
        File arquivo = new File(System.getProperty("user.dir") + "/" + textFieldNome.getText() + "anoes.txt");
        if (arquivo.exists()) {
            boolean liberado = false;
            FileReader fileReader;
            try {
                fileReader = new FileReader(arquivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String linha;
                int i = 0;
                while ((linha = bufferedReader.readLine()) != null) {
                    if (i == 2 && linha.equals(passwordFieldSenha.getText())) {
                        liberado = true;
                    }
                    i++;
                }
                fileReader.close();
                bufferedReader.close();

                passwordFieldSenha.setText("");

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if (liberado) {

                JFrame perfilServidor = new JFrame();
                perfilServidor.setTitle("Perfil Servidor");
                perfilServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                perfilServidor.setBounds(100, 100, 450, 300);
        		contentPane.setBackground(new Color(196, 213, 249));

                JPanel contentPane = new JPanel();
                contentPane.setLayout(null);

                JButton btnBuscar = new JButton("Buscar");
                btnBuscar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new BuscarVagas().setVisible(true);
                    }
                });

                contentPane.add(btnBuscar);
                btnBuscar.setBounds(10, 65, 85, 21);
                contentPane.add(btnBuscar);

                JButton btnSairPerfil = new JButton("Sair");
                btnSairPerfil.setForeground(Color.RED);
                btnSairPerfil.setBounds(10, 232, 85, 21);
                contentPane.add(btnSairPerfil);
                btnSairPerfil.addActionListener(e -> {
                    perfilServidor.dispose();
                });

                JTextArea Dados = new JTextArea();
                Dados.setBounds(151, 26, 275, 227);
                contentPane.add(Dados);
                Dados.setEditable(false);        		
                Dados.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                Dados.setBackground(new Color(196, 213, 249));
                Font fonte = new Font("Tahoma 10", Font.PLAIN, 15);
                Dados.setFont(fonte);


                StringBuilder conteudo = new StringBuilder();
                int numeroLinha = 0;
                String textoLabel = "";
                try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    String[] legendas = {"Nome: ", "Email: ", "CPF: ", "Idade: ", "Descrição: ", "URL do Currículo: "};
                    int indiceLegendas = 0;
                    while ((linha = reader.readLine()) != null) {
                        numeroLinha++;
                        if (numeroLinha != 3) {
                            if (indiceLegendas < legendas.length) {
                                conteudo.append(legendas[indiceLegendas]).append(" ").append(linha).append("\n");
                                indiceLegendas++;
                            }
                            if (numeroLinha == 1) {

                                textoLabel = linha;
                            }
                        }
                    }

                    JLabel label = new JLabel("Bem-vindo, " + textoLabel + "!");
                    label.setBounds(10, 10, 200, 13);
                    contentPane.add(label);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                Dados.setText(conteudo.toString());

                perfilServidor.setContentPane(contentPane);
                perfilServidor.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Senha errada");
            }
        }
    }

    public LoginAnao() {
        setTitle("Login Servidor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 213, 249));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnCadastrar = new JButton("Ainda não é Cadastrado? Clique Aqui");
        btnCadastrar.setBackground(UIManager.getColor("Button.disabledShadow"));
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroAnao().setVisible(true);
            }
        });
        btnCadastrar.setBounds(169, 242, 257, 21);
        contentPane.add(btnCadastrar);

        textFieldNome = new JTextField();
        textFieldNome.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldNome.setBounds(146, 43, 154, 19);
        contentPane.add(textFieldNome);
        textFieldNome.setColumns(10);

        JLabel lblEmail = new JLabel("Nome");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setBounds(198, 20, 45, 13);
        contentPane.add(lblEmail);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setLocation(186, 154);
        btnEntrar.setSize(73, 21);
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BuscarArquivo();
            }
        });
        contentPane.add(btnEntrar);

        passwordFieldSenha = new JPasswordField();
        passwordFieldSenha.setHorizontalAlignment(SwingConstants.CENTER);
        passwordFieldSenha.setColumns(10);
        passwordFieldSenha.setBounds(146, 111, 154, 19);
        contentPane.add(passwordFieldSenha);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
        lblSenha.setBounds(198, 88, 45, 13);
        contentPane.add(lblSenha);

        JButton btnSair = new JButton("Sair");
        btnSair.setForeground(Color.RED);
        btnSair.setBounds(10, 232, 85, 21);
        contentPane.add(btnSair);
        btnSair.addActionListener(e -> {
            dispose();
        });

    }
}