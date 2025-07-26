package com.juaracoding.ecom;

import com.juaracoding.ecom.pages.InventoryPage;
import com.juaracoding.ecom.utils.DriverUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

    private InventoryPage inventoryPage;

    @Test()
    public void testAddItems() {
        inventoryPage = new InventoryPage(DriverUtil.getDriver());

        int total = inventoryPage.getTotalProductDisplayed();
        Assert.assertEquals(total, 6, "Jumlah produk tidak sesuai!");

        inventoryPage.addItemToCart();

        String itemCount = inventoryPage.getCartItemCount();
        Assert.assertEquals(itemCount, "1", "Jumlah item di cart tidak sesuai!");

        boolean removeButtonExists = inventoryPage.isRemoveButtonExists();
        Assert.assertTrue(removeButtonExists, "Tombol Remove tidak ditemukan setelah add item!");

    }
}