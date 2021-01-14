package br.com.masters3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.masters3.beans.Cidade;

public class CidadeDAO implements DAO{
	
	private DataSource dataSource;
	
	public CidadeDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return this.dataSource;
	}

	@Override
	public void create(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object read(Object object) {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from TB_TIN_CIDADE";
			PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			ArrayList<Cidade> listaCidades = new ArrayList<Cidade>();
			while (rs.next()) {
				Cidade cidade = new Cidade();
				cidade.setId(rs.getInt("ID"));
				cidade.setCidade(rs.getString("CIDADE"));
				cidade.setEstado(rs.getString("ESTADO"));
				cidade.setSiglaEstado(rs.getString("SIGLA_ESTADO"));
				cidade.setPais(rs.getString("PAIS"));
				cidade.setSiglaPais(rs.getString("SIGLA_PAIS"));
				listaCidades.add(cidade);
			}
			return listaCidades;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		try {
			
		}
		catch(Exception ex) {
			
		}
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		
	}

}
