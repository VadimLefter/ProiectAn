package tmps.Strategy;

import tmps.Compartiment;

import java.util.ArrayList;

public class WorkingWithFiles {
  private Context context = new Context();

  public Object ReloadMenu() {
    context.setStrategy(new ReloadMenu());
    return context.executeStrategy(new ArrayList<Compartiment>());
  }

  public void SaveMenu(ArrayList<Compartiment> compartimentList) {
    context.setStrategy(new SaveMenu());
    context.executeStrategy(compartimentList);
  }
}
