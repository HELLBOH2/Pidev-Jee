package ManagedBean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import Services.UserService;
import enumeration.Role;
import model.AspNetUser;


@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {
		private static final long serialVersionUID = 1L;
		private String firstName;
		private String lastName;
		private String passwordHash;
		private String email;
		private Role role;
		private List<AspNetUser> user;
		private Integer userIdToBeUpdated;
		
	
		

		@EJB
		UserService userServices;

		
		@ManagedProperty(value="#{loginBean}")
		LoginBean loginBean;
		
		

		public void displayUser(AspNetUser empl) {
			this.setLastName(empl.getLastName());
			this.setFirstName(empl.getFirstName());			
			this.setEmail(empl.getEmail());
			this.setRole(Role.valueOf(empl.getRole()));
			this.setEmail(empl.getEmail());
			this.setPasswordHash(empl.getPasswordHash());
			this.setUserIdToBeUpdated(empl.getId());
		}



		public String getFirstName() {
			return firstName;
		}



		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}



		public String getLastName() {
			return lastName;
		}



		public void setLastName(String lastName) {
			this.lastName = lastName;
		}



		public String getPasswordHash() {
			return passwordHash;
		}



		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public Role getRole() {
			return role;
		}



		public void setRole(Role role) {
			this.role = role;
		}



		public List<AspNetUser> getUser() {
			return user;
		}



		public void setUser(List<AspNetUser> user) {
			this.user = user;
		}



		public Integer getUserIdToBeUpdated() {
			return userIdToBeUpdated;
		}



		public void setUserIdToBeUpdated(Integer userIdToBeUpdated) {
			this.userIdToBeUpdated = userIdToBeUpdated;
		}



		public UserService getUserServices() {
			return userServices;
		}



		public void setUserServices(UserService userServices) {
			this.userServices = userServices;
		}



		public LoginBean getLoginBean() {
			return loginBean;
		}



		public void setLoginBean(LoginBean loginBean) {
			this.loginBean = loginBean;
		}

		 
		
/*
		public String addUser() {
			
			if(loginBean == null || !loginBean.isLoggedIn())
			{
				return "/login?faces-redirect=true";
			}
			
			userServices.addUser(new User(nom, prenom, email, password, role));
			return null ;
		}
		//*/
}
