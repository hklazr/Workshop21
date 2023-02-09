package com.ws21.Workshop21.repo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.ws21.Workshop21.model.Customers;
import com.ws21.Workshop21.model.Orders;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private String SQL_SELECT_ALL_FROM_CUSTOMERS = "SELECT * FROM customers LIMIT ? OFFSET ?";
    private String SQL_SELECT_ALL_FROM_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE id = ?";
    private String SQL_SELECT_ALL_ORDERS_FROM_CUSTOMERS = "SELECT * FROM orders WHERE customer_id = ?;";

    public List<Customers> getAllCustomers(int offset, int limit) {

        List<Customers> cust = new LinkedList<>();
        SqlRowSet srs = jdbcTemplate.queryForRowSet(SQL_SELECT_ALL_FROM_CUSTOMERS, limit, offset);
        
        while (srs.next()) {
            cust.add(Customers.fromSQL(srs));
    }
        return cust;
}
    public List<Customers> getCustomerId(Integer customerId) {

        List<Customers> cust = new LinkedList<>();
        SqlRowSet srs = jdbcTemplate.queryForRowSet(SQL_SELECT_ALL_FROM_CUSTOMER_BY_ID, customerId);
        
        while (srs.next()) {
            cust.add(Customers.fromSQL(srs));
    }
        return cust;
    }
    public List<Orders> getCustomerOrders(Integer customerId) {

        List<Orders> orders = new LinkedList<>();
        SqlRowSet srs = jdbcTemplate.queryForRowSet(SQL_SELECT_ALL_ORDERS_FROM_CUSTOMERS, customerId);
        
        while (srs.next()) {
            orders.add(Orders.fromSQL(srs));
    }
        return orders;
    }
}

