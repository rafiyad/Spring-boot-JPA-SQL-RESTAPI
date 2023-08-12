package com.example.demodb;


import jakarta.persistence.*;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Service;

@Service
@Entity
@Table(name = "student")
public class StudentID {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;

    public StudentID(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentID() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
