package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_GS_HOTEL")
@SequenceGenerator(name = "seqHotel", allocationSize = 1)
public class Hotel {
	
	@Id
	@Column(name = "cd_hotel")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqHotel")
	protected int id;
	
	@Column(name = "nm_hotel", length = 50, nullable = false)
	protected String nome;
	
	@Column(name = "ds_endereco", nullable = false)
	protected String endereco;
	
	@Column(name = "ds_telefone", length = 20)
	protected String telefone;
	
	@Column(name = "ds_hotel")
	protected String descricao;
	
	@Column(name = "nr_avaliacao")
	protected double avaliacao;

	public Hotel(String nome, String endereco, String telefone, String descricao, double avaliacao) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.descricao = descricao;
		this.avaliacao = avaliacao;
	}
	
	public Hotel() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}

	
	
}
