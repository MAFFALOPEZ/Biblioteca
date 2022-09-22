package com.Biblioteca.Prestamos.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Prestamo")
public class Prestamo {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prestamo;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "documento", referencedColumnName ="documento", nullable = false)
    @JsonIgnore
    private Estudiante estudiante;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "isbn", referencedColumnName = "isbn", nullable = false)
    @JsonIgnore
    private Libro libro;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @PrePersist
    public void prePersist(){
        this.fecha = new Date();
    }

    public Prestamo() {
    }

    public Prestamo(int id_prestamo, Estudiante estudiante, Libro libro, Date fecha) {
        this.id_prestamo = id_prestamo;
        this.estudiante = estudiante;
        this.libro = libro;
        this.fecha = fecha;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Libro getLibro() {
        return (Libro) libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id_prestamo=" + id_prestamo +
                ", estudiante='" + estudiante + '\'' +
                ", libro='" + libro + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
