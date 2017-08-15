package models;


import java.time.LocalDateTime;

public class Animal {

    private String name;
    private String gender;
    private LocalDateTime admitDate;
    private String type;
    private String breed;
    private int id;

    public Animal (String name, String gender, String type, String breed) {
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.breed = breed;
        this.admitDate = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDateTime getAdmitDate() {
        return admitDate;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getBreed() {
        return breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAdmitDate(LocalDateTime admitDate) {
        this.admitDate = admitDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (!name.equals(animal.name)) return false;
        if (gender != null ? !gender.equals(animal.gender) : animal.gender != null) return false;
        if (type != null ? !type.equals(animal.type) : animal.type != null) return false;
        return breed != null ? breed.equals(animal.breed) : animal.breed == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (admitDate != null ? admitDate.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (breed != null ? breed.hashCode() : 0);
        return result;
    }


}
