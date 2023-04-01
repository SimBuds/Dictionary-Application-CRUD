import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Casey Hsu - 101376814

        Coordinator coordinator = new Coordinator();
        int choice = 0;

        while (choice != 6){
            Scanner scan = new Scanner(System.in);
            System.out.println("\nPlease enter one of the following menu items.\n");
            System.out.println("--------------1. Add New Word-----------------");
            System.out.println("--------------2. Delete Word------------------");
            System.out.println("--------------3. Get Meaning------------------");
            System.out.println("--------------4. Dictionary List--------------");
            System.out.println("--------------5. Spell Check Text File--------");
            System.out.println("--------------6. Exit Program-----------------\n");
            choice = Integer.parseInt(scan.nextLine());

            switch (choice){
                case 1:
                    System.out.println("\nPlease enter the word you want submitted");
                    String word = scan.nextLine();
                    System.out.println("\nPlease enter the definition of the word.");
                    String meaning = scan.nextLine();
                    coordinator.addWord(word, meaning);
                    break;
                case 2:
                    System.out.println("\nPlease enter the name of the word that you want deleted.\n");
                    String deletedWord = scan.nextLine();
                    coordinator.deleteWord(deletedWord);
                    break;
                case 3:
                    System.out.println("\nPlease enter the word that you want defined.\n");
                    String definedWord = scan.nextLine();
                    coordinator.getMeaning(definedWord);
                    break;
                case 4:
                    Thread.sleep(500);
                    coordinator.printDictionary();
                    break;
                case 5:
                    System.out.println("\nPlease enter the name of the text file that you want spell checked.");
                    String fileName = scan.nextLine();  
                    System.out.println("\nSpell checking file...\n");
                    coordinator.spellCheck(fileName);
                    break;
                case 6:
                    System.out.println("\nThank you for using the Dictionary application.\n");
                    scan.close();
                    break;
            }
        }
    }
}
