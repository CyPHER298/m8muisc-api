package br.fiap.music.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "cantor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cantor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nm_cantor", nullable = false, length = 50)
    private String nome;

    @NotBlank
    @Email
    @Size(max = 50)
    @Column(name = "email_cantor", nullable = false, unique = true, length = 50)
    private String email;

    @NotBlank
    @Size(max = 10)
    @Column(name = "senha_cantor", nullable = false, length = 10)
    private String senha;
}
