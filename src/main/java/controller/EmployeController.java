package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employe;
import service.EmployeService;

@WebServlet("/employes")
public class EmployeController extends HttpServlet{
	EmployeService employeService;
	@Override
	public void init() throws ServletException {
		employeService=new EmployeService();
			}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		List<Employe> employes= this.employeService.getAllEmployes();
		ObjectMapper mapper=new ObjectMapper();
		String jsonEmploye=mapper.writeValueAsString(employes);
		resp.getWriter().write(jsonEmploye);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		String jsonEmploye="";
		String line;
		while((line=req.getReader().readLine()) != null) {
			jsonEmploye+=line.trim();
		}
		ObjectMapper mapper=new ObjectMapper();
		Employe employe=mapper.readValue(jsonEmploye, Employe.class);
		Employe empl=this.employeService.addEmploye(employe);
		if (empl!=null) {		
		PrintWriter response=resp.getWriter();
		response.write(jsonEmploye);
		}
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setHeader("Access-Control-Allow-Origin", "*");
        String jsonEmploye="";
		String line;
		while((line=req.getReader().readLine()) != null) {
			jsonEmploye+=line.trim();
		}
		System.out.println(jsonEmploye);
		ObjectMapper mapper=new ObjectMapper();
		Employe employe=mapper.readValue(jsonEmploye, Employe.class);
		employeService.deleteEmploye(employe);
	}
	

}