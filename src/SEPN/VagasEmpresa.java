package SEPN;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
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

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VagasEmpresa extends JFrame {

    private JPanel contentPane;
    private JTextArea textAreaVaga;
    private JTextField textFieldNomeVaga;
    private JTextField textFieldEmpresa;
    private JTextField textFieldEmailEmpresa;
    private JTextField textFieldRequisitos;
    private File arquivo;
    private JTextArea textAreaDescricao;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VagasEmpresa frame = new VagasEmpresa();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VagasEmpresa() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 213, 249));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnAdicionar = new JButton("Adicionar Vagas");
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame AdicionarVagas = new JFrame();
                AdicionarVagas.setTitle("Adicionar Vaga");
                AdicionarVagas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                AdicionarVagas.setBounds(100, 100, 450, 300);
                
                JPanel contentPane = new JPanel();
                contentPane.setLayout(null);
                AdicionarVagas.setContentPane(contentPane);
                AdicionarVagas.setVisible(true);

                JButton btnSair = new JButton("Sair");
                btnSair.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        AdicionarVagas.dispose();
                    }
                });
                btnSair.setBounds(10, 204, 85, 21);
                contentPane.add(btnSair);

                textFieldNomeVaga = new JTextField();
                textFieldNomeVaga.setBounds(10, 40, 147, 19);
                contentPane.add(textFieldNomeVaga);
                textFieldNomeVaga.setColumns(10);

                textFieldEmailEmpresa = new JTextField();
                textFieldEmailEmpresa.setBounds(10, 107, 147, 19);
                contentPane.add(textFieldEmailEmpresa);
                textFieldEmailEmpresa.setColumns(10);

                JLabel lblNome = new JLabel("Vaga: ");
                lblNome.setBounds(10, 17, 45, 13);
                contentPane.add(lblNome);

                JLabel lblEmail = new JLabel("Email: ");
                lblEmail.setBounds(10, 89, 45, 13);
                contentPane.add(lblEmail);

                JLabel lblRequisitos = new JLabel("Requisitos: ");
                lblRequisitos.setBounds(243, 14, 61, 13);
                contentPane.add(lblRequisitos);

                textFieldRequisitos = new JTextField();
                textFieldRequisitos.setBounds(243, 40, 183, 19);
                contentPane.add(textFieldRequisitos);
                textFieldRequisitos.setColumns(10);
                
                textFieldEmpresa = new JTextField();
                textFieldEmpresa.setBounds(10, 170, 147, 19);
                contentPane.add(textFieldEmpresa);
                textFieldEmpresa.setColumns(10);


                JLabel lblEmpresa = new JLabel("Nome da Empresa: ");
                lblEmpresa.setBounds(10, 137, 91, 13);
                contentPane.add(lblEmpresa);

                JButton btnSalvarVaga = new JButton("Adicionar");
                btnSalvarVaga.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SalvarVaga();
                    }
                });
                btnSalvarVaga.setBounds(243, 204, 85, 21);
                contentPane.add(btnSalvarVaga);
                
                textAreaDescricao = new JTextArea();
                textAreaDescricao.setText("");
                textAreaDescricao.setBounds(243, 100, 131, 96);
                contentPane.add(textAreaDescricao);
                
                JLabel lblDescricao = new JLabel("Descrição da Vaga");
                lblDescricao.setBounds(243, 79, 116, 13);
                contentPane.add(lblDescricao);
            }
        });
        btnAdicionar.setBounds(10, 10, 116, 21);
        contentPane.add(btnAdicionar);
        
        textAreaVaga = new JTextArea();
        textAreaVaga.setBounds(10, 35, 416, 182);
        contentPane.add(textAreaVaga);

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnSair.setForeground(Color.RED);
        btnSair.setBounds(10, 232, 85, 21);
        contentPane.add(btnSair);

        
        JButton btnApagarVagas = new JButton("Apagar Vagas");
        btnApagarVagas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ApagarVagas();
            }
        });
        btnApagarVagas.setBounds(136, 10, 116, 21);
        contentPane.add(btnApagarVagas);
        
    }

    private void SalvarVaga() {
        String Nome = textFieldNomeVaga.getText();
        String Email = textFieldEmailEmpresa.getText();
        String Requisitos = textFieldRequisitos.getText();
        String Empresa = textFieldEmpresa.getText();
        String Descricao = textAreaDescricao.getText();

        try {
            if (!Nome.isEmpty() && !Email.isEmpty() && !Requisitos.isEmpty() && !Empresa.isEmpty() && !Descricao.isEmpty()) {
                arquivo = new File(Nome + "Vaga.txt");
                FileWriter fileWriter = new FileWriter(arquivo, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("Vaga: " + Nome);
                bufferedWriter.newLine();
                bufferedWriter.write("Nome da Empresa: " + Empresa);
                bufferedWriter.newLine();
                bufferedWriter.write("Email para contato: " + Email);
                bufferedWriter.newLine();
                bufferedWriter.write("Requisitos: " + Requisitos);
                bufferedWriter.newLine();
                bufferedWriter.write("Descrição: " + Descricao);
                bufferedWriter.newLine();
                
                bufferedWriter.close();

                JOptionPane.showMessageDialog(null, "Vaga Adicionada!");
              
                textFieldNomeVaga.setText("");
                textFieldEmpresa.setText("");
                textFieldEmailEmpresa.setText("");
                textFieldRequisitos.setText("");
                textAreaDescricao.setText("");
                
                // Atualizar o conteúdo do textAreaVaga com as vagas salvas
                FileReader fileReader = new FileReader(arquivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                bufferedReader.close();
                String vagasSalvas = sb.toString();
                textAreaVaga.setText(vagasSalvas);
            } else {
                JOptionPane.showMessageDialog(null, "Por Favor, Preencha todos os campos");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar os Dados");
            ex.printStackTrace();
        }
    }

    private void ApagarVagas() {
        if (arquivo != null && arquivo.exists()) {
            if (arquivo.delete()) {
                textAreaVaga.setText("");
                JOptionPane.showMessageDialog(null, "Vagas Apagadas!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao Apagar as Vagas");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há vagas para apagar");
        }
    }
}
