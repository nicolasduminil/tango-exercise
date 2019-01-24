package lu.tango.online_store.model;

import java.io.*;
import java.util.*;

/**
 * A basket has a collection of products
 */
public class Basket implements Serializable
{
  private List<StandardBroadbandProduct> products;

  public Basket() {}

  public Basket(List<StandardBroadbandProduct> products)
  {
    this.products = products;
  }

  public List<StandardBroadbandProduct> getProducts()
  {
    return products;
  }

  public void setProducts(List<StandardBroadbandProduct> products)
  {
    this.products = products;
  }
}
