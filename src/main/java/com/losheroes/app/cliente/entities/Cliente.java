package com.losheroes.app.cliente.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.sql.Date;

/**
 * Cliente entity.
 */
@Entity
@Table(name = "cliente", uniqueConstraints =
        { @UniqueConstraint(name = "UK_CORREO", columnNames = "correo"), @UniqueConstraint(name = "UK_RUT",
                columnNames = "rutCliente") })
@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column
    private String nombreCliente;
    @Column
    private String rutCliente;
    @Column
    private String correo;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    @Column
    private Date fechaCreacion;
    @Column
    private String direccion;


}