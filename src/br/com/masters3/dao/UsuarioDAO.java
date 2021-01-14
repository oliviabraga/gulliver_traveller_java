package br.com.masters3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;

import br.com.masters3.beans.Cidade;
import br.com.masters3.beans.Usuario;

public class UsuarioDAO implements DAO<Usuario> {

	private DataSource dataSource;

	public UsuarioDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return this.dataSource;
	}

	@Override
	public void create(Usuario object) {
		try {
			String SQL = "insert into TB_TIN_USUARIO (nivel, genero, email, senha, nome, "
					+ "         nascimento, foto, id_cidade) " + "    values (?,?,?,?,?,?,?,?) ";
			PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
			stm.setString(1, object.getNivel());
			stm.setString(2, object.getGenero());
			stm.setString(3, object.getEmail());
			stm.setString(4, object.getSenha());
			stm.setString(5, object.getNome());
			stm.setString(6, object.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
			//stm.setString(7, object.getUltimoAcesso().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
			stm.setString(7, object.getFoto());
			stm.setInt(8, object.getCidade().getId());
	
			System.out.println("DEBUG "+stm);
			int res = stm.executeUpdate();
			if (res != 0) {
				System.out.println("Usuario criado com sucesso");
			} else {
				throw new RuntimeException("Erro ao atualizar usuario ");
			}
		} catch (Exception ex) {
			System.out.println("UsuarioDAO.CREATE = " + ex.getMessage());
			ex.printStackTrace();
		}
		

	}

	@Override
	public Usuario read(Usuario object) {
		// TODO Auto-generated method stub
		try {
			String SQL = "select * from TB_TIN_USUARIO inner join TB_TIN_CIDADE "
					+ "   on TB_TIN_USUARIO.ID_CIDADE = TB_TIN_CIDADE.ID" + "   where email = ? and senha = ?";
			PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
			stm.setString(1, object.getEmail());
			stm.setString(2, object.getSenha());
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("ID"));
				usuario.setNome(rs.getString("NOME"));
				usuario.setNivel(rs.getString("NIVEL"));
				usuario.setGenero(rs.getString("GENERO"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setNascimento(rs.getDate("NASCIMENTO").toLocalDate());
//				usuario.setUltimoAcesso(rs.getDate("ULTIMO_ACESSO").toLocalDate());
				usuario.setFoto(rs.getString("FOTO"));
				Cidade cidade = new Cidade();
				cidade.setId(rs.getInt("ID_CIDADE"));
				cidade.setCidade(rs.getString("CIDADE"));
				cidade.setEstado(rs.getString("ESTADO"));
				cidade.setSiglaEstado(rs.getString("SIGLA_ESTADO"));
				cidade.setPais(rs.getString("PAIS"));
				cidade.setSiglaPais(rs.getString("SIGLA_PAIS"));
				usuario.setCidade(cidade);
				return usuario;
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("UsuarioDAO.READ = " + ex.getMessage());
		}
		return null;
	}

	@Override
	public void update(Usuario object) {
		try {
			String SQL = "update TB_TIN_USUARIO set nivel = ?, genero = ?, email = ?,"
					+ "      senha = ?, nome = ?, nascimento = ? "
					+ "      foto = ?, id_cidade = ? where id = ?";
			PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
			stm.setString(1, object.getNivel());
			stm.setString(2, object.getGenero());
			stm.setString(3, object.getEmail());
			stm.setString(4, object.getSenha());
			stm.setString(5, object.getNome());
			stm.setString(6, object.getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
			//stm.setString(7, object.getUltimoAcesso().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
			stm.setString(7, object.getFoto());
			stm.setInt(8, object.getCidade().getId());
			stm.setInt(9, object.getId());

			int res = stm.executeUpdate();
			if (res != 0) {
				System.out.println("Usuario alterado com sucesso");
			} else {
				throw new RuntimeException("Erro ao atualizar usuario ");
			}
		} catch (Exception ex) {
			System.out.println("UsuarioDAO.UPDATE = " + ex.getMessage());
		}

	}

	@Override
	public void delete(Usuario object) {
		try {
			// definimos nossa instrucão SQL
			String SQL = "delete from TB_TIN_USUARIO where ID = ?";
			// a partir da nossa conexão, criamos um STATEMENT parametrizado
			PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
			// parametrizamos o "?" com o ID do usuário que vamos apagar
			stm.setInt(1, object.getId());
			// executamos
			int res = stm.executeUpdate();
			// se der certo, retornará o número de registros afetados (tem que ser 1)
			if (res != 0) {
				System.out.println("DEBUG - Usuario excluido com sucesso");
			} else {
				throw new RuntimeException("ERRO ao apagar usuario");
			}
		} catch (Exception ex) {
			System.out.println("UsuarioDAO.DELETE = " + ex.getMessage());
		}
	}
}
