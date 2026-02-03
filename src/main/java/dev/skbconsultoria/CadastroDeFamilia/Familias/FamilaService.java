package dev.skbconsultoria.CadastroDeFamilia.Familias;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilaService {

    private FamilaRepository familaRepository;

    //agora inicializar o construtor, somente usando a anotation @Autowired ou usar o construtor.

    public FamilaService(FamilaRepository familaRepository){
        this.familaRepository = familaRepository;
    }

    //Listar meus familiares
    public List<FamiliaModel> listarFamilia(){
        return familaRepository.findAll();
    }

    //Listar meus familiares por Id,aqui como o usuario que vai buscar por ID é ele que vai falar qual ID quer buscar
    public FamiliaModel listarFamiliaID(Long id){
        Optional<FamiliaModel> familaPorId = familaRepository.findById(id);
        return familaPorId.orElse(null);
    }

    //Adicionar familiar tendo que passar todas as informações do banco de dados do FamiliaModel menos o ID que é
    // gerado automaticamente, o INSERT do BD no JPA se chama SAVE
    public FamiliaModel criarFamilia(FamiliaModel familia){
        return familaRepository.save(familia);
    }
<<<<<<< HEAD
=======

    //Deletar Familiar - Sempre tem que ser VOID pois nao tem que retornar nada para o user
    public void deletarFamiliarPorId(Long id){
        familaRepository.deleteById(id);
    }
>>>>>>> db43ade (feat: Adiciona a rota de deleção do familiar por id)
}
