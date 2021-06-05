package BASE;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Miguel Nobrega
 */

//Exercise 10 - Self-Checkout
//Working with multiple inputs and currency can introduce some tricky precision issues.
//
//Create a simple self-checkout system. Prompt for the prices and quantities of three items. Calculate the subtotal of the items. Then calculate the tax using a tax rate of 5.5%. Print out the line items with the quantity and total, and then print out the subtotal, tax amount, and total.
//
//Example Output
//Enter the price of item 1: 25
//Enter the quantity of item 1: 2
//Enter the price of item 2: 10
//Enter the quantity of item 2: 1
//Enter the price of item 3: 4
//Enter the quantity of item 3: 1
//Subtotal: $64.00
//Tax: $3.52
//Total: $67.52

//Constraints
//Keep the input, processing, and output parts of your program separate. Collect the input, then do the math operations and string building, and then print out the output.
//Be sure you explicitly convert input to numerical data before doing any calculations.

//Challenges
//Revise the program to ensure that prices and quantities are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
//Alter the program so that an indeterminate number of items can be entered. The tax and total are computed when there are no more items to be entered.

import java.util.Scanner;

public class SelfCheck
{
    private int items[] = new int[6];
    private double subtotal = -1;
    private double total;
    private final double TAX = 0.06;

    private static Scanner in = new Scanner(System.in);

    public double getSubtotal()
    {
        return subtotal;
    }

    public double getTotal()
    {
        return total;
    }

    public void getItems()
    {
        for(int i = 0; i < (this.items.length / 2); i ++)
        {
            System.out.print("Enter the price of item "+ i +": ");
            this.items[i] = Integer.valueOf(in.nextLine());
            System.out.print("Enter the price of item "+ (++i) +": ");
            this.items[i] = Integer.valueOf(in.nextLine());
        }
    }

    public void calcSubtotal()
    {
        for(int i = 0; i < (this.items.length / 2); i ++)
        {
            this.subtotal +=  this.items[i] * this.items[++i];
        }
    }

    public void calcTotal()
    {
        if(this.subtotal == -1)
        {
            calcSubtotal();
        }
        this.total = this.subtotal + (this.subtotal * this.TAX);
    }
}
