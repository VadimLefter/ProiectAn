package tmps;
// o sa-l folosesc atunci cand vom adauga in meniu bucate portie fitness 1/2
public class Prototype {

  Product cloneProduct(Product product){
    return (Product) product.copy();
  }

  Compartiment cloneCompartiment(Compartiment compartiment){
    return (Compartiment) compartiment.copy();
  }

}
