package dominio;

import java.util.List;

public class Uf {
	
	private String descricao;
	private String sigla;
	private Pais pais;
	private List<Cidade> cidades;
	
	public Uf(String descricao, String sigla, Pais pais) {
		super();
		this.descricao = descricao;
		this.sigla = sigla;
		this.pais = pais;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

		
}
