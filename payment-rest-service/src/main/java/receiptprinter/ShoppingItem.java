package receiptprinter;

public class ShoppingItem {

    private int quantity;
    private String productName;
    private boolean exempt;
    private boolean imported;
    private double price;
    private double salesTaxRate;
    private double importDutyTaxRate;
    private double totalTax;
    private double priceWithTax;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isExempt() {
        return exempt;
    }

    public void setExempt(boolean exempt) {
        this.exempt = exempt;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSalesTaxRate() {
        return salesTaxRate;
    }

    public void setSalesTaxRate(double salesTaxRate) {
        this.salesTaxRate = salesTaxRate;
    }

    public double getImportDutyTaxRate() {
        return importDutyTaxRate;
    }

    public void setImportDutyTaxRate(double importDutyTaxRate) {
        this.importDutyTaxRate = importDutyTaxRate;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(double priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    public ShoppingItem() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingItem item = (ShoppingItem) o;

        if (exempt != item.exempt) return false;
        if (Double.compare(item.importDutyTaxRate, importDutyTaxRate) != 0) return false;
        if (imported != item.imported) return false;
        if (Double.compare(item.price, price) != 0) return false;
        if (Double.compare(item.priceWithTax, priceWithTax) != 0) return false;
        if (quantity != item.quantity) return false;
        if (Double.compare(item.salesTaxRate, salesTaxRate) != 0) return false;
        if (Double.compare(item.totalTax, totalTax) != 0) return false;
        if (!productName.equals(item.productName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = quantity;
        result = 31 * result + productName.hashCode();
        result = 31 * result + (exempt ? 1 : 0);
        result = 31 * result + (imported ? 1 : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(salesTaxRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(importDutyTaxRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalTax);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(priceWithTax);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "quantity=" + quantity +
                ", productName='" + productName + '\'' +
                ", exempt=" + exempt +
                ", imported=" + imported +
                ", price=" + price +
                ", salesTaxRate=" + salesTaxRate +
                ", importDutyTaxRate=" + importDutyTaxRate +
                ", totalTax=" + totalTax +
                ", priceWithTax=" + priceWithTax +
                '}';
    }
}
