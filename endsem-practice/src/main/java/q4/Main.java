package ques4;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted temp.txt to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }

        try {
            try {
                String s = null;
                int len = s.length();
            } catch (NullPointerException e) {
                System.out.println("1");
                throw new NullPointerException();
            }
            catch(Exception e) {
                System.out.println("2");
                throw new NullPointerException();
            }
            finally {
                System.out.println("3"); }
        }
        catch(Exception e) {
            System.out.println("4"); }
        finally {
            System.out.println("5"); }
    }
}