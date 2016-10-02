package andytran.apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import andytran.apis.services.number.NumberService;

@RestController
@RequestMapping(value="/number")
public class NumberController {
	@Autowired
	private NumberService numberService;
	
	@RequestMapping(value="/sum")
	public Integer getSum(@RequestParam int x, @RequestParam int y){
		return numberService.getSum(x,y);
	}
}
