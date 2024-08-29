package com.example.xx2.payload;
import lombok.Data;
import java.util.UUID;

@Data
public class MerchantDto {
    // private UUID id;

    private String name;
    private String location;
    private String open;

}
