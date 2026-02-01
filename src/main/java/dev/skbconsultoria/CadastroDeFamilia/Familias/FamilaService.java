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


}
