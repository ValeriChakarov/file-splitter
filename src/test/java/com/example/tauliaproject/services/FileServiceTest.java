package com.example.tauliaproject.services;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    @TempDir
    Path tempDir;

    @Test
    void splitAllBuyersInCVSFiles(@TempDir Path fileDir) throws IOException {
        Path file = fileDir.resolve("Axtronics.csv");
        String description = "buyer,image_name,invoice_image,invoice_due_date,invoice_number,invoice_amount,invoice_currency,invoice_status,supplier" +
                "Axtronics,f1.png,,2020-10-23,AA-C56790,305.45,USD,NEW,Silver Logistics";
        Files.write(file, description.getBytes());
        List<String> actualData = Files.readAllLines(file);
        List<String> expected = Collections.singletonList(description);
        Assertions.assertEquals(expected,actualData);
    }

    @Test
    void splitAllBuyersInXMLFiles(@TempDir Path fileDir) throws IOException {
        Path file = fileDir.resolve("Axtronics.xml");
        String description = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<buyerEntities>" +
                "    <buyerEntity>" +
                "        <buyer>Axtronics</buyer>" +
                "        <imageName>f1.png</imageName>" +
                "        <invoiceDueDate>2020-10-23</invoiceDueDate>" +
                "        <invoiceNumber>AA-C56790</invoiceNumber>" +
                "        <invoiceAmount>305.45</invoiceAmount>" +
                "        <invoiceCurrency>USD</invoiceCurrency>" +
                "        <invoiceStatus>NEW</invoiceStatus>" +
                "        <supplier>Silver Logistics</supplier>" +
                "    </buyerEntity>" +
                "</buyerEntities>";
        Files.write(file, description.getBytes());
        List<String> actualData = Files.readAllLines(file);
        List<String> expected = Collections.singletonList(description);

        Assertions.assertEquals(expected,actualData);
    }
}