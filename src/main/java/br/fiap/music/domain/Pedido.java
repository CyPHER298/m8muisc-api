package br.fiap.music.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE", nullable = false,
            foreignKey = @ForeignKey(name = "FK_PEDIDO_CLIENTE"))
    private Cliente cliente;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MUSICA", nullable = false,
            foreignKey = @ForeignKey(name = "FK_PEDIDO_MUSICA"))
    private Musica musica;
}
