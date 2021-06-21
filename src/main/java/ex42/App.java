package ex42;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
Exercise 42 - Parsing a Data File
Sometimes data comes in as a structured format that you have to break down and turn into records so you can process them. CSV, or comma-separated values, is a common standard for doing this.

Construct a program that reads in the following data file:

Ling,Mai,55900
Johnson,Jim,56500
Jones,Aaron,46000
Jones,Chris,34500
Swift,Geoffrey,14200
Xiong,Fong,65000
Zarnecki,Sabrina,51500
Process the records and display the results formatted as a table, evenly spaced, as shown in the example output.

Example Output
Last      First     Salary
--------------------------
Ling      Mai       55900
Johnson   Jim       56500
Jones     Aaron     46000
Jones     Chris     34500
Swift     Geoffrey  14200
Xiong     Fong      65000
Zarnecki  Sabrina   51500

Constraints
Write your own code to parse the data. Don't use a CSV parser.
Use spaces to align the columns.
Make each column one space longer than the longest value in the column.

Challenges
Format the salary as currency with dollar signs and commas.
Sort the results by salary from highest to lowest.
Rework your program to use a CSV parsing library and compare the results.
 */
//UCF COP3330 Summer 2021 Assignment 3 Solution Copyright 2021 Ifeoma Chukwu
public class App
{
    public static ArrayList<String> data;
    public static void main(String[] args) throws IOException
    {
        //call the readFile method to read the data from the input file
        readFile("src/main/resources/exercise42_input.txt");
        System.out.printf("%-9s%-9s%s\n","Last", "First", "Salary");
        System.out.println("--------------------------");
        //call parseData on the array list to format it
        parseData(data);
    }
    public static void readFile(String fileName) throws FileNotFoundException
    {
        //call the readFile function on the input.txt file with all of the names and the salaries to read the file
        FileReader fr = new FileReader(fileName);
        Scanner input = new Scanner(fr);
        //recall data
        data = new ArrayList<String>();
        //while loop iterates through the entire file
        while(input.hasNextLine())
        {
            String name = input.nextLine();
            data.add(name);
        }
    }
    public static String[] parseData(ArrayList<String> data) throws IOException
    {
        //initialize a file writer to the output.txt file because that is the file we are writing to
        FileWriter fw = new FileWriter("src/main/resources/exercise42_output.txt");
        //initialize a string array to store the formatted data
        String[] names = null;
        //loop that formats each line in the file with spaces and seperates the data by comma
        for(int i =0; i<data.size();i++)
        {
            names = data.get(i).split(",");
            fw.write(names[0] +" "+names[1]+" "+names[2]+"\n");
            fw.flush();
            System.out.printf("%-9s%-9s%s\n",names[0], names[1], names[2]);
        }
        fw.close();
        return names;
    }
}