# Gilded Rose Refactoring Kata
Hi, this is my implementation of the Gilded Rose Refactoring Kata.
I started my refactoring from the following GitHub repository: https://github.com/emilybache/GildedRose-Refactoring-Kata.
This Kata was originally created by Terry Hughes (http://twitter.com/TerryHughes). 
It is already on GitHub [here](https://github.com/NotMyself/GildedRose). See also [Bobby Johnson's description of the kata](http://iamnotmyself.com/2011/02/13/refactor-this-the-gilded-rose-kata/).

If you want try your own implementation for the refactoring, do not look at my code yet or you will take out all the fun!

## Unit-Test Approval Testing
For my solution I spent a little more time at the beginning, focusing on the implementation of unit tests.
I found out that there was also a bug in the original implementation (compared to the spesifications) before starting the refactoring. After that I was able to do any possible change to the code being very confident that I wouldn't break any of the rules explained in the ["Gilded Rose Requirements"](https://github.com/emilybache/GildedRose-Refactoring-Kata/tree/master/GildedRoseRequirements.txt)
Regrding the "Text-Based Approval Testing", suggested in the project I started from, I found it very helpful at the beginning to visualize what the outpout should look like but I couln't rely only on that to be sure my refactoring was perfect.

## How to Compile and Run the code
#### Requirements 
1. Java 8+
2. Maven
#### Build & Test
```bash
mvn clean package
```
#### Run
```bash
$ java -cp gilded-rose-kata-0.0.1-SNAPSHOT.jar com.gildedrose.run.App items.txt
```
*You can find and example of file **items.txt** in the root folder of the repository.*
### Author
If oyu want to know more about the author you can visit my profile on [linkedin](https://www.linkedin.com/in/dariosavarese/).