package yte.intern.springweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class URLController {

    @RequestMapping("/courses/{courseNumber}")
    public void url(@PathVariable Long courseNumber,
                    @RequestParam String name, //soru işaretinden sonrası RequestParam ile alınıyor
                    @RequestParam String instructor){
        System.out.println(courseNumber + " " + name + " " + instructor);
    }
}
