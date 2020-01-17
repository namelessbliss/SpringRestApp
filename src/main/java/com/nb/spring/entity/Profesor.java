package com.nb.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "profesores")
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id autogenerado
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(length = 60, unique = true) //campo unico
    private String email;

    private String password;

    @Column(length = 2000)
    private String foto;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @OneToMany(cascade = CascadeType.ALL) //Si se borra un profesor, se borraran sus cursos asociados
    @JoinColumn(name = "profesor_id", referencedColumnName = "id")
    private List<Curso> curso = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "profesores_lenguajes",
            joinColumns = @JoinColumn(name = "profesor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lenguaje_id", referencedColumnName = "id"))
    private Set<Lenguaje> lenguajes = new HashSet<Lenguaje>();

    public Set<Lenguaje> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(Set<Lenguaje> lenguajes) {
        this.lenguajes = lenguajes;
    }

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    public Profesor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }

    public void addLenguaje(Lenguaje lenguaje){
        this.lenguajes.add(lenguaje);
    }
}
