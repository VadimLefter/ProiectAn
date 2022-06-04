package tmps;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Menu menu = new Menu();
    ClientBascket bascket = new ClientBascket();
    int thisCompartiment = 0;
    boolean isExit = true;
    boolean isCompartiment = false;
    String command;

    menu.ReloadedMenu();
    menu.ShowMainMenu();

    while (isExit) {
      command = InputString();

      if (command.contains("exit"))
        isExit = false;//exit app
      else if (command.contains("add")) {
        CreateProductOrCompartiment(command, menu);
        isCompartiment = false;
      }
      else if (command.contains("remove")){
        RemoveProductOrCompartiment(command, menu);
        isCompartiment = false;
      }
      else if (isNumeric(command) && !isCompartiment) {
        menu.ShowSubMenu(Integer.parseInt(command));
        thisCompartiment = Integer.parseInt(command);
        isCompartiment = true;
      } else if (isNumeric(command) && isCompartiment) {
        bascket.addProductBasket(thisCompartiment, Integer.parseInt(command));
        System.out.println("Comanda " +
            menu.getCompartimentList().get(thisCompartiment).getProducts().get(Integer.parseInt(command)).getTitlu() +
            " este adaugat in cos");
      } else if (
          (command.contains("back") && isCompartiment) ||
              command.contains("main")
      ) {
        menu.ShowMainMenu();
        isCompartiment = false;
      } else if (command.contains("basket")) {
        menu.ShowBasket(bascket);
      }
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
    Scanner scanner = new Scanner(System.in);
    System.out.println(string);
    return scanner.nextLine();
  }

  public static String InputString() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  public static int InputInt(String string) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(string);
    return scanner.nextInt();
  }
}
