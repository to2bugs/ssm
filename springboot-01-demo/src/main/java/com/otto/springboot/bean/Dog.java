package com.otto.springboot.bean;


import com.otto.springboot.properties.DogProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public class Dog {
    private String name;
    private Integer age;
    private String gender;

    private DogProperties dogProperties;

    public Dog(DogProperties dogProperties) {
        this.dogProperties = dogProperties;
    }

    public String getName() {
        return this.dogProperties.getName();
    }

    public Integer getAge() {
        return this.dogProperties.getAge();
    }

    public String getGender() {
        return this.dogProperties.getGender();
    }
}
