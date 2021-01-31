package at.aau.ue5.bsp1.dao;

import at.aau.ue5.bsp1.dao.impl.ListCustomerDao;
import at.aau.ue5.bsp1.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoTest {

    ListCustomerDao customerDao;
    ListCustomerDao customerDaoEmpty;
    List customerDaoList;
    List customerDaoListEmpty;
    Customer customer1;
    Customer customer2;
    Customer customer3;

    @BeforeEach
    public void beforeEach(){
        customerDao=new ListCustomerDao();
        customerDaoEmpty = new ListCustomerDao();
        customerDaoList=new ArrayList();
        customerDaoListEmpty=new ArrayList();
        customer1 = new Customer((long) 5000,"Person1","Straße1");
        customer2 = new Customer((long) 5001,"Person2","Straße2");
        customer3 = new Customer((long) 5002,"Person3","Straße3");
        customerDao.insert(customer1);
        customerDao.insert(customer2);
        customerDaoList.add(customer1);
        customerDaoList.add(customer2);
    }

    /**
     * findAll()
     */
    @Test
    public void Should_ReturnListSize_WhenCallingFindAll(){
        Assertions.assertEquals(customerDaoList,customerDao.findAll());
    }
    @Test
    public void Should_ReturnZero_WhenCallingFindAllAndListIsEmpty(){
        Assertions.assertEquals(new ArrayList<>(),customerDaoEmpty.findAll());
    }
    /**
     * findOne()
     */
    @Test
    public void Should_ReturnCustomer_WhenCustomerInList(){
        Assertions.assertEquals(customer1,customerDao.findOne((long)1));
    }
    @Test
    public void Should_ReturnNull_WhenCustomerIsNotInList(){
        Assertions.assertEquals(null,customerDao.findOne((long)4000));
    }
    @Test
    public void Should_ReturnNull_WhenListIsEmpty(){
        Assertions.assertEquals(null,customerDaoEmpty.findOne((long)4000));
    }
    /**
     * insert()
     */
    @Test
    public void Should_ReturnCustomerAndIncrByOne_WhenCallingInsert(){
        Assertions.assertEquals(customer3,customerDao.insert(customer3));
        customerDaoList.add(customer3);
        Assertions.assertEquals(customerDaoList,customerDao.findAll());
    }
    /**
     * delete()
     */
    @Test
    public void Should_RemoveCustomerAndDecrByOne_WhenCustomerIsInList(){
        Assertions.assertEquals(customerDaoList,customerDao.findAll());
        customerDao.delete((long)2);
        customerDaoList.remove(customer2);
        Assertions.assertEquals(customerDaoList,customerDao.findAll());
    }
    @Test
    public void Should_NotRemoveCustomerAndDecrByOne_WhenCustomerIsNotInList(){
        Assertions.assertEquals(customerDaoList,customerDao.findAll());
        customerDao.delete((long)3);
        Assertions.assertEquals(customerDaoList,customerDao.findAll());
    }
    @Test
    public void Should_NotRemoveCustomerAndDecrByOne_WhenListIsEmpty(){
        Assertions.assertEquals(new ArrayList<>(),customerDaoEmpty.findAll());
        customerDao.delete((long)3);
        Assertions.assertEquals(new ArrayList<>(),customerDaoEmpty.findAll());
    }
    /**
     * update()
     */
    @Test
    public void Should_ReturnRemovedCustomerObj_WhenCustomerIdIsEqualToIdOfListItem(){
        Customer customer4 = new Customer((long)2,"Person4","Straße4");
        Assertions.assertEquals(customerDaoList,customerDao.findAll());
        Assertions.assertEquals(customer2,customerDao.update(customer4));
        customerDaoList.remove(customer2);
        customerDaoList.add(customer4);
        Assertions.assertEquals(customerDaoList,customerDao.findAll());
    }
    @Test
    public void Should_ReturnNullAndAddCustomer_WhenCustomerIdIsNotEqualToIdOfListItem(){
        Assertions.assertEquals(customerDaoList,customerDao.findAll());
        Assertions.assertEquals(null,customerDao.update(customer3));
        customerDaoList.add(customer3);
        Assertions.assertEquals(customerDaoList,customerDao.findAll());
    }
    @Test
    public void Should_ReturnNullAndAddCustomer_WhenListIsEmpty(){
        Assertions.assertEquals(new ArrayList<>(),customerDaoEmpty.findAll());
        Assertions.assertEquals(null,customerDaoEmpty.update(customer3));
        customerDaoListEmpty.add(customer3);
        Assertions.assertEquals(customerDaoListEmpty,customerDaoEmpty.findAll());
    }
    /**
     * findCustomerByName()
     */
    @Test
    public void Should_ReturnEmptyList_WhenCustomerNameIsNotEqualToNamesInList(){
        Assertions.assertEquals(new ArrayList(),customerDao.findCustomerByName("Person55"));
    }
    @Test
    public void Should_ReturnListWithCustomers_WhenCustomerNameIsEqualToNamesInList(){
        List l = new ArrayList();
        l.add(customer1);
        Assertions.assertEquals(l,customerDao.findCustomerByName("Person1"));
    }
    @Test
    public void Should_ReturnEmptyList_WhenListIsEmpty(){
        Assertions.assertEquals(new ArrayList(),customerDaoEmpty.findCustomerByName("Person55"));
    }

}
