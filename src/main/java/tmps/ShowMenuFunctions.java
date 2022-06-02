package tmps;

import java.util.ArrayList;

public class ShowMenuFunctions {

  public void ShowMainMenu(ArrayList<Compartiment> compartimentList)
  {
    EmptyLines();
    System.out.println("Restaurant UTM");
    System.out.println("");

    for (int i = 0; i < compartimentList.size(); i++) {
      System.out.println(i + ". " + compartimentList.get(i).getName() + " -> ");
    }

    System.out.println("");
    System.out.println("Alegeti inserand numarul potrivit: ");
  }

  public void ShowSubMenu(int indexCompartiment, ArrayList<Compartiment> compartimentList)
  {
    Compartiment compartiment = compartimentList.get(indexCompartiment);

    EmptyLines();
    System.out.println("Restaurant UTM");
    System.out.println(compartiment.getName()+": ");
    System.out.println("");

    for (int i = 0; i < compartiment.getProducts().size(); i++) {
      System.out.println(i + ". " +
          compartiment.getProducts().get(i).getTitlu() +
          "Pret: " +
          compartiment.getProducts().get(i).getPret() +
          " mdl -> ");
    }

    System.out.println("");
    System.out.println("Alegeti inserand numarul potrivit: ");
  }

  public void EmptyLines()
  {
    for (int i = 0; i < 10; i++)
    {
      System.out.println("\n");
    }
  }
}
