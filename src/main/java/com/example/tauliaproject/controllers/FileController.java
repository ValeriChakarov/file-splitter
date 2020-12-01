package com.example.tauliaproject.controllers;

import com.example.tauliaproject.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/buyers")
@RequiredArgsConstructor
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/csv")
    public void fetchAllBuyersCSVs(@RequestParam String inputFilePath) throws IOException {
        fileService.splitAllBuyersInCVSFiles(inputFilePath);
    }

    @GetMapping("/xml")
    public void fetchAllBuyersXMLs(@RequestParam String inputFilePath) throws IOException {
        fileService.splitAllBuyersInXMLFiles(inputFilePath);
    }
}
