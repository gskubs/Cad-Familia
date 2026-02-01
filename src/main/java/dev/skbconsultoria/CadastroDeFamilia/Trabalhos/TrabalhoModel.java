package dev.skbconsultoria.CadastroDeFamilia.Trabalhos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.skbconsultoria.CadastroDeFamilia.Familias.FamiliaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Entity transforma uma classe em uma entidade do Banco de Dados
//JPA Java persistence API, esse jakarta persistence, vem tudo do JPA que baixamos no Spring
@Entity
@Table(name = "tb_tarefas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrabalhoModel {

    //passar o @ID para gerar o numero de identif de cada membro, e o GenerateValue para gerar os dados infinitamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tarefas;
    private String descricao;
    private String dificuldade;

    //@OneToMany significa muitos familiares em uma mesma tarefa, usamos sempre no elemento que vc for precisar.
    @OneToMany(mappedBy = "trabalho")
    @JsonIgnore
    private List<FamiliaModel> familia;






}


