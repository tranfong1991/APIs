package andytran.apis.string.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import andytran.apis.shared.models.APIResponse;
import andytran.apis.shared.utils.ControllerUtils;
import andytran.apis.string.services.StringService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@RestController
@RequestMapping(value="api/string")
@Api(tags="String APIs", produces="application/json")
public class StringController {
	
	@Autowired
	private StringService stringService;
	
	@RequestMapping(value="reverse/{str}", method=RequestMethod.GET)
	public ResponseEntity<APIResponse> reverse(@PathVariable String str){
		String result = stringService.reverse(str);
		if(result == null)
			return ControllerUtils.makeErrorResponseEntity(HttpStatus.BAD_REQUEST, "bad request");
		
		return ControllerUtils.makeSuccessResponseEntity(HttpStatus.OK, result);
	}
	
	@RequestMapping(value="palindrome/{str}", method=RequestMethod.GET)
	public ResponseEntity<APIResponse> isPalindrome(@PathVariable String str){
		return ControllerUtils.makeSuccessResponseEntity(HttpStatus.OK, stringService.isPalindrome(str));
	}
	
	@RequestMapping(value="piglatin/{str}", method=RequestMethod.GET)
	public ResponseEntity<APIResponse> pigLatin(@PathVariable String str){
		String result = stringService.pigLatin(str);
		if(result == null)
			return ControllerUtils.makeErrorResponseEntity(HttpStatus.BAD_REQUEST, "bad request");
		
		return ControllerUtils.makeSuccessResponseEntity(HttpStatus.OK, result);
	}
	
	@RequestMapping(value="lnrs/{str}", method=RequestMethod.GET)
	public ResponseEntity<APIResponse> longestNonRepeatingSubstring(@PathVariable String str){
		String result = stringService.longestNonRepeatingSubstring(str);
		if(result == null)
			return ControllerUtils.makeErrorResponseEntity(HttpStatus.BAD_REQUEST, "bad request");
		
		return ControllerUtils.makeSuccessResponseEntity(HttpStatus.OK, result);
	}
	
	@RequestMapping(value="unscramble/{str}", method=RequestMethod.GET)
	public ResponseEntity<APIResponse> unscramble(@PathVariable String str){
		List<String> unscrambledWords = stringService.unscramble(str);
		if(unscrambledWords == null)
			return ControllerUtils.makeErrorResponseEntity(HttpStatus.BAD_REQUEST, "bad request");
		
		return ControllerUtils.makeSuccessResponseEntity(HttpStatus.OK, unscrambledWords);
	}
	
	@RequestMapping(value="dankify/{str}", method=RequestMethod.GET)
	public ResponseEntity<APIResponse> dankify(@PathVariable String str){
		List<String> results = stringService.dankify(str);
		if(results.isEmpty())
			return ControllerUtils.makeErrorResponseEntity(HttpStatus.BAD_REQUEST, "bad request");
		
		return ControllerUtils.makeSuccessResponseEntity(HttpStatus.OK, results);
	}
	
	@RequestMapping(value = "longestpalindrome/{str}", method=RequestMethod.GET)
	public ResponseEntity<APIResponse> longestPalindrome(@PathVariable String str){
		String result = stringService.longestPalindrome(str);
		if(result == null)
			return ControllerUtils.makeErrorResponseEntity(HttpStatus.BAD_REQUEST, "bad request");
		
		return ControllerUtils.makeSuccessResponseEntity(HttpStatus.OK, result);
	}
	
}
