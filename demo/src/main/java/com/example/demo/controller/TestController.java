package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;

@RestController
@RequestMapping("test")
public class TestController {
	
	//@GetMapping("/{id}")
	//public String TestController(@PathVariable(required = false) String id) {
	//	return "Test Done!!" + id;
	//}
	
	@GetMapping("/testRequestBody")
	public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDto) {
		return "id in testRequestBodyDTO => " + testRequestBodyDto.getId() + ". + "
				+ "message in testRequestBodyDTO => " + testRequestBodyDto.getMessage();
	}
	
	@GetMapping("testResponseBody")
	public ResponseDTO<String> testControllerResponseBody() {
		
		List<String> list = new ArrayList<>();
		list.add("first");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		
		return response;
	}
	
}
