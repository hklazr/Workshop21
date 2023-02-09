package com.ws21.Workshop21.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws21.Workshop21.model.Customers;
import com.ws21.Workshop21.model.Orders;
import com.ws21.Workshop21.repo.CustomerRepo;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;

@RestController
@RequestMapping (path = "/api")
public class CustomerController {
    
    @Autowired
    CustomerRepo customerRepo;

    @GetMapping (path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> getAllCustomers() {

        List<Customers> customers = customerRepo.getAllCustomers(0,5);
        JsonArrayBuilder jarrb = Json.createArrayBuilder();

        for (Customers c : customers) {
            jarrb.add(c.toJson());
        }
        
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Json.createObjectBuilder()
                    .add("customers", jarrb)
                    .build().toString());
    }
    
    @GetMapping (path = "/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> getCustomerById(@PathVariable Integer customerId) {
            
            List<Customers> customers = customerRepo.getCustomerId(customerId);
            JsonArrayBuilder jarrb = Json.createArrayBuilder();
            
            for (Customers c : customers) {
                jarrb.add(c.toJson());
            }
       
        if (customers.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"error_mesg\": \"Sorry, record not found :(\"}");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Json.createObjectBuilder()
                    .add("customers", jarrb)
                    .build().toString());
    }

    @GetMapping (path = "/customer/{id}/orders", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> getCustomerOrders(@PathVariable Integer customerId) {
            
            List<Orders> orders = customerRepo.getCustomerOrders(customerId);
            JsonArrayBuilder jarrb = Json.createArrayBuilder();
            
            for (Orders o : orders) {
                jarrb.add(o.toJson());
            }
       
        // if (Customers.isEmpty()) {
        //     return ResponseEntity
        //             .status(HttpStatus.NOT_FOUND)
        //             .contentType(MediaType.APPLICATION_JSON)
        //             .body("{\"error_mesg\": \"Sorry, record not found :(\"}");
        // }
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Json.createObjectBuilder()
                    .add("orders", jarrb)
                    .build().toString());
    }                   
}