package xyz.wablers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class HelloController
{
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public  String  sayHello()
    {
        return "Hello SpringBoot";
    }
}
