package dev.skbconsultoria.CadastroDeFamilia.Familias;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FamiliaService {

    private FamiliaRepository familiaRepository;
    private FamiliaMapper familiaMapper;

    //agora inicializar o construtor, somente usando a anotation @Autowired ou usar o construtor.

    public FamiliaService(FamiliaRepository familiaRepository, FamiliaMapper familiaMapper) {
        this.familiaRepository = familiaRepository;
        this.familiaMapper = familiaMapper;
    }

    //Listar meus familiares
    //Aqui estou retornando a minha lista ao inves de for usando o Stream
    public List<FamiliaDTO> listarFamilia() {
        List<FamiliaModel> familias = familiaRepository.findAll();
        return familias.stream()
                .map(familiaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar meus familiares por Id,aqui como o usuario que vai buscar por ID é ele que vai falar qual ID quer buscar
    public FamiliaDTO listarFamiliaID(Long id) {
        Optional<FamiliaModel> familiaPorId = familiaRepository.findById(id);
        return familiaPorId.map(familiaMapper::map)
                .orElse(null);
    }

        //Criar/Adicionar familiar tendo que passar todas as informações do banco de dados do FamiliaModel menos o ID que é
        // gerado automaticamente, o INSERT do BD no JPA se chama SAVE

    public FamiliaDTO criarFamilia(FamiliaDTO familiaDTO) {
        FamiliaModel familiaModel = familiaMapper.map(familiaDTO); // <-- AQUI É O CERTO
        FamiliaModel salvo = familiaRepository.save(familiaModel);
        return familiaMapper.map(salvo);
    }
        
        //Deletar Familiar - Sempre tem que ser VOID pois nao tem que retornar nada para o user
        public void deletarFamiliarPorId (Long id){
            familiaRepository.deleteById(id);
        }

        //Atualizar Familiar - nesse caso preciso passar o ID para buscar mais o meu FamilaModel
        public FamiliaDTO atualizarFamilia (Long id, FamiliaDTO familiaDTO){
            Optional<FamiliaModel> familiaExistente = familiaRepository.findById(id);
            if (familiaExistente.isPresent()) {
                FamiliaModel familiaAtualizado = familiaMapper.map(familiaDTO);
                familiaAtualizado.setId(id);
                FamiliaModel familiaSalvo = familiaRepository.save(familiaAtualizado);
                return familiaMapper.map(familiaSalvo);
            }
                return null;
        }
}


