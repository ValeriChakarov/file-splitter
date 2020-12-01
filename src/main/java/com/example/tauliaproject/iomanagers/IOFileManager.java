package com.example.tauliaproject.iomanagers;

import com.example.tauliaproject.domain.BuyerEntities;
import com.example.tauliaproject.domain.BuyerEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class IOFileManager {

    public static final String ROOT_OUTPUT_FOLDER = "src/main/resources/files/resultFiles/";
    public static final String FILE_EXTENSION = ".csv";


    public static void splitIntoCsvByBuyer(String inputFilePath) throws IOException {
        List<BuyerEntity> buyers = getBuyers(inputFilePath);
        Set<String> buyerNames = getBuyersNames(buyers);
        createBuyersFiles(buyerNames, inputFilePath);
        populateBuyerFiles(buyers);
    }

    public static void splitIntoXMLByBuyer(String inputFilePath) throws IOException {
        List<BuyerEntity> buyers = getBuyers(inputFilePath);
        HashMap<String, List<BuyerEntity>> hashMap = new HashMap<>();
        for (int i = 0; i < buyers.size(); i++) {
            if (!hashMap.containsKey(buyers.get(i).getBuyer())) {
                List<BuyerEntity> list = new ArrayList<>();
                buyers.get(i).setInvoiceImage(null);
                list.add(buyers.get(i));

                hashMap.put(buyers.get(i).getBuyer(), list);
            } else {
                buyers.get(i).setInvoiceImage(null);
                hashMap.get(buyers.get(i).getBuyer()).add(buyers.get(i));
            }
        }
        for (Map.Entry<String, List<BuyerEntity>> entry : hashMap.entrySet()) {
            try {
                BuyerEntities buyerEntities = new BuyerEntities();
                buyerEntities.setEmployees(entry.getValue());
                JAXBContext context = JAXBContext.newInstance(BuyerEntities.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                String filePathName = ROOT_OUTPUT_FOLDER + entry.getKey() + ".xml";
                File xmlFile = new File(filePathName);
                marshaller.marshal(buyerEntities, xmlFile);
            } catch (JAXBException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static List<BuyerEntity> getBuyers(String filePath) throws IOException {
        File inputFile = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;
        reader.readLine();
        List<BuyerEntity> buyers = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String[] row = line.split(",");
            BuyerEntity buyerEntity = new BuyerEntity(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8]);
            buyers.add(buyerEntity);
        }
        return buyers;
    }

    public static Set<String> getBuyersNames(List<BuyerEntity> buyers) {
        Set<String> buyerNames = new HashSet<>();
        for (BuyerEntity buyer : buyers) {
            buyerNames.add(buyer.getBuyer());
        }
        return buyerNames;
    }

    public static void createBuyersFiles(Set<String> buyerNames, String filePath) throws IOException {
        for (String name : buyerNames) {
            File outputFile = new File(ROOT_OUTPUT_FOLDER + name + FILE_EXTENSION);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String[] columns = reader.readLine().split(",");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            for (int i = 0; i < columns.length; i++) {
                if (i != columns.length - 1) {
                    writer.write(columns[i] + ",");
                } else {
                    writer.write(columns[i]);
                }
            }
            writer.newLine();
            writer.close();
        }
    }

    public static void populateBuyerFiles(List<BuyerEntity> buyers) throws IOException {
        File dir = new File(ROOT_OUTPUT_FOLDER);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                for (int i = 0; i < buyers.size(); i++) {
                    if (child.getName().contains(buyers.get(i).getBuyer())) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(child, true));
                        writer.write(buyers.get(i).toString());
                        writer.newLine();
                        writer.close();
                    }
                }
            }
        }
    }
}
