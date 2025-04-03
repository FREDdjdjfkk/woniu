package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TUser {

    private  Integer uid;
    private  String username;
    private  String password;
    private  String email;
    private  String telephone;
    private UserDetails userDetails;
    private List<Orders> ordersList;

}
