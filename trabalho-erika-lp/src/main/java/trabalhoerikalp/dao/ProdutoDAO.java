package trabalhoerikalp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import trabalhoerikalp.dao.util.Conexao;
import trabalhoerikalp.modelo.Produto;

public class ProdutoDAO {
	
	private Connection connection;
	
	private void conectar() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = Conexao.getConexao();
		}
	}

	private void desconectar() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
	
	public Produto inserirProduto(Produto produto) throws SQLException {
		String sql = "INSERT INTO produto (descricao, categoria, data_entrada, preco_custo, preco_venda, quantidade)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";		    
		
		conectar();

		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, produto.getDescricao());
		statement.setString(2, produto.getCategoria());
		Date entrada = new Date(produto.getDataEntrada().getTime());
		statement.setDate(3, entrada);
		statement.setString(4, produto.getPreco_custo());
		statement.setString(5, produto.getPreco_venda());
		statement.setString(6, produto.getQuantidade());
		
		statement.executeUpdate();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		long id = 0;
		if(resultSet.next())
			id = resultSet.getInt("id");
		statement.close();

		desconectar();
		
		produto.setId(id);
		return produto;
	}
	
	public List<Produto> listarTodosProdutos() throws SQLException {
		
		List<Produto> listaProdutos= new ArrayList<Produto>();

		String sql = "SELECT * FROM produto";

		conectar();

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			long id = resultSet.getLong("id");
			String descricao = resultSet.getString("descricao");
			String categoria = resultSet.getString("categoria");
			Date entrada = new Date(resultSet.getDate("data_entrada").getTime());
			String preco_custo= resultSet.getString("preco_custo");
			String preco_venda= resultSet.getString("preco_venda");
			String quantidade = resultSet.getString("quantidade");
			

			Produto produto= new Produto(descricao, categoria, entrada, preco_custo, preco_venda, quantidade);
			produto.setId(id);
			listaProdutos.add(produto);
		}
		resultSet.close();
		statement.close();

		desconectar();

		return listaProdutos;
	}

		public boolean apagarProduto(Produto produto) throws SQLException {
			String sql = "DELETE FROM produto where id = ?";
    
			conectar();
     
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, produto.getId());
     
			boolean linhaApagada = statement.executeUpdate() > 0;
			statement.close();
    
			desconectar();
    
    return linhaApagada;     
}




}

