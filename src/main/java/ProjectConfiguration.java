import entities.Parrot;
import entities.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {


    @Bean
    Parrot parrot(){
        System.out.println(11);
        var p = new Parrot();
        p.setName("Cocki");
        return p;
    }

    @Bean
    Person person(Parrot parrot) {
        var p = new Person();
        p.setName("Nikita");
        p.setParrot(parrot);
        return p;
    }
}
