package andytran.apis.graph.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import andytran.apis.graph.services.GraphService;

@RestController
public class GraphController {
	
	@Autowired
	private GraphService graphService;
	
}
