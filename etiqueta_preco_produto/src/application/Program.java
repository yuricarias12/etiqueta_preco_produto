package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int numberProducts = ler.nextInt();


        for (int cont = 1; cont <= numberProducts; cont++) {

            System.out.print("Product #"+ cont + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char opt = ler.next().charAt(0);
            System.out.print("Name: ");
            ler.nextLine();
            String name = ler.nextLine();
            System.out.print("Price: ");
            Double price = ler.nextDouble();

            if(opt == 'i') {

                System.out.print("Customs fee: ");
                double customsFee = ler.nextDouble();

                list.add(new ImportedProduct(name, price, customsFee));

            } else if (opt == 'u') {

                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufactureDate = LocalDate.parse(ler.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                list.add(new UsedProduct(name, price, manufactureDate));
            } else {

                list.add(new Product(name, price));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");

        for (Product product : list) {

            System.out.println(product.priceTag());
        }
    }
}
