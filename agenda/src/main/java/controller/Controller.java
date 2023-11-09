package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();//objeto contato que vai acessar os atributos publicos
	
	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();//criando a variavel que armazena as requisicoes
		System.out.println("Entrou no doGet do Controller!");

		if (action.equals("/main")) {//se o nome da requisicao for main
			contatos(request, response);//vai ser redirecionado para o metodo contatos
		} else if (action.equals("/insert")) {//se a requisicao nao for main, mas a palavra insert
			novoContato(request, response);//vai chamar o metodo novoContato
		}else {//se o servelet receber alguma requisicao que ele nao conhece
			response.sendRedirect("index.html");//vai redirecionar para o index.html
		}
	}

	// listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("agenda.jsp");
	}
	
	//novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		//request.getParameter --> serve para capturar o dados do formulario
		//cada parametro e o nome do campo da caixa de texo
			System.out.println(request.getParameter("nome"));
			System.out.println(request.getParameter("Fone"));
			System.out.println(request.getParameter("email"));
			
			//setar as variaveis JavaBeans
			//objeto contato vai armazenar na variavel nome o parametro 
			contato.setNome(request.getParameter("nome"));
			contato.setNome(request.getParameter("Fone"));
			contato.setNome(request.getParameter("email"));
		
	}

}
