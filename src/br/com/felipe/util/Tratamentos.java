package br.com.felipe.util;

import java.text.Normalizer;

public class Tratamentos {

	public static String removerAcentosUpperCase(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
	}

	public static String removerPontos(String str) {
		return str.replaceAll("\\D+", "");
	}

}