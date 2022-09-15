import java.util.ArrayList;

/**
 * Scrumboard
 */
public class Scrumboard{

    private ArrayList<String> Todo = new ArrayList<>();
    private ArrayList<String> Completed = new ArrayList<>();

    public Scrumboard() {
        char letter = 'A';
        for (int i = 0; i < 10; i++) {
            Todo.add(Character.toString(letter));
            letter++;
        }

    }
    public String getNext() {
        if (this.Todo.size() == 0){
            return "";
        }
        return this.Todo.remove(0);
    }

    public void addComplete(String add) {
        this.Completed.add(add);
    }

    public ArrayList<String> getTodo() {
        return Todo;
    }
    public ArrayList<String> getCompleted() {
        return Completed;
    }
    public static void main(String[] args) {
        Scrumboard a = new Scrumboard();
        System.out.println(a.getNext());
        System.out.println(a.getTodo());
    }
}