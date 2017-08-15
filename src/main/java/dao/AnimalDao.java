package dao;
import models.Animal;

import java.util.List;

public interface AnimalDao {

    //create
    void add (Animal animal);
    //read
    List<Animal> getAll();

    Animal findById(int id);


    //update
    //void update(int id, String content, int categoryId);
    //delete
//    void deleteById(int id);

   // void clearAllTasks();

}