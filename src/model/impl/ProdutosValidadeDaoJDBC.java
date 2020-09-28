package model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.ProdutosValidadeDao;
import model.entities.ProdutosValidade;


public class ProdutosValidadeDaoJDBC implements ProdutosValidadeDao {

	private Connection conn;

	public ProdutosValidadeDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ProdutosValidade findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM ProdutosValidade WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				ProdutosValidade obj = new ProdutosValidade();
				obj.setId(rs.getInt("Id"));
				obj.setNome(rs.getString("Nome"));
				obj.setValor(rs.getDouble("Valor"));
				obj.setDataValidade(rs.getDate("DataValidade"));
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void insert(ProdutosValidade obj) {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("insert into ProdutosValidade (Nome,Valor,DataValidade) values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNome());
			st.setDouble(2, obj.getValor());
			st.setDate(3, new java.sql.Date(obj.getDataValidade().getTime()));

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			} else {
				throw new DbException("Unexpected error! No rows affected!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(ProdutosValidade obj) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("update ProdutosValidade set Nome = ?,Valor = ?,DataValidade = ? where Id = ?");
			st.setString(1, obj.getNome());
			st.setDouble(2, obj.getValor());
			st.setDate(3, new java.sql.Date(obj.getDataValidade().getTime()));
			st.setInt(4, obj.getId());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {

			st = conn.prepareStatement("delete from ProdutosValidade where Id = ?");

			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public List<ProdutosValidade> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from ProdutosValidade ORDER BY Nome");
			rs = st.executeQuery();

			List<ProdutosValidade> list = new ArrayList<>();

			while (rs.next()) {
				ProdutosValidade obj = new ProdutosValidade();
				obj.setId(rs.getInt("Id"));
				obj.setNome(rs.getString("Nome"));
				obj.setValor(rs.getDouble("Valor"));
				obj.setDataValidade(rs.getDate("DataValidade"));
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

}
