package br.com.mjv.bank.exception;

/**
 * Exceção disparada quando temos uma regra de negócio inválida.
 * @author edson.costa
 *
 */
public class BusinessException extends Exception {

	public BusinessException(String msg) {
		super(msg);
	}

	/**
	 * SERIAL
	 */
	private static final long serialVersionUID = -7691904891430286280L;

}
