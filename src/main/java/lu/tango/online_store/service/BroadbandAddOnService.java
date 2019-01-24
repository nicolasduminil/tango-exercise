package lu.tango.online_store.service;

import com.acme.serviceavailability.*;
import lu.tango.online_store.model.*;

public interface BroadbandAddOnService
{
  /**
   *
   * @param basket
   * @param postCode
   * @return Basket
   * @throws TechnicalFailureException
   *
   * This interface has been modified such that to return a Basket object.
   * In the requirements it was proposed that it returns the add ons which qualify for the given post code.
   * However, this is not consistent for the case when no add ons qualify for the current postcode.
   * In this case, the interface should have returned null. And having methods returning null is a bad practice.
   */
  public Basket checkForAddOnProducts(Basket basket, String postCode) throws TechnicalFailureException;
}