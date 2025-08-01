package com.ngo.management;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ngo.dao.DonorDao;
import com.ngo.dao.DonorDaoImpl;
import com.spring.donation.Donor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context=new AnnotationConfigApplicationContext(DBconfig.class);
        Donor d=new Donor();
        DonorDao dd=context.getBean("donorDao",DonorDao.class);
        JdbcTemplate temp=new JdbcTemplate();
        d.setName("Ankita");
        d.setEmail("ankita@gmail.com");
        d.setPhone("8604596667");
        d.setDonation_type("Money");
        d.setAmount_of_items("10000");
        int res=dd.insertDonor(d);
        System.out.println("Donor Inserted successfully..."+res);
    }
}
