import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author 墨诚 mocheng@byai.com
 * @Package annotation
 * @date 2020/9/24 16:54
 */
@Configuration
@EnableConfigurationProperties(DubboUtilProperties.class)
public class DubboAspectConfigure {

    @Bean
    public DubboServiceAspect aspect(DubboUtilProperties dubboUtilProperties) {
        return new DubboServiceAspect(dubboUtilProperties);
    }

}
