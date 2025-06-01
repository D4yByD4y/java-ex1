package chapter_05;

class Ex53Person {}
class Ex53Student extends Ex53Person {}
class Ex53Researcher extends Ex53Person {}
class Ex53Professor extends Ex53Researcher {}

public class Ex53InstanceOfEx {
    static void print(Ex53Person p) {
        if(p instanceof Ex53Person) {
            System.out.print("Person ");
        }
        if(p instanceof Ex53Student) {
            System.out.print("Student ");
        }
        if(p instanceof Ex53Researcher) {
            System.out.print("Researcher ");
        }
        if(p instanceof Ex53Professor) {
            System.out.print("Professor ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.print("new Student() -> ");
        print(new Ex53Student());
        System.out.print("new Researcher() -> ");
        print(new Ex53Researcher());
        System.out.print("new Professor() -> ");
        print(new Ex53Professor());
    }
}
