import java.util.ArrayList;
import java.util.regex.Pattern;

public class RechnerLogic {

	// Speichern die geteilten IP und Subnetzmaske in Oktetten
	public ArrayList<Integer> splittedIPAdress = new ArrayList<Integer>();
	public ArrayList<Integer> splittedSubnetzmask = new ArrayList<Integer>();
	
	public ArrayList<String> splittedIPAdressBinary = new ArrayList<String>();
	public ArrayList<String> splittedSubnetzmaskBinary = new ArrayList<String>();
	public ArrayList<String> splittedNetworkBinary = new ArrayList<String>();
	
	public void getAndSplit() {
		clearLists();
		
		String[] splittedIP = Rechner_GUI.getIPFieldContent().split(Pattern.quote("."));
		String[] splittedMaske = Rechner_GUI.getSubnetzmaskeFieldContent().split(Pattern.quote("."));
		
		
		for(int i = 0; i < splittedIP.length; i++) {
			splittedIPAdress.add(Integer.parseInt(splittedIP[i]));
		}
		
		for(int i = 0; i < splittedMaske.length; i++) {
			splittedSubnetzmask.add(Integer.parseInt(splittedMaske[i]));
		}
	
		System.out.println(splittedIPAdress);
		System.out.println(splittedSubnetzmask);
		
		everythingToBinary();
	}
	
	public void everythingToBinary() {
		for(int k : splittedIPAdress) {
			String temp = String.format("%8s", Integer.toBinaryString(k));
			temp = temp.replace(' ', '0');
			
			splittedIPAdressBinary.add(temp);
		}
		
		for(int k : splittedSubnetzmask) {
			String temp = String.format("%8s", Integer.toBinaryString(k));
			temp = temp.replace(' ', '0');
			
			splittedSubnetzmaskBinary.add(temp);
		}
		
		System.out.println(splittedIPAdressBinary);
		System.out.println(splittedSubnetzmaskBinary);
	}
	
	
	public String getIPAlsBinary() {
		String tempIP = "";
		
		for(int i = 0; i < splittedIPAdressBinary.size(); i++) {
			tempIP += splittedIPAdressBinary.get(i);
			
			if(i<3) {
				tempIP += ".";
			}
		}
		return tempIP;
	}
	
	public String getIPAlsHexa() {
		String tempIP = "";
		
		for(int i = 0; i < splittedIPAdress.size(); i++) {
			tempIP += Integer.toHexString(splittedIPAdress.get(i));
			
			if(i<3) {
				tempIP += ".";
			}
		}
		return tempIP;
	}
	
	public String doTheSuffix() {
		int suffix = 0;
		
		for(int i = 0; i < splittedSubnetzmask.size(); i++) {
			suffix += Integer.bitCount(splittedSubnetzmask.get(i));
		}
		
		return ""+suffix;
	}
	
	public String getIPWithSuffix() {
		
		return Rechner_GUI.getIPFieldContent() + " /" + doTheSuffix();
	}
	
	public String getNetworkAdress() {
		ArrayList<String> tempSplittedNetworkAdressBinary = new ArrayList<String>();
		String tempNetz = "";
		// Erstellt Segmente der Netzadresse in Binary
		for(int i = 0; i < 4; i++ ) {
			String tempSegment = "";
			for(int k = 0; k < 8; k++) {
				if(splittedIPAdressBinary.get(i).charAt(k) == '1' && splittedSubnetzmaskBinary.get(i).charAt(k) == '1') {
					tempSegment += "1";
				}else {
					tempSegment += "0";
				}
			}
			tempSplittedNetworkAdressBinary.add(tempSegment);
		}
		System.out.println(tempSplittedNetworkAdressBinary);
		splittedNetworkBinary.addAll(tempSplittedNetworkAdressBinary);
		
		for(int i = 0; i < tempSplittedNetworkAdressBinary.size(); i++ ) {
			tempNetz += Integer.parseInt(tempSplittedNetworkAdressBinary.get(i), 2);
			
			
			if(i<3) {
				tempNetz += ".";
			}
		}
		
		System.out.println(splittedNetworkBinary);
		System.out.println(tempNetz);
		return tempNetz;
	}
	

	
	public String getLastAdress() {
		
		
		
		return null;
	}
	
	private void clearLists() {
		splittedNetworkBinary.clear();
		
		splittedIPAdress.clear();
		splittedSubnetzmask.clear();
		
		splittedIPAdressBinary.clear();
		splittedSubnetzmaskBinary.clear();
	}
	
	
}
