package one.digital.innovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.innovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity // indica que é uma identidade
@Data // Seta Get e Setters
@Builder //Padrão de projetos para construção de objetos
@AllArgsConstructor // Insere construtor com todos os argumentos
@NoArgsConstructor // Construtor sem argumentos
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
