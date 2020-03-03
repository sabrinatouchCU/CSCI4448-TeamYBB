/********************************************************
**                                                     **
** Team Members: Justin Vuong, Sabrina Touch, Andy Kim **
**        CSCI4448-Object Oriented Programming         **
**                     Project 3                       **
**                                                     **
********************************************************/

import java.util.*;
import java.io.*;

/* -------------------------- Main -------------------------- */
public class Main
{
  public static void main(String[] args)
  {

    //Initial setup for cars, customers, and store.

    //Instantiate a car factory and create 24 cars of each category.
    CarFactory carFactory = new CarFactory();

    Car car1 = carFactory.createCar("SUV123", "SUV");
    Car car2 = carFactory.createCar("SUV124", "SUV");
    Car car3 = carFactory.createCar("SUV125", "SUV");
    Car car4 = carFactory.createCar("SUV126", "SUV");
    Car car5 = carFactory.createCar("SUV127", "SUV");

    Car car6 = carFactory.createCar("MIN123", "Minivan");
    Car car7 = carFactory.createCar("MIN124", "Minivan");
    Car car8 = carFactory.createCar("MIN125", "Minivan");
    Car car9 = carFactory.createCar("MIN126", "Minivan");
    Car car10 = carFactory.createCar("MIN127", "Minivan");

    Car car11 = carFactory.createCar("LUX123", "Luxury");
    Car car12 = carFactory.createCar("LUX124", "Luxury");
    Car car13 = carFactory.createCar("LUX125", "Luxury");
    Car car14 = carFactory.createCar("LUX126", "Luxury");
    Car car15 = carFactory.createCar("LUX127", "Luxury");

    Car car16 = carFactory.createCar("ECO123", "Economy");
    Car car17 = carFactory.createCar("ECO124", "Economy");
    Car car18 = carFactory.createCar("ECO125", "Economy");
    Car car19 = carFactory.createCar("ECO126", "Economy");
    Car car20 = carFactory.createCar("ECO127", "Economy");

    Car car21 = carFactory.createCar("STA123", "Standard");
    Car car22 = carFactory.createCar("STA124", "Standard");
    Car car23 = carFactory.createCar("STA125", "Standard");
    Car car24 = carFactory.createCar("STA126", "Standard");

    //Instantiate a store and add the 24 cars into the store inventory.
    Store store = new Store();

    store.addCar(car1);
    store.addCar(car2);
    store.addCar(car3);
    store.addCar(car4);
    store.addCar(car5);
    store.addCar(car6);
    store.addCar(car7);
    store.addCar(car8);
    store.addCar(car9);
    store.addCar(car10);
    store.addCar(car11);
    store.addCar(car12);
    store.addCar(car13);
    store.addCar(car14);
    store.addCar(car15);
    store.addCar(car16);
    store.addCar(car17);
    store.addCar(car18);
    store.addCar(car19);
    store.addCar(car20);
    store.addCar(car21);
    store.addCar(car22);
    store.addCar(car23);
    store.addCar(car24);

    //store.printList();
    //System.out.println(store.getCapacity());

    //Instantiate a Customer factory and create 12 customers with 3 different categories.
    CustomerFactory customerFactory = new CustomerFactory();

    Customer customer1 = customerFactory.createCustomer("Joe", "Regular");
    Customer customer2 = customerFactory.createCustomer("Bob", "Regular");
    Customer customer3 = customerFactory.createCustomer("James", "Regular");
    Customer customer4 = customerFactory.createCustomer("Tom", "Regular");

    Customer customer5 = customerFactory.createCustomer("Josh", "Business");
    Customer customer6 = customerFactory.createCustomer("John", "Business");
    Customer customer7 = customerFactory.createCustomer("Luke", "Business");
    Customer customer8 = customerFactory.createCustomer("Sabs", "Business");

    Customer customer9 = customerFactory.createCustomer("Justin", "Casual");
    Customer customer10 = customerFactory.createCustomer("Suebin", "Casual");
    Customer customer11 = customerFactory.createCustomer("Andy", "Casual");
    Customer customer12 = customerFactory.createCustomer("Eric", "Casual");


    // Making a list of all the customer objects
    ArrayList<Customer> listofCustomers = new ArrayList<Customer>();
    ArrayList<Customer> rentingCustomers = new ArrayList<Customer>();
    ArrayList<String> completedRentals = new ArrayList<String>();

    listofCustomers.add(customer1);
    listofCustomers.add(customer2);
    listofCustomers.add(customer3);
    listofCustomers.add(customer4);
    listofCustomers.add(customer5);
    listofCustomers.add(customer6);
    listofCustomers.add(customer7);
    listofCustomers.add(customer8);
    listofCustomers.add(customer9);
    listofCustomers.add(customer10);
    listofCustomers.add(customer11);
    listofCustomers.add(customer12);

    int num_day = 1;
    int completed_rentals = 0;
    ArrayList<String> activeRentals = new ArrayList<String>();

    while(num_day <= 35){

      System.out.println("Day number: " + num_day);

      for(int i = 0; i < listofCustomers.size(); i++){
        Customer currCust = listofCustomers.get(i);
        currCust.generateDays();
      }

      Random rand = new Random();
      Random rand1 = new Random();
      Random rand2 = new Random();

      int number_customers = rand.nextInt(12) + 1;
      int revenue = 0;

      //Collections.shuffle(listofCustomers);

      for (int i = 0; i < number_customers; i++){
        boolean Radio = rand.nextBoolean();
        boolean Gps = rand1.nextBoolean();
        boolean CSeat = rand2.nextBoolean();

        if(store.getCapacity() > 0){
          Customer tempCustomer = listofCustomers.get(i);
          if(tempCustomer.getCapacity() + tempCustomer.getNumCars() <= 3 && store.getCapacity() - tempCustomer.getNumCars() > 0){
            String sentence = "";

            sentence += tempCustomer.getName();

            for(int j = 0; j < tempCustomer.getNumCars(); j++){
              Car rentalCar = store.removeCar();
              rentalCar.setCost(tempCustomer.getDays());
              if(Radio){
                rentalCar = new Radio(rentalCar);
              }
              if(Gps){
                rentalCar = new GPS(rentalCar);
              }
              if(CSeat){
                rentalCar = new CarSeat(rentalCar);
              }
              tempCustomer.addList(rentalCar);
              sentence += rentalCar.getDescription();

              rentingCustomers.add(tempCustomer);
              store.addRevenue(rentalCar.getCost());
              revenue += rentalCar.getCost();
              activeRentals.add(sentence);
            }
            //Rental newRental = new Rental();
            //newRental.createRental(tempCustomer.getCarList());

          }
        }
      }

      int size = rentingCustomers.size();
      System.out.println(size);

      for(int i = 0; i < size; i++){

        Customer Current = rentingCustomers.get(i);

        if(Current.getDays() == 0){
          String sentence = "";

          for(int j = 0; j < listofCustomers.size(); j++){
            System.out.println(listofCustomers.get(j).getName());
            System.out.println(Current);
            if(listofCustomers.get(j).getName().equals(Current.getName())){
              System.out.println("Hello");
              Customer currCustomer = listofCustomers.get(j);
            }
          }

          //sentence += currCustomer.getName();
          //sentence += currCustomer.getDays();

          ArrayList<Car> currentCars = new ArrayList<Car>();
          currentCars = Current.getCarList();

          for(int j = 0; j < currentCars.size(); j++){
            Car returningCar = currentCars.get(j);
            sentence += returningCar.getDescription();
            sentence += returningCar.getCost();
            String name = returningCar.getName();
            String type = returningCar.getType();
            Car newCar = carFactory.createCar(name, type);
            store.addCar(newCar);
            //System.out.println(newCar.getDescription());
            completed_rentals += 1;
          }

          completedRentals.add(sentence);

          Current.resetList();
          Current.resetCapacity();
          rentingCustomers.remove(Current);
        }

        Current.decrement();
      }

      System.out.println("Completed Rentals Count: " + completedRentals.size());

      for(int i = 0; i < completedRentals.size(); i++){
        System.out.println(completedRentals.get(i));
      }

      System.out.println("Active Rentals Count: " + activeRentals.size());

      for(int i = 0; i < activeRentals.size(); i++){
        System.out.println(activeRentals.get(i));
      }

      //All cars left in the store.
      store.printList();

      System.out.println("Revenue for the day: " + revenue);

      num_day += 1;

    }//end of while.

    System.out.println("Total number of rentals: " + completed_rentals);
    System.out.println("Total money made for the 35 day period: " + store.getProfit());

  } // void Main
} //Actual main.
