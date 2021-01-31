package at.aau.ue5.bsp1.dao;

import at.aau.ue5.bsp1.dao.impl.ListProductDao;
import at.aau.ue5.bsp1.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoTest {
    ListProductDao listProductDao;
    ListProductDao listProductDaoEmpty;
    List listProductDaoList;
    List listProductDaoListEmpty;
    Product product1;
    Product product2;
    Product product3;

    @BeforeEach
    public void beforeEach(){
        listProductDao=new ListProductDao();
        listProductDaoEmpty = new ListProductDao();
        listProductDaoList=new ArrayList();
        listProductDaoListEmpty=new ArrayList();

        product1 = new Product((long) 5000,"Product1",50.00);
        product2 = new Product((long) 5001,"Product2",5.00);
        product3 = new Product((long) 5002,"Product3",6.00);

        listProductDao.insert(product1);
        listProductDao.insert(product2);
        listProductDaoList.add(product1);
        listProductDaoList.add(product2);
    }
    /**
     * findAll()
     */
    @Test
    public void Should_ReturnListSize_WhenCallingFindAll(){
        Assertions.assertEquals(listProductDaoList,listProductDao.findAll());
    }
    @Test
    public void Should_ReturnZero_WhenCallingFindAllAndListIsEmpty(){
        Assertions.assertEquals(new ArrayList<>(),listProductDaoEmpty.findAll());
    }
    /**
     * findOne()
     */
    @Test
    public void Should_ReturnCustomer_WhenCustomerInList(){
        Assertions.assertEquals(product1,listProductDao.findOne((long)1));
    }
    @Test
    public void Should_ReturnNull_WhenCustomerIsNotInList(){
        Assertions.assertEquals(null,listProductDao.findOne((long)4000));
    }
    @Test
    public void Should_ReturnNull_WhenListIsEmpty(){
        Assertions.assertEquals(null,listProductDaoEmpty.findOne((long)4000));
    }
    /**
     * insert()
     */
    @Test
    public void Should_ReturnCustomerAndIncrByOne_WhenCallingInsert(){
        Assertions.assertEquals(product3,listProductDao.insert(product3));
        listProductDaoList.add(product3);
        Assertions.assertEquals(listProductDaoList,listProductDao.findAll());
    }
    /**
     * delete()
     */
    @Test
    public void Should_RemoveCustomerAndDecrByOne_WhenCustomerIsInList(){
        Assertions.assertEquals(listProductDaoList,listProductDao.findAll());
        listProductDao.delete((long)2);
        listProductDaoList.remove(product2);
        Assertions.assertEquals(listProductDaoList,listProductDao.findAll());
    }
    @Test
    public void Should_NotRemoveCustomerAndDecrByOne_WhenCustomerIsNotInList(){
        Assertions.assertEquals(listProductDaoList,listProductDao.findAll());
        listProductDao.delete((long)3);
        Assertions.assertEquals(listProductDaoList,listProductDao.findAll());
    }
    @Test
    public void Should_NotRemoveCustomerAndDecrByOne_WhenListIsEmpty(){
        Assertions.assertEquals(new ArrayList<>(),listProductDaoEmpty.findAll());
        listProductDao.delete((long)3);
        Assertions.assertEquals(new ArrayList<>(),listProductDaoEmpty.findAll());
    }
    /**
     * update()
     */
    @Test
    public void Should_ReturnRemovedCustomerObj_WhenCustomerIdIsEqualToIdOfListItem(){
        Product product4 = new Product((long) 2,"Product4",3.33);
        Assertions.assertEquals(listProductDaoList,listProductDao.findAll());
        Assertions.assertEquals(product2,listProductDao.update(product4));
        listProductDaoList.remove(product2);
        listProductDaoList.add(product4);
        Assertions.assertEquals(listProductDaoList,listProductDao.findAll());
    }
    @Test
    public void Should_ReturnNullAndAddCustomer_WhenCustomerIdIsNotEqualToIdOfListItem(){
        Assertions.assertEquals(listProductDaoList,listProductDao.findAll());
        Assertions.assertEquals(null,listProductDao.update(product3));
        listProductDaoList.add(product3);
        Assertions.assertEquals(listProductDaoList,listProductDao.findAll());
    }
    @Test
    public void Should_ReturnNullAndAddCustomer_WhenListIsEmpty(){
        Assertions.assertEquals(new ArrayList<>(),listProductDaoEmpty.findAll());
        Assertions.assertEquals(null,listProductDaoEmpty.update(product3));
        listProductDaoListEmpty.add(product3);
        Assertions.assertEquals(listProductDaoListEmpty,listProductDaoEmpty.findAll());
    }


}
