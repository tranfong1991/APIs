package andytran.apis.array.controllers;

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
	public APIResponse getMaxWaterVolume(@RequestParam int[] heights){
		return ControllerUtils.makeSuccessResponse(arrayService.maxWaterVolume(heights));
	}
	
	@RequestMapping(value = "nextpermutation", method = RequestMethod.GET)
	public APIResponse nextPermutation(@RequestParam int[] nums){
		arrayService.nextPermutation(nums);
		return ControllerUtils.makeSuccessResponse(nums);
	}
	
	@RequestMapping(value = "rotatematrix/{dimension}", method = RequestMethod.GET)
	public APIResponse rotateMatrix(@PathVariable int dimension, @RequestParam int[] matrix){
		int[][] m = new int[dimension][dimension];
		int currentIndex = 0;
		for(int row = 0; row < m.length; row++){
			for(int col = 0; col < m[row].length; col++){
				m[row][col] = matrix[currentIndex++];
			}
		}
		arrayService.rotateMatrix(m);
		return ControllerUtils.makeSuccessResponse(m);
	}
	
	@RequestMapping(value = "maxsubarray", method = RequestMethod.GET)
	public APIResponse maxSubArray(@RequestParam int[] nums){
		return ControllerUtils.makeSuccessResponse(arrayService.maxSubArray(nums));
	}
	
	@RequestMapping(value = "jumpgame", method = RequestMethod.GET)
	public APIResponse canJump(@RequestParam int[] nums){
		return ControllerUtils.makeSuccessResponse(arrayService.canJump(nums));
	}
	
	@RequestMapping(value = "optimalbooking", method = RequestMethod.GET)
	public APIResponse optimalBooking(@RequestParam int[] bookings){
		return ControllerUtils.makeSuccessResponse(arrayService.optimalBooking(bookings));
	}
}
