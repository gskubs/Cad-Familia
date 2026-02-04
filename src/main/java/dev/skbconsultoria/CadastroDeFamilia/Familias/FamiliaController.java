package dev.skbconsultoria.CadastroDeFamilia.Familias;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarFamilia(@RequestBody FamiliaDTO familia){
        FamiliaDTO novoFamiliar = familiaService.criarFamilia(familia);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Familiar adicionado com sucesso: " + novoFamiliar.getNome() + " (ID): "  + novoFamiliar.getId());
    }

    //MOSTRAR TODOS OS FAMILIARES (READ) @GetMapping é usado para mostrar do BD um resultado
    @GetMapping("/todos")
    public ResponseEntity <List<FamiliaDTO>> listarFamilia(){
        List<FamiliaDTO> listaFamilia = familiaService.listarFamilia();
        return ResponseEntity.ok(listaFamilia);
    }

    // MOSTRAR familiares por ID (READ) é aqui que o user vai preencher o ID que ele quer buscar
    //Colocar o <?> para puxar generics ou seja todos os tipos de dados para puxar todos os tipos de dados
    @GetMapping("/todos/{id}")
    public ResponseEntity<?> listarFamiliaID(@PathVariable Long id){
        FamiliaDTO familia = familiaService.listarFamiliaID(id);
        if(familia != null){
            return ResponseEntity.ok(familia);
        }
        else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Familiar: " + id + " Não existe nos meus registros");
        }
    }

    //Alterar dados dos familiares (UPDATE) @PutMapping usado para alterar dados
    //como o @PutMapping é uma mistura do PostMapping com o GetMapping, precicamos colocar a variavel
    //@PathVariable para buscar dados nesse caso por ID e o RequestBody, pois precisamo buscar os dados que precisam ser alterados
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarFamiliarPorId(@PathVariable Long id, @RequestBody FamiliaDTO familiaAtualizado){
        FamiliaDTO familia = familiaService.atualizarFamilia(id, familiaAtualizado);
        if(familia != null){
            return ResponseEntity.ok(familia);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum Familiar com esse ID " + id + " foi encontrado!");
        }

    }

    // Deletar familiar (DELETE) @DeleteMapping usado para deletar dados
    //Usar o @PathVariable sempre que precisa ser passado um dado para buscar o dado
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarFamiliarPorId(@PathVariable Long id){

        if (familiaService.listarFamiliaID(id) != null) {
            familiaService.deletarFamiliarPorId(id);
            return ResponseEntity.ok("Familiar com ID " + id + " Deletado com Sucesso!!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum Familiar com esse ID" + id + " foi encontrado!");
        }

    }

}