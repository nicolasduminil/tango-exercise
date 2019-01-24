package lu.tango.online_store.model;

import java.io.*;
import java.util.*;

/**
 * A standard broadband product has code, a name and a list of add ons.
 */
public class StandardBroadbandProduct implements Serializable
{
  private StandardBroadbandProductCode standardBroadbandProductCode;
  private String productName;
  private List<AddOn> addons;

  public StandardBroadbandProduct() {}

  public StandardBroadbandProduct(StandardBroadbandProductCode standardBroadbandProductCode, String productName, List<AddOn> addons)
  {
    this.standardBroadbandProductCode = standardBroadbandProductCode;
    this.productName = productName;
    this.addons = addons;
  }

  public StandardBroadbandProductCode getStandardBroadbandProductCode()
  {
    return standardBroadbandProductCode;
  }

  public void setStandardBroadbandProductCode(StandardBroadbandProductCode standardBroadbandProductCode)
  {
    this.standardBroadbandProductCode = standardBroadbandProductCode;
  }

  public String getProductName()
  {
    return productName;
  }

  public void setProductName(String productName)
  {
    this.productName = productName;
  }

  public List<AddOn> getAddons()
  {
    return addons;
  }

  public void setAddons(List<AddOn> addons)
  {
    this.addons = addons;
  }
}
