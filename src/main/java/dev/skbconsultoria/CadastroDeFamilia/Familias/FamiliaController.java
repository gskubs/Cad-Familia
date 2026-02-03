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

    //Adicionar familiar (CREATE) @PostMapping para adicionar ao BD dados
    @PostMapping("/criar")
    public FamiliaModel criarFamilia(@RequestBody FamiliaModel  familiaModel){
        return familaService.criarFamilia(familiaModel);
    }

    //MOSTRAR TODOS OS FAMILIARES (READ) @GetMapping é usado para mostrar do BD um resultado
    @GetMapping("/todos")
    public List<FamiliaModel> listarFamilia(){
        return familaService.listarFamilia();
    }

    // MOSTRAR familiares por ID (READ) é aqui que o user vai preencher o ID que ele quer buscar
    @GetMapping("/todos/{id}")
    public FamiliaModel listarFamiliaID(@PathVariable Long id){
       return familaService.listarFamiliaID(id);
           }

    //Alterar dados dos familiares (UPDATE) @PutMapping usado para alterar dados
    @PutMapping("/alterarID")
    public String alterarFamiliarPorId(){
        return "Alterar familiar por id";
    }

    // Deletar familiar (DELETE) @DeleteMapping usado para deletar dados
    //Usar o @PathVariable sempre que precisa ser passado um dado para buscar o dado
    @DeleteMapping("/deletar/{id}")
    public void deletarFamiliarPorId(@PathVariable Long id){
        familaService.deletarFamiliarPorId(id);
    }







}
