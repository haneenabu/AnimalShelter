package models;

/**
 * Created by Guest on 8/15/17.
 */
public class Customer {
    private String name;
    private int phoneNum;
    private String animalPreference;
    private String breedPreference;



    private int id;

    public Customer(String name, int phoneNum, String animalPreference, String breedPreference){
        this.name = name;
        this.phoneNum = phoneNum;
        this.animalPreference = animalPreference;
        this.breedPreference = breedPreference;
        //this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAnimalPreference() {
        return animalPreference;
    }

    public void setAnimalPreference(String animalPreference) {
        this.animalPreference = animalPreference;
    }

    public String getBreedPreference() {
        return breedPreference;
    }

    public void setBreedPreference(String breedPreference) {
        this.breedPreference = breedPreference;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!name.equals(customer.name)) return false;
        if (phoneNum != customer.phoneNum) return false;
        if (id != customer.id) return false;

        if (animalPreference != null ? !animalPreference.equals(customer.animalPreference) : customer.animalPreference != null)
            return false;
        return breedPreference != null ? breedPreference.equals(customer.breedPreference) : customer.breedPreference == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + phoneNum;
        result = 31 * result + (animalPreference != null ? animalPreference.hashCode() : 0);
        result = 31 * result + (breedPreference != null ? breedPreference.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
