package trabalhoerikalp.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trabalhoerikalp.controle.util.ManipulacaoData;
import trabalhoerikalp.dao.ProdutoDAO;
import trabalhoerikalp.modelo.Produto;


/**
 * Servlet implementation class IndexControle
 */
@WebServlet("/publica")
public class IndexControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProdutoDAO produtoDAO;
       
    public IndexControle() {
        super();
    }
    
    public void init() {
    	produtoDAO = new ProdutoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}
	
	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		try {
			switch (acao) {
			case "novo":
				novoProduto(request, response);
				break;
			case "inserir":
				gravarProduto(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}
	

	
	private void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-novo-produto.jsp");
		dispatcher.forward(request, response);
	}
	
	private void gravarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {		
		
		String descricao = request.getParameter("descricao");
		String categoria = request.getParameter("categoria");
		String preco_custo = request.getParameter("preco_custo");
		String preco_venda = request.getParameter("preco_venda");
		String quantidade = request.getParameter("quantidade");		
		String data = request.getParameter("entrada");	
		
		ManipulacaoData manipulacaoData = new ManipulacaoData();
		Date dataEntrada= manipulacaoData.converterStringData(data);
		
		Produto produto = new Produto(descricao, categoria, dataEntrada, preco_custo, preco_venda, quantidade);
		
			Produto produtoGravado =  produtoDAO.inserirProduto(produto);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-novo-produto.jsp");
			request.setAttribute("mensagem", "Produto cadastrado com sucesso");
			dispatcher.forward(request, response);


	}


}
