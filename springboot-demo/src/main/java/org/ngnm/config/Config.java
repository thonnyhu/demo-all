package org.ngnm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Value("${name}")
    public void setName(String name) {
        this.name = name;
    }
    private String name;

    public String getSchool() {
        return school;
    }
    @Value("${school}")
    public void setSchool(String school) {
        this.school = school;
    }

    private String school;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Config{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
