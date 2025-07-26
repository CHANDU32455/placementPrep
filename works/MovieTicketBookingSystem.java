
import java.util.Scanner;

abstract class movie {
    protected String movieid;
    protected String movietitle;
    protected double ticketprice;
    protected int no_of_tickets;

    public movie(String movieid,String movietitle ,double ticketPrice, int numberOfTickets) {
        this.movieid = movieid;
        this.movietitle = movietitle;
        this.ticketprice = ticketPrice;
        this.no_of_tickets = numberOfTickets;
    }

    public abstract double calculatePrice();
/**
 * displayDetails that prints the movieId, title, ticket price, number of tickets, and total cost. If the number of tickets requested exceeds 6, a message is displayed and the price is not calculated.
 */
    public void displayMovieDetails(){
        System.out.println("movieId: " + movieid);
        System.out.println("movietitle: " + movietitle);
        System.out.println("ticketprice: " + ticketprice);
        System.out.println("no_of_tickets: " + no_of_tickets);
        if(no_of_tickets <= 6){
            System.out.println("total cost: " + calculatePrice());
        }else{
            System.out.println("Booking Failed: Cannot book more than 6 tickets");
        }
    }
}

/**
 * Class TeluguMovie extends Movie
This class provides an implementation of calculatePrice by multiplying tictickeketPrice with numberOfTickets and applying 5 percent GST on the total.
 */
class teluguMovie extends movie{
    public teluguMovie(String movieid, String movietitle, double ticketPrice, int numberOfTickets) {
        super(movieid, movietitle, ticketPrice, numberOfTickets);
    }
    @Override
    public double calculatePrice(){
        // 5% gst
        double basePrice = ticketprice * no_of_tickets;
        double gst = basePrice * 0.05;
        return basePrice + gst;
    }
}
/**
 * Class HindiMovie extends Movie
This class implements calculatePrice by first multiplying ticketPrice with numberOfTickets, applying a 10 percent discount on the result, and then adding 5 percent GST to the discounted amount.
 */

class hindiMovie extends movie {
    public hindiMovie(String movieid, String movietitle, double ticketPrice, int numberOfTickets) {
        super(movieid, movietitle, ticketPrice, numberOfTickets);
    }
    @Override
    public double calculatePrice() {
        double basePrice = ticketprice * no_of_tickets;
        double discount = basePrice * 0.10;
        double discountedPrice = basePrice - discount;
        double gst = discountedPrice * 0.05;
        return discountedPrice + gst;
    }
}
/**
 * Class EnglishMovie extends Movie
This class implements calculatePrice by multiplying ticketPrice with numberOfTickets, adding a fixed 3D charge of 50 per ticket, and then applying 5 percent GST on the total.
 */
class englishMovie extends movie{
    public englishMovie(String movieid, String movietitle, double ticketPrice, int no_of_tickets){
        super(movieid, movietitle, ticketPrice, no_of_tickets);
    }
    @Override
    public double calculatePrice(){
        double basePrice = ticketprice * no_of_tickets;
        double d3dCharge = 50 * no_of_tickets;
        double totalCost = basePrice + d3dCharge;
        double gst = totalCost * 0.05;
        return totalCost + gst;
    }
}

/**
 * Main Class
In the main method, create objects of TeluguMovie, HindiMovie, and EnglishMovie. Assign values for movieId, title, ticketPrice, and numberOfTickets directly. Store all objects in an array of type Movie. Use a loop to call displayDetails for each movie. The method should only calculate and display the total price if the number of tickets requested is 6 or less.
 */
public class MovieTicketBookingSystem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) { 
            System.out.println("\n====== Movie Ticket Booking Menu ======");
            System.out.println("1. Book Telugu Movie");
            System.out.println("2. Book Hindi Movie");
            System.out.println("3. Book Engish Movie");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter number of tickets: ");
                    int numTickets = sc.nextInt();
                    teluguMovie teluguMovie = new teluguMovie("M101", "RRR", 150.0, numTickets);
                    teluguMovie.displayMovieDetails();
                    break;
                case 2:
                    System.out.print("Enter number of tickets: ");
                    numTickets = sc.nextInt();
                    hindiMovie hindiMovie = new hindiMovie("M102", "Pathaan", 200.0, numTickets);
                    hindiMovie.displayMovieDetails();
                    break;
                case 3:
                    System.out.print("Enter number of tickets: ");
                    numTickets = sc.nextInt();
                    englishMovie englishMovie = new englishMovie("M103", "Avatar", 250.0, numTickets);
                    englishMovie.displayMovieDetails();
                    break;
                case 0:
                    System.out.println("Thankyou for using our service...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}