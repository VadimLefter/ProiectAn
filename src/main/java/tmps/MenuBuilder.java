package tmps;

public interface MenuBuilder {
  void AddCompartiment(String titlu);

  void AddProduct(int index, String titlu, String descriere, int grame, int pret);

  void AddClonedProduct(int indexCompartiment, int indexProduct);

  void RemoveCompartiment(int index);

  void RemoveProduct(int indexCompartimet, int indexProduct);

  void ReloadedMenu();

  void ShowMainMenu();

  void ShowSubMenu(int indexCompartiment);

  void ShowBasket(ClientBascket bascket);
}
