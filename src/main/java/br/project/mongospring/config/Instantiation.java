package br.project.mongospring.config;

import br.project.mongospring.domain.Post;
import br.project.mongospring.domain.User;
import br.project.mongospring.dto.AuthorDTO;
import br.project.mongospring.dto.CommentDTO;
import br.project.mongospring.repositories.PostRepository;
import br.project.mongospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostRepository postRepo;
    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        userRepo.deleteAll();
        postRepo.deleteAll();
        User maria = new User(null,"Maria do carmo","maria@gmail.com");
        User jose = new User(null,"Jose do carmo","jose@gmail.com");

        userRepo.saveAll(Arrays.asList(maria,jose));

        Post p1 = new Post(null, LocalDate.parse("21/07/2026",dtf),"Partiu acapulco","so lança e balinha",new AuthorDTO(maria));
        Post p2 = new Post(null, LocalDate.parse("23/07/2026",dtf),"Partiu baile com as amiga","dar perdido no meu ex",new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Que merda em",LocalDate.parse("22/07/2026",dtf),new AuthorDTO(jose));
        CommentDTO c2 = new CommentDTO("Baile mucho",LocalDate.parse("23/07/2026",dtf),new AuthorDTO(jose));

        p1.getComments().add(c1);
        p2.getComments().add(c2);
        postRepo.saveAll(Arrays.asList(p1,p2));

        maria.getPosts().addAll(Arrays.asList(p1,p2));
        userRepo.save(maria);
    }
}
