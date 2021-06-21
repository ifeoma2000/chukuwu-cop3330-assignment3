package ex43;
/*
Exercise 43 - Website Generator
Programming languages can create files and folders too.

Create a program that generates a website skeleton with the following specifications:

Prompt for the name of the site.
Prompt for the author of the site.
Ask if the user wants a folder for JavaScript files.
Ask if the user wants a folder for CSS files.
Generate an index.html file that contains the name of the site inside the <title> tag and the author in a <meta> tag.

Example Output
Site name: awesomeco
Author: Max Power
Do you want a folder for JavaScript? y
Do you want a folder for CSS? y
Created ./awesomeco
Created ./awesomeco/index.html
Created ./awesomeco/js/
Created ./awesomeco/css/

Challenges
Implement this in a scripting language on Windows, OSX, and Linux.
Implement this as a web application that provides the specified site as a zip file.
 */
//UCF COP3330 Summer 2021 Assignment 3 Solution Copyright 2021 Ifeoma Chukwu
//<head>
//<title name = "">
//
//</title>
//<meta author = "">
//
//</meta>
//</head>
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WebsiteGenerator
{
    String name;
    String author;
    boolean js = false;
    boolean css = false;

    public static void main(String[] args) throws IOException
    {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator();
        websiteGenerator.getUserInput();
        websiteGenerator.createDirectories();
    }

    public void getUserInput()
    {
        Scanner scanner = new Scanner(System.in); // Init scanner to get user input

        System.out.print("Site name: ");
        name = scanner.nextLine(); // Get website name

        System.out.print("\nAuthor: ");
        author = scanner.nextLine(); // Get website author

        System.out.print("\nDo you want a folder for JavaScript? ");
        String input = scanner.nextLine(); // Get 'y' or 'n'
        if (input.charAt(0) == 'y')
        {
            js = true;
        }

        System.out.print("\nDo you want a folder for CSS? ");
        input = scanner.nextLine(); // Get 'y' or 'n'
        if (input.charAt(0) == 'y')
        {
            css = true;
        }
    }

    /*
    <head>
        <meta name="description" content="Free Web tutorials">
        <meta name="keywords" content="HTML, CSS, JavaScript">
        <meta name="author" content="John Doe">
    </head>
     */
    //method that implements the syntax for an html file stored in multiple strings
    public void createHTMLFile(String path) throws IOException
    {
        String html = "<!DOCTYPE>\n";
        html += "<html>\n";
        html += "\t<head>\n";
        html += "\t\t<meta name = \"author\" content = \"" + author + "\">\n";
        //html += "\t\t</meta>\n";
        html += "\t\t<title>\n";
        html += "\t\t" + name + "\n";
        html += "\t\t</title>\n";
        html += "\t</head>\n";
        html += "</html>\n";
        FileWriter fw = new FileWriter(path);
        fw.write(html);
        fw.flush();
        fw.close();
    }

    public void createDirectories() throws IOException
    {
        String path = System.getProperty("user.dir"); // Stores current working directory in path String variable
        path += "/website/";


        File file = new File(path); // Create file instance
        file.mkdir(); // Convert file to directory
        System.out.println("Created " + path);

        createHTMLFile(path + "/index.html");
        System.out.println("Created " + path + "index.html");

        if (js)
        {
            File jsFolder = new File(path + "/js/"); // Create file instance
            file.mkdir(); // Convert file to directory
            FileWriter fw = new FileWriter(jsFolder);
            System.out.println("Created " + jsFolder);
        }

        if (css)
        {
            File cssFolder = new File(path + "/css/"); // Create file instance
            file.mkdir(); // Convert file to directory
            FileWriter fw = new FileWriter(cssFolder);
            System.out.println("Created " + cssFolder);
        }
    }
}
