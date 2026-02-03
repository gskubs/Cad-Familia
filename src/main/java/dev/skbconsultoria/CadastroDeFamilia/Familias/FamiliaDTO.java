package dev.skbconsultoria.CadastroDeFamilia.Familias;
import dev.skbconsultoria.CadastroDeFamilia.Trabalhos.TrabalhoModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FamiliaDTO {

    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private String rank;
    private TrabalhoModel trabalho;

}
