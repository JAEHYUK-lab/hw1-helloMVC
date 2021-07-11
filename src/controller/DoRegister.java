package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

@WebServlet("/doRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//registerForm.jsp에서 입력한 값을 받아온다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");

		//CustomerService.java에서 set한 값들을 불러온다.
		CustomerService service = (CustomerService) CustomerService.getInstance();
		Customer customer = service.register(id, password, name, gender, email);

		String page;
		
		//id나 password를 입력하지 않으면 error 페이지
		if(id.isEmpty() || password.isEmpty()) {
			page = "/view/error.jsp";
			request.setAttribute("id", id);
		}
		//id와 password 둘 다 입력했으면 회원가입 완료 페이지
		else {
			page = "/view/registerSuccess.jsp";
			request.setAttribute("customer", customer);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}
