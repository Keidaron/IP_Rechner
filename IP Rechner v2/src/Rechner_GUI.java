import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Rechner_GUI{

	private RechnerLogic thisLogic = new RechnerLogic();
	
	private JTextField tF_ipAlsBinar;
	private JTextField tF_ipAlsHexa;
	private JTextField tF_ipMitSuffix;
	private JTextField tF_Netzadresse;
	private JTextField tF_ErsteHost;
	private JTextField tF_LetzteHost;
	private JTextField tF_Broadcastadresse;
	private JTextField tF_ANzahlHosts;
	private JTextField tF_BesondereIP;
	private static JTextField tF_IPAdresse;
	private static JTextField tF_Subnetzmaske;
	
	public void init_gui() {
		
		// Das Fenster selbst
		JFrame mainWindow = new JFrame();
		mainWindow.setTitle("IP Rechner");
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setBounds(100, 100, 455, 510);
		mainWindow.setLayout(null);
		
		// Panel für die Eingabe aller Elemente
		JPanel eingabe_pnl = new JPanel();
		eingabe_pnl.setBounds(120, 11, 210, 179);
		mainWindow.add(eingabe_pnl);
		eingabe_pnl.setLayout(null);
		
		JLabel lbl_ipadress = new JLabel("IP-Adresse");
		lbl_ipadress.setBounds(73, 11, 70, 14);
		eingabe_pnl.add(lbl_ipadress);
		
		// IP Eingabe Feld
		tF_IPAdresse = new JTextField();
		tF_IPAdresse.setBounds(10, 36, 190, 20);
		eingabe_pnl.add(tF_IPAdresse);
		tF_IPAdresse.setColumns(10);
		tF_IPAdresse.setText("192.168.172.23");
		
		JLabel lbl_subnetz = new JLabel("Subnetzmaske");
		lbl_subnetz.setBounds(69, 67, 120, 14);
		eingabe_pnl.add(lbl_subnetz);
		
		// Subnetzmaske Eingabe Feld
		tF_Subnetzmaske = new JTextField();
		tF_Subnetzmaske.setBounds(10, 92, 190, 20);
		eingabe_pnl.add(tF_Subnetzmaske);
		tF_Subnetzmaske.setColumns(10);
		tF_Subnetzmaske.setText("255.255.255.0");
		
		JButton btn_berechne = new JButton("Berechne");
		btn_berechne.setBounds(7, 145, 89, 23);
		btn_berechne.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if(SecurityLogic.isValidIPV4(tF_IPAdresse.getText()) && SecurityLogic.isValidIPV4(tF_Subnetzmaske.getText())) {
					thisLogic.getAndSplit();
					tF_ipAlsBinar.setText(thisLogic.getIPAlsBinary());
					tF_ipAlsHexa.setText(thisLogic.getIPAlsHexa());
					
					tF_ipMitSuffix.setText(thisLogic.getIPWithSuffix());
					tF_Netzadresse.setText(thisLogic.getNetworkAdress());
				}else {
					JOptionPane.showMessageDialog(mainWindow, "The Task failed Successfully");
				}

			}
		});
		
		eingabe_pnl.add(btn_berechne);
		
		JPanel ausgabe_pnl = new JPanel();
		ausgabe_pnl.setBounds(10, 201, 429, 275);
		mainWindow.add(ausgabe_pnl);
		ausgabe_pnl.setLayout(null);
		
		JLabel lbl_ipAlsBinär = new JLabel("IP als Bin\u00E4r:");
		lbl_ipAlsBinär.setBounds(10, 11, 100, 14);
		ausgabe_pnl.add(lbl_ipAlsBinär);
		
		JLabel lbl_ipAlsHexadekadisch = new JLabel("IP Hexadekaisch:");
		lbl_ipAlsHexadekadisch.setBounds(10, 36, 100, 14);
		ausgabe_pnl.add(lbl_ipAlsHexadekadisch);
		
		JLabel lbl_ipMitSuffix = new JLabel("IP mit Suffix:");
		lbl_ipMitSuffix.setBounds(10, 61, 100, 14);
		ausgabe_pnl.add(lbl_ipMitSuffix);
		
		JLabel lbl_Netzadresse = new JLabel("Netzadresse:");
		lbl_Netzadresse.setBounds(10, 86, 100, 14);
		ausgabe_pnl.add(lbl_Netzadresse);
		
		JLabel lbl_ersteHostadresse = new JLabel("Erste Hostadresse:");
		lbl_ersteHostadresse.setBounds(10, 111, 100, 14);
		ausgabe_pnl.add(lbl_ersteHostadresse);
		
		JLabel lbl_letzteHostadresse = new JLabel("Letzte Hostadresse:");
		lbl_letzteHostadresse.setBounds(10, 136, 100, 14);
		ausgabe_pnl.add(lbl_letzteHostadresse);
		
		JLabel lbl_Broadcastadresse = new JLabel("Broadcastadresse:");
		lbl_Broadcastadresse.setBounds(10, 161, 100, 14);
		ausgabe_pnl.add(lbl_Broadcastadresse);
		
		JLabel lbl_AnzahlHosts = new JLabel("Anzahl an Hosts:");
		lbl_AnzahlHosts.setBounds(10, 186, 100, 14);
		ausgabe_pnl.add(lbl_AnzahlHosts);
		
		JLabel lbl_besondereIp = new JLabel("Besondere IP:");
		lbl_besondereIp.setBounds(10, 211, 100, 14);
		ausgabe_pnl.add(lbl_besondereIp);
		
		tF_ipAlsBinar = new JTextField();
		tF_ipAlsBinar.setEditable(false);
		tF_ipAlsBinar.setBounds(120, 8, 299, 20);
		ausgabe_pnl.add(tF_ipAlsBinar);
		tF_ipAlsBinar.setColumns(10);
		
		tF_ipAlsHexa = new JTextField();
		tF_ipAlsHexa.setEditable(false);
		tF_ipAlsHexa.setColumns(10);
		tF_ipAlsHexa.setBounds(120, 33, 299, 20);
		ausgabe_pnl.add(tF_ipAlsHexa);
		
		tF_ipMitSuffix = new JTextField();
		tF_ipMitSuffix.setEditable(false);
		tF_ipMitSuffix.setColumns(10);
		tF_ipMitSuffix.setBounds(120, 58, 299, 20);
		ausgabe_pnl.add(tF_ipMitSuffix);
		
		tF_Netzadresse = new JTextField();
		tF_Netzadresse.setEditable(false);
		tF_Netzadresse.setColumns(10);
		tF_Netzadresse.setBounds(120, 83, 299, 20);
		ausgabe_pnl.add(tF_Netzadresse);
		
		tF_ErsteHost = new JTextField();
		tF_ErsteHost.setEditable(false);
		tF_ErsteHost.setColumns(10);
		tF_ErsteHost.setBounds(120, 108, 299, 20);
		ausgabe_pnl.add(tF_ErsteHost);
		
		tF_LetzteHost = new JTextField();
		tF_LetzteHost.setEditable(false);
		tF_LetzteHost.setColumns(10);
		tF_LetzteHost.setBounds(120, 133, 299, 20);
		ausgabe_pnl.add(tF_LetzteHost);
		
		tF_Broadcastadresse = new JTextField();
		tF_Broadcastadresse.setEditable(false);
		tF_Broadcastadresse.setColumns(10);
		tF_Broadcastadresse.setBounds(120, 158, 299, 20);
		ausgabe_pnl.add(tF_Broadcastadresse);
		
		tF_ANzahlHosts = new JTextField();
		tF_ANzahlHosts.setEditable(false);
		tF_ANzahlHosts.setColumns(10);
		tF_ANzahlHosts.setBounds(120, 183, 299, 20);
		ausgabe_pnl.add(tF_ANzahlHosts);
		
		tF_BesondereIP = new JTextField();
		tF_BesondereIP.setEditable(false);
		tF_BesondereIP.setColumns(10);
		tF_BesondereIP.setBounds(120, 208, 299, 50);
		ausgabe_pnl.add(tF_BesondereIP);
		
		mainWindow.setVisible(true);
	}
	
	public static String getIPFieldContent() {
		return tF_IPAdresse.getText();
	}
	
	public static String getSubnetzmaskeFieldContent() {
		return tF_Subnetzmaske.getText();
	}
}
