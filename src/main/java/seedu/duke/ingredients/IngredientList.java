package seedu.duke.ingredients;

import seedu.duke.exceptions.DukeException;

import java.util.ArrayList;

/**
 * Represents the list of ingredients.
 */
public class IngredientList {

    protected ArrayList<Ingredient> ingredientList;
    private static IngredientList instance = null;

    private static final String ADDED_MESSAGE = "That task has been added:\n" + "\t";
    private static final String LIST_EMPTY_MESSAGE = "No ingredients currently in the list.";
    private static final String LIST_MESSAGE = "Here is the list of the ingredients currently in inventory:\n";
    private static final String DELETE_MESSAGE = "Got it. This ingredient has been removed:\n" + "\t";

    public IngredientList() {
        ingredientList = new ArrayList<Ingredient>(); //This is for v1.0
    }

    public static IngredientList getInstance() {
        if (instance == null) {
            instance = new IngredientList();
        }
        return instance;
    }

    /**
     * Gets the size of the current inventory, not including the amount of individual ingredient.
     * @return the size of current inventory
     */
    public int getInventoryStock() {
        return ingredientList.size();
    }

    /**
     * Gets the string representation of an ingredient in the list.
     * @param ingredientNumber ingredient number to get information
     * @return String representation of the ingredient
     * @throws DukeException if the ingredient number have not existed
     */
    public String getIngredientInfo(int ingredientNumber) throws DukeException {
        try {
            return ingredientList.get(ingredientNumber - 1).toString();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Ingredient number have not existed!");
        }
    }

    /**
     * Removes an ingredient from the list.
     * @param ingredientNumber ingredient number to remove
     * @return The removed ingredient
     * @throws DukeException if the ingredient number has not existed
     */
    public Ingredient remove(int ingredientNumber) throws DukeException {
        try {
            Ingredient removedIngredient = ingredientList.remove(ingredientNumber - 1);
            return removedIngredient;
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Ingredient number have not existed!");
        }
    }


}