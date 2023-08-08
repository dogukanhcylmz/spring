package yte.intern.springweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @PostMapping("/persons")
    public List<Person> getPersons(@RequestBody List<Person> people) {
        return people.stream()
                .map(person -> new Person(person.name(), person.surname(), person.age()+1))
                .toList();
    }
}
