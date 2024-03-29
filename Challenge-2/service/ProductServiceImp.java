import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

public class ProductServiceImp implements ProductService{
    @Override
    public int getTotalProduct(){
        return Data.menuProduct.size();
    }
    
    @Override
    public int getTotalOrderList(int id){
        return this.searchOrder(id).getItemOrderList().size();
    }

    @Override
    public List<Product> getListMenu(){
        return Data.menuProduct;
    }
    @Override
    public HashMap<Integer, Order> getListOrder(){
        return Data.order;
    }
    @Override
    public void addOrder(int id){
        Data.order.put(id, new Order(id));
        System.out.println("Input Berhasil");
    }

    public Order searchOrder(int id){
        return Data.order.get(id);
    }

    public int getTotalQuantity(int id){
        Order order = this.searchOrder(id);
        int quantity = 0;
        for(OrderDetail orDet : order.getItemOrderList()){
            quantity += orDet.getAmount();
        }
        return quantity;
    }
    public int getTotalPrice(int id){
        Order order = this.searchOrder(id);
        int price = 0;
        for(OrderDetail orDet : order.getItemOrderList()){
            price += orDet.getAmount()*orDet.getProduct().getHarga();
        }
        return price;
        
    }
    public Product searchProduct(int id){
        Product product=null;
        for (Product m : getListMenu()){
            if (m.getId()==id){
                product = m;
                break;
            }
        }
        return product;
    }

    public void updateOrder(int id, Product product, int amount){
        Order order = searchOrder(id); 
        order.setItemOrderList(new OrderDetail(product, amount));
    }

    public List<Integer> getAllId(){
        List<Integer> list = new ArrayList<>();
        for (Product p : this.getListMenu()){
            list.add(p.getId());
        }
        return list;

    }

    public String accumulateBill(int id){
        String text ="========================\n"+
                    "Binar Fud\n"+
                    "========================\n\n"+
                    "Terima kasih sudah memesan\n"+
                    "di BinarFud\n\n"+
                    "Dibawah ini adalah pesanan anda\n\n";
        Order order = this.searchOrder(id);
        for(OrderDetail orDet : order.getItemOrderList()){
            text = text +orDet.getProduct().getNama()+"\t"+orDet.getAmount()+"\t"+orDet.getAmount()*orDet.getProduct().getHarga()+"\n";
        }                    
        text = text +"---------------------------------+\n";
        text = text +"Total\t\t"+this.getTotalQuantity(id)+"\t"+this.getTotalPrice(id)+
                    "\n\nPembayaran : BinarCash\n\n"+
                    "========================\n"+
                    "Simpan struk ini sebagai\n"+
                    "bukti pembayaran\n"+
                    "========================\n";
        return text;

        // File file = new File(PATH);
        // try {
        //     if (file.createNewFile()) {
        //         System.out.println("File Created");
        //     }else{
        //         System.out.println("File already exists");
        //     }

        // } catch (IOException e) {
        //     System.out.println("Terjadi error");
        //     throw new RuntimeException(e);
        // }

        // writeFile(text);     
    }
    
    // public void printBill(String bill){
    //     File file = new File("back_end_java/Challenge-2/bill.txt");
    //     try {
    //         if (file.createNewFile()) {
    //             System.out.println("File Created");
    //         }else{
    //             System.out.println("File already exists");
    //         }

    //     } catch (IOException e) {
    //         System.out.println("Terjadi error");
    //         throw new RuntimeException(e);
    //     }

    //     writeFile(text);  
    // }


}
