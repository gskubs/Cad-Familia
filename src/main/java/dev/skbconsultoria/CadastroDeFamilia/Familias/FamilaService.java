package dev.skbconsultoria.CadastroDeFamilia.Familias;

import org.springframework.stereotype.Service;

import java.util.List;

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


}
