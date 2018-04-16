package andytran.apis.array.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "nextpermutation", method = RequestMethod.GET)
	public APIResponse nextPermutation(@RequestParam List<Integer> nums){
		int[] n = new int[nums.size()];
		for(int i = 0; i < nums.size(); i++){
			n[i] = nums.get(i);
		}
		
		arrayService.nextPermutation(n);
		return ControllerUtils.makeSuccessResponse(n);
	}
	
	@RequestMapping(value = "rotatematrix/{dimension}", method = RequestMethod.GET)
	public APIResponse rotateMatrix(@PathVariable int dimension, @RequestParam List<Integer> matrix){
		int[][] m = new int[dimension][dimension];
		int currentIndex = 0;
		for(int row = 0; row < m.length; row++){
			for(int col = 0; col < m[row].length; col++){
				m[row][col] = matrix.get(currentIndex++);
			}
		}
		arrayService.rotateMatrix(m);
		return ControllerUtils.makeSuccessResponse(m);
	}
	
}
