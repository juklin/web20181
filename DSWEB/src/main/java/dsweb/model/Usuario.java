package dsweb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity (name = "usuario")
public class Usuario {
	
	@Id
	@NotNull
	@Size(min = 5, max = 30, message="O tamanho deve ser entre {min} e {max}")
	private String login;
	
	@NotNull
	@Size(min = 2, max = 30, message="O tamanho deve ser entre {min} e {max}")
	private String nome;
	
	@NotNull
	@Size(min = 5, max = 15, message="O tamanho deve ser entre {min} e {max}")
	private String cpf;
	
	@NotNull
	private String dataNasc;
	
	@NotNull
	private String endereco;
	
	@NotNull
	@Size(min = 5, max = 50, message="A senha deve ter pelo menos 5 caracteres")
	private String senha;
	
	@ManyToMany(mappedBy="compradores")
	private List<Produto> historicoProdutos;

	public Usuario() {}
	
	public Usuario(String login) {
		this.login = login;
	}
	
	public Usuario(String nome, String cpf, String dataNasc, String endereco, String login, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
		this.login = login;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public List<Produto> getHistoricoProdutos() {
		return historicoProdutos;
	}

	public void setHistoricoProdutos(List<Produto> historicoProdutos) {
		this.historicoProdutos = historicoProdutos;
	}
}
