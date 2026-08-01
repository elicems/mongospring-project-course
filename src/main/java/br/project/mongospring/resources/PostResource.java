package br.project.mongospring.resources;

import br.project.mongospring.domain.Post;
import br.project.mongospring.resources.util.URL;
import br.project.mongospring.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        List<Post> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }
    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text",defaultValue = "")String text,
                                                 @RequestParam(value = "minDate",defaultValue = "")String minDate,
                                                 @RequestParam(value = "maxDate",defaultValue = "")String maxDate){
        text = URL.decodeParam(text);
        LocalDate min = URL.convertDate(minDate,LocalDate.of(2020,1,1));
        LocalDate max = URL.convertDate(maxDate,LocalDate.now());
        List<Post> list = service.allSearch(text,min,max);
        return ResponseEntity.ok().body(list);
    }

}
