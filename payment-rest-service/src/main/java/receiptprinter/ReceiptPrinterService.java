package receiptprinter;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptPrinterService {
    private DecimalFormat df = new DecimalFormat("0.00");

    public String[] getReceiptLines(final String[] lines){
        List<ShoppingItem> items = new ArrayList<ShoppingItem>();
        for(String line : lines) {
            items.add(parseInput(line));
        }
        return generateReceipt(items);
    }


    private ShoppingItem parseInput(final String line) {
        String[] result = line.split(" ");

        ShoppingItem item = new ShoppingItem();
        item.setQuantity(Integer.parseInt(result[0]));
        item.setPrice(Double.parseDouble(result[result.length - 1]));

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < result.length - 2; i++) {
            sb.append(result[i] + " ");
        }

        item.setProductName(sb.toString().trim());
        item.setImported(sb.toString().trim().contains("imported"));
        item.setExempt(isProductExempt(sb.toString().trim()));
        item.setSalesTaxRate(item.isExempt() ? 0.0 : 0.1);
        item.setImportDutyTaxRate(item.isImported() ? 0.05 : 0);
        item.setTotalTax((item.getSalesTaxRate() + item.getImportDutyTaxRate()) * item.getPrice());
        item.setPriceWithTax(item.getPrice() + item.getTotalTax());

        return item;
    }

    private boolean isProductExempt(final String str) {
        return str.contains("book") || str.contains("chocolate") || str.contains("pills");
    }

    private String[] generateReceipt(List<ShoppingItem> shoppingItems) {
        double taxes = 0;
        double total = 0;
        String[] lines = new String[shoppingItems.size() + 2];
        int i = 0;
        for(ShoppingItem item : shoppingItems) {
            lines[i++] = (buildLine(item));
            taxes += (item.getTotalTax() * item.getQuantity());
            total += (item.getPriceWithTax() * item.getQuantity());
        }

        lines[i++] = new String("Sales Taxes: " + df.format((new BigDecimal(taxes)).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        lines[i++] = new String("Total: " + df.format((new BigDecimal(total)).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        return lines ;
    }

    private String buildLine(ShoppingItem item) {
        return item.getQuantity() + " " +item.getProductName() + ": " + df.format((new BigDecimal(item.getPriceWithTax()
                * item.getQuantity()).setScale(2, RoundingMode.HALF_UP).doubleValue()));
    }
}
