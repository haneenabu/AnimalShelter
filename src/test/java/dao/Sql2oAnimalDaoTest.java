package dao;
import models.Animal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import static org.junit.Assert.*;


public class Sql2oAnimalDaoTest {
    private Sql2oAnimalDao animalDao;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        animalDao = new Sql2oAnimalDao(sql2o); //ignore me for now

        //keep connection open through entire test so it does not get erased.
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void addInstanceOfAnimal_True () throws Exception {
        Animal animal = new Animal("Fifi", "female", "cat", "persian");
        animalDao.add(animal); //add to dao (takes care of saving)
        int originalAnimalId = animal.getId();
        assertEquals(originalAnimalId, animal.getId()); //should be the same
    }

    @Test
    public void animalCanBeFoundById(){
        Animal animal = new Animal("spark", "male", "dog", "goldenretriever");
        animalDao.add(animal);
        Animal foundAnimal = animalDao.findById(animal.getId());
        System.out.println(foundAnimal);
        System.out.println(animal);
        assertEquals(animal, foundAnimal);
    }
    @Test public void returnAnimalsByBreed() {
        Animal animal = new Animal("spark", "male", "dog", "corgie");
        Animal newAnimal = new Animal("spark", "male", "dog", "goldenretriever");
        animalDao.add(animal);
        animalDao.add(newAnimal);

        assertEquals(animal, animalDao.findByBreed("corgie"));
    }
    @Test
    public void returnByAdmitDate(){
        Animal animal = new Animal("spark", "male", "dog", "corgie");
        Animal newAnimal = new Animal("spark", "male", "dog", "goldenretriever");
        animalDao.add(animal);
        animalDao.add(newAnimal);
        System.out.println(animal.getAdmitDate());
        System.out.println(newAnimal.getAdmitDate());
        assertEquals(2, animalDao.orderByLongestTime().size());
    }
}