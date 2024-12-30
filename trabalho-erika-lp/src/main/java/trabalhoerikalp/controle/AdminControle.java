package trabalhoerikalp.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trabalhoerikalp.dao.ProdutoDAO;
import trabalhoerikalp.modelo.Produto;

/**
 * Servlet implementation class AdminControle
 */
@WebServlet("/auth/admin")
public class AdminControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private ProdutoDAO produtoDAO;
    
    public AdminControle() {
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
			case "listar":
				listarProduto(request, response);
				break;
				
			case "apagar":
				apagarProduto(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}


	private void listarProduto(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		List<Produto> produtos = produtoDAO.listarTodosProdutos();
		
		request.setAttribute("listaProdutos", produtos);
		
		String path =  request.getServletPath() + "/admin-listar-produto.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		
		dispatcher.forward(request, response);

	}
	
	private void apagarProduto(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Produto produto = new Produto();
		produto.setId(id);
		produtoDAO.apagarProduto(produto);
		
		String path = request.getContextPath() + request.getServletPath() + "?acao=listar";
		response.sendRedirect(path);
		
		
	}

}


	

