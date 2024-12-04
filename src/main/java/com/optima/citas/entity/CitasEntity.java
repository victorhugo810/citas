package com.optima.citas.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
/*@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter*/
@Table(name="citas")
public class CitasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombreProyecto;

    private String consulta;

    @CreationTimestamp
    private Date fechaRegistro;

    private Date fechaAsignacion;

    private Date fechaCulminada;

    private String estado;

    @ManyToOne
    private UserEntity usuarioCliente;

    @ManyToOne
    private UserEntity usuarioAsignado;

    public CitasEntity() {
    }

    public CitasEntity(Integer id, String nombreProyecto, String consulta, Date fechaRegistro, Date fechaAsignacion, Date fechaCulminada, String estado, UserEntity usuarioCliente, UserEntity usuarioAsignado) {
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.consulta = consulta;
        this.fechaRegistro = fechaRegistro;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaCulminada = fechaCulminada;
        this.estado = estado;
        this.usuarioCliente = usuarioCliente;
        this.usuarioAsignado = usuarioAsignado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaCulminada() {
        return fechaCulminada;
    }

    public void setFechaCulminada(Date fechaCulminada) {
        this.fechaCulminada = fechaCulminada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UserEntity getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(UserEntity usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public UserEntity getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(UserEntity usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }
}//fin de la clase citas
