package io.github.diferreira.cm;

import io.github.diferreira.cm.modelo.Tabuleiro;
import io.github.diferreira.cm.visao.TabuleiroConsole;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		
		new TabuleiroConsole(tabuleiro);
		
	}
	
}
