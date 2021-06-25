package one.digital.innovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //controlador rest
@RequestMapping("/api/v1/people") //caminho de acesso principal
public class PersonController {

    @GetMapping
    public String getBook(){
        return "API test!";
    }

}
