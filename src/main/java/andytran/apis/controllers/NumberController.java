package andytran.apis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import andytran.apis.models.Response;
import andytran.apis.models.Unit;
import andytran.apis.models.UnitType;
import andytran.apis.services.number.NumberService;
import andytran.apis.utils.ControllerUtils;

@RestController
@RequestMapping(value="api/number")
public class NumberController {
	
	@Autowired
	private NumberService numberService;
	
	@RequestMapping(value="pi", method = RequestMethod.GET)
	public ResponseEntity<Response<String>> getPi(@RequestParam(defaultValue="5") int precision){
		String pi = numberService.pi(precision);
		
		if(pi == null)
			return ControllerUtils.makeResponseEntity(HttpStatus.BAD_REQUEST, null);
		return ControllerUtils.makeResponseEntity(HttpStatus.OK, pi);
	}
	
	@RequestMapping(value="fibonacci", method = RequestMethod.GET)
	public ResponseEntity<Response<List<Integer>>> getFibonacci(@RequestParam(defaultValue="10") int limit){
		List<Integer> series = numberService.fibonacci(limit);
		
		if(series.isEmpty())
			return ControllerUtils.makeResponseEntity(HttpStatus.BAD_REQUEST, null);
		return ControllerUtils.makeResponseEntity(HttpStatus.OK, series);
	}
	
	@RequestMapping(value="convert/{numStr}", method = RequestMethod.GET)
	public ResponseEntity<Response<Unit>> convert(@PathVariable String numStr, 
			@RequestParam(name = "from") UnitType fromType, 
			@RequestParam(name = "to") UnitType toType){
		Unit result = numberService.convert(numStr, fromType, toType);
		
		if(result == null)
			return ControllerUtils.makeResponseEntity(HttpStatus.BAD_REQUEST, null);
		return ControllerUtils.makeResponseEntity(HttpStatus.OK, result);
	}
	
}
