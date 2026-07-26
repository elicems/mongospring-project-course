package br.project.mongospring.repositories;

import br.project.mongospring.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
