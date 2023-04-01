import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    public App() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Dictionary Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // Create and add components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        contentPane.add(panel, BorderLayout.CENTER);

        JButton addWordButton = new JButton("1. Add New Word");
        JButton deleteWordButton = new JButton("2. Delete Word");
        JButton getMeaningButton = new JButton("3. Get Meaning");
        JButton dictionaryListButton = new JButton("4. Dictionary List");
        JButton spellCheckButton = new JButton("5. Spell Check Text File");
        JButton exitProgramButton = new JButton("6. Exit Program");

        panel.add(addWordButton);
        panel.add(deleteWordButton);
        panel.add(getMeaningButton);
        panel.add(dictionaryListButton);
        panel.add(spellCheckButton);
        panel.add(exitProgramButton);

        // Set up action listeners
        Coordinator coordinator = new Coordinator();

        addWordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add new word
                // Replace console input with JOptionPane dialogs
                String word = JOptionPane.showInputDialog("Please enter the word you want submitted");
                String meaning = JOptionPane.showInputDialog("Please enter the definition of the word.");
                coordinator.addWord(word, meaning);
            }
        });

        deleteWordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Delete word
                String deletedWord = JOptionPane.showInputDialog("Please enter the name of the word that you want deleted.");
                coordinator.deleteWord(deletedWord);
            }
        });

        getMeaningButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get meaning
                String definedWord = JOptionPane.showInputDialog("Please enter the word that you want defined.");
                coordinator.getMeaning(definedWord);
            }
        });

        dictionaryListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Print dictionary
                coordinator.printDictionary();
            }
        });

        spellCheckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Spell check text file
                String fileName = JOptionPane.showInputDialog("Please enter the name of the text file that you want spell checked.");
                coordinator.spellCheck(fileName);
            }
        });

        exitProgramButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exit program
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App app = new App();
                app.setVisible(true);
            }
        });
    }
}
