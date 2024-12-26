package tw.pan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api")
public class PathController {

	@GetMapping(value = "/get/{pathName}")
	public String pathSwitch(@PathVariable String pathName) {
		return pathName;
	}
}
