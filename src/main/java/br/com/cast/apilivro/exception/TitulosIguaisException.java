package br.com.cast.apilivro.exception;

public class TitulosIguaisException extends Exception {

	public TitulosIguaisException() {
		super("Titulo do livro j� existente");
	}
}

