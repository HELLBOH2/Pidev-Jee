package ManagedBean;

import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Services.UserService;
import enumeration.Role;
import model.AspNetUser;


@ManagedBean
@SessionScoped
public class LoginBean {

	private String login;
	private String password;
	private AspNetUser user;
	private boolean loggedIn;

	// injection de depandance
	@EJB
	UserService userServices;

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	public String doLogin() {
		String navigateTo = "null";
		user = userServices.getUserByEmailAndPassword(login, password);
		if (user != null && (user.getRole().equals(Role.Candidat.toString()))) {
			Savelogger(user);
			navigateTo = "/pages/collaborator/CollaboratorDashboard?faces-redirect=true";
			loggedIn = true;
		}
		else if(user != null && (user.getRole().equals(Role.ProjectManager.toString()))){
			Savelogger(user);
			navigateTo = "/pages/managerDashboard?faces-redirect=true";
		}
		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
	return navigateTo;

	}
	
	public void  Savelogger(AspNetUser c){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		   sessionMap.put("logger" , c);
	}


	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/login/login?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AspNetUser getUser() {
		return user;
	}

	public void setUser(AspNetUser user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public UserService getUserServices() {
		return userServices;
	}

	public void setUserServices(UserService userServices) {
		this.userServices = userServices;
	}


}
