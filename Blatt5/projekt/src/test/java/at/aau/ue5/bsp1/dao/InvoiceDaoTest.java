package at.aau.ue5.bsp1.dao;

import at.aau.ue5.bsp1.dao.impl.ListInvoiceDao;
import at.aau.ue5.bsp1.entity.Customer;
import at.aau.ue5.bsp1.entity.Invoice;
import at.aau.ue5.bsp1.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDaoTest {

    ListInvoiceDao invoiceDao;
    ListInvoiceDao invoiceDaoEmpty;
    List invoiceDaoList;
    List invoiceDaoListEmpty;
    List productList;
    Invoice invoice1;
    Invoice invoice2;
    Invoice invoice3;
    Customer customer1;
    Customer customer2;
    Customer customer3;
    Product product1;
    Product product2;
    Product product3;

    @BeforeEach
    public void beforeEach(){
        invoiceDao=new ListInvoiceDao();
        invoiceDaoEmpty = new ListInvoiceDao();
        invoiceDaoList=new ArrayList();
        invoiceDaoListEmpty=new ArrayList();
        productList = new ArrayList();

        customer1 = new Customer((long) 5000,"Person1","Straße1");
        customer2 = new Customer((long) 5001,"Person2","Straße2");
        customer3 = new Customer((long) 5002,"Person3","Straße3");

        product1 = new Product((long) 5000,"Person1",50.00);
        product2 = new Product((long) 5001,"Person2",5.00);
        product3 = new Product((long) 5002,"Person3",6.00);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        invoice1 = new Invoice((long) 5000,customer1,productList,true);
        invoice2 = new Invoice((long) 5001,customer2,productList,false);
        invoice3 = new Invoice((long) 5002,customer3,productList,false);

        invoiceDao.insert(invoice1);
        invoiceDao.insert(invoice2);
        invoiceDaoList.add(invoice1);
        invoiceDaoList.add(invoice2);
    }
    /**
     * findAll()
     */
    @Test
    public void Should_ReturnListSize_WhenCallingFindAll(){
        Assertions.assertEquals(invoiceDaoList,invoiceDao.findAll());
    }
    @Test
    public void Should_ReturnZero_WhenCallingFindAllAndListIsEmpty(){
        Assertions.assertEquals(new ArrayList<>(),invoiceDaoEmpty.findAll());
    }
    /**
     * findOne()
     */
    @Test
    public void Should_ReturnCustomer_WhenCustomerInList(){
        Assertions.assertEquals(invoice1,invoiceDao.findOne((long)1));
    }
    @Test
    public void Should_ReturnNull_WhenCustomerIsNotInList(){
        Assertions.assertEquals(null,invoiceDao.findOne((long)4000));
    }
    @Test
    public void Should_ReturnNull_WhenListIsEmpty(){
        Assertions.assertEquals(null,invoiceDaoEmpty.findOne((long)4000));
    }
    /**
     * insert()
     */
    @Test
    public void Should_ReturnCustomerAndIncrByOne_WhenCallingInsert(){
        Assertions.assertEquals(invoice3,invoiceDao.insert(invoice3));
        invoiceDaoList.add(invoice3);
        Assertions.assertEquals(invoiceDaoList,invoiceDao.findAll());
    }
    /**
     * delete()
     */
    @Test
    public void Should_RemoveCustomerAndDecrByOne_WhenCustomerIsInList(){
        Assertions.assertEquals(invoiceDaoList,invoiceDao.findAll());
        invoiceDao.delete((long)2);
        invoiceDaoList.remove(invoice2);
        Assertions.assertEquals(invoiceDaoList,invoiceDao.findAll());
    }
    @Test
    public void Should_NotRemoveCustomerAndDecrByOne_WhenCustomerIsNotInList(){
        Assertions.assertEquals(invoiceDaoList,invoiceDao.findAll());
        invoiceDao.delete((long)3);
        Assertions.assertEquals(invoiceDaoList,invoiceDao.findAll());
    }
    @Test
    public void Should_NotRemoveCustomerAndDecrByOne_WhenListIsEmpty(){
        Assertions.assertEquals(new ArrayList<>(),invoiceDaoEmpty.findAll());
        invoiceDao.delete((long)3);
        Assertions.assertEquals(new ArrayList<>(),invoiceDaoEmpty.findAll());
    }
    /**
     * update()
     */
    @Test
    public void Should_ReturnRemovedCustomerObj_WhenCustomerIdIsEqualToIdOfListItem(){
        Invoice invoice4 = new Invoice((long)2,customer3,productList,true);
        Assertions.assertEquals(invoiceDaoList,invoiceDao.findAll());
        Assertions.assertEquals(invoice2,invoiceDao.update(invoice4));
        invoiceDaoList.remove(invoice2);
        invoiceDaoList.add(invoice4);
        Assertions.assertEquals(invoiceDaoList,invoiceDao.findAll());
    }
    @Test
    public void Should_ReturnNullAndAddCustomer_WhenCustomerIdIsNotEqualToIdOfListItem(){
        Assertions.assertEquals(invoiceDaoList,invoiceDao.findAll());
        Assertions.assertEquals(null,invoiceDao.update(invoice3));
        invoiceDaoList.add(invoice3);
        Assertions.assertEquals(invoiceDaoList,invoiceDao.findAll());
    }
    @Test
    public void Should_ReturnNullAndAddCustomer_WhenListIsEmpty(){
        Assertions.assertEquals(new ArrayList<>(),invoiceDaoEmpty.findAll());
        Assertions.assertEquals(null,invoiceDaoEmpty.update(invoice3));
        invoiceDaoListEmpty.add(invoice3);
        Assertions.assertEquals(invoiceDaoListEmpty,invoiceDaoEmpty.findAll());
    }
}
