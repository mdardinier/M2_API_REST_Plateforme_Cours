package fr.ul.miage.m2.sid.plateformecours;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class VerificationCarteBancaire {

	public static boolean formatNumeroCarteValide(String numeroCarte) {
		return Pattern.matches("^[0-9]{12}", numeroCarte);
	}

	public static boolean datExpirationValide(String dateExpiration) {
		if (Pattern.matches("^[0-9]{2}/[0-9]{4}", dateExpiration)) {
			String[] date = dateExpiration.split("/");
			if (Integer.parseInt(date[1]) > LocalDate.now().getYear()
					|| (Integer.parseInt(date[1]) == LocalDate.now().getYear()
							&& Integer.parseInt(date[0]) >= LocalDate.now().getMonthValue())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean codeCarteValide(String numeroCarte, String codeCarte) {
		if(formatNumeroCarteValide(numeroCarte)) {
			return numeroCarte.substring(8).equals(codeCarte);
		}
		return false;
	}
	
	public static boolean transactionBancaireValide(String numeroCarte, String dateExpiration, String codeCarte) {
		return formatNumeroCarteValide(numeroCarte) && datExpirationValide(dateExpiration) && codeCarteValide(numeroCarte, codeCarte);
	}
}
