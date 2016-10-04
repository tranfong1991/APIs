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
		
		if(series == null)
			return ControllerUtils.makeResponseEntity(HttpStatus.BAD_REQUEST, null);
		return ControllerUtils.makeResponseEntity(HttpStatus.OK, series);
	}
	
	@RequestMapping(value="converter/bin2dec/{binary}", method = RequestMethod.GET)
	public ResponseEntity<Response<Integer>> binaryToDecimal(@PathVariable String binary){
		Integer decimal = numberService.binaryToDecimal(binary);
		
		if(decimal == null)
			return ControllerUtils.makeResponseEntity(HttpStatus.BAD_REQUEST, null);
		return ControllerUtils.makeResponseEntity(HttpStatus.OK, decimal);
	}
	
	@RequestMapping(value="converter/dec2bin/{decimal}", method = RequestMethod.GET)
	public ResponseEntity<Response<String>> binaryToDecimal(@PathVariable int decimal){
		String binary = numberService.decimalToBinary(decimal);
		
		if(binary == null)
			return ControllerUtils.makeResponseEntity(HttpStatus.BAD_REQUEST, null);
		return ControllerUtils.makeResponseEntity(HttpStatus.OK, binary);
	}
	
}
