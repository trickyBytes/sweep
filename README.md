Java application to explore a model for calculate the cost or price of items within a basket of goods


## Building / Running the application
[![Build Status](https://travis-ci.org/trickyBytes/sweep.svg?branch=master)](https://travis-ci.org/trickyBytes/sweep)

This is a Java 8 application, built using Gradle

*Using gradle wrapper on linux*
- To run tests ./gradlew test
- To build ./gradlew build
- To run ./gradlew run

## Thoughts on cost

*TODO Money / Currency*
- Will ignore currenty thoughts for the moment
- Everything be in pence - avoid floating-point arithmetic problems for now... 

*TODO Units - How an amount of goods is represented*
- Physical number - e.g. 2 cans of coke
- Likely to be a whole number

- Some type of weight - e.g 0.200 kg
- Shown as a decimal in a example, are these required when you can use gramms or mililitres for instance

## Offers - What are these actually?

*TODO Example 1 Beans 3 for the price of 2*
Total/3 but what happens if there are 4 items? Usually this would be a full-price right

*TODO Example 2 - Coke 2 for £1*

## Thoughts on basket

- Calculation - should be simple - ask each entry
- VAT - changes over time so you'd get VAT rate at given time from somewhere












