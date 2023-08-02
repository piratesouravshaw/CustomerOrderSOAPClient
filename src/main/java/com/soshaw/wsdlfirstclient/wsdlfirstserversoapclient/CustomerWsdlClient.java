package com.soshaw.wsdlfirstclient.wsdlfirstserversoapclient;

import cxf.com.soshaw.ws.*;
import cxf.com.soshaw.wsdlfirstserversoap.CustomerOrdersWsImplService;

import java.net.MalformedURLException;
import java.net.URL;

public class CustomerWsdlClient {
    public static void main(String[] args) {
        try {
            CustomerOrdersWsImplService customerOrdersWsImplService=new CustomerOrdersWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
            CustomerOrdersPortType customerOrdersWsImplPort = customerOrdersWsImplService.getCustomerOrdersWsImplPort();
            GetOrderRequest request=new GetOrderRequest();
            request.setCustomerId(45);
            GetOrderResponse response=customerOrdersWsImplPort.getOrders(request);

            for(Order order:response.getOrderList()){
                for(Product prod:order.getProduct())
                {
                    System.out.println(prod.getProductDescription());
                }
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
