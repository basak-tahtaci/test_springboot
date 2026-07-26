package org.example.test_springboot.controller;

import org.example.test_springboot.model.Student;
import org.springframework.web.bind.annotation.*;

//Annotations, hier sagen wir ihm dass er ein Controller ist
@RestController
@RequestMapping("/api/hello")     //Ordnerstruktur für verschiedene Anfragen für den Controller

//springboot entscheidet jetzt wann braucht er diesen Controller, muss nicht jedes mal neuen controller bauen
public class HelloController {

    //wo soll diese methode liegen, mit get holen wir es aus dem Server, getMapping muss einzigartig sein
    @GetMapping
    public String sayHello() {
        return "Hello World";
    }

    //browser rufen automatisch immer get auf
    @GetMapping("/second")  //diese methode ist unter /api/hello/second erreichbar
    public String sayHello2() {
        return "Hello World2";
    }

    //um auch daten mitzuschicken
    //mit @requestbody gibt man an, das student im body der anfrage steckt
    @PostMapping
    public String printValue(@RequestBody Student value) {
        return "Hello " + value.firstName() + " " + value.lastName();
    }

    //path variable mitschicken, geht aber nicht nur mit get sondern alle, wenn variabel in {}
    @GetMapping("/{id}")
    public String printValue(@PathVariable String id) {
        return "Hello, your ID is: " + id;
    }

    //query parameter mitschicken, geht wieder mit allen methoden get, post etc.
    @GetMapping("/search")
    public String printQuery(@RequestParam String query) {
        return "Your query is: " + query;
    }
}
