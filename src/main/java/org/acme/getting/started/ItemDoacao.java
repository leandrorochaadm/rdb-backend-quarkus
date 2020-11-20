package org.acme.getting.started;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_doacao")
public class ItemDoacao implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// private CategoriaItem categoria;

	@Column(length = 64, nullable = false)
	private String nome;
	private BigDecimal valorReferencia;
	private boolean ativo;

	// @Temporal(TemporalType.DATE)
	// @JsonbDateFormat(value = "yyyy-MM-dd")
	// private LocalDateTime dataCriacao;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "autor_id")
	private Pessoa autor;

	public ItemDoacao() {
		this.ativa();
		// this.dataCriacao = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorReferencia() {
		return valorReferencia;
	}

	public void setValorReferencia(BigDecimal valorReferencia) {
		this.valorReferencia = valorReferencia;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Pessoa getAutor() {
		return autor;
	}

	public void setAutor(Pessoa autor) {
		this.autor = autor;
	}

	public void ativa() {
		setAtivo(true);

	}

	public void desativa() {
		setAtivo(false);
	}

	@Override
	public String toString() {

		return "Nome: " + this.nome + ", ativo: " + this.ativo + " pessoa: " + this.autor;
	}

}