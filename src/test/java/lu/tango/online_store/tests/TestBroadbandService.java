package lu.tango.online_store.tests;

import com.acme.serviceavailability.*;
import lu.tango.online_store.model.*;
import lu.tango.online_store.service.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestBroadbandService
{
  @Mock
  private AvailabilityChecker availabilityChecker;
  @InjectMocks
  private BroadbandAddOnService broadbandAddOnService = new BroadbandAddOnServiceImpl();

  @Test
  public void testShouldReturnServiceAvailable() throws  TechnicalFailureException
  {
    when (availabilityChecker.isPostCodeInServicableArea("75008")).thenReturn(AvailabilityServiceReturnCode.SERVICE_AVAILABLE.name());
    StandardBroadbandProduct standardBroadbandProduct = new StandardBroadbandProduct(StandardBroadbandProductCode.TANGO_INTERNET_M, StandardBroadbandProductCode.TANGO_INTERNET_M.name(), new ArrayList<AddOn>());
    List<StandardBroadbandProduct> standardBroadbandProducts = new ArrayList<>();
    standardBroadbandProducts.add(standardBroadbandProduct);
    Basket basket = new Basket (standardBroadbandProducts);
    Basket newBasket = broadbandAddOnService.checkForAddOnProducts(basket, "75008");
    assertNotNull (newBasket);
    List<AddOn> addOns = newBasket.getProducts().get(0).getAddons();
    assertTrue (!addOns.isEmpty());
    assertTrue (addOns.get(0).getAddOnCode().equals(AddOnCode.BB_FIX_COMMUNICATION_ADD_ON));
  }

  @Test
  public void testShouldReturnServicePlanned() throws  TechnicalFailureException
  {
    when (availabilityChecker.isPostCodeInServicableArea("75015")).thenReturn(AvailabilityServiceReturnCode.SERVICE_PLANNED.name());
    StandardBroadbandProduct standardBroadbandProduct = new StandardBroadbandProduct(StandardBroadbandProductCode.TANGO_INTERNET_M, StandardBroadbandProductCode.TANGO_INTERNET_M.name(), new ArrayList<AddOn>());
    List<StandardBroadbandProduct> standardBroadbandProducts = new ArrayList<>();
    standardBroadbandProducts.add(standardBroadbandProduct);
    Basket basket = new Basket (standardBroadbandProducts);
    Basket newBasket = broadbandAddOnService.checkForAddOnProducts(basket, "75015");
    assertNotNull (newBasket);
    List<AddOn> addOns = newBasket.getProducts().get(0).getAddons();
    assertTrue (!addOns.isEmpty());
    assertTrue (addOns.get(0).getAddOnCode().equals(AddOnCode.BB_FIX_COMMUNICATION_ADD_ON));
  }

  @Test(expected = TechnicalFailureException.class)
  public void testShouldRaiseTechnicalFailureException() throws  TechnicalFailureException
  {
    when (availabilityChecker.isPostCodeInServicableArea("93800")).thenReturn(AvailabilityServiceReturnCode.SERVICE_UNAVAILABLE.name());
    broadbandAddOnService.checkForAddOnProducts(new Basket (new ArrayList<StandardBroadbandProduct>()), "93800");
  }

  @Test
  public void testShouldReturnPostCodeInvalid() throws  TechnicalFailureException
  {
    when (availabilityChecker.isPostCodeInServicableArea("0")).thenReturn(AvailabilityServiceReturnCode.POSTCODE_INVALID.name());
    StandardBroadbandProduct standardBroadbandProduct = new StandardBroadbandProduct(StandardBroadbandProductCode.TANGO_INTERNET_M, StandardBroadbandProductCode.TANGO_INTERNET_M.name(), new ArrayList<AddOn>());
    List<StandardBroadbandProduct> standardBroadbandProducts = new ArrayList<>();
    standardBroadbandProducts.add(standardBroadbandProduct);
    Basket basket = new Basket (standardBroadbandProducts);
    Basket newBasket = broadbandAddOnService.checkForAddOnProducts(basket, "0");
    assertEquals (newBasket, basket);
  }
}
