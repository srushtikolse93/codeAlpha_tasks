import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    boolean isBooked;
    String customerName;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
        this.customerName = "";
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));

        while (true) {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    viewBookingDetails();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void viewRooms() {

        System.out.println("\nRoom List:");

        for (Room room : rooms) {
            System.out.println(
                    room.roomNumber + " | "
                    + room.category + " | "
                    + (room.isBooked ? "Booked" : "Available"));
        }
    }

    static void bookRoom() {

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();
        sc.nextLine();

        for (Room room : rooms) {

            if (room.roomNumber == roomNo) {

                if (!room.isBooked) {

                    int amount = 0;

                    if (room.category.equals("Standard"))
                        amount = 2000;
                    else if (room.category.equals("Deluxe"))
                        amount = 4000;
                    else
                        amount = 6000;

                    System.out.println("Room Charge: ₹" + amount);
                    System.out.println("Payment Successful");

                    room.isBooked = true;
                    room.customerName = name;

                    System.out.println("Booking Confirmed!");
                } else {
                    System.out.println("Room Already Booked");
                }

                return;
            }
        }

        System.out.println("Room Not Found");
    }

    static void cancelReservation() {

        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();
        sc.nextLine();

        for (Room room : rooms) {

            if (room.roomNumber == roomNo) {

                if (room.isBooked) {

                    room.isBooked = false;
                    room.customerName = "";

                    System.out.println("Reservation Cancelled");
                } else {
                    System.out.println("Room Was Not Booked");
                }

                return;
            }
        }

        System.out.println("Room Not Found");
    }

    static void viewBookingDetails() {

        boolean found = false;

        System.out.println("\n===== BOOKING DETAILS =====");

        for (Room room : rooms) {

            if (room.isBooked) {

                found = true;

                System.out.println("Customer Name : " + room.customerName);
                System.out.println("Room Number   : " + room.roomNumber);
                System.out.println("Category      : " + room.category);
                System.out.println("----------------------------");
            }
        }

        if (!found) {
            System.out.println("No Active Bookings");
        }
    }
}