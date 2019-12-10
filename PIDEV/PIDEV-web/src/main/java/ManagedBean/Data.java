package ManagedBean;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import enumeration.Role;






@ManagedBean(name = "data")
@ApplicationScoped
public class Data implements Serializable {
	private static final long serialVersionUID = 1L;

	public Role[] getRoles() {
		return Role.values();
	}
	
	public Data() {
		// TODO Auto-generated constructor stub
	}
}
