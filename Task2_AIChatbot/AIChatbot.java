import java.util.Scanner;

public class AIChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("      Welcome to AI Chatbot");
        System.out.println("Type 'bye' to exit.");
        System.out.println("=================================");

        while (true) {

            System.out.print("\nYou: ");
            String userInput = sc.nextLine().toLowerCase();

            if (userInput.equals("hello")) {
                System.out.println("Bot: Hello! Nice to meet you.");
            }

            else if (userInput.equals("how are you")) {
                System.out.println("Bot: I am fine. How can I help you?");
            }

            else if (userInput.equals("what is java")) {
                System.out.println("Bot: Java is a popular object-oriented programming language.");
            }

            else if (userInput.equals("who are you")) {
                System.out.println("Bot: I am a simple AI Chatbot created in Java.");
            }

            else if (userInput.equals("what is your name")) {
                System.out.println("Bot: My name is CodeAlpha ChatBot.");
            }

            else if (userInput.equals("thank you")) {
                System.out.println("Bot: You're welcome!");
            }

            else if (userInput.equals("bye")) {
                System.out.println("Bot: Goodbye! Have a great day.");
                break;
            }

            else {
                System.out.println("Bot: Sorry, I don't understand that.");
            }
        }

        sc.close();
    }
}