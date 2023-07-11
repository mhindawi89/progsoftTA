package com.progsoft.assignment.service;

import org.springframework.web.multipart.MultipartFile;

import com.progsoft.assignment.exception.FileEmptyException;
import com.progsoft.assignment.exception.FileTypeExceptionFormat;

public interface FileService {
	
	public void uploadDealsFile(MultipartFile file) throws FileEmptyException, FileTypeExceptionFormat;

}
