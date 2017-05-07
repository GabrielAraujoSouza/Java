package curso.java.viagem.entity;

import java.util.Date;

/**
 * Representa uma viagem
 */
public class Viagem {

	/**
	 * Tipos de viagem disponíveis
	 */
	public static enum Tipo {
		PASSEIO, NEGÓCIOS, FAMÍLIA
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
	 * Informações da viagem
	 */
	private String info;

	/**
	 * Obtém o ID da viagem
	 * @return ID da viagem
	 */
	public int getId() {
		return id;
	}

	/**
	 * Obtém a data de ida
	 * @return Data de ida
	 */
	public Date getDataIda() {
		return dataIda;
	}

	/**
	 * Obtém a data de volta
	 * @return Data de volta
	 */
	public Date getDataVolta() {
		return dataVolta;
	}

	/**
	 * Obtém o tipo da viagem
	 * @return Tipo da viagem
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * Obtém as informações da viagem
	 * @return Informações da viagem
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
	 * Define as informações da viagem
	 * @param info Informações da viagem
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
