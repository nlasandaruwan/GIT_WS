package spring4.core.profiling.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({ ProfilingConfig.class })
@ImportResource({ "classpath*:Profiling_Beans.xml" })
public class GenericConfig {

}
