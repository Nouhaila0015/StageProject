package springMVC.service.IService;

import springMVC.dao.entities.User;

public interface IServiceUser {
	public User rechercherParId(String username);
}
