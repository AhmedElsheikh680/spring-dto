package com.spring.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {

    private Long id;

    private String name;

//    private String cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
