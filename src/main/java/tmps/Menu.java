package tmps;

import java.util.ArrayList;
//menu vip decorator
public class Menu extends WorkingWithFiles {
  private ArrayList<Compartiment> compartimentList = new ArrayList<Compartiment>();

  private ShowMenuFunctions showMenuFunctions = new ShowMenuFunctions();

  public ArrayList<Compartiment> getCompartimentList() {
    return this.compartimentList;
  }

  public void AddCompartiment(String titlu) {

    this.compartimentList.add(new Compartiment(titlu));
    SaveMenu(this.compartimentList);
    ReloadedMenu();
  }

  public void AddProduct(int index, String titlu, String descriere, int grame, int pret) {

    this.compartimentList.get(index).AddProduct(titlu, descriere, grame, pret);
    SaveMenu(this.compartimentList);
    ReloadedMenu();
  }

  public void RemoveCompartiment(int index) {
    this.compartimentList.remove(index);
  }

  public void RemoveProduct(int indexCompartimet, int indexProduct) {

    this.compartimentList.get(indexCompartimet).RemoveProduct(indexProduct);
    SaveMenu(this.compartimentList);
    ReloadedMenu();
  }

  public void ReloadedMenu() {
    this.compartimentList = (ArrayList<Compartiment>) super.ReloadMenu();
  }

  public void ShowMainMenu() {
    showMenuFunctions.ShowMainMenu(this.compartimentList);
  }

  public void ShowSubMenu(int indexCompartiment) {
    showMenuFunctions.ShowSubMenu(indexCompartiment, this.compartimentList);
  }
}
