import entities.Parrot;
import entities.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var person =
                context.getBean(Person.class);
        var parrot =
                context.getBean(Parrot.class);
        System.out.println(
                "Person's name: " + person.getName());
        System.out.println(
                "Parrot's name: " + parrot.getName());
        System.out.println(
                "Person's parrot: " + person.getParrot());
    }
}
