import java.util.Scanner;

class Room{
    int roomNumber;
    String type;
    double price;
    boolean booked;

    Room(int roomNumber, String type, double price){
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.booked = false;
    }
}

public class HotelReservationSystem{

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        Room room1 = new Room(101, "Standard", 5000);
        Room room2 = new Room(102, "Standard", 5000);
        Room room3 = new Room(201, "Deluxe", 8000);
        Room room4 = new Room(202, "Deluxe", 8000);
        Room room5 = new Room(301, "Suite", 12000);

        int choice;

        do{
            System.out.println("\n===== Hotel Reservation System =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            if(choice == 1){

                System.out.println("\n----- Available Rooms -----");

                if(!room1.booked)
                    System.out.println(room1.roomNumber + " - " + room1.type + " - Rs. " + room1.price);

                if(!room2.booked)
                    System.out.println(room2.roomNumber + " - " + room2.type + " - Rs. " + room2.price);

                if(!room3.booked)
                    System.out.println(room3.roomNumber + " - " + room3.type + " - Rs. " + room3.price);

                if(!room4.booked)
                    System.out.println(room4.roomNumber + " - " + room4.type + " - Rs. " + room4.price);

                if(!room5.booked)
                    System.out.println(room5.roomNumber + " - " + room5.type + " - Rs. " + room5.price);

            }else if(choice == 2){

                System.out.print("\nEnter room number: ");
                int roomNumber = input.nextInt();

                Room selectedRoom = null;

                if(roomNumber == room1.roomNumber)
                    selectedRoom = room1;
                else if(roomNumber == room2.roomNumber)
                    selectedRoom = room2;
                else if(roomNumber == room3.roomNumber)
                    selectedRoom = room3;
                else if(roomNumber == room4.roomNumber)
                    selectedRoom = room4;
                else if(roomNumber == room5.roomNumber)
                    selectedRoom = room5;

                if(selectedRoom == null){
                    System.out.println("Room not found.");
                }else if (selectedRoom.booked){
                    System.out.println("This room is already booked.");
                }else{

                    input.nextLine();

                    System.out.print("Enter your name: ");
                    String name = input.nextLine();

                    System.out.println("\nRoom Type: " + selectedRoom.type);
                    System.out.println("Room Price: Rs. " + selectedRoom.price);

                    System.out.print("Confirm booking? (yes/no): ");
                    String confirm = input.nextLine();

                    if(confirm.equalsIgnoreCase("yes")){

                        System.out.println("\nPayment Amount: Rs. " + selectedRoom.price);
                        System.out.print("Enter payment amount: ");
                        double payment = input.nextDouble();

                        if(payment >= selectedRoom.price){
                            selectedRoom.booked = true;

                            System.out.println("Payment successful.");
                            System.out.println("Room booked successfully.");
                            System.out.println("Booking Name: " + name);
                            System.out.println("Room Number: " + selectedRoom.roomNumber);
                        }else{
                            System.out.println("Insufficient payment.");
                        }
                    }else{
                        System.out.println("Booking cancelled.");
                    }
                }

            }else if(choice == 3){

                System.out.print("\nEnter room number to cancel: ");
                int roomNumber = input.nextInt();

                if(roomNumber == room1.roomNumber && room1.booked){
                    room1.booked = false;
                    System.out.println("Reservation cancelled.");
                }else if(roomNumber == room2.roomNumber && room2.booked){
                    room2.booked = false;
                    System.out.println("Reservation cancelled.");
                }else if(roomNumber == room3.roomNumber && room3.booked){
                    room3.booked = false;
                    System.out.println("Reservation cancelled.");
                }else if(roomNumber == room4.roomNumber && room4.booked){
                    room4.booked = false;
                    System.out.println("Reservation cancelled.");
                }else if(roomNumber == room5.roomNumber && room5.booked){
                    room5.booked = false;
                    System.out.println("Reservation cancelled.");
                }else{
                    System.out.println("No active reservation found.");
                }

            }else if(choice == 4){

                System.out.println("\n----- Booking Details -----");

                if(room1.booked)
                    System.out.println("Room 101 - Standard - Booked");

                if(room2.booked)
                    System.out.println("Room 102 - Standard - Booked");

                if(room3.booked)
                    System.out.println("Room 201 - Deluxe - Booked");

                if(room4.booked)
                    System.out.println("Room 202 - Deluxe - Booked");

                if(room5.booked)
                    System.out.println("Room 301 - Suite - Booked");

            }else if(choice == 5){

                System.out.println("Thank you for using the Hotel Reservation System.");

            }else{
                System.out.println("Invalid choice.");
            }

        }while(choice != 5);

        input.close();
    }
}