public class Dictionary {
    private String EnglishWord;
    private String VietnameseWord;

    public Dictionary() {
    }

    public Dictionary(String englishWord, String vietnameseWord) {
        EnglishWord = englishWord;
        VietnameseWord = vietnameseWord;
    }

    public String getEnglishWord() {
        return EnglishWord;
    }

    public void setEnglishWord(String englishWord) {
        EnglishWord = englishWord;
    }

    public String getVietnameseWord() {
        return VietnameseWord;
    }

    public void setVietnameseWord(String vietnameseWord) {
        VietnameseWord = vietnameseWord;
    }

    public String toString(){
        return this.EnglishWord + "," + this.VietnameseWord;
    }
}
