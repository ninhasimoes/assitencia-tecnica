package br.fiap.assistenciatecnica.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
@Table(name = "JAVA_EQUIPAMENTO")
@Getter
@Setter
@NoArgsConstructor
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EQUIP")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    private String tipo;
    private String marca;
    private String modelo;

    @Column(name = "NUMERO_SERIE")
    private String numero_serie;

    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;

}
// tipo, marca, modelo, numeroSerie, dataCadastr