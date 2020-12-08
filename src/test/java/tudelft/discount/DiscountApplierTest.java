package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tudelft.invoicemocked.Invoice;
import tudelft.invoicemocked.InvoiceDao;
import tudelft.invoicemocked.InvoiceFilter;

import java.util.Arrays;
import java.util.List;

public class DiscountApplierTest {
    @Test
    void DiscountApplier() {

        Product home = new Product("Google Home Mini",100,"HOME");
        Product business = new Product("Google Home Business",100,"BUSINESS");

        ProductDao dao = Mockito.mock(ProductDao.class);
        List<Product> results = Arrays.asList(home,business);
        Mockito.when(dao.all()).thenReturn(results);

        DiscountApplier appliedDiscount = new DiscountApplier(dao);
        appliedDiscount.setNewPrices();

        Assertions.assertEquals(90,home.getPrice());
        Assertions.assertEquals(110,Math.round(business.getPrice()));
    }
}
