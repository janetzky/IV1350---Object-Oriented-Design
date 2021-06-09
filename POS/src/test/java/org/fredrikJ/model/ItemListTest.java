package org.fredrikJ.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemListTest {

    private ItemList itemList;

    @Before
    public void setUp() {
        this.itemList = ItemList.getInstance();
        ItemType item = new ItemType("331dfsef", 13.37, 12, "Delikat kladdkaka", 42);
        this.itemList.addItemType(item);
    }

    @After
    public void tearDown() throws Exception {
        this.itemList = null;
    }

    @Test
    public void addItemByQuantity() {
        this.itemList.addItemByQuantity("331dfsef",3);
        Assert.assertEquals(45, this.itemList.getItemTypeById("331dfsef").getQuantity() );
        this.itemList.addItemByQuantity("331dfsef",-44);
        Assert.assertEquals(1, this.itemList.getItemTypeById("331dfsef").getQuantity() );
        this.itemList.addItemByQuantity("331dfsef",-10);
        Assert.assertNull(this.itemList.getItemTypeById("331dfsef"));
    }

    @Test
    public void addItemType() {
        ItemType item = new ItemType("KOSur83&%#", 5.00, 6, "Dennis hotdog", 1250);
        this.itemList.addItemType(item);
        Assert.assertEquals("KOSur83&%#", this.itemList.getItemTypeById("KOSur83&%#").getItemId());
        Assert.assertEquals(5, this.itemList.getItemTypeById("KOSur83&%#").getPrice().getNetto(),0.0001);
        Assert.assertEquals(6, this.itemList.getItemTypeById("KOSur83&%#").getPrice().getVatPercentage(),0.0001);
        Assert.assertEquals("Dennis hotdog", this.itemList.getItemTypeById("KOSur83&%#").getDescription());
        Assert.assertEquals(1250, this.itemList.getItemTypeById("KOSur83&%#").getQuantity());
    }

    @Test
    public void isItemTypeInList() {
        Assert.assertTrue(this.itemList.isItemTypeInList("331dfsef"));
        Assert.assertFalse(this.itemList.isItemTypeInList("invalidItemId"));
    }

    @Test
    public void updatePrice() {
        Assert.assertEquals(42 * (13.37 * 1.12), this.itemList.getPrice().getPrice(), 0.00001);
    }

    @Test
    public void setDiscount() {
        Double percentage = 14.2;
        this.itemList.setDiscount(percentage);
        Assert.assertEquals(14.2,this.itemList.getPrice().getDiscountPercentage(), 0.0001);
        Assert.assertEquals(this.itemList.getPrice().getPricePreDiscount() * 14.2/100,this.itemList.getPrice().getDiscountAmount(), 0.0001);
    }

    @Test
    public void getItemTypeById() {
        addItemType();
    }
}