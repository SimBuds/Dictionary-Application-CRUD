public class Coordinator {
    // Casey Hsu - 101376814

    public Dictionary dictionary;

    public Coordinator(){
        dictionary = new Dictionary();
        dictionary.loadDictionary();
        dictionary.wordSort();
    }

    public void addWord(String word, String meaning){
        if (dictionary.addWord(word, meaning) != false){
            System.out.println(String.format("\nThe word: %s was successfully added to the dictionary!\n", word));
        } else {
            System.out.println(String.format("\nThe word: %s already exists in the dictionary.\n", word));
        }
    }

    public void deleteWord(String word){
        if (dictionary.wordDelete(word) == true){
            System.out.println(String.format("\nThe word: %s was successfully deleted from the dictionary!\n", word));
        } else {
            System.out.println(String.format("\nThe word: %s does not exist in the dictionary.\n", word));
        }
    }

    public void getMeaning(String word){
        if (dictionary.wordExists(word) == true){
            System.out.println(String.format("\nThe meaning of the word: %s is %s.\n", word, dictionary.getMeaning(word)));
        } else {
            System.out.println(String.format("\nThe word: %s does not exist in the dictionary.\n", word));
        }
    }

    public void getWordCount(){
        System.out.println(String.format("\nThere are %s words in the dictionary.\n", dictionary.getWordCount()));
    }

    public void printWordList(){
        System.out.println("\nPrinting word list...");
        System.out.println(dictionary.printWordList());
    }

    public void printDictionary(){
        System.out.println("\nPrinting Dictionary list...");
        System.out.println(dictionary.printDictionary());
    }

    public void spellCheck(String fileName){
        dictionary.spellCheck(fileName);
    }
}