package app;

public class AlgoritmiCesarit {
	
	public static void main(String[] args) {

	}
	public static String Enkripto(String plaintexti, int celesi ) {
		StringBuilder ciphertexti = new StringBuilder(plaintexti);
		for (int i = 0; i < plaintexti.length(); i++) {
			
			if ( Character.isUpperCase(plaintexti.charAt(i)) ) {
				int pozitaAktuale = plaintexti.charAt(i) - 'A';
				int pozitaRe = (pozitaAktuale + celesi) % 26;
				char encChar = (char)(pozitaRe + 'A');
				ciphertexti.setCharAt(i, encChar);
			} else if ( Character.isLowerCase(plaintexti.charAt(i)) ) {
				int pozitaAktuale = plaintexti.charAt(i) - 'a';
				int pozitaRe = (pozitaAktuale + celesi) % 26;
				char encChar = (char)(pozitaRe + 'a');
				ciphertexti.setCharAt(i, encChar);
			}
		}
		return ciphertexti.toString();
	}
}
