//package com.example.tauliaproject;
//
//import com.example.tauliaproject.services.FileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Runner implements CommandLineRunner {
//
//    @Autowired
//    FileService fileService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (args[1].contains("csv")) {
//            fileService.splitAllBuyersInCVSFiles(args[0]);
//        } else if (args[1].contains("xml")) {
//            fileService.splitAllBuyersInXMLFiles(args[0]);
//        }
//        System.out.println("Finished");
//    }
//}
