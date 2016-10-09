package andytran.apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import andytran.apis.models.LongestSubstringResponse;
import andytran.apis.models.APIResponse;
import andytran.apis.services.string.StringService;
import andytran.apis.utils.ControllerUtils;

@RestController
@RequestMapping(value="api/string")
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
	
	@RequestMapping(value="longestsubstring/{str}", method=RequestMethod.GET)
	public ResponseEntity<APIResponse> longestSubstring(@PathVariable String str){
		String longestSubstring = stringService.longestSubstring(str);
		if(longestSubstring == null)
			return ControllerUtils.makeErrorResponseEntity(HttpStatus.BAD_REQUEST, "bad request");
		
		LongestSubstringResponse result = new LongestSubstringResponse(longestSubstring);
		return ControllerUtils.makeSuccessResponseEntity(HttpStatus.OK, result);
	}
	
}
