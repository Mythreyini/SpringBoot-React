package com.example.SpringBotApp.conntrollers;


import com.example.SpringBotApp.models.Employee;
import com.example.SpringBotApp.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class HelloWorldController {
    @Autowired//application context->to access the all the object unlike in java object crated using new class(),here no need this//if not given displays cannot invoke "com.example.SpringBotApp.service.HelloWorldService.helloworldservice()" because "this.hws" is null
    HelloWorldService hws;//object for service//  https://chatgpt.com/share/686630e5-7c98-8002-bca5-0b266878a662

    @GetMapping("/")
    public List<Employee> hello(){
        return hws.getMethodService();
    }


@PostMapping("/")
    public String postMethod(){
        return hws.postMethodService();
    }



@PutMapping("/")
    public String putMethod(){
    return hws.putMethodService();
}


@DeleteMapping("/")
    public String deleteMethod(){
    return hws.deleteMethodService();
}


}




//
//@Controller: This tells Spring that this class handles web requests.
//
//@ResponseBody (on class): Applies to all methods inside the class — it means every method will return data, not a view.
//@GetMapping("/"): Maps the root URL (http://localhost:8080/) to this method.
//
//        hello() method returns the string "hello" as a plain response — i.e., you’ll see "hello" in your browser or API response.

//in brower use->localhost:8080 or by using postman






//GET REQUEST
//Retrieve data from the server.
//
//It does not modify anything on the server.
//
//Commonly used for:
//
//Viewing a web page.
//
////Getting user details.
////
////Fetching a list of items (like products, movies, etc).




//for get
//http://localhost:8080/









//👇
//
//🆚 Difference between @Controller and @RestController
//@Controller	@RestController
//Used to return HTML pages	Used to return data (like text or JSON)
//Needs @ResponseBody to return text or JSON	Returns text or JSON by default
//Used in websites	Used in REST APIs / mobile apps / Angular, React