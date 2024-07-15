package springMVC.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import springMVC.dao.entities.User;

public interface IUserRepo extends JpaRepository<User,String>{

}
