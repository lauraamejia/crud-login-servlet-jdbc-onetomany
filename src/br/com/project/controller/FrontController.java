package br.com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.project.dao.AlunoDao;
import br.com.project.dao.DisciplinaDao;
import br.com.project.dao.UsuarioDao;
import br.com.project.dto.AlunoDisciplinaDto;
import br.com.project.model.Aluno;
import br.com.project.model.Disciplina;
import br.com.project.model.Usuario;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String cmd = request.getParameter("cmd");
    	if (cmd.equalsIgnoreCase("excluir")) {
    		excluir(request, response);
    	} else if (cmd.equalsIgnoreCase("alterar")) {
    		alterar(request, response);
    	}
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String cmd = request.getParameter("cmd");
    	if (cmd.equalsIgnoreCase("gravar")) {
    		gravar(request, response);
    	} else if (cmd.equalsIgnoreCase("editar")) {
    		editar(request, response);
    	} else if (cmd.equalsIgnoreCase("logar")) {
    		logar(request, response);
    	}
	}
    
    protected void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		Aluno a = new Aluno(null, request.getParameter("nome"), request.getParameter("email"));
    		Disciplina d = new DisciplinaDao().findByCod(Integer.parseInt(request.getParameter("disciplina")));
    		a.setDisciplina(d);
    		new AlunoDao().create(a);
    		response.sendRedirect("pages/admin/consulta.jsp");
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}
    
    protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		Integer idAluno = Integer.parseInt(request.getParameter("idAluno"));
    		new AlunoDao().delete(idAluno);
    		response.sendRedirect("pages/admin/consulta.jsp");
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}
    
    protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		Integer idAluno = Integer.parseInt(request.getParameter("idAluno"));
    		AlunoDisciplinaDto alunoDisciplinaDto = new AlunoDao().findByCod(idAluno);
    		request.setAttribute("alunoDisciplinaDto", alunoDisciplinaDto);
    		getServletContext().getRequestDispatcher("/pages/admin/editar.jsp").forward(request, response);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}
    
    protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		Aluno a = new Aluno(Integer.parseInt(request.getParameter("idAluno")), request.getParameter("nome"), request.getParameter("email"));
    		Disciplina d = new DisciplinaDao().findByCod(Integer.parseInt(request.getParameter("disciplina")));
    		a.setDisciplina(d);
    		new AlunoDao().update(a);
    		response.sendRedirect("/project/pages/admin/consulta.jsp");
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}
    
    protected void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
    	try {
    		Usuario u = new Usuario(null, request.getParameter("login"), request.getParameter("senha"));
    		Usuario usuario = new UsuarioDao().findByUsuario(u);
    		if (usuario==null) {
    			request.setAttribute("msg", "Login invalido!");
    			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
    		} else {
    			HttpSession httpSession = request.getSession();
    			httpSession.setAttribute("usuario", usuario);
    			request.getRequestDispatcher("pages/admin/index.jsp").forward(request, response);
    		}
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}
    
}
