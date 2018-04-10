package andytran.apis.string.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import andytran.apis.shared.exceptions.BadRequestException;
import andytran.apis.shared.models.APIResponse;
import andytran.apis.shared.utils.ControllerUtils;
import andytran.apis.string.services.StringService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="api/string")
@Api(tags="String APIs", produces="application/json")
public class StringController {
	
	@Autowired
	private StringService stringService;
	
	@RequestMapping(value="reverse/{str}", method=RequestMethod.GET)
	public APIResponse reverse(@PathVariable String str){
		String result = stringService.reverse(str);
		
		if(result == null)
			throw new BadRequestException();	
		return ControllerUtils.makeSuccessResponse(result);
	}
	
	@RequestMapping(value="palindrome/{str}", method=RequestMethod.GET)
	public APIResponse isPalindrome(@PathVariable String str){
		return ControllerUtils.makeSuccessResponse(stringService.isPalindrome(str));
	}
	
	@RequestMapping(value="piglatin/{str}", method=RequestMethod.GET)
	public APIResponse pigLatin(@PathVariable String str){
		String result = stringService.pigLatin(str);
	
		if(result == null)
			throw new BadRequestException();
		return ControllerUtils.makeSuccessResponse(result);
	}
	
	@RequestMapping(value="lnrs/{str}", method=RequestMethod.GET)
	public APIResponse longestNonRepeatingSubstring(@PathVariable String str){
		String result = stringService.longestNonRepeatingSubstring(str);
	
		if(result == null)
			throw new BadRequestException();
		return ControllerUtils.makeSuccessResponse(result);
	}
	
	@RequestMapping(value="unscramble/{str}", method=RequestMethod.GET)
	public APIResponse unscramble(@PathVariable String str){
		List<String> unscrambledWords = stringService.unscramble(str);
		
		if(unscrambledWords == null)
			throw new BadRequestException();
		return ControllerUtils.makeSuccessResponse(unscrambledWords);
	}
	
	@RequestMapping(value="dankify/{str}", method=RequestMethod.GET)
	public APIResponse dankify(@PathVariable String str){
		List<String> results = stringService.dankify(str);
		
		if(results.isEmpty())
			throw new BadRequestException();
		return ControllerUtils.makeSuccessResponse(results);
	}
	
	@RequestMapping(value = "longestpalindrome/{str}", method=RequestMethod.GET)
	public APIResponse longestPalindrome(@PathVariable String str){
		String result = stringService.longestPalindrome(str);
		
		if(result == null)
			throw new BadRequestException();
		return ControllerUtils.makeSuccessResponse(result);
	}
	
	@RequestMapping(value = "isvalidparenthesis/{str}", method = RequestMethod.GET)
	public APIResponse isValidParentheses(@PathVariable String str){
		return ControllerUtils.makeSuccessResponse(stringService.isValidParentheses(str));
	}
	
}
