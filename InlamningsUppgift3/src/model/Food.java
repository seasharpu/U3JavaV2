package model;

public abstract class Food extends Menu{

    private Ingredients ingredients;

    public Food(int productCost, String productName, Ingredients ingredients) {
        super(productCost, productName);
        this.ingredients = ingredients;
    }

    //@return
    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    //@return
    @Override
    public String toString() {
        return super.toString() + ", Ing: " + ingredients;
    }

}
