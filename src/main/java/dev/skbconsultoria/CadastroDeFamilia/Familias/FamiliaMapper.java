package dev.skbconsultoria.CadastroDeFamilia.Familias;
import org.springframework.stereotype.Component;

@Component
public class FamiliaMapper {

        public FamiliaModel map(FamiliaDTO familiaDTO) {

                FamiliaModel familiaModel = new FamiliaModel();
                familiaModel.setId(familiaDTO.getId());
                familiaModel.setNome(familiaDTO.getNome());
                familiaModel.setEmail(familiaDTO.getEmail());
                familiaModel.setIdade(familiaDTO.getIdade());
                familiaModel.setRank(familiaDTO.getRank());
                familiaModel.setTrabalho(familiaDTO.getTrabalho());

                return familiaModel;
        }

        public FamiliaDTO map(FamiliaModel familiaModel) {

                FamiliaDTO familiaDTO = new FamiliaDTO();
                familiaDTO.setId(familiaModel.getId());
                familiaDTO.setNome(familiaModel.getNome());
                familiaDTO.setEmail(familiaModel.getEmail());
                familiaDTO.setIdade(familiaModel.getIdade());
                familiaDTO.setRank(familiaModel.getRank());
                familiaDTO.setTrabalho(familiaModel.getTrabalho());

                return familiaDTO;
        }
}
