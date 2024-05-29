package service;

import java.util.ArrayList;
import java.util.List;

import dao.EmployeDao;
import model.Employe;

public class EmployeService {
EmployeDao employeDao;
public EmployeService() {
	employeDao=new EmployeDao();
	
}

public List<Employe> getAllEmployes(){
	return employeDao.getAllEmployes();
}

public Employe addEmploye(Employe employe) {
	return employeDao.addEmploye(employe);
}

public void deleteEmploye(Employe employe) {
	employeDao.deleteEmploye(employe);
}
}