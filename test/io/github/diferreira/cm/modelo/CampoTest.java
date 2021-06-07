package io.github.diferreira.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.diferreira.cm.excecao.ExplosaoException;

public class CampoTest {

	private Campo campo;

	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}

	@Test
	void testVizinhoRealDistancia1() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);

	}

	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}

	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}

	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}

	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, ()->{
			campo.abrir();
		});
	}
	
	@Test
	void testeAbrirComVizinhos() {

		Campo campo11 = new Campo(1,1);		
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto()&&campo11.isAberto());
	}
	
	@Test
	void testeAbrirComVizinhosMinados() {

		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,1);	
		campo12.minar();
		
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}

}
