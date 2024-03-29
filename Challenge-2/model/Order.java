import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private LocalDate date;
    private List<OrderDetail> itemOrderList;

    public Order(int id){
        this.id=id;
        this.date=LocalDate.now();
        this.itemOrderList = new ArrayList<>();
    }
    public void setItemOrderList(OrderDetail orderDetail){
        this.itemOrderList.add(orderDetail);
    }
    public List<OrderDetail> getItemOrderList(){
        return this.itemOrderList;
    }
}
