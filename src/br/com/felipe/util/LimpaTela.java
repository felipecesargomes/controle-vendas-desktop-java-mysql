package br.com.felipe.util;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class LimpaTela {

	/**
	 * @author Felipe César
	 */
	
	//Construtor para pecorrer todos os text fields existente no painel passado por argumento
	public LimpaTela(JPanel container) {
		Component components[] = container.getComponents();
		for (Component component : components) {
			if (component instanceof JTextField) {
				((JTextField) component).setText(null);
			}
		}
	}

}
