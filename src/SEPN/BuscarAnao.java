package SEPN;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BuscarAnao extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBuscar;
	private JTextArea resultadoBusca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarAnao frame = new BuscarAnao();
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
	public BuscarAnao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 213, 249));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(10, 21, 248, 19);
		contentPane.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
        btnSair.setForeground(Color.RED);
        btnSair.setBounds(10, 232, 85, 21);
        contentPane.add(btnSair);
        btnSair.addActionListener(e -> {
            dispose();
        });
		
        resultadoBusca = new JTextArea();
        resultadoBusca.setBounds(10, 73, 440, 150);
        resultadoBusca.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoBusca);
        getContentPane().add(scrollPane);
        
        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				 PesquisarArquivo(System.getProperty("user.dir")+"/"+textFieldBuscar.getText()+"anoes.txt");                
            }
        });
        btnPesquisar.setBounds(268, 20, 107, 21);
        contentPane.add(btnPesquisar);

		
	}
	
	private void PesquisarArquivo(String caminhoArquivo) {
        try {
            // Cria um BufferedReader para ler o arquivo
            BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
            
            // Lê a primeira linha do arquivo
            String primeiraLinha = reader.readLine();

            // Se a primeira linha não for nula, exibe todas as linhas
            if (primeiraLinha != null) {
                StringBuilder conteudoArquivo = new StringBuilder();
                int numeroLinha = 0;
                String linha;
                String[] legendas = {"Email: ", "CPF: ", "Idade: ", "Descrição: ", "URL Currículo: "};
                int indiceLegendas = 0;
                while ((linha = reader.readLine()) != null) {
                    numeroLinha++;
                    if (numeroLinha != 2) {
                        if (indiceLegendas < legendas.length) {
                            conteudoArquivo.append(legendas[indiceLegendas]).append(" ").append(linha).append("\n");
                            indiceLegendas++;
                        }
                    }
                }
                conteudoArquivo.append("\n");
        		
                // Define o conteúdo do JTextArea como o conteúdo do arquivo
                TextArea resultadoBusca = new TextArea();
                resultadoBusca.setBounds(10, 73, 440, 150);
        		contentPane.add(resultadoBusca);
        		resultadoBusca.setEditable(false);
        		JScrollPane scrollPane = new JScrollPane(resultadoBusca);
        		getContentPane().add(scrollPane);
        		resultadoBusca.setText(conteudoArquivo.toString());
        		
     
                String[] linhas = conteudoArquivo.toString().split("\n");
                
            
            } else {
                // Exibe um aviso caso o arquivo esteja vazio
                JOptionPane.showMessageDialog(this, "O arquivo está vazio.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

            // Fecha o BufferedReader
            reader.close();
        } catch (Exception e) {
            // Exibe um aviso caso ocorra um erro ao ler o arquivo
            JOptionPane.showMessageDialog(this, "Servidor não existe: ");
        }
	}
}