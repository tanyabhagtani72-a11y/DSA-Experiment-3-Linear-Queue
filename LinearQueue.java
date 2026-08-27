import java.util.Scanner;

public class LinearQueue {

    static int[] queue;
    static int front = -1;
    static int rear = -1;
    static int size;

    // Enqueue operation
    static void enqueue(int customer) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow! Queue is full.");
        } else {
            if (front == -1) {
                front = 0;
            }

            rear++;
            queue[rear] = customer;

            System.out.println("Customer " + customer + " joined the queue.");
        }
    }

    // Dequeue operation
    static void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow! Queue is empty.");
        } else {
            System.out.println("Customer " + queue[front] + " has been served.");

            front++;

            if (front > rear) {
                front = -1;
                rear = -1;
            }
        }
    }

    // Peek operation
    static void peek() {
        if (front == -1) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Customer at the front: " + queue[front]);
        }
    }

    // Display operation
    static void display() {
        if (front == -1) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Customers in the queue:");

            for (int i = front; i <= rear; i++) {
                System.out.println("Customer " + queue[i]);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the queue: ");
        size = sc.nextInt();

        queue = new int[size];

        int choice;

        do {
            System.out.println("\n===== LINEAR QUEUE =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter customer number: ");
                    int customer = sc.nextInt();
                    enqueue(customer);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    peek();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}