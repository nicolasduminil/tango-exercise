package lu.tango.online_store.service;

import com.acme.serviceavailability.*;
import lu.tango.online_store.model.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BroadbandAddOnServiceImpl implements BroadbandAddOnService
{
  private static Logger slf4jLogger = LoggerFactory.getLogger(BroadbandAddOnServiceImpl.class);

  @Autowired
  public AvailabilityChecker availabilityChecker;

  @Override
  public Basket checkForAddOnProducts(Basket basket, String postCode) throws TechnicalFailureException
  {
    String availability = availabilityChecker.isPostCodeInServicableArea(postCode);
    switch (AvailabilityServiceReturnCode.valueOf(availability))
    {
      // Returns relevant add ons. There is no distinction between immediate or planned availability
      case SERVICE_AVAILABLE:
      case SERVICE_PLANNED:
        basket.getProducts().forEach(product ->
        {
          if (product.getStandardBroadbandProductCode().equals(StandardBroadbandProductCode.TANGO_INTERNET_M))
            product.getAddons().add(new AddOn(AddOnCode.BB_FIX_COMMUNICATION_ADD_ON, AddOnCode.BB_FIX_COMMUNICATION_ADD_ON.name()));
          product.getAddons().add(new AddOn(AddOnCode.BB_FIXED_SINGLE_IP_ADDRESS, AddOnCode.BB_FIXED_SINGLE_IP_ADDRESS.name()));
          if (product.getStandardBroadbandProductCode().equals(StandardBroadbandProductCode.TANGO_INTERNET_L))
            product.getAddons().add(new AddOn(AddOnCode.BB_FIXED_SINGLE_IP_ADDRESS, AddOnCode.BB_FIXED_SINGLE_IP_ADDRESS.name()));
          product.getAddons().add(new AddOn(AddOnCode.BB_FIXED_MULTIPLE_IP_ADDRESS, AddOnCode.BB_FIXED_MULTIPLE_IP_ADDRESS.name()));
        });
        break;
      // Throws exception as service is not available
      case SERVICE_UNAVAILABLE:
        throw new TechnicalFailureException();
      // Return the same input basket as no add ons available for invalid postcode. It also notifies the user
      case POSTCODE_INVALID:
        slf4jLogger.warn("### BroadbandAddOnServiceImpl.checkForAddOnProducts(): AvailabilityChecker has returned SERVICE_UNAVAILABLE");
        break;
      default:
        throw new TechnicalFailureException();
    }
    return basket;
  }
}
