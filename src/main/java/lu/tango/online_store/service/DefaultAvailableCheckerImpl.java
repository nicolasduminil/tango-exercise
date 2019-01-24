package lu.tango.online_store.service;

import com.acme.serviceavailability.*;
import lu.tango.online_store.model.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

/**
 * The default implementation of the AvailabilityChecker interface.
 * It is required as a place-holder for the real interface.
 */
@Component
public class DefaultAvailableCheckerImpl implements AvailabilityChecker
{
  private Logger slf4jLogger = LoggerFactory.getLogger(DefaultAvailableCheckerImpl.class);

  @Override
  public String isPostCodeInServicableArea(String postCode) throws TechnicalFailureException
  {
    slf4jLogger.warn("### DefaultAvailableCheckerImpl.isPostCodeInServiceAvailableArea: Using default implementation, nothing will happen");
    return AvailabilityServiceReturnCode.SERVICE_UNAVAILABLE.name();
  }
}
