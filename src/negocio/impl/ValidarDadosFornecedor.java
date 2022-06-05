package negocio.impl;

import dominio.EntidadeDominio;
import dominio.Fornecedor;
import negocio.IStrategy;

public class ValidarDadosFornecedor implements IStrategy {

	public String processar(EntidadeDominio entidade) {

		Fornecedor fornecedor = (Fornecedor)entidade;
		
		String cnpj = fornecedor.getCnpj();
		String rzSocial = fornecedor.getRzSocial();
		String nmFantasia = fornecedor.getNmFantasia();
		String  inscricaoEstadual = fornecedor.getInscricaoEstadual();
		String inscricaoMunicipal = fornecedor.getInscricaoMunicipal();
		String email = fornecedor.getEmail();
		
		if(cnpj == null || cnpj == "")
			return "CNPJ obrigat�rio \n>";
		
		if(rzSocial == null || rzSocial == "")
			return "Raz�o Social obrigat�ria \n";
		
		if(nmFantasia == null || nmFantasia == "")
			return "Nome fantasia obrigat�rio \n";
		
		if(inscricaoEstadual == null || inscricaoEstadual == "")
			return "Inscri��o estadual obrigat�ria \n";
		
		if(inscricaoMunicipal == null || inscricaoMunicipal == "")
			return "Inscri��o municipal obrigat�ria \n";
		
		if(email == null || email == "")
			return "Email obrigat�rio \n";
		
	
		return null;			
	}
	
}
