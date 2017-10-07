package com.example.chaol.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int numOfCoffee = 2;
    boolean isWhippedCream = false;
    boolean isChocolate = false;
    String customerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(numOfCoffee);
        int price = calulateBill(numOfCoffee,false,false);
        displayPrice(""+price);
        /*
        EditText  customerNameText = (EditText)findViewById(R.id.customerName);
        customerName = customerNameText.getText().toString();
        CheckBox isChocolateBox = (CheckBox)findViewById(R.id.chocolate);
        isChocolate = isChocolateBox.isChecked();
        display(numOfCoffee);
        CheckBox isWhippedCreamBox = (CheckBox)findViewById(R.id.whippedCreams);
        isWhippedCream = isWhippedCreamBox.isChecked();
        int price = calulateBill(numOfCoffee,isChocolate,isWhippedCream);
        String order = "Hello ";
        order = order + customerName;
        order = order + "\n";
        order = order + "Your total will be :";
        order = order + "\n";
        order = order + String.valueOf(price);
        order = order + " Dollars";
        displayPrice(order);
        */
    }

    private int calulateBill(int numOfCoffee,
                             boolean isChocolate,
                             boolean isWhippedCream)
    {
        int price = 0;
        price = 5*numOfCoffee;
        if (isChocolate) {
            price = price + 2;
        }
        if (isWhippedCream) {
            price = price +1;
        }
        Log.v("mainActivity","price is: "+price);
        return price;

    }

    public void incrementQuantity(View view) {
        Log.d("MainActivity","increment by one coffee");

        numOfCoffee += 1;
        display(numOfCoffee);
    }

    public void decrementQuantity(View view) {
        Log.d("MainActivity","decrement by one coffee");
        //int numOfCoffee = 2;
        numOfCoffee -= 1;
        display(numOfCoffee);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(String number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(number);
    }
}
