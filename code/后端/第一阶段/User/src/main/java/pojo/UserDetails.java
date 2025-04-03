package pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.AutomapConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    private  Integer uid;
    private String realname;
    private String imgpath;
    private String signature;


//    private TUser user;
}
