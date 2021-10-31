import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Originator.Memento> list = new ArrayList<>();

        Originator originator = new Originator();
        originator.setState("one");
        System.out.println(originator.state);
        originator.setState("two");
        System.out.println(originator.state);
        list.add(originator.saveState());
        originator.setState("three");
        System.out.println(originator.state);
        originator.restoreFromMomento(list.get(0));
        System.out.println(originator.state);
    }

}

class Originator {
    String state;

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveState() {
        return new Memento(this.state);
    }

    public void restoreFromMomento(Memento memento) {
        this.state = memento.state;
    }

    static class Memento {
        String state;

        public Memento(String state) {
            this.state = state;
        }
        public String getState() {
            return state;
        }
    }
}
