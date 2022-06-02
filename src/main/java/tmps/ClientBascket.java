package tmps;

public class ClientBascket {
  private int[][] clientProducts;

  public int[][] getClientProducts(){
    return this.clientProducts;
  }

  public void addProductBasket(int indexCompartiment, int indexProduct){
    clientProducts[indexCompartiment][indexProduct] = indexProduct;
  }
}
