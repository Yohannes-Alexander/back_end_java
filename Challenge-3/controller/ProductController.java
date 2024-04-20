
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class ProductController {
    private ProductView productView;
    private ProductServiceImp productService;
    private int id;
    private User user = new User("user", "user@gmail", "1234");
    public ProductController(){
        productView = new ProductView();
        productService = new ProductServiceImp();
        this.id=0;
    }

    public void addOrder(){
        this.id+=1;
        productService.addOrder(this.id, "Jakarta", user);
    }

    public void orderApp(){
        this.addOrder();
        this.mainMenu();
    }

    public void choiceInput(){
        char choice = productView.displayErrorInput();
        switch (choice) {
            case 'y':
                this.mainMenu();
                break;
            case 'n':
                System.exit(0);
            default:
                this.choiceInput();
        }
    }

    public void mainMenu(){
        productView.splashScreen(this.id);

        int pilih = productView.listProduct(productService.getListMenu());
        List<Integer> list= productService.getAllId();
        list.add(0);
        list.add(99);

        if (!list.contains(pilih)) {
            this.choiceInput();
        }
        switch (pilih) {
            case 99:
                if (productService.getTotalOrderList(this.id)<1){
                    productView.displayErrorOrder();
                    mainMenu();
                    break;

                }
                this.payment();
                break;
            case 0:
                System.exit(0);
                System.out.println("Thank you, see you next time");
                break;
            default:
                selectMenu(pilih);
                break;
        }
    }

    public void selectMenu(int pilih){
        switch (pilih){
            case 0:
                this.mainMenu();
                // System.exit(0);
            default:
                Product product = productService.searchProduct(pilih);
                if (product != null) {
                    int quantity = productView.inputQuantity(product);
                    while (quantity<=0){
                        productView.displayErrorQuantity();
                        quantity = productView.inputQuantity(product);
                    }
                    this.productService.updateOrder(this.id, product, quantity);
                    System.out.println("Pesanan telah dimasukkan");
                    this.mainMenu();
                }     
            }  
    }

    public void payment(){
        int choice = productView.confirmedMenu(productService.searchOrder(this.id).getItemOrderList(), productService.getTotalQuantity(id), productService.getTotalPrice(id));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(0);
        while (!list.contains(choice)) {
            System.out.println("Mohon masukkan input pilihan anda");
            choice = productView.confirmedMenu(productService.searchOrder(this.id).getItemOrderList(), productService.getTotalQuantity(id), productService.getTotalPrice(id));
        }
        switch (choice) {
            case 0:
                System.out.println("Thank you, see you next time");
                System.exit(0);
                break;
            case 1:
                String bill = productService.accumulateBill(id);
                productView.displayBill(bill);
                this.writeFile(bill);
                this.orderApp();
            case 2:
                this.mainMenu();
                break;
    
        }
    }

    public void checkFile(){
        File file = new File("bill.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File Created");
            }else{
                System.out.println("File already exists");
            }

        } catch (IOException e) {
            System.out.println("Terjadi error");
            throw new RuntimeException(e);
        }
    }
    public void writeFile(String text){
        this.checkFile();
        try {
            FileWriter fileWriter = new FileWriter("bill.txt");
            fileWriter.write(text);
            fileWriter.close();
            System.out.println("Write successfuly");
        } catch (IOException e) {
            System.out.println("Terjadi error");
            throw new RuntimeException(e);
        }

    }   
}
