package ex44;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Iterator;

/*
Pulling data from a file into a complex data structure makes parsing much simpler. Many programming languages support the Json format, a popular way of representing data.

Create a program that takes a product name as input and retrieves the current price and quantity for that product. The product data is in a data file in the Json format and looks like this:

{
    "products" : [
        {"name": "Widget", "price": 25.00, "quantity": 5 },
        {"name": "Thing", "price": 15.00, "quantity": 5 },
        {"name": "Doodad", "price": 5.00, "quantity": 10 }
    ]
}
Print out the product name, price, and quantity if the product is found. If no product matches the search, state that no product was found and start over.

Example Output
What is the product name? iPad
Sorry, that product was not found in our inventory.
What is the product name? Widget
Name: Widget
Price: $25.00
Quantity on hand: 5

Constraints
The file is in the Json format. Use a Json parser to pull the values out of the file.
If no record is found, prompt again.

Challenges
Ensure that the product search is case insensitive.
When a product is not found, ask if the product should be added. If yes, ask for the price and the quantity, and save it in the Json file. Ensure the newly added product is immediately available for searching without restarting the program.
 */
//UCF COP3330 Summer 2021 Assignment 3 Solution Copyright 2021 Ifeoma Chukwu
public class App {
        public static void main(String[] args)
        {
            //To read Json file, first you need to add one external library
            //Create one Json parser object
            jsonParse();
        }
        public static void jsonParse()
        {
            JsonParser parser = new JsonParser();
            try {
                //Read Json file using parser and store it in obj
                Object obj = parser.parse(new FileReader("src/main/resources/exercise44_products.json"));
                //Create Json object to read internal values
                JsonObject JsonObject = (JsonObject)obj;
                //Reading products array from  the file
                JsonArray subjects = (JsonArray)JsonObject.get("products");
                //Create buffered reader object to take user input
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                //Create string variable
                String input;
                //Flag is used whether given string is present or not
                int flag = 0;
                System.out.print("What is the product name? ");
                input = bufferedReader.readLine();
                //Create iterator for products array
                Iterator iterator = subjects.iterator();
                //Loop through the iterator
                while (iterator.hasNext()) {
                    //Create another Json
                    JsonObject Json = (JsonObject) iterator.next();
                    //Get the name value
                    String name = (String)Json.get("name").getAsString();
                    //Compare it with given input
                    if(input.toLowerCase().equals(name.toLowerCase())){
                        System.out.println("Name: "+name);
                        System.out.println("Price: "+Json.get("price"));
                        System.out.println("Quantity: "+Json.get("quantity"));
                        flag = 1;
                    }
                }
                //If flag value is zero, then value is not found
                if(flag == 0){
                    System.out.println("Sorry, that product was not found in our inventory");
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
