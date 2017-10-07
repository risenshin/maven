package com.iddel.spt.exception;

public class IncorrectInputException extends Exception {

	public IncorrectInputException(String string) {
		super(string);
	}

	public IncorrectInputException() {
		super("Incorrect input provided.. cannot proceed");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2945433647206315581L;

}
