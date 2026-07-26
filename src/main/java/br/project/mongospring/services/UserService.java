package br.project.mongospring.services;

import br.project.mongospring.domain.User;
import br.project.mongospring.dto.UserDTO;
import br.project.mongospring.repositories.UserRepository;
import br.project.mongospring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
    public User findById(String id){
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(()-> new ObjectNotFoundException("Object not found!"));
    }
    public User insert(User obj){
        return repo.insert(obj);
    }
    public void deleteById(String id){
        findById(id);
        repo.deleteById(id);
    }
    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(),userDTO.getName(), userDTO.getEmail());
    }
}
