package cs2365_project3;

import java.util.ArrayList;
import java.util.Collections;

public class DiceController {
    
    ArrayList<Dice> diceArray;
    
    public DiceController()
    {
        this.diceArray = new ArrayList<>(5);
        for(int i = 0; i < 5; i++)
        {
            Dice newDice = new Dice(i+1, true); //set the dice index to be 1-5 and all flags to be true for first roll
            diceArray.add(newDice);
        }
    }
    
    public ArrayList<Dice> getDiceArray()
    {
        return new ArrayList<>(diceArray);
    }
    
    public ArrayList<Dice> sortDiceArray()
    {
        ArrayList<Dice> sortDiceArray = getDiceArray();
        for(int i = 0; i < sortDiceArray.size()-1; i++)
        {
            if(sortDiceArray.get(i).getDiceInt() > sortDiceArray.get(i+1).getDiceInt())
            {
                Collections.swap(sortDiceArray, i, i+1);
                i = 0;
            }
        }
        
        return diceArray;
    }
    
    public void rollAllDice(boolean[] diceReroll)
    {
        for(Dice dice : getDiceArray())
        {
            if(dice.getReroll())
            {
                dice.rollDice();
                dice.setReroll(false); //resets all reroll flags to false
            }
        }
    }
    
    public int checkFrequency(int diceValue)
    { 
        int count = 0;
        for(Dice dice : getDiceArray())
            if(dice.getDiceInt() == diceValue)
                count++;
        
        return count;
    }
    
}
