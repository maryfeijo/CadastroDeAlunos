
package com.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Aluno;

public class AlunoDAO {

	public void create(Aluno a)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "insert into aluno (matricula, nome, email, senha) values (?,?,?,?) ";
	
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, a.getMatricula());
			stmt.setString(2, a.getNome());
			stmt.setString(3, a.getEmail());
			stmt.setString(4, a.getSenha());
			stmt.executeUpdate();
			
			System.out.println("Aluno registrado!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Erro ao salvar!");
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
			
		}
		
		
	}
	
	
	public List<Aluno> read()
	{
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from aluno";
		
		List<Aluno> alunos = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next())
			{
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setSenha(rs.getString("senha"));
				
				
				alunos.add(aluno);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return alunos;
	}
	
}
