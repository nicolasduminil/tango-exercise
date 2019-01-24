package lu.tango.online_store.model;

import java.io.*;

/**
 * An add on has a code and a name
 */
public class AddOn implements Serializable
{
  private AddOnCode addOnCode;
  private String addOnName;

  public AddOn() {}

  public AddOn(AddOnCode addOnCode, String addOnName)
  {
    this.addOnCode = addOnCode;
    this.addOnName = addOnName;
  }

  public String getAddOnName()
  {
    return addOnName;
  }

  public void setAddOnName(String addOnName)
  {
    this.addOnName = addOnName;
  }

  public AddOnCode getAddOnCode()
  {
    return addOnCode;
  }

  public void setAddOnCode (AddOnCode addOnCode)
  {
    this.addOnCode = addOnCode;
  }
}
