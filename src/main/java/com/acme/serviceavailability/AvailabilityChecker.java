package com.acme.serviceavailability;

/**
 * This interface is implemented by Tango's partner.
 * Consequently, the implementation class is not provided.
 * The interface itseld can neither be modified nor adapted in any way as not under control of Tango
 */
public interface AvailabilityChecker
{
  String isPostCodeInServicableArea(String postCode) throws TechnicalFailureException;
}
