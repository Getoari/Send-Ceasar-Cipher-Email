package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.sun.mail.util.MailConnectException;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;



public class sendEmail {
	
	boolean programFinished = false;
	int count = 0;

	private JFrame frmDergoEmailTe;
	private JTextField txtMarresi;
	private JTextField txtCelesi;
	private JTextField txtsubjekti;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtEmailiJuaj;
	private JPasswordField txtFjalekalimiJuaj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sendEmail window = new sendEmail();
					window.frmDergoEmailTe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public sendEmail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDergoEmailTe = new JFrame();
		frmDergoEmailTe.getContentPane().setForeground(Color.RED);
		frmDergoEmailTe.setTitle("Dergo email te enkriptuar me Cesar GMAIL");
		frmDergoEmailTe.setBounds(100, 100, 446, 526);
		frmDergoEmailTe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDergoEmailTe.getContentPane().setLayout(null);
		
		JLabel lblDerguesi = new JLabel("Marresi/at:");
		lblDerguesi.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblDerguesi.setBounds(31, 149, 118, 14);
		frmDergoEmailTe.getContentPane().add(lblDerguesi);
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setVerticalAlignment(SwingConstants.TOP);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInfo.setForeground(Color.BLACK);
		lblInfo.setBounds(31, 400, 255, 51);
		frmDergoEmailTe.getContentPane().add(lblInfo);
		
		txtMarresi = new JTextField();
		txtMarresi.setToolTipText("Emaili1,Emaili2,Emaili3,.....");
		txtMarresi.setColumns(10);
		txtMarresi.setBounds(31, 171, 155, 20);
		frmDergoEmailTe.getContentPane().add(txtMarresi);
		
		JLabel lblMesazhi = new JLabel("Mesazhi:");
		lblMesazhi.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblMesazhi.setBounds(31, 266, 105, 14);
		frmDergoEmailTe.getContentPane().add(lblMesazhi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Celesi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(219, 159, 128, 83);
		frmDergoEmailTe.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rbRandom = new JRadioButton("Random");
		rbRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCelesi.setEditable(false);
			}
		});
		rbRandom.setBounds(17, 20, 89, 23);
		panel_1.add(rbRandom);
		rbRandom.setToolTipText("Ky opsion gjeneron nje celes te cfaredoshem!");
		rbRandom.setSelected(true);
		buttonGroup.add(rbRandom);
		
		JRadioButton rbCaktoCelesin = new JRadioButton("");
		rbCaktoCelesin.setBounds(17, 46, 18, 23);
		panel_1.add(rbCaktoCelesin);
		rbCaktoCelesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCelesi.setEditable(true);
			}
		});
		buttonGroup.add(rbCaktoCelesin);
		
		txtCelesi = new JTextField();
		txtCelesi.setBounds(41, 46, 65, 24);
		panel_1.add(txtCelesi);
		txtCelesi.setEditable(false);
		txtCelesi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// validimi per me shenu vetem numra
				char vchar = e.getKeyChar();
				
				if (!(Character.isDigit(vchar)))
					e.consume();

			}
		});
		txtCelesi.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Email Autentifikimi", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(31, 24, 316, 100);
		frmDergoEmailTe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmailiJuaj = new JLabel("Gmaili Juaj:");
		lblEmailiJuaj.setBounds(30, 33, 65, 14);
		panel.add(lblEmailiJuaj);
		
		txtEmailiJuaj = new JTextField();
		txtEmailiJuaj.setText("@gmail.com");
		txtEmailiJuaj.setToolTipText("Shkuajeni emailin tuaj ne Gmail!");
		txtEmailiJuaj.setBounds(105, 30, 178, 20);
		panel.add(txtEmailiJuaj);
		txtEmailiJuaj.setColumns(10);
		
		JLabel lblFjalekalimi = new JLabel("Fjalekalimi:");
		lblFjalekalimi.setBounds(30, 61, 65, 14);
		panel.add(lblFjalekalimi);
		
		txtFjalekalimiJuaj = new JPasswordField();
		txtFjalekalimiJuaj.setBounds(105, 58, 178, 20);
		panel.add(txtFjalekalimiJuaj);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 291, 372, 100);
		frmDergoEmailTe.getContentPane().add(scrollPane);
		
		JTextArea txtMesazhi = new JTextArea();
		scrollPane.setViewportView(txtMesazhi);
		txtMesazhi.setWrapStyleWord(true);
		txtMesazhi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int count = txtMesazhi.getText().length();
				if ( count >= 1000) {
					e.consume();
					try {
						txtMesazhi.setText(txtMesazhi.getText().substring(0, 999));						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				lblInfo.setText("Numri i karaktereve: " + count + " nga 999");
			}
		});
		txtMesazhi.setLineWrap(true);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		progressBar.setBounds(10, 462, 146, 14);
		frmDergoEmailTe.getContentPane().add(progressBar);
		
		JButton btnDergo = new JButton("Dergo");
		btnDergo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
							
				
	            Thread go = new Thread()
	            {
	                public void run()
	                {
	                	lblInfo.setText("Mesazhi eshte duke u derguar!");
                        
                        try {
                        	lblInfo.setForeground(Color.RED);
                        	progressBar.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
                        	
        			        Properties props = new Properties();
        			        props.put("mail.smtp.host", "smtp.gmail.com"); 
        			        props.put("mail.smtp.auth", "true");
        			        props.put("mail.debug", "true"); 
        			        props.put("mail.smtp.starttls.enable", "true");
        			        props.put("mail.smtp.port", "587");
        			        props.put("mail.smtp.socketFactory.port", "587");
        			        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        			        props.put("mail.smtp.socketFactory.fallback", "true");
        			
        			        Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
        			            
        						@SuppressWarnings("deprecation")
								protected PasswordAuthentication getPasswordAuthentication() {
        			                return new PasswordAuthentication(txtEmailiJuaj.getText(), txtFjalekalimiJuaj.getText());
        			            }
        			        });

        			        
        			        //mailSession.setDebug(true); // Enable the debug mode
        			        Message msg = new MimeMessage( mailSession );
        			        
        			        // Caktimi i celesit
        			        int celesi;
        			        if ( rbRandom.isSelected() ) {
        			        	// Generimi i celesit random
        			        	Random r = new Random();
        			        	celesi = r.nextInt(26-1)+1;
        			        } else {
        			        	celesi = Integer.parseInt(txtCelesi.getText()) % 26;
        			        }
        			        

        			        //--[ Set the FROM, TO, DATE and SUBJECT fields
        			        msg.setFrom( new InternetAddress( txtEmailiJuaj.getText() ));
        			        msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse( txtMarresi.getText()) );
        			        msg.setSentDate( new Date());
        			        msg.setSubject( AlgoritmiCesarit.Enkripto(txtsubjekti.getText(), celesi));

        			        //--[ Create the body of the mail
        			        msg.setText( AlgoritmiCesarit.Enkripto(txtMesazhi.getText(), celesi));
        			        
        			        progressBar.setValue(60);
        			        
        			        // Validimet
        			        if ( !EmailValidate.isGmail(txtEmailiJuaj.getText()) ) {
        			        	progressBar.setForeground(Color.RED);
        			        	lblInfo.setText("Emaili juaj duhet te jete Gmail!");
        			        	
        			        } else if ( txtMarresi.getText().equals("")) {
        			        	progressBar.setForeground(Color.RED);
        			        	lblInfo.setText("Ju lutem plotesoni fushen marresi!");
        			        	
        			        } else if ( !EmailValidate.checkEmail(txtMarresi.getText()) ) {
        			        	progressBar.setForeground(Color.RED);
        			        	lblInfo.setText("Ju lutem kontrolloni emailat!");
        			        	
        			        } else if (txtMesazhi.getText().equals("")) {
        			        	progressBar.setForeground(Color.RED);
        			        	lblInfo.setText("Ju lutem shkruajeni mesazhin!");
        			        	
        			        } else if( celesi == 0 ) {
        			        	progressBar.setForeground(Color.RED);
        			        	lblInfo.setText("Celesi i dhene nuk bene enkriptim!");
        			        	
        			        } else {
        			        	//--[ Ask the Transport class to send our mail message
        			        	Transport.send( msg );
        			        	
        			        	lblInfo.setForeground(Color.BLUE);
        			        	lblInfo.setText("Mesazhi u dergua! (celesi: " + celesi +")");
        			        	progressBar.setValue(100);
        			        }
        			        
        			        
        				} catch (MailConnectException e1) {
        					lblInfo.setText("<html><p>Mesazhi nuk mund te dergohet!</p><p>Ju lutem kontrolloni lidhjen me internet!</p></html>");
        					progressBar.setForeground(Color.RED);
        					
        				} catch (AuthenticationFailedException e2) {
        					lblInfo.setText("<html><p>Kontrolloni te dhenat autentifikuese.\n</p><p><small>Nese jane ne rregull atehere sigurohuni se \"Access for less secure apps\" eshte \"on\" ne llogarine tuaj ne Gmail!</small></p></html>");
        					progressBar.setForeground(Color.RED);

        				} catch (SendFailedException e3) {
        					lblInfo.setText("Mesazhi nuk mund te dergohet! Ju lutem kontrolloni lidhjen ne Interent!");
        					progressBar.setForeground(Color.RED);
        					
        				} catch (AddressException e4) {
        					lblInfo.setText("<html><p>Mesazhi nuk mund te dergohet ju lutem kontrolloni email adresat!</p>"
        							+ "<p>Nese dergoni ne shume adresa ndani emailat me (,) !</p></html>");
        					progressBar.setForeground(Color.RED);
        					
        				} catch (Exception e ){
        					lblInfo.setText("Ka ndodhur nje gabim!");
        					JOptionPane.showMessageDialog(null, e);			
        					progressBar.setForeground(Color.RED);
        				} 
                        
	                }
	            };
	            go.start();
				
				
			}
		});
		btnDergo.setBounds(296, 406, 107, 39);
		frmDergoEmailTe.getContentPane().add(btnDergo);
		
		JLabel lblSubjekti = new JLabel("Subjekti:");
		lblSubjekti.setFont(new Font("Courier New", Font.PLAIN, 15));
		lblSubjekti.setBounds(31, 202, 105, 14);
		frmDergoEmailTe.getContentPane().add(lblSubjekti);
		
		txtsubjekti = new JTextField();
		txtsubjekti.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int count = txtsubjekti.getText().length();
				if ( count >= 100 ) {
					e.consume();
					try {
						txtsubjekti.setText(txtsubjekti.getText().substring(0, 99));						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				lblInfo.setText("Numri i karaktereve: " + count + " nga 99");
				
			}
		});
		txtsubjekti.setColumns(10);
		txtsubjekti.setBounds(31, 222, 155, 20);
		frmDergoEmailTe.getContentPane().add(txtsubjekti);
		
		

		
	}
}
