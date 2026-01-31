package dev.skbconsultoria.CadastroDeFamilia.Trabalhos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TrabalhoController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Bem vindo, essa é a mensagem inicial";
    }




}
