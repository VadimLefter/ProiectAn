package tmps;

import java.util.ArrayList;

public class MenuMemento {
  private final ArrayList<Compartiment> menuBackup;

  public MenuMemento(ArrayList<Compartiment> menuBackup) {
    this.menuBackup = menuBackup;
  }

  public ArrayList<Compartiment> getMenuBackup() {
    return menuBackup;
  }
}
