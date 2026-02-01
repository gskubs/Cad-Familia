package dev.skbconsultoria.CadastroDeFamilia.Familias;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class FamiliaController {

    private FamilaService familaService;

    public FamiliaController(FamilaService familaService) {
        this.familaService = familaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem vindo, essa é a mensagem inicial";
    }

    //VAMOS COMEÇAR NO BASICO NO CRUD

    //Adicionar familiar (CREATE) @PostMapping para adicionar
    @PostMapping("/criar")
    public String criarFamilia(){
        return "Familiar criado com sucesso";
    }

    //MOSTRAR TODOS OS FAMILIARES (READ) @GetMapping é usado para mostrar um resultado
    @GetMapping("/todos")
    public List<FamiliaModel> listarFamilia(){
        return familaService.listarFamilia();
    }

    // MOSTRAR familiares por ID (READ)
    @GetMapping("/todosID")
    public String mostrarFamiliaPorId(){
        return "Essa é minha familia por id";
    }

    //Alterar dados dos familiares (UPDATE) @PutMapping usado para alterar dados
    @PutMapping("/alterarID")
    public String alterarFamiliarPorId(){
        return "Alterar familiar por id";
    }

    // Deletar familiar (DELETE) @DeleteMapping usado para deletar dados
    @DeleteMapping("/deletarID")
    public String deletarFamiliaPorId(){
        return "Deletando familiar por id";
    }







}
