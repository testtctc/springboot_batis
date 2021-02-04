package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.restservice.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class DemoApplication {

	private final AtomicLong counter = new AtomicLong();
	private static final String template = "Hello, %s!";
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/rest")
	public Greeting rest(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	//自动获取
	@Autowired
	private UserService userService;

	@ResponseBody
	@PostMapping("/add")
	public int addUser(User user){
		return userService.addUser(user);
	}

	@ResponseBody
	@GetMapping("/all")
	public Object findAllUser(
			@RequestParam(name = "pageNum", required = false, defaultValue = "1")
					int pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10")
					int pageSize){
		return userService.findAllUser(pageNum,pageSize);
	}
}
