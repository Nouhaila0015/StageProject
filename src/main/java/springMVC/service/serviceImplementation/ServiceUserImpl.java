package springMVC.service.serviceImplementation;


import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import springMVC.dao.entities.User;
import springMVC.dao.repositories.IUserRepo;
import springMVC.service.IService.IServiceUser;

@Service
public class ServiceUserImpl implements IServiceUser {
    @Autowired
    private IUserRepo userRepository;

    @Override
    public User rechercherParId(String username) {
        return userRepository.findById(username).orElseThrow(() 
        		-> new RuntimeException("User not found"));
    }
}
