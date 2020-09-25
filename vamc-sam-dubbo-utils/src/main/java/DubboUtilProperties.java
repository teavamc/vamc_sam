import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package PACKAGE_NAME
 * @date 2020/9/24 16:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "dubbo.util")
public class DubboUtilProperties {

    /**
     * 是否开启rpc调用返回结果日志
     */
    private Boolean logResult;

    /**
     * fixme 未启用，是否后续需要扩展
     */
    private String level;

}
