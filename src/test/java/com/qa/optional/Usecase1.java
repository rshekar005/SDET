package com.qa.optional;

import java.util.Optional;

/**
 * Whenever we are retieving some data from external source there may be chance of getting null values.
 * When we are using that variable will get null pointer exception. To check the difference uncomment first sout.
 * <p>
 * Above case can be handled by using Optional class
 */
public class Usecase1 {
    public static void main(String[] args) {
        String s = null;
        //System.out.println(s.startsWith("s"));

        /*From below if we are retriving data of null value it will throw no such element exception instead of null pointer exception.
        (remove if condition and try to print. we will get null pointer exception.)
        ifPresent then it wll enter into if condition. If not it simply ignore case.
        */

        Optional<String> optional = Optional.ofNullable(null);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }


        String browser = System.getenv("browser");
        if (browser == null) {
            browser = "chrome";
        }
        System.out.println(browser);

        String browser1 = Optional.ofNullable(System.getenv("browser")).orElse("chrome");
        System.out.println(browser1);

        Optional.ofNullable(System.getenv()).
                ifPresentOrElse(System.out::println, () -> System.out.println("browser is not present"));

        Optional.ofNullable(System.getenv()).
               orElseThrow(NullPointerException::new);

    }
}
