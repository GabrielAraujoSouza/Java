package curso.java.viagem.entity;

import java.util.Date;

/**
 * Representa uma viagem
 */
public class Viagem {

	/**
	 * Tipos de viagem dispon�veis
	 */
	public static enum Tipo {
		PASSEIO, NEG�CIOS, FAM�LIA
	}

	/**
	 * ID da viagem
	 */
	private int id;
	
	/**
	 * Data de ida
	 */
	private Date dataIda;
	
	/**
	 * Data de volta
	 */
	private Date dataVolta;
	
	/**
	 * Tipo da viagem
	 */
	private Tipo tipo;
	
	/**
	 * Informa��es da viagem
	 */
	private String info;

	/**
	 * Obt�m o ID da viagem
	 * @return ID da viagem
	 */
	public int getId() {
		return id;
	}

	/**
	 * Obt�m a data de ida
	 * @return Data de ida
	 */
	public Date getDataIda() {
		return dataIda;
	}

	/**
	 * Obt�m a data de volta
	 * @return Data de volta
	 */
	public Date getDataVolta() {
		return dataVolta;
	}

	/**
	 * Obt�m o tipo da viagem
	 * @return Tipo da viagem
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * Obt�m as informa��es da viagem
	 * @return Informa��es da viagem
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * Define o ID da viagem
	 * @param id ID da viagem
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Define a data de ida
	 * @param dataIda Data de ida
	 */
	public void setDataIda(Date dataIda) {
		this.dataIda = dataIda;
	}

	/**
	 * Define a data de volta
	 * @param dataVolta Data de volta
	 */
	public void setDataVolta(Date dataVolta) {
		this.dataVolta = dataVolta;
	}

	/**
	 * Define o tipo da viagem
	 * @param tipo Tipo da viagem
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * Define as informa��es da viagem
	 * @param info Informa��es da viagem
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Viagem [id=" + id + ", dataIda=" + dataIda + ", dataVolta=" + dataVolta + ", tipo=" + tipo + ", info=" + info + "]";
	}
}
