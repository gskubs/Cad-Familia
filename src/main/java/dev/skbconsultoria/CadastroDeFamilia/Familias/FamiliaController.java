package dev.skbconsultoria.CadastroDeFamilia.Familias;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class FamiliaController {

    private FamiliaService familiaService;
    public FamiliaController(FamiliaService familiaService) {
        this.familiaService = familiaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem vindo, essa é a mensagem inicial";
    }

    //VAMOS COMEÇAR NO BASICO NO CRUD

    //Adicionar familiar (CREATE) @PostMapping para adicionar ao BD dados
    @PostMapping("/criar")
    public FamiliaDTO criarFamilia(@RequestBody FamiliaDTO familiaDTO){
        return familiaService.criarFamilia(familiaDTO);
    }

    //MOSTRAR TODOS OS FAMILIARES (READ) @GetMapping é usado para mostrar do BD um resultado
    @GetMapping("/todos")
    public List<FamiliaDTO> listarFamilia(){
        return familiaService.listarFamilia();
    }

    // MOSTRAR familiares por ID (READ) é aqui que o user vai preencher o ID que ele quer buscar
    @GetMapping("/todos/{id}")
    public FamiliaDTO listarFamiliaID(@PathVariable Long id){
       return familiaService.listarFamiliaID(id);
           }

    //Alterar dados dos familiares (UPDATE) @PutMapping usado para alterar dados
    //como o @PutMapping é uma mistura do PostMapping com o GetMapping, precicamos colocar a variavel
    //@PathVariable para buscar dados nesse caso por ID e o RequestBody, pois precisamo buscar os dados que precisam ser alterados
    @PutMapping("/alterar/{id}")
    public FamiliaDTO alterarFamiliarPorId(@PathVariable Long id, @RequestBody FamiliaDTO familiaAtualizado){
        return familiaService.atualizarFamilia(id, familiaAtualizado);//Dessa maneira eu consigo fazer o update
    }

    // Deletar familiar (DELETE) @DeleteMapping usado para deletar dados
    //Usar o @PathVariable sempre que precisa ser passado um dado para buscar o dado
    @DeleteMapping("/deletar/{id}")
    public void deletarFamiliarPorId(@PathVariable Long id){
        familiaService.deletarFamiliarPorId(id);
    }







}
