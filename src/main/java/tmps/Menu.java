package tmps;

import tmps.Strategy.WorkingWithFiles;

import java.util.ArrayList;
//Composite
public class Menu extends WorkingWithFiles implements MenuBuilder {
  private ArrayList<Compartiment> compartimentList = new ArrayList<Compartiment>();

  private ShowMenuFunctions showMenuFunctions = new ShowMenuFunctions();
  private Prototype prototype = new Prototype();

  public ArrayList<Compartiment> getCompartimentList() {
    return this.compartimentList;
  }

  @Override
  public void AddCompartiment(String titlu) {

    this.compartimentList.add(new Compartiment(titlu));
    SaveMenu(this.compartimentList);
    ReloadedMenu();
  }

  @Override
  public void AddProduct(int index, String titlu, String descriere, int grame, int pret) {

    this.compartimentList.get(index).AddProduct(titlu, descriere, grame, pret);
    SaveMenu(this.compartimentList);
    ReloadedMenu();
  }

  @Override
  public void AddClonedProduct(int indexCompartiment, int indexProduct) {

    this.compartimentList.get(indexCompartiment).AddClonedProduct(
        prototype.cloneProduct(
            this.compartimentList.get(indexCompartiment).getProducts().get(indexProduct)
        )
    );
    SaveMenu(this.compartimentList);
    ReloadedMenu();
  }

  @Override
  public void RemoveCompartiment(int index) {
    this.compartimentList.remove(index);
  }

  @Override
  public void RemoveProduct(int indexCompartimet, int indexProduct) {

    this.compartimentList.get(indexCompartimet).RemoveProduct(indexProduct);
    SaveMenu(this.compartimentList);
    ReloadedMenu();
  }

  @Override
  public void ReloadedMenu() {
    this.compartimentList = (ArrayList<Compartiment>) super.ReloadMenu();
  }

  @Override
  public void ShowMainMenu() {
    showMenuFunctions.ShowMainMenu(this.compartimentList);
  }

  @Override
  public void ShowSubMenu(int indexCompartiment) {
    showMenuFunctions.ShowSubMenu(indexCompartiment, this.compartimentList);
  }

  @Override
  public void ShowBasket(ClientBascket bascket) {
    showMenuFunctions.ShowBasket(bascket, this.compartimentList);
  }

  //Memento
  public ArrayList<Compartiment> getMenuForSave(){
    return this.compartimentList;
  }

  //Memento
  public void loadBackup(MenuMemento menuMemento){
    this.compartimentList = menuMemento.getMenuBackup();
  }
}
