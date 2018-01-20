package com.duccipopi.jokelib;

import java.util.Random;

public class Joker {
    private static final Random mRandom = new Random(444830400);

    // Jokes from http://www.short-funny.com/
    private static final String[] mJokesList = new String[] {
            "I dig, you dig, she dig, we dig, you dig…the poem may not be beautiful, but it's certainly very deep.",
            "Can a kangaroo jump higher than a house? Of course, a house doesn\'t jump at all.",
            "Anton, do you think I’m a bad mother? My name is Paul.",
            "My ex-wife still misses me. But her aim is steadily improving.",
            "If you spent your day in a well, can you say your day was well-spent?",
            "I Googled \"how to start a wildfire\". I got 48,500 matches.",
            "What is red and occasionally explodes in the fruit section? A pomegranate.",
            "What do snowmen do in their spare time? Just chilling.",
            "Why did the balloon go near the needle?  He wanted to be a pop star."
    };

    public static String tellJoke() {
        return mJokesList[mRandom.nextInt(mJokesList.length)];
    }
}
