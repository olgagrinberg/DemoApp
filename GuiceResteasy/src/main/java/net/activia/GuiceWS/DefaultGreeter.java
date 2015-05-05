package net.activia.GuiceWS;

public class DefaultGreeter implements Greeter
{
   public String greet(final String name)
   {
      return "Hello " + name;
   }
}