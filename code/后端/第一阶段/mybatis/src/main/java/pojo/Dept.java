package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id;          // 对应数据库的 id
    private String name;         // 对应数据库的 name
    private Integer companyId;   // 对应数据库的 companyId
    private Date buildDate;      // 对应数据库的 buildDate
    private Integer number;      // 对应数据库的 number


}
