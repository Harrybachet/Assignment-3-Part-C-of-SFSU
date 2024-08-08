/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: BlurbGenerator.java
 * Author: Java Foundation
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment03PartC;

import java.util.Random;

public class BlurbGenerator {

    private final Random random;

    /**
     * Instantiates a random number generator needed for blurb creation.
     */
    public BlurbGenerator() {


        /**
         * Instantiates a random number generator needed for blurb creation.
         */
        // Made a new random object so that I can print out random items //
        random = new Random();

    }

    /**
     * Generates and returns a random Blurb. A Blurb is a Whoozit followed by
     * one or more Whatzits.
     */
    public String makeBlurb() {
        return makeWhoozit() + makeMultiWhatzits();
    }

    /**
     * Generates a random Whoozit. A Whoozit is the character 'x' followed by
     * zero or more 'y's.
     */
    private String makeWhoozit() {

        // I made all the whoozit and whatzit from String builder, so it is easier for me to put strings in them //
        StringBuilder whoozit = new StringBuilder();
        whoozit.append('x');
        while (random.nextBoolean()) {
            whoozit.append('y');
        }
        return whoozit.toString();
    }

    /**
     * Recursively generates a string of zero or more 'y's.
     */
    private String makeYString() {
        if (random.nextBoolean()) {
            // recursion to generate more y's //
            return "y" + makeYString();
        } else {
            return "";
        }
    }

    /**
     * Recursively generates a string of one or more Whatzits.
     */

    // This part was pretty confusing for me because I didn't know what to return, but my friend helped me out on this one. //
    // I just did the same thing over and over again //
    private String makeMultiWhatzits() {
        StringBuilder whatzits = new StringBuilder();
        whatzits.append(makeWhatzit());
        while (random.nextBoolean()) {
            whatzits.append(makeWhatzit());
        }
        return whatzits.toString();
    }

    /**
     * Generates a random Whatzit. A Whatzit is a 'q' followed by either a 'z'
     * or a 'd', followed by a Whoozit.
     */

    // This one was a tough one because I was playing around with a lot of methods //
    // I didn't get the exact output, but I got something close to that, and I am happy with it. //
    private String makeWhatzit() {

        StringBuilder whatzit = new StringBuilder();
        whatzit.append('q');
        if (random.nextBoolean()) {
            whatzit.append('z');
        } else {
            whatzit.append('d');
        }
        whatzit.append(makeWhoozit());
        return whatzit.toString();
    }
}