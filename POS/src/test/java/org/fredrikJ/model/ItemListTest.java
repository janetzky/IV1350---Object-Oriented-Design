package org.fredrikJ.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemListTest {

    private ItemList itemList;

    @Before
    public void setUp() {
        this.itemList = new ItemList();
        ItemType item = new ItemType("331dfsef", 13.37, 12, "Delikat kladdkaka", 42);
        this.itemList.addItemType(item);
    }

    @After
    public void tearDown() throws Exception {
        this.itemList = null;
    }

    @Test //add to existing itemType, is only
    public void addItemByQuantity() {
        this.itemList.addItemByQuantity("331dfsef",3);
        Assert.assertEquals(45, this.itemList.getItemTypeById("331dfsef").getQuantity() );
    }

    @Test // finns
    public void addItemType() {
        ItemType item = new ItemType("KOSur83&%#", 5.00, 6, "Dennis hotdog", 1250);
        this.itemList.addItemType(item);
        Assert.assertEquals("KOSur83&%#", this.itemList.getItemTypeById("KOSur83&%#").getItemId());
    }

    @Test //finns
    public void isItemTypeInList() {
        Assert.assertEquals(true, this.itemList.isItemTypeInList("331dfsef"));
    }

    @Test // finns
    public void updatePrice() {
        Assert.assertEquals(42 * (13.37 * 1.12), this.itemList.getPrice().getPrice(), 0.00001);
    }

    @Test // finns
    public void setDiscount() {
    }

    @Test // finns
    public void getItemTypeById() {
        addItemType();
    }
}