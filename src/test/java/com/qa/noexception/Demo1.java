package com.qa.noexception;

import com.machinezoo.noexception.Exceptions;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Rajashekar.p
 *
 * From below example, we have written lot of try catch blocks to handle exceptions.
 * Lot of code is invaloved.
 *
 * By Using Exceptions class we can leverage by avoiding lot of code.
 */
public class Demo1 {
    public static void main(String[] args) {
        /* System.out.println("Traditional Way of handling exceptions");
        try {
            FileInputStream fis= new FileInputStream("");
            try {
                XSSFWorkbook xssfWorkbook= new XSSFWorkbook(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */
        System.out.println("********** Using Exception Handler ***********");

        //It will throw exception
        Exceptions.wrap().get(() -> new FileInputStream(new File("")));

    }
}
