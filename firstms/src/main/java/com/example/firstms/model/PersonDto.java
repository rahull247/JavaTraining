package com.example.firstms.model;

public class PersonDto {
	private final Integer id;
    private final String name;
    private final long age;
    public PersonDto(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getAge() {
        return age;
    }
}
