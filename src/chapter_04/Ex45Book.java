package chapter_04;

public class Ex45Book {
    String title;
    String author;

    void show() {
        System.out.println(title + " " + author);
    }

    public Ex45Book() {
        this("", "");
        System.out.println("생성자 호출됨.");
    }

    public Ex45Book(String title) {
        this(title, "작자미상");
    }

    public Ex45Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public static void main(String[] args) {
        // Ex45Book littlePrince = new Ex45Book("어린왕자", "생텍쥐페리");
        Ex45Book loveStory = new Ex45Book("춘향전");
        // Ex45Book emptyBook = new Ex45Book();
        loveStory.show();
    }
    
}
