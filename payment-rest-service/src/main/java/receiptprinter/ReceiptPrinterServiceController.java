package receiptprinter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiptPrinterServiceController {
    @Autowired
    private ReceiptPrinterService service;

    @RequestMapping("/print")
    public String[] print(@RequestParam(value="lines") String[] lines) {
        return service.getReceiptLines(lines);
    }

}
