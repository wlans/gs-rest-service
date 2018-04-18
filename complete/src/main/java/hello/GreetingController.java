package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.validator.constraints.ScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.create.facade.ServiceFacade;

@RestController
public class GreetingController implements GreetingI {
	
	@Autowired
	ServiceFacade facade;
	

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public ResponseEntity<Greeting> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        facade.
    	return ResponseEntity.ok().body(new Greeting(counter.incrementAndGet(),
                String.format(template, name)) );
    }
    
    public ResponseEntity<Greeting> greeting2(@RequestParam(value="name", defaultValue="World") String name) {
        return ResponseEntity.ok().body(new Greeting(counter.incrementAndGet(),
                String.format(template, name)) );
    }
    
    @RequestMapping(value = "/greeting/{id}", method = RequestMethod.GET)
    public Greeting greetingId(@PathVariable("id") String id) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, id));
    }

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Greeting greetingPut(@RequestBody String greeting) {
		return new Greeting(1,greeting);
	}
	}
