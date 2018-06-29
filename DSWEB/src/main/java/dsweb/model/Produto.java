package dsweb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity (name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min = 2, max = 50, message="O tamanho deve ser entre {min} e {max}")
	private String nome;
	
	@NotNull
	private double preco;
	
	private String imagem;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "comprou", 
	joinColumns = @JoinColumn(name = "produto_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="usuario_login", referencedColumnName = "login"))
	List<Usuario> compradores;
	
	public Produto() {}
	
	public Produto(Integer id) {
		this.id = id;
	}
	
	public Produto(Integer id, String nome, double preco, String imagem) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.imagem = imagem;	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public List<Usuario> getCompradores() {
		return compradores;
	}

	public void setCompradores(List<Usuario> compradores) {
		this.compradores = compradores;
	}

	
	@Override
	public String toString() {
		return "Produto [id= " + id + ", nome=" + nome + ", preco=" + preco + ", imagem=" + imagem + "]";
	}
}
