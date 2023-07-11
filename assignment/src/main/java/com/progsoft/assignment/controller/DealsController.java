package com.progsoft.assignment.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.progsoft.assignment.service.FileService;

@RestController
public class DealsController {

	@Autowired
	private FileService fileService;

	@PostMapping("/uploadFile")
	public ResponseEntity<?> uploadDealsFile(@RequestParam("file") @Valid MultipartFile file) {
		try {
			fileService.uploadDealsFile(file);
			return new ResponseEntity<>("file uploaded successfully", HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = String.format("Error on uploading file ....!, {}", e.getMessage());
			return new ResponseEntity<>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
