package tmps;

import java.util.ArrayList;

public class Menu extends WorkingWithFiles{
  private ArrayList<Compartiment> compartimentList;

  public ArrayList<Compartiment> getCompartimentList(){
    return this.compartimentList;
  }

  public void AddCompartiment(String titlu){
    this.compartimentList.add(new Compartiment( titlu));
    SaveMenu(this.compartimentList);
    ReloadedMenu();
  }

  public void AddProduct(int index, String titlu, String descriere, int grame, int pret){
    this.compartimentList.get(index).AddProduct(titlu,descriere,grame,pret);
    SaveMenu(this.compartimentList);
    ReloadedMenu();
  }

  public void RemoveCompartiment(int index){
    this.compartimentList.remove(index);
  }

  public void RemoveProduct(int indexCompartimet, int indexProduct){
    this.compartimentList.get(indexCompartimet).RemoveProduct(indexProduct);
    SaveMenu(this.compartimentList);
    ReloadedMenu();
  }

  public void ReloadedMenu() {
    this.compartimentList = (ArrayList<Compartiment>) super.ReloadMenu(this.compartimentList);
  }

  public void ShowMainMenu()
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

  public void ShowSubMenu(int indexCompartiment)
  {
    EmptyLines();
    System.out.println("Restaurant UTM");
    System.out.println(compartimentList.get(indexCompartiment).getName()+": ");
    System.out.println("");

    for (int i = 0; i < compartimentList.get(indexCompartiment).getProducts().size(); i++) {
      System.out.println(i + ". " + compartimentList.get(i).getName() + " -> ");
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
