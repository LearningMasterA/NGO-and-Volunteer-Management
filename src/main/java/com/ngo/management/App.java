package com.ngo.management;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ngo.dao.DonorDao;
import com.ngo.service.MailService;
import com.spring.donation.Donor;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello and Welcome to HappyNGO !");
        System.out.println("We appreciate your thinking!!!");
        
        ApplicationContext context = new AnnotationConfigApplicationContext(DBconfig.class);
        Scanner sc=new Scanner(System.in);

        Donor d = new Donor();
        DonorDao dd = context.getBean("donorDao", DonorDao.class);
// Insert a donor
//        d.setName("AS");
//        d.setEmail("ankitasingh0269@gmail.com");
//        d.setPhone("8181027176");
//        d.setDonation_type("Saree");
//        d.setAmount_of_items("200");
//
//        int res = dd.insertDonor(d);
//        System.out.println("Donor Inserted successfully..." + res);
//
//        MailService mailService = new MailService();
//        mailService.sendThankYouEmail(d.getEmail(), d.getName(), d.getDonation_type(), d.getAmount_of_items());
//        System.out.println("Thank You for Visiting 🙏🫶....");
//        System.out.println("Please Visit again...");
//        
//        List all donors
//        List<Donor> li=dd.getAllDonors();
//        System.out.println(li);
        
//        List donor by id
//        d.setId(11);
//        Donor d1=dd.getDonorById(d.getId());
//        System.out.println(d1);
        
        
        
        
//        Update Donor
        
        System.out.println("Enter the id you want to update: ");
        int id=sc.nextInt();
        d.setId(id);
        sc.nextLine();
        System.out.println("Select the field you want to update: ");
        System.out.println("1. Name");
        System.out.println("2. Email");
        System.out.println("3. Phone");
        System.out.println("4. Donation Type");
        System.out.println("5. Amount of Items");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        String field = "", newValue = "";
        	switch (choice) {
        	    case 1:
        	        field = "name";
        	        System.out.println("Enter new name:");
        	        newValue = sc.nextLine();
        	        break;
        	    case 2:
        	        field = "email";
        	        System.out.println("Enter new email:");
        	        newValue = sc.nextLine();
        	        break;
        	    case 3:
        	        field = "phone";
        	        System.out.println("Enter new phone:");
        	        newValue = sc.nextLine();
        	        break;
        	    case 4:
        	        field = "donation_type";
        	        System.out.println("Enter new donation type:");
        	        newValue = sc.nextLine();
        	        break;
        	    case 5:
        	        field = "amount_of_items";
        	        System.out.println("Enter new amount:");
        	        newValue = sc.nextLine();
        	        break;
        	    default:
        	        System.out.println("Invalid choice.");
        	        return;
        	}

        	boolean updated = dd.updateDonor(id, field, newValue);
        	if (updated)
        	    System.out.println("Updated successfully!");
        	else
        	    System.out.println("Update failed. Check ID or input.");
        	
        	 List<Donor> li=dd.getAllDonors();
             System.out.println(li);
       
    }
}
