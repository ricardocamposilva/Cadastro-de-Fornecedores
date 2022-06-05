package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import dao.IDAO;
import dominio.Endereco;
import dominio.EntidadeDominio;

public class EnderecoDAO implements IDAO {
	
	private Connection connection;
	private boolean ctrlTransaction = true;
	
	public EnderecoDAO() {}
	
	public EnderecoDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		
		PreparedStatement pst = null;
		Endereco end = (Endereco)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO tb_endereco(cidade, estado, ");
		sql.append("logradouro, dt_cadastro) ");
		sql.append(" VALUES (?,?,?,?) ");
		
		try {
			if (connection == null) {
				connection = Conexao.getConnectionPostgres();
			}else {
				ctrlTransaction = false;
			}
			
			connection.setAutoCommit(false);
			
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, end.getCidade().getDescricao());
			pst.setString(2, end.getCidade().getUf().getDescricao());
			pst.setString(3, end.getLogradouro());
			
			Timestamp time = new Timestamp(end.getDtCadastro().getTime());
			pst.setTimestamp(4, time);
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			end.setId(idEnd);
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			if (ctrlTransaction) {
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
