package negocio.impl;

import dominio.EntidadeDominio;
import dominio.Fornecedor;
import negocio.IStrategy;

public class ValidarFornecimento implements IStrategy {

	public String processar(EntidadeDominio entidade) {

		Fornecedor fornecedor = (Fornecedor)entidade;
		
		int qtdProdutos = fornecedor.getProdutos().size();
		int qtdServicos = fornecedor.getServicos().size();
		
		if(qtdProdutos == 0 && qtdServicos == 0)
			return "� necess�rio cadastrar pelos menos um produto ou servi�o \n";
		else
			return null;
	}
}