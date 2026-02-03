package dev.skbconsultoria.CadastroDeFamilia.Familias;

import dev.skbconsultoria.CadastroDeFamilia.Trabalhos.TrabalhoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

//Entity transforma uma classe em uma entidade do Banco de Dados
//JPA Java persistence API, esse jakarta persistence, vem tudo do JPA que baixamos no Spring
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor //Ele ja cria um construtor vazio de forma oculta graças ao Lombok
@AllArgsConstructor //Ele ja cria automaticamente os construtores cheios automaticamente de forma oculta graças ao Lombok
@Data //Ele ja cria automaticamente os getters e setters automaticamente de forma oculta graças ao Lombok
public class FamiliaModel {


    //passar o @ID para gerar o numero de identif de cada membro, e o GenerateValue para gerar os dados infinitamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)//Falando que a coluna do e-mail é unica, não pode haver 2 e-mails iguais.
    private String email;

    @Column(name = "idade")
    private Integer idade;

    //@ManyToOne um familiar tem apenas uma unica tarefa, usamos sempre no elemento que vc for precisar.
    @ManyToOne
    @JoinColumn(name = "trabalho_id") // Foreing Key, ou chave estrangeira
    private TrabalhoModel trabalho;

}
