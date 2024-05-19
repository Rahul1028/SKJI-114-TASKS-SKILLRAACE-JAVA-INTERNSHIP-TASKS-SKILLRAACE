import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ChatBot extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextArea chatArea;
    private JTextField userInput;
    private JButton sendButton;
    private Map<String, String> predefinedResponses;
    private Random random;

    public ChatBot() {
        // Initialize the predefined responses
        predefinedResponses = new HashMap<>();
        loadPredefinedResponses();

        // Initialize the GUI components
        chatArea = new JTextArea();
        userInput = new JTextField(30);
        sendButton = new JButton("Send");

        // Set up the chat area
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        // Set up the send button action
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = userInput.getText();
                chatArea.append("You: " + input + "\n");
                String response = generateResponse(input);
                chatArea.append("Bot: " + response + "\n\n");
                userInput.setText("");
            }
        });

        // Set up the layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(userInput);
        inputPanel.add(sendButton);

        panel.add(inputPanel, BorderLayout.SOUTH);

        // Set up the frame
        setTitle("SR ChatBot");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setVisible(true);

        random = new Random();
    }

    
    private void loadPredefinedResponses() {
        
            predefinedResponses.put("hello", "Hello! How can I assist you today?");
            predefinedResponses.put("hi", "Hi there! How can I help?");
            predefinedResponses.put("hey", "Hey! What can I do for you?");
            predefinedResponses.put("good morning", "Good morning! How can I assist you?");
            predefinedResponses.put("good evening", "Good evening! What can I help you with?");
            predefinedResponses.put("bye", "Goodbye! Have a great day!");
            predefinedResponses.put("see you", "See you later! Take care.");
            predefinedResponses.put("goodbye", "Goodbye! Feel free to chat with me anytime.");
            predefinedResponses.put("what is your name", "I am an advanced chatbot created to assist you.");
            predefinedResponses.put("who are you", "I am a chatbot designed to provide information and assistance.");
            predefinedResponses.put("what can you do", "I can chat with you, answer simple questions, and provide information.");
            predefinedResponses.put("what is ai", "Artificial Intelligence (AI) is the simulation of human intelligence in machines that are programmed to think and learn.");
            predefinedResponses.put("tell me a fun fact", "Did you know that honey never spoils? Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3,000 years old and still edible.");
            predefinedResponses.put("who created you", "I was created by a programmer to assist you with various tasks.");
            predefinedResponses.put("where are you from", "I exist in the digital world, hosted on a server.");
            predefinedResponses.put("tell me about yourself", "I am a chatbot created to assist with various tasks and provide information.");
            predefinedResponses.put("how old are you", "I don't have an age, as I am a program, but I am always evolving and learning.");
            predefinedResponses.put("what is your purpose", "My purpose is to assist and provide information to users like you.");
            predefinedResponses.put("thank you", "You're welcome! If you have any other questions, feel free to ask.");
            predefinedResponses.put("thanks", "No problem! I'm here to help.");
            predefinedResponses.put("how are you", "I'm just a bot, but I'm doing great! How about you?");
            predefinedResponses.put("how is the weather", "I can't check the weather right now, but you can check it on your favorite weather website.");
            predefinedResponses.put("tell me a joke", "Why don't scientists trust atoms? Because they make up everything!");
            predefinedResponses.put("what is the time", "I can't tell the time, but you can check it on your device.");
            predefinedResponses.put("what is your favorite color", "I love all colors equally, but blue is quite calming.");
            predefinedResponses.put("what do you like to do", "I enjoy helping people and providing useful information.");
        }
    
  
    private String generateResponse(String input) {
        input = input.toLowerCase();

        for (String key : predefinedResponses.keySet()) {
            if (input.contains(key)) {
                return predefinedResponses.get(key);
            }
        }

        return getFallbackResponse();
    }

    private String getFallbackResponse() {
        String[] fallbackResponses = {
            "I see. Can you tell me more?",
            "Interesting. Please elaborate.",
            "I'm not sure I understand. Can you explain that?",
            "That's quite intriguing. What else can you share?",
            "Can you give me more details on that?"
        };

        return fallbackResponses[random.nextInt(fallbackResponses.length)];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChatBot();
            }
        });
    }
}
