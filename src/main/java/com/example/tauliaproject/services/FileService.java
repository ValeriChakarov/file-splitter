package com.example.tauliaproject.services;

import com.example.tauliaproject.iomanagers.IOFileManager;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FileService {

    public void splitAllBuyersInCVSFiles(String inputFilePath) throws IOException {
        IOFileManager.splitIntoCsvByBuyer(inputFilePath);
    }

    public void splitAllBuyersInXMLFiles(String inputFilePath)throws IOException {
        IOFileManager.splitIntoXMLByBuyer(inputFilePath);
    }
}
