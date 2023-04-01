public class WordInfo {
    // Casey Hsu - 101376814

    private String word;
    private String meaning;

    public WordInfo(String word, String meaning){
        this.word = word;
        this.meaning = meaning;
    }

    public String getWord(){
        return word;
    }

    public String getMeaning(){
        return meaning;
    }

    public void setWord(String word){
        this.word = word;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String toString(){
        return String.format("Word: %s (Meaning: %s)", word, meaning);
    }
}
