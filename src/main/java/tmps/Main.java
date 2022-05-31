package tmps;

import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
    Scanner myObj = new Scanner(System.in);
    Menu menu = new Menu();

    boolean isExit = true;
    String command;
    menu.ReloadedMenu();

    while(isExit)
    {
      command = myObj.nextLine();
      if (command.contains("exit"))
        isExit = false;//exit app
      else if (command.contains("add"))
        CreateProductOrCompartiment(command,menu);
      else if (command.contains("remove"))
        RemoveProductOrCompartiment(command,menu);
      else if (isNumeric(command))
        menu.ShowSubMenu(Integer.parseInt(command));
      else
        menu.ShowMainMenu();
    }
  }

  static void CreateProductOrCompartiment(String string, Menu menu)
  {
    Scanner myObj2 = new Scanner(System.in);
    if (string.contains("Compartiment"))
    {
      System.out.println("Title: ");
      String title = myObj2.nextLine();
      menu.AddCompartiment(title);
      menu.ShowMainMenu();
    }
    else if (string.contains("Product"))
    {
      System.out.println("Inserati indexul compartimentului: ");
      int index = Integer.parseInt(myObj2.next());

      System.out.println("Inserati titlul produsului: ");
      String titlu = myObj2.nextLine();

      System.out.println("Inserati gramele produsului: ");
      int grame = myObj2.nextInt();

      System.out.println("Inserati descrierea produsului: ");
      String descriere = myObj2.nextLine();

      System.out.println("Inserati pretul produsului: ");
      int pret = myObj2.nextInt();

      menu.AddProduct(index,titlu,descriere,grame,pret);
      menu.ShowMainMenu();
    }
    else
    {
      System.out.println("Incerceti 'add'+(Compartiment sau Product)");
    }
  }

  static void RemoveProductOrCompartiment(String string, Menu menu)
  {
    Scanner myObj2 = new Scanner(System.in);
    if (string.contains("Compartiment"))
    {
      System.out.println("Inserati indexul compartimentului: ");
      int indexCompartiment = Integer.parseInt(myObj2.next());
      menu.RemoveCompartiment(indexCompartiment);
      menu.ShowMainMenu();
    }
    else if (string.contains("Product"))
    {
      System.out.println("Inserati indexul compartimentului: ");
      int indexCompartiment = Integer.parseInt(myObj2.next());
      System.out.println("Inserati indexul produsului: ");
      int indexProduct = Integer.parseInt(myObj2.next());

      menu.RemoveProduct(indexCompartiment,indexProduct);
      menu.ShowMainMenu();
    }
    else
    {
      System.out.println("Incerceti 'remove'+(Compartiment sau Product)");
    }
  }

  public static boolean isNumeric(String str) {
    return str != null && str.matches("[-+]?\\d*\\.?\\d+");
  }
}
