package pskcrackinggame; 

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

class PskGenerator { // Class
    private String inputPsk;

    public void setInputPsk(String inputPsk) { // Setter
        this.inputPsk = inputPsk; // Assignment
    }

    public String getPsk() { // Getter
        return inputPsk; // Return
    }
}

interface crackingMethod { // Interface
    String crack(String password); // Method
}

class PskCracking implements crackingMethod { // Inheritance
    private final String CHARSET = "abcdefghijklmnopqrstUvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*?"; // Constant
    private boolean found = false;
    private long attempts = 0; // Counter
    private String CrackedPsk = null;

    @Override
    public String crack(String password) { // Override
        if (password == null || password.isEmpty()) { // Condition
            return "No password to crack. Please generate a password first."; // Message
        }
        found = false; // Reset
        attempts = 0; // Reset
        CrackedPsk = null; // Reset
        for (int i = 1; i <= password.length(); i++) { // Loop
            tryAll("", password, i); 
            if (found) break; // Break
        }
        return "Total Attempts: " + attempts + "\nCracked Password: " + CrackedPsk; // Return
    }

    private void tryAll(String guess, String target, int maxLength) { // Method
        if (found || guess.length() > maxLength) // Condition
            return; // Exit
        if (guess.equals(target)) { // Condition
            found = true; // Set
            CrackedPsk = guess; // Assignment
            return; // Exit
        }
        for (int i = 0; i < CHARSET.length(); i++) { // Loop
            if (found) return; // Exit
            attempts++; // Increment
            tryAll(guess + CHARSET.charAt(i), target, maxLength);
        }
    }
}

class AutoSaveData { // Class
    public void saveData(String password) { // Method
        try (FileWriter saveData = new FileWriter("CrackedPSK.txt", true)) { // Try
            saveData.write(password + System.lineSeparator()); // Write
        } catch (IOException e) { // Exception handling
            System.out.println("Error While Saving Password " + e.getMessage()); // Message
        }
    }
}

class LoadData { // Class
    public String showSaveData() { // Method
        StringBuilder records = new StringBuilder(); // Builder
        try (BufferedReader readData = new BufferedReader(new FileReader("CrackedPSK.txt"))) { // Try
            String line; // Variable
            while ((line = readData.readLine()) != null) { // Loop
                records.append("Previously Cracked Password: ").append(line).append("\n"); // Append
            }
        } catch (IOException e) { // Exception handling
            return "Error While loading Saved Data: " + e.getMessage(); // Message
        }
        return records.toString(); // Return
    }
}

class Close { // Class
    public static void close() { // Method
        System.out.println("Quitting....."); // Message
        System.exit(0); // Exit
    }
}

public class PskCrackingGame extends JFrame { // Inheritance
    private PskGenerator generator; // Field
    private AutoSaveData ASD; // Field
    private LoadData LD; // Field
    private JTextArea outputArea; // Field
    private JTextField passwordField; // Field

    public PskCrackingGame() { // Constructor
        generator = new PskGenerator(); // Initialization
        ASD = new AutoSaveData(); // Initialization
        LD = new LoadData(); // Initialization

        setTitle("PSK Cracking Game"); // Set title
        setSize(400, 300); // Set size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
        setLayout(new BorderLayout()); // Set layout

        // Create components
        passwordField = new JTextField(); // Component
        JButton generateButton = new JButton("Generate Password"); // Component
        JButton crackButton = new JButton("Crack Password"); // Component
        JButton loadButton = new JButton("Load Previous Record"); // Component
        JButton closeButton = new JButton("Close"); // Component
        outputArea = new JTextArea(); // Component
        outputArea.setEditable(false); // Set editable

        // Add components to the frame
        JPanel inputPanel = new JPanel(); // Panel
        inputPanel.setLayout(new GridLayout(2, 1)); // Set layout
        inputPanel.add(new JLabel("Enter Your Password:")); // Add label
        inputPanel.add(passwordField); // Add field

        JPanel buttonPanel = new JPanel(); // Panel
        buttonPanel.add(generateButton); // Add button
        buttonPanel.add(crackButton); // Add button
        buttonPanel.add(loadButton); // Add button
        buttonPanel.add(closeButton); // Add button

        add(inputPanel, BorderLayout.NORTH); // Add panel
        add(buttonPanel, BorderLayout.CENTER); // Add panel
        add(new JScrollPane(outputArea), BorderLayout.SOUTH); // Add scroll pane

        // Action Listeners
        generateButton.addActionListener(new ActionListener() { // Listener
            @Override
            public void actionPerformed(ActionEvent e) { // Override
                String PSK = passwordField.getText(); // Get text
                generator.setInputPsk(PSK); // Set password
                outputArea.append("Generated Password: " + PSK + "\n"); // Append
            }
        });

        crackButton.addActionListener(new ActionListener() { // Listener
            @Override
            public void actionPerformed(ActionEvent e) { // Override
                String PSK = generator.getPsk(); // Get password
                crackingMethod Crack = new PskCracking(); // Instantiate
                String result = Crack.crack(PSK); // Crack password
                if (result.contains("Cracked Password:")) { // Condition
                    ASD.saveData(PSK); // Save data
                }
                outputArea.append(result + "\n"); // Append
            }
        });

        loadButton.addActionListener(new ActionListener() { // Listener
            @Override
            public void actionPerformed(ActionEvent e) { // Override
                String records = LD.showSaveData(); // Load data
                outputArea.append(records + "\n"); // Append
            }
        });

        closeButton.addActionListener(new ActionListener() { // Listener
            @Override
            public void actionPerformed(ActionEvent e) { // Override
                Close.close(); // Close
            }
        });
    }

    public static void main(String[] args) { // Main method
        SwingUtilities.invokeLater(() -> { // Runnable
            PskCrackingGame gui = new PskCrackingGame();
            gui.setVisible(true); // Set visible
        });
    }
}
