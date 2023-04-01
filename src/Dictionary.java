import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
    // Casey Hsu - 101376814

    private int numWords;
    private int maxWords;
    private WordInfo[] wordList;

    public Dictionary(){
        this.numWords = 0;
        this.maxWords = 1500;
        wordList = new WordInfo[maxWords];
    }

    public boolean addWord(String word, String meaning){
        if (maxWords > numWords && wordExists(word) == false){
            wordList[numWords] = new WordInfo(word.toLowerCase(), meaning.toLowerCase());
            numWords++;
            return true;
        }
        return false;
    }

    public boolean wordDelete(String word){
        if (maxWords > numWords && wordExists(word) == true){
            wordSort();
            int low = 0, high = numWords -1, mid;
            while (high >= low){
                mid = (low + high) / 2;
                if (wordList[mid].getWord().equals(word)){
                    for (int i = mid; i < numWords; i++) {
                        wordList[i] = wordList[i + 1];
                    }
                    numWords--;
                    return true;
                }
                if (wordList[mid].getWord().compareTo(word) > 0) high = mid - 1;
                if (wordList[mid].getWord().compareTo(word) < 0) low = mid + 1;
            }  
        }
        return false;
    }

    public boolean wordExists(String word){
        if (maxWords > numWords && wordList != null){
            wordSort();
            int low = 0, high = numWords -1, mid;
            while (high >= low){
                mid = (low + high) / 2;
                if (wordList[mid].getWord().equals(word)) return true;
                if (wordList[mid].getWord().compareTo(word) > 0) high = mid - 1;
                if (wordList[mid].getWord().compareTo(word) < 0) low = mid + 1;
            }  
        }
        return false;
    }

    public String getMeaning(String word){
        if (maxWords > numWords && wordList != null && wordExists(word) == true){
            wordSort();
            int low = 0, high = numWords -1, mid;
            while (high >= low){
                mid = (low + high) / 2;
                if (wordList[mid].getWord().equals(word)) return wordList[mid].getMeaning();
                if (wordList[mid].getWord().compareTo(word) > 0) high = mid - 1;
                if (wordList[mid].getWord().compareTo(word) < 0) low = mid + 1;
            }  
        }
        return null;
    }

    public int getWordCount(){
        if (wordList != null && numWords > 0){
            return numWords;
        }
        return -1;
    }

    public void wordSort(){
        if (wordList != null && numWords > 0){
            for (int i = 0; i < numWords; i++) {
                int min = i;
                for (int j = i + 1; j < numWords; j++) {
                    if (wordList[j].getWord().compareTo(wordList[min].getWord()) < 0) min = j;
                    WordInfo temp = wordList[i];
                    wordList[i] = wordList[min];
                    wordList[min] = temp;
                }
            }
        }
    }

    public String printWordList(){
        if (wordList != null && numWords > 0){
            String builder = "";
            for (int i = 0; i < numWords; i++) {
                builder += wordList[i].getWord().toString() + "\n";
            }
            return builder;
        }
        return null;
    }

    public String printDictionary(){
        if (wordList != null & numWords > 0){
            String builder = "";
            for (int i = 0; i < numWords; i++) {
                builder += wordList[i].toString() + "\n";
            }
            return builder;
        }
        return null;
    }

    public void loadDictionary(){
        try {
            File file = new File("wordList.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split(",|\\.|\\s");
                for (int i = 0; i < words.length; i++) {
                    if (wordExists(words[i]) == false){
                        addWord(words[i], "Undefined word");
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Database could not be loaded.");
        }
    }

    public void spellCheck(String fileName){
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split(",|\\.|\\s");
                for (int i = 0; i < words.length; i++) {
                    if (wordExists(words[i]) == true){
                        System.out.println(words[i] + " is in the dictionary.");
                    } else {
                        System.out.println(words[i] + " is not in the dictionary.");
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found or could not be opened.");
        }
    }
}