package dao;

import models.Customer;

import java.util.List;

/**
 * Created by Guest on 8/15/17.
 */
public interface CustomerDao {
    void add (Customer customer);
    List<Customer> getAll();
    Customer findById(int id);
}
