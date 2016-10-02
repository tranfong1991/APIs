package andytran.apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import andytran.apis.models.Response;
import andytran.apis.services.string.StringService;
import andytran.apis.utils.ControllerUtils;

@RestController
@RequestMapping(value="api/string")
public class StringController {
	
	@Autowired
	private StringService stringService;
	
	@RequestMapping(value="reverse/{str}", method=RequestMethod.GET)
	public ResponseEntity<Response<String>> reverse(@PathVariable String str){
		return ControllerUtils.makeResponseEntity(HttpStatus.OK, stringService.reverse(str));
	}
	
	@RequestMapping(value="palindrome/{str}", method=RequestMethod.GET)
	public ResponseEntity<Response<Boolean>> isPalindrome(@PathVariable String str){
		return ControllerUtils.makeResponseEntity(HttpStatus.OK, stringService.isPalindrome(str));
	}
	
	@RequestMapping(value="piglatin/{str}", method=RequestMethod.GET)
	public ResponseEntity<Response<String>> pigLatin(@PathVariable String str){
		return ControllerUtils.makeResponseEntity(HttpStatus.OK, stringService.pigLatin(str));
	}
	
}
