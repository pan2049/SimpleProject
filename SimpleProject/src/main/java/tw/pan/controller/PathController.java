package tw.pan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tw.pan.utils.exception.PageNotFoundException;

@Controller
@CrossOrigin
public class PathController {

	@GetMapping(value = "/{pathName}")
	public String pathSwitch(@PathVariable String pathName) throws PageNotFoundException {
		return pathName;
	}
}
