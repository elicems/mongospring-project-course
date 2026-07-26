package br.project.mongospring.config;

import br.project.mongospring.domain.User;
import br.project.mongospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repo;
    @Override
    public void run(String... args) throws Exception {
    }
}
