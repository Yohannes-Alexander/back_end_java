import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

public class ProductView {
    private Scanner scanner;

    public ProductView(){
        this.scanner = new Scanner(System.in);
    }
    public void splashScreen(int id){
        System.out.println("==========================");
        System.out.println("Selamat datang di BinarFud");
        System.out.println("==========================");
        System.out.println("===========ID Order "+id+"===========");        
        
    }

    public int listProduct(List<Product> menuProduct){
        System.out.println("Silahkan pilih makanan :");
        menuProduct.forEach(p -> System.out.println(p.getId() + ". " + p.getNama() + "\t| " + p.getHarga()));
        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar Aplikasi");
        System.out.print("Pilih ");int pilih =  scanner.nextInt() ;
        return pilih;
    }

    public int inputQuantity(Product product){
        System.out.println("===================");
        System.out.println("Berapa pesanan anda");
        System.out.println("===================");
        System.out.println(product.getNama() + "   | " + product.getHarga());
        System.out.println("(input 0 untuk kembali)");
        System.out.print("Pilih Jumlah "); 
        int jumlah =  scanner.nextInt() ;
        return jumlah;
        // ProductService.addProduct(pilih, jumlah); 
        // System.out.println("Pesanan telah dimasukkan");
    }

    public int confirmedMenu(List<OrderDetail> menuProduct, int totalQuantity, int totalPrice){
        System.out.println("==========================");
        System.out.println("Konfirmasi dan Pembayaran");
        System.out.println("==========================");

        menuProduct.forEach(p -> System.out.println(p.getProduct().getNama() + "\t" + p.getAmount() + "\t" + p.getAmount() * p.getProduct().getHarga()));
        System.out.println("---------------------------------+");
        System.out.println("Total\t\t"+totalQuantity+"\t"+totalPrice);
        System.out.println("1. Konfirmasi dan bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");
        System.out.print("Pilih "); 
        int choice =  scanner.nextInt() ;
        return choice;
    }

    public void displayBill(String bill){
        System.out.println(bill);
    }

    public char displayErrorInput(){
        System.out.print("""
            ========================
            Mohon masukkan input 
            pilihan anda
            ========================
            (Y) untuk lanjut
            (n) untuk keluar

            Pilih"""+" ");
        char choice =  scanner.next().charAt(0); 
        return choice;
    }

    public void displayErrorQuantity(){
        System.out.print("""
            ========================
            Minimal 1 jumlah  
            kuantitas!
            ========================
            """);
    }
    public void displayErrorOrder(){
        System.out.print("""
            ========================
            Minimal 1 jumlah  
            pesanan!
            ========================
            """);
    }
    
}
