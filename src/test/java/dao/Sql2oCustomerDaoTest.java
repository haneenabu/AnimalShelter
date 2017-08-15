package dao;

import models.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/15/17.
 */
public class Sql2oCustomerDaoTest {

    private Sql2oCustomerDao customerDao;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing2;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        customerDao = new Sql2oCustomerDao(sql2o); //ignore me for now

        //keep connection ope
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void addInstanceOfAnimal() throws Exception {
        Customer customer = new Customer("Bobbi Jo", 404, "doggies", "dachsund");
        customerDao.add(customer);
        int originalCustomerId = customer.getId();
        assertEquals(originalCustomerId, customer.getId());
    }

    @Test
    public void customerCanBeFoundById() throws Exception{
        Customer customer = new Customer("Bobbi Jo", 404 , "cats", "fluffy");
        customerDao.add(customer);
        Customer foundCustomer = customerDao.findById(customer.getId());
        assertEquals(customer, foundCustomer);
    }

    @Test
    public void getAllInstancesOfCustomer() throws Exception {
        Customer customer= new Customer("Bobbi Jo", 404 , "cats", "fluffy");
        Customer customer2= new Customer(" Jo", 404 , "cats", "fluffy");
        customerDao.add(customer);
        customerDao.add(customer2);
        assertEquals(2, customerDao.getAll().size());
    }
    @Test
    public void getAllCustomersByBreedPreference() throws Exception {
        Customer customer= new Customer("Bobbi Jo", 404 , "cats", "fluffy");
        Customer customer2= new Customer(" Jo", 404 , "cats", "fluffy");
        customerDao.add(customer);
        customerDao.add(customer2);
        assertEquals(2, customerDao.getCustomersByBreedPreference().size());
    }

}