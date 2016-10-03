package andytran.apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import andytran.apis.models.Response;
import andytran.apis.services.number.NumberService;
import andytran.apis.utils.ControllerUtils;

@RestController
@RequestMapping(value="api/number")
public class NumberController {
	
	@Autowired
	private NumberService numberService;
	
	@RequestMapping(value="pi", method = RequestMethod.GET)
	public ResponseEntity<Response<String>> getPi(@RequestParam(defaultValue="5") int precision){
		String pi = numberService.getPi(precision);
		
		if(pi == null)
			return ControllerUtils.makeResponseEntity(HttpStatus.BAD_REQUEST, null);
		return ControllerUtils.makeResponseEntity(HttpStatus.OK, pi);
	}
	
}
