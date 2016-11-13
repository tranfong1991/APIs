package andytran.apis.number.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import andytran.apis.number.models.Unit;
import andytran.apis.number.models.UnitType;
import andytran.apis.number.services.NumberService;
import andytran.apis.shared.exceptions.BadRequestException;
import andytran.apis.shared.models.APIResponse;
import andytran.apis.shared.utils.ControllerUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value="api/number")
@Api(tags="Number APIs", produces="application/json")
public class NumberController {
	
	@Autowired
	private NumberService numberService;
	
	@RequestMapping(value="pi", method = RequestMethod.GET)
	public APIResponse getPi(@RequestParam(defaultValue="5") int precision){
		String pi = numberService.pi(precision);
		
		if(pi == null)
			throw new BadRequestException();
		return ControllerUtils.makeSuccessResponse(pi);
	}
	
	@RequestMapping(value="fibonacci", method = RequestMethod.GET)
	public APIResponse getFibonacci(@RequestParam(defaultValue="10") int limit){
		List<Integer> series = numberService.fibonacci(limit);
		
		if(series.isEmpty())
			throw new BadRequestException();
		return ControllerUtils.makeSuccessResponse(series);
	}
	
	@RequestMapping(value="convert/{numStr}", method = RequestMethod.GET)
	public APIResponse convert(@ApiParam(value="number")
			@PathVariable String numStr, 
			@RequestParam(name = "from") UnitType fromType, 
			@RequestParam(name = "to") UnitType toType){
		Unit result = numberService.convert(numStr, fromType, toType);
		
		if(result == null)
			throw new BadRequestException();
		return ControllerUtils.makeSuccessResponse(result);
	}
	
}
