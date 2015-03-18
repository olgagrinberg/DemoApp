package receiptprinter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.util.List;

    /* Test data
    Input 1:
    1 book at 12.49
    1 music CD at 14.99
    1 chocolate bar at 0.85

    Input 2:
    1 imported box of chocolates at 10.00
    1 imported bottle of perfume at 47.50

    Input 3:
    1 imported bottle of perfume at 27.99
    1 bottle of perfume at 18.99
    1 packet of headache pills at 9.75
    1 box of imported chocolates at 11.25

    Output 1:
    1 book : 12.49
    1 music CD: 16.49
    1 chocolate bar: 0.85
    Sales Taxes: 1.50
    Total: 29.83

    Output 2:
    1 imported box of chocolates: 10.50
    1 imported bottle of perfume: 54.65
    Sales Taxes: 7.65
    Total: 65.15

    Output 3:
    1 imported bottle of perfume: 32.19
    1 bottle of perfume: 20.89
    1 packet of headache pills: 9.75
    1 imported box of chocolates: 11.85
    Sales Taxes: 6.70
    Total: 74.68
    */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:8090")
public class TestReceiptPrinterService {

    public static final String SERVER_URI = "http://localhost:8090/print";

    @Test
    public void test1() {
        String[] linesIn = {"1 book at 12.49",
                "1 music CD at 14.99",
                "1 chocolate bar at 0.85"};
        String[] linesOut = testGetPrinter(linesIn);
        assertNotNull("can not print receipt", linesOut);
        assertEquals(linesIn.length, linesOut.length - 2);
        System.out.println("\n\n");
        for(String s:linesOut) {
            System.out.println(s);
        }
        System.out.println("\n\n");
    }

    @Test
    public void test2() {
        String[] linesIn = {"1 imported box of chocolates at 10.00",
                "1 imported bottle of perfume at 47.50"};
        String[] linesOut = testGetPrinter(linesIn);
        assertNotNull("can not print receipt", linesOut);
        assertEquals(linesIn.length, linesOut.length - 2);
        System.out.println("\n\n");
        for(String s:linesOut) {
            System.out.println(s);
        }
        System.out.println("\n\n");
    }

    @Test
    public void test3() {
        String[] linesIn = {"1 imported bottle of perfume at 27.99",
                "1 bottle of perfume at 18.99",
                "1 packet of headache pills at 9.75",
                "1 box of imported chocolates at 11.25"};
        String[] linesOut = testGetPrinter(linesIn);
        assertNotNull("can not print receipt", linesOut);
        assertEquals(linesIn.length, linesOut.length - 2);
        System.out.println("\n\n");
        for(String s:linesOut) {
            System.out.println(s);
        }
        System.out.println("\n\n");
    }

    private String[] testGetPrinter(String[] lines) {
        RestTemplate restTemplate = new RestTemplate();
        URI targetUrl= UriComponentsBuilder.fromUriString(SERVER_URI)
                .queryParam("lines", lines)
                .build()
                .toUri();
        return restTemplate.getForObject(targetUrl, String[].class);
     }

}