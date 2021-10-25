package application1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaThread extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel jPanel = new JPanel(new GridBagLayout()); // Paninel de Componentes*

	private JLabel decricao1 = new JLabel("Nome");
	private JTextField mostrarTempo1 = new JTextField();

	private JLabel decricao2 = new JLabel("E-mail");
	private JTextField mostrarTempo2 = new JTextField();

	private static JButton JBStart = new JButton("Gerar");
	private static JButton JBStop = new JButton("Stop");

	private  ImplementacaoTreadFilha fila = new ImplementacaoTreadFilha();

	public TelaThread() {

		setTitle("PROGRAMA THREAD");
		setSize(new Dimension(250, 300)); // dimensão em pix
		setLocationRelativeTo(null); //
		setResizable(false); // centralizar

		GridBagConstraints gridBagConstraints = new GridBagConstraints(); // gerenciado de posionvamento e componentes
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = GridBagConstraints.WEST; // Posição alinha a esquerda
		gridBagConstraints.insets = new Insets(5, 10, 5, 5); //

		decricao1.setPreferredSize(new Dimension(200, 25));
		jPanel.add(decricao1, gridBagConstraints); // add  a tela

		mostrarTempo1.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		mostrarTempo1.setEditable(true); // não habilitar p/ editar
		jPanel.add(mostrarTempo1, gridBagConstraints);

		decricao2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(decricao2, gridBagConstraints); // add  a tela

		mostrarTempo2.setPreferredSize(new Dimension(200, 25));
		mostrarTempo2.setEditable(true); // não habilitar p/ editar
		gridBagConstraints.gridy++;
		jPanel.add(mostrarTempo2, gridBagConstraints);

		gridBagConstraints.gridwidth = 1;
		JBStart.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jPanel.add(JBStart, gridBagConstraints);

		JBStop.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jPanel.add(JBStop, gridBagConstraints);
		fila.start(); //roda o thread
		
		JBStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { //Executar o clique no botao add
				
				if(fila == null) { // Verifica se é null e refazar o processo
					
					fila = new ImplementacaoTreadFilha();
					
					fila.start(); // iniciar
					
				}
				
				
				
				for(int qtd = 0; qtd < 50 ; qtd ++ ) { // Com um clique faz 50x o processo de add
				
				
				ObjThread  ObjThread = new ObjThread();
				ObjThread.setNome(mostrarTempo1.getText());
				ObjThread.setEmail(mostrarTempo2.getText() + "  quantidade:" + qtd);

				fila.add(ObjThread); //Adiciona os nomes a pilha
				}
			}
		});

		JBStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			fila.stop();
			fila = null ;
			
				
			}
		});

		

		
		add(jPanel, BorderLayout.WEST);
		setVisible(true); // mostra tela

	}

	

}
