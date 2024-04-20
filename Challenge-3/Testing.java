import org.junit.*;
import java.util.List;
import java.util.ArrayList;
public class Testing {
    @Test
    public void testGetTotalProduct(){
        Data.initiateProduct();
        ProductServiceImp service = new ProductServiceImp();
        System.out.println(service.getListMenu());
        Assert.assertEquals(5, service.getTotalProduct());
    }
    @Test
    public void testGetAddOrder(){
        // Data.initiateProduct();
        User user = new User("user", "user@gmail", "1234");
        ProductServiceImp service = new ProductServiceImp();
        service.addOrder(0, "jakarta", user);
        
        Assert.assertEquals(0, service.getTotalOrderList(0));
    }

    @Test
    public void testSearchProduct(){
        // Data.initiateProduct();
        ProductServiceImp service = new ProductServiceImp();
        Assert.assertEquals(null, service.searchProduct(0));
    }

    @Test
    public void testListProduct(){
        // Data.initiateProduct();

        ProductServiceImp service = new ProductServiceImp();
        Assert.assertEquals(Data.menuProduct, service.getListMenu());
    }
    // @Test
    // public void testGetTotalQuantity(){
    //     // Data.initiateProduct();
    //     User user = new User("user", "user@gmail", "1234");
    //     ProductServiceImp service = new ProductServiceImp();
    //     service.addOrder(0, "jakarta", user);
    //     Assert.assertEquals(0, service.getTotalQuantity(0));
    // }
    @Test
    public void testGetTotalQuantity(){
        // Data.initiateProduct();
        User user = new User("user", "user@gmail", "1234");
        ProductServiceImp service = new ProductServiceImp();
        service.addOrder(0, "jakarta", user);
        Assert.assertEquals(0, service.getTotalQuantity(0));
    }

    @Test
    public void testGetTotalPrice(){
        // Data.initiateProduct();
        User user = new User("user", "user@gmail", "1234");
        ProductServiceImp service = new ProductServiceImp();
        service.addOrder(0, "jakarta", user);
        Assert.assertEquals(0, service.getTotalPrice(0));
    }
}
