package dao;

import models.Animal;
import models.Customer;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oCustomerDao implements CustomerDao{
    private final Sql2o sql2o ;

    public Sql2oCustomerDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Customer customer) {
        String sql = "INSERT INTO customers (name, phonenum, animalpreference, breedpreference) VALUES (:name, :phoneNum, :animalPreference, :breedPreference)"; //raw sql
        try (Connection con = sql2o.open()) { //try to open a connection
            int id = (int) con.createQuery(sql) //make a new variable
                    .bind(customer) //map my argument onto the query so we can use information from it
                    .executeUpdate() //run it all
                    .getKey(); //int id is now the row number (row “key”) of db
            customer.setId(id); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }
    @Override
    public List<Customer> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM customers") //raw sql
                    .executeAndFetch(Customer.class); //fetch a list
        }
    }

    @Override
    public Customer findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM customers WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Customer.class);
        }
    }
    public List<Customer> getCustomersByBreedPreference() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM customers ORDER BY breedpreference")
                    .executeAndFetch(Customer.class);
        }
    }

}
