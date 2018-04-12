package andytran.apis.array.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import andytran.apis.array.services.ArrayService;
import andytran.apis.shared.models.APIResponse;
import andytran.apis.shared.utils.ControllerUtils;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "api/array")
@Api(tags="Array APIs", produces="application/json")
public class ArrayController {

	@Autowired
	private ArrayService arrayService;
	
	@RequestMapping(value = "maxwatervolume", method = RequestMethod.GET)
	public APIResponse getMaxWaterVolume(@RequestParam List<Integer> heights){
		return ControllerUtils.makeSuccessResponse(arrayService.getMaxWaterVolume(heights));
	}
	
}