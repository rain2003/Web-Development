package project.Main_function;

import project.bean.Application;
import project.bean.Buyer;
import project.bean.Product;
import project.bean.Seller;
import project.service.*;

import java.util.Scanner;

public class MainRun {

    public static void main(String[] args) {

        Application application = new Application();

        Rating productRating = new ProductRating();
        Rating sellerRating = new SellerRating();

        BuyerService buyerService = new BuyerService();
        SellerService sellerService = new SellerService();

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("***************Welcome to Supply Chain Management System*****************");
            System.out.println();
            System.out.println("Press b for buyer or s for seller");
            char c = sc.next().charAt(0); // input from user
            sc.nextLine();
            System.out.println("Enter your name");
            String name = sc.nextLine(); // input from user
            System.out.println("Enter your phone number");
            String phoneNo = sc.nextLine(); // input from user
            System.out.println("Enter your gender");
            String gender = sc.nextLine(); // input from user
            System.out.println("Enter your address");
            String address = sc.nextLine(); // input from user
            System.out.println("Enter your age");
            int age = sc.nextInt(); // input from user

            if (c == 'b') {
                Buyer buyer = new Buyer( name, phoneNo, gender, address, age);

                Application.buyers.put(buyer.getBuyerId(), buyer);

                System.out.println("these are all the products available at the moment");
                System.out.println();
                buyerService.getAllProducts().forEach(product -> System.out.println(product.toString()));
                System.out.println();
                System.out.println("Enter the productId you want");
                int productId = sc.nextInt(); // get from user
                System.out.println("Enter the quantity that you want of that product");
                int quantity = sc.nextInt(); // get from user
                System.out.println("Successfully bought the product");
                System.out.println();
                //updating the inventory
                buyerService.buyProduct(buyer.getBuyerId(), productId, quantity);
                //updation complete
                System.out.println("Please take a moment to give the rating of the product you purchased");
                System.out.println();
                System.out.println("Enter the productId");
                int productIdToPutRatting = sc.nextInt(); // get from user
                System.out.println("Enter the rating that you want to give out of 5");
                int ratting = sc.nextInt(); // get from user
                System.out.println("thanks for your feedback");
                buyerService.putRatting(productIdToPutRatting, ratting);

                System.out.println("if you want to view of the average rating of any product enter y");
                char c1 = sc.next().charAt(0);
                sc.nextLine();
                if ( c1 == 'y') {
                    System.out.println("Enter the productId of whom you want to view rating");
                    int productIdAvgRating = sc.nextInt(); // get from user;
                    productRating.calculateRating(productIdAvgRating);
                    System.out.println(Application.inventory.get(productIdAvgRating).getAvgRating());
                }else{
                    System.out.println("thanks for buying products hope to see you again!!");
                    System.out.println("if you want to buy more products please enter y");
                    char c2 = sc.next().charAt(0);
                    sc.nextLine();
                    if(c2 != 'y') {
                        break;
                    }
                }
            } else {
                Seller seller = new Seller( name, phoneNo, gender, address, age);
                Application.sellers.put(seller.getSellerId(), seller);

                System.out.println("the products that are currently there in your inventory are:-");
                buyerService.getAllProducts().forEach(product -> System.out.println(product.toString()));
                sc.nextLine();
                System.out.println("enter the name of the product you want to sell");
                String productName = sc.nextLine();
                System.out.println("enter the price of the product that you are selling");
                double price = sc.nextInt();
                System.out.println("Enter the number of products you want to add to this productId");
                int quantity = sc.nextInt();
                Product item = new Product(productName,quantity,price);
                sellerService.sellProduct(item, seller.getSellerId());
                System.out.println("successfully added the product in inventory");
                System.out.println();
                sellerService.increaseProductQty(item.getProductId(),item.getQuantity());
                System.out.println("if you want to view the inventory press i or if you want to add another item then enter a");
                char c1 = sc.next().charAt(0);
                sc.nextLine();
                if ( c1 == 'i'){
                    sellerService.getAllProducts().forEach(product -> System.out.println(product.toString()));
                }

                System.out.println("If you want to view the ratting of any seller enter y");
                char cr = sc.next().charAt(0);
                sc.nextLine();
                if (cr == 'y') {
                    sellerService.getAllSellers().forEach(seller1 -> System.out.println(seller1.toString()));
                    System.out.println("Enter the sellerId of whom you want to view rating");
                    int sellerIdAvgRatting = sc.nextInt(); // get from user;
                    sellerRating.calculateRating(sellerIdAvgRatting);
                    System.out.println(Application.sellers.get(sellerIdAvgRatting).getAvgRating());
                }

                System.out.println("if you want to leave enter l");
                char c2 = sc.next().charAt(0);
                if(c2 == 'l'){
                    break;
                }

            }


        }

    }

}