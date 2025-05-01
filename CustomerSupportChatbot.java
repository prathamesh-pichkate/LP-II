import java.util.Scanner;

public class CustomerSupportChatbot {

    public static String getResponse(String userInput) {
        userInput = userInput.toLowerCase();

        if (userInput.contains("hi") || userInput.contains("hello")) {
            return "Hello! How can I assist you today?";
        } else if (userInput.contains("order status") || userInput.contains("track order")) {
            return "Please provide your order ID to check the status.";
        } else if (userInput.contains("refund")) {
            return "Refunds are processed within 5-7 business days. Can you share your order ID?";
        } else if (userInput.contains("product") || userInput.contains("item")) {
            return "What product are you looking for? I can help you find it.";
        } else if (userInput.contains("support") || userInput.contains("help")) {
            return "I'm here to help! Tell me what issue you're facing.";
        } else if (userInput.contains("bye") || userInput.contains("exit")) {
            return "Thank you for visiting! Have a great day.";
        } else {
            return "I'm sorry, I didn't understand that. Could you please rephrase?";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🤖 Welcome to QuickShop Customer Support Chatbot!");
        System.out.println("Type 'exit' anytime to end the chat.\n");

        while (true) {
            System.out.print("You: ");
            String userInput = sc.nextLine();

            if (userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("bye")) {
                System.out.println("Bot: " + getResponse(userInput));
                break;
            }

            String response = getResponse(userInput);
            System.out.println("Bot: " + response);
        }

        sc.close();
    }
}
