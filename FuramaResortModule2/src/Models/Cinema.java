package Models;

import java.util.ArrayDeque;
import java.util.Queue;

public class Cinema {
    Queue<Customer> customerQueue = new ArrayDeque<>();

    public void printCinemaCustomer() {
        Customer customer = new Customer();
        customer.printDetail("D:\\\\A1020I1-NguyenVinhDiem" +
                "\\\\FuramaResortModule2\\\\src\\\\Data\\\\CinemaCustomer.csv");
        while (Customer.customerArrayList.size() > 0) {
            Customer customer1 = Customer.customerArrayList.get(0);
            customerQueue.add(customer1);
            Customer.customerArrayList.remove(0);
        }
        for (Customer customer1 : customerQueue) {
            System.out.println(customer1.toCSV());
        }
        Customer.customerArrayList.clear();
    }


}
