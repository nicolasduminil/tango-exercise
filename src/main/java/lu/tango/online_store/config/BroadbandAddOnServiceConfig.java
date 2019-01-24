package lu.tango.online_store.config;

import com.acme.serviceavailability.*;
import lu.tango.online_store.service.*;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.*;

/**
 * Spring Boot configuration class.
 * It aims at defining a default implementation of the AvailabilityChecker interface.
 * This is because the real implementation is not available, as owned by a Tango's partner.
 * However, for unit test purposes, Spring need to inject this interface.
 * And in order for the injection to work, an implementation class is required. Hence this default implementation.
 */
@Configuration
public class BroadbandAddOnServiceConfig
{
  @ConditionalOnMissingBean(AvailabilityChecker.class)
  @Bean
  public DefaultAvailableCheckerImpl defaultAvailableCheckerImpl()
  {
    return new DefaultAvailableCheckerImpl();
  }
}
