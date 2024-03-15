package back_end_java.Challenge_1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
public class project {
    static Menu[] menu = new Menu[5]; // Declaring an array of Menu objects with size 5
    public static final String PATH="back_end_java/Challenge_1/bill.txt";

    // Constructor to initialize the menu array
    public static void  input_menu() {
        menu[0] = new Menu(1, "Nasi Goreng", 15000);
        menu[1] = new Menu(2, "Mie Goreng", 13000);
        menu[2] = new Menu(3, "Nasi + Ayam", 18000);
        menu[3] = new Menu(4, "Es Teh Manis", 13000);
        menu[4] = new Menu(5, "Es Jeruk", 5000);
    }

    public static void list_menu(){
        System.out.println("Silahkan pilih makanan :");
        for (Menu m : menu) {
            System.out.println(m.getId() + ". " + m.getNama() + "\t| " + m.getHarga());
        }
        System.err.println("99. Pesan dan Bayar");
        System.err.println("0. Keluar Aplikasi");
    }

    public static void  printBill(Dictionary<Integer, Integer> list_pesanan, int jumlah_quantity, int jumlah_harga){
        String text ="========================\n"+
                    "Binar Fud\n"+
                    "========================\n\n"+
                    "Terima kasih sudah memesan\n"+
                    "di BinarFud\n\n"+
                    "Dibawah ini adalah pesanan anda\n\n";
        Enumeration<Integer> keys = list_pesanan.keys();
        while (keys.hasMoreElements()) {
            int id = keys.nextElement();
            int quantity = list_pesanan.get(id);
            for (Menu m : menu){
                if (m.getId()==id){
                    text = text +m.getNama()+"\t"+quantity+"\t"+quantity*m.getHarga()+"\n";
                    // text = text+String.format("%-15s%-10s%-10s\n", m.getNama(), quantity, quantity * m.getHarga());
                }                        
            }

        }   
        text = text +"---------------------------------+\n";
        text = text +"Total\t\t"+jumlah_quantity+"\t"+jumlah_harga+
                    "\n\nPembayaran : BinarCash\n\n"+
                    "========================\n"+
                    "Simpan struk ini sebagai\n"+
                    "bukti pembayaran\n"+
                    "========================\n";
        System.out.println(text);

        File file = new File(PATH);
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

        writeFile(text);     
    }        
    public static void writeFile(String text){
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            fileWriter.write(text);
            fileWriter.close();
            System.out.println("Write successfuly");
        } catch (IOException e) {
            System.out.println("Terjadi error");
            throw new RuntimeException(e);
        }

    }    

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========================");
        System.out.println("Selamat datang di BinarFud");
        System.out.println("==========================");
               // Creating an empty Dictionary 
        Dictionary<Integer, Integer> list_pesanan  = new Hashtable<Integer, Integer>(); 
        input_menu();

        while (true) {
            list_menu();
            System.out.print("Pilih ");int pilih =  scanner.nextInt() ;
            // scanner.close();
            switch (pilih){
                case 99:
                    System.out.println("==========================");
                    System.out.println("Konfirmasi dan Pembayaran");
                    System.out.println("==========================");
                    Enumeration<Integer> keys = list_pesanan.keys();
                    int jumlah_quantity = 0;
                    int jumlah_harga = 0;
                    while (keys.hasMoreElements()) {
                        int id = keys.nextElement();
                        int quantity = list_pesanan.get(id);
                        for (Menu m : menu){
                            if (m.getId()==id){
                                System.out.println( m.getNama()+"\t" + quantity +"\t" +quantity*m.getHarga());
                                jumlah_quantity+=quantity;
                                jumlah_harga+=quantity*m.getHarga();
                            }                        
                        }
                    }    
                    System.out.println("---------------------------------+");
                    System.out.println("Total\t\t"+jumlah_quantity+"\t"+jumlah_harga);
                    System.out.println("1. Konfirmasi dan bayar");
                    System.out.println("2. Kembali ke menu utama");
                    System.out.println("0. Keluar aplikasi");
                    System.out.print("Pilih ");int pilih_1 =  scanner.nextInt() ;
                    if (pilih_1==0) {
                        System.exit(0);
                    }else if(pilih_1==1){
                        printBill(list_pesanan,jumlah_quantity, jumlah_harga);
                        System.exit(0);
                    }
                    else{
                        break;
                    }
                    break;
                case 0:
                    System.out.println("Thank you, see you next time");
                    System.exit(0);
                default:
                    for (Menu m : menu){
                        if (m.getId()==pilih){
                            System.out.println("===================");
                            System.out.println("Berapa pesanan anda");
                            System.out.println("===================");
                            System.out.println(m.getNama() + "   | " + m.getHarga());
                            System.out.println("(input 0 untuk kembali)");
                            System.out.print("Pilih Jumlah "); int jumlah =  scanner.nextInt() ;
                            list_pesanan.put(pilih, jumlah); 
                            System.out.println("Pesanan telah dimasukkan");
                            break;
            
                        }
                    }
            }  
        }
    }
}

class Menu {
    private int id;
    private String nama;
    private int harga;

    public Menu(int id, String nama, int harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }
}
