package dev.skbconsultoria.CadastroDeFamilia.Familias;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class FamiliaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem vindo, essa é a mensagem inicial";
    }





}
