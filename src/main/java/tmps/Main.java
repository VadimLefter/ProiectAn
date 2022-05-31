package tmps;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    Menu menu = new Menu();

    boolean isExit = true;
    String command;
    menu.ReloadedMenu();

    while (isExit) {
      command = myObj.nextLine();
      if (command.contains("exit"))
        isExit = false;//exit app
      else if (command.contains("add"))
        CreateProductOrCompartiment(command, menu);
      else if (command.contains("remove"))
        RemoveProductOrCompartiment(command, menu);
      else if (isNumeric(command))
        menu.ShowSubMenu(Integer.parseInt(command));
      else
        menu.ShowMainMenu();
    }
  }

  static void CreateProductOrCompartiment(String string, Menu menu) {

    if (string.contains("Compartiment")) {

      String titlu = InputString("Inserati titlul compartimentului: ");
      menu.AddCompartiment(titlu);
      menu.ShowMainMenu();
    } else if (string.contains("Product")) {

      int index = InputInt("Inserati indexul compartimentului: ");
      String titlu = InputString("Inserati titlul produsului: ");
      String descriere = InputString("Inserati descrierea produsului: ");
      int grame = InputInt("Inserati gramele produsului: ");
      int pret = InputInt("Inserati pretul produsului: ");

      menu.AddProduct(index, titlu, descriere, grame, pret);
      menu.ShowMainMenu();
    } else {
      System.out.println("Incerceti 'add'+(Compartiment sau Product)");
    }
  }

  static void RemoveProductOrCompartiment(String string, Menu menu) {

    if (string.contains("Compartiment")) {

      int indexCompartiment = InputInt("Inserati indexul compartimentului: ");

      menu.RemoveCompartiment(indexCompartiment);
      menu.ShowMainMenu();
    } else if (string.contains("Product")) {

      int indexCompartiment = InputInt("Inserati indexul compartimentului: ");
      int indexProduct = InputInt("Inserati indexul produsului: ");

      menu.RemoveProduct(indexCompartiment, indexProduct);
      menu.ShowMainMenu();
    } else {
      System.out.println("Incerceti 'remove'+(Compartiment sau Product)");
    }
  }

  public static boolean isNumeric(String str) {
    return str != null && str.matches("[-+]?\\d*\\.?\\d+");
  }

  public static String InputString(String string) {
    Scanner myObj2 = new Scanner(System.in);
    System.out.println(string);
    return myObj2.nextLine();
  }

  public static int InputInt(String string) {
    Scanner myObj2 = new Scanner(System.in);
    System.out.println(string);
    return myObj2.nextInt();
  }
}
