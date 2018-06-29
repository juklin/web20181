package dsweb.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	private List<Produto> produtos;
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Carrinho() {
		this.produtos = new ArrayList<Produto>();
	}

}
