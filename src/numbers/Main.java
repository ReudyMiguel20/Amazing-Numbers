package numbers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initializing objects and variables
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> bannedWords = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbInput = new StringBuilder();
        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedNumber = "";
        String propertyToSearch = "";
        String[] propertyList = {"EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SUNNY", "SQUARE", "JUMPING", "HAPPY", "SAD"};
        String propertyToSearchInUppercase2 = "";
        String propertyToSearchTwo = "";
        String propertyThree = "";
        String propertyFour = "";
        String propertyFive = "";
        String propertySix = "";
        String propertySeven = "";
        String propertyEight = "";
        String propertyNine = "";
        String propertyTen = "";
        String entireInputStringUppercase = "";
        String twoValuesOrMore = "";
        long sumDigits = 0;
        long productDigits = 1;
        long startingNumber = 0;
        long inputNumber = 0;
        long consecutiveNum = 0;
        int conditionCounter = 0;
        boolean threeOrMoreConditions = false;
        boolean confirmedOnlyOneNumber = false;
        boolean isOdd = false;
        boolean isEven = false;
        boolean isBuzzNumber;
        boolean isDuck;
        boolean isPalindromic;
        boolean isGapful = false;
        boolean isSpy = false;
        boolean isSunny = false;
        boolean isSquare = false;
        boolean isJumping = false;
        boolean isHappy = false;
        boolean isSad = false;
        boolean bannedNumber = false;
        int counterWords = 0;


        String welcomeMessage = "Welcome to Amazing Numbers!\n";
        String welcomeMessageTwo = """
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be printed;
                - two natural numbers and a property to search for;
                - two natural numbers and two properties to search for;
                - separate the parameters with one space;
                - enter 0 to exit.""";

        System.out.println(welcomeMessage);
        System.out.println(welcomeMessageTwo);

        //Checking if the number is natural
        while (true) {
            bannedWords.clear();
            sbInput.setLength(0);
            System.out.println();
            System.out.print("Enter a request: ");
            String inputNumberStringStart = scanner.nextLine();

            if (inputNumberStringStart.contains(" ")) {
                String[] inputArray = inputNumberStringStart.split(" ");
                //This is to search number and the consecutive number
                if (inputArray.length == 2) {
                    inputNumber = Long.parseLong(inputArray[0]);
                    consecutiveNum = (Long.parseLong(inputArray[1]) - 1);

                    propertyToSearch = "no parameter";
                } else { //this is for the number, consecutive numbers and property
                    inputNumber = Long.parseLong(inputArray[0]);
                    consecutiveNum = (Long.parseLong(inputArray[1]) - 1);

                    propertyToSearch = inputArray[2].toLowerCase();

                    String propertyToSearchInUppercase = inputArray[2].toUpperCase();
                    if (inputArray.length == 4) {
                        propertyToSearchTwo = inputArray[3];
                        propertyToSearchInUppercase2 = inputArray[3].toUpperCase();

                        //This is for when theres three or more properties to number
                    } else if (inputArray.length > 4) {
                        switch (inputArray.length) {
                            case 5 -> propertyThree = inputArray[4];
                            case 6 -> propertyFour = inputArray[5];
                            case 7 -> propertyFive = inputArray[6];
                            case 8 -> propertySix = inputArray[7];
                            case 9 -> propertySeven = inputArray[8];
                            case 10 -> propertyEight = inputArray[9];
                            case 11 -> propertyNine = inputArray[10];
                            case 12 -> propertyTen = inputArray[11];
                        }
                    }

                    //Creating variable to search for desired words


                    //This is for building the string with all the properties to look for to compare later on
                    for (int i = 2; i < inputArray.length; i++) {
                        if (i == 5) {
                            threeOrMoreConditions = true;
                        }
                        if (i == inputArray.length - 1) {
                            if (inputArray[i].contains("-")) {
                                bannedWords.add(inputArray[i].toUpperCase());
                            } else {
                                sbInput.append(inputArray[i]);
                            }
                            break;
                        }
                        if (inputArray[i].contains("-")) {
                            bannedWords.add(inputArray[i].toUpperCase());
                        } else {
                            sbInput.append(inputArray[i]).append(", ");
                        }

                    }

                    //Assigning the sbInput to the variable twoOrMoreNumbers
//                    if (inputArray.length == 3) {
//                        twoValuesOrMore = inputArray[2];
//                    } else if (inputArray.length == 4) {
//                        twoValuesOrMore = sbInput.append(inputArray[2]).append(inputArray[3]);
//                    }
                    twoValuesOrMore = sbInput.toString();


                    //I'm thinking to check the input of the user to compare it to the string properties
                    //If there's a word that's not into the array then it's a strange word, and it should make an array of
                    //those incorrect words and then 'CONTINUE' to the beginning, throwing an error.
                    entireInputStringUppercase = sbInput.toString();
                    entireInputStringUppercase = entireInputStringUppercase.toUpperCase();
                    String[] compareInput = entireInputStringUppercase.split(", ");

                    //The string for the bad words and then print them out, and a counter
                    String[] wrongInput = new String[15];
                    int counterWrongInput = 0;
                    ;
                    for (String word : compareInput) {
                        if (!(Arrays.toString(propertyList).contains((word)))) {
                            wrongInput[counterWrongInput] = word;
                            counterWrongInput++;
                        }
                    }

                    if (counterWrongInput == 1) {
                        System.out.println("The property " + "[" + wrongInput[0] + "]" + " is wrong.");
                        System.out.println("Available properties: " + Arrays.toString(propertyList));
                        counterWrongInput = 0;
                        sbInput.setLength(0);
                        continue;
                    } else if (counterWrongInput == 2) {
                        System.out.println("The properties " + "[" + wrongInput[0] + ", " + wrongInput[1] + "]" + " are wrong.");
                        System.out.println("Available properties: " + Arrays.toString(propertyList));
                        counterWrongInput = 0;
                        sbInput.setLength(0);
                        continue;
                    } else if (counterWrongInput > 2) {

                    }

                    //If both are wrong then
//                    if (!Arrays.toString(propertyList).contains(propertyToSearchInUppercase) && !Arrays.toString(propertyList).contains(propertyToSearchInUppercase2)) {
//                        System.out.println("The properties " + "[" + propertyToSearchInUppercase + ", " + propertyToSearchInUppercase2 + "]" + " are wrong.");
//                        System.out.println("Available properties: " + Arrays.toString(propertyList));
//                        continue;
//                    }
//                    //Checking if the first written parameter is on the list
//                    else if (!(Arrays.toString(propertyList).contains(propertyToSearchInUppercase))) {
//                        System.out.println("The property " + "[" + propertyToSearchInUppercase + "]" + " is wrong.");
//                        System.out.println("Available properties: " + Arrays.toString(propertyList));
//                        continue;
//                    }
//                    //Checking if the second written parameter is on the list
//                    else if (!(Arrays.toString(propertyList).contains(propertyToSearchInUppercase2))) {
//                        System.out.println("The property " + "[" + propertyToSearchInUppercase2 + "]" + " is wrong.");
//                        System.out.println("Available properties: " + Arrays.toString(propertyList));
//                        continue;
//                    }


                    //Mutually exclusive properties
                    if (Arrays.asList(compareInput).contains("EVEN") && Arrays.asList(compareInput).contains("ODD")) {
                        System.out.println("The request contains mutually exclusive properties: [ODD, EVEN]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("DUCK") && Arrays.asList(compareInput).contains("SPY")) {
                        System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("SUNNY") && Arrays.asList(compareInput).contains("SQUARE")) {
                        System.out.println("The request contains mutually exclusive properties: [SUNNY, SQUARE]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("SAD") && Arrays.asList(compareInput).contains("HAPPY")) {
                        System.out.println("The request contains mutually exclusive properties: [SAD, HAPPY]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("SAD") && bannedWords.contains("-SAD")) {
                        System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("HAPPY") && bannedWords.contains("-HAPPY")) {
                        System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("GAPFUL") && bannedWords.contains("-GAPFUL")) {
                        System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("SPY") && bannedWords.contains("-SPY")) {
                        System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("SUNNY") && bannedWords.contains("-SUNNY")) {
                        System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("SQUARE") && bannedWords.contains("-SQUARE")) {
                        System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("JUMPING") && bannedWords.contains("-JUMPING")) {
                        System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("PALINDROMIC") && bannedWords.contains("-PALINDROMIC")) {
                        System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("DUCK") && bannedWords.contains("-DUCK")) {
                        System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("BUZZ") && bannedWords.contains("-BUZZ")) {
                        System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("EVEN") && bannedWords.contains("-EVEN")) {
                        System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    } else if (Arrays.asList(compareInput).contains("ODD") && bannedWords.contains("-ODD")) {
                        System.out.println("The request contains mutually exclusive properties: [SAD, -SAD]\n" +
                                "There are no numbers with these properties.");
                        //Resetting values
                        propertyToSearchInUppercase = "";
                        propertyToSearchInUppercase2 = "";
                        continue;
                    }


                    //Mutually exclusive properties
//                    if (propertyToSearchInUppercase.equals("EVEN") && propertyToSearchInUppercase2.equals("ODD") ||
//                            propertyToSearchInUppercase.equals("ODD") && propertyToSearchInUppercase2.equals("EVEN")) {
//
//                        System.out.println("The request contains mutually exclusive properties: [ODD, EVEN]\n" +
//                                "There are no numbers with these properties.");
//                        //Resetting values
//                        propertyToSearchInUppercase = "";
//                        propertyToSearchInUppercase2 = "";
//                        continue;
//
//                    } else if (propertyToSearchInUppercase.equals("DUCK") && propertyToSearchInUppercase2.equals("SPY") ||
//                            propertyToSearchInUppercase.equals("SPY") && propertyToSearchInUppercase2.equals("DUCK")) {
//
//                        System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
//                                "There are no numbers with these properties.");
//                        //Resetting values
//                        propertyToSearchInUppercase = "";
//                        propertyToSearchInUppercase2 = "";
//                        continue;
//
//                    } else if (propertyToSearchInUppercase.equals("SUNNY") && propertyToSearchInUppercase2.equals("SQUARE") ||
//                            propertyToSearchInUppercase.equals("SQUARE") && propertyToSearchInUppercase2.equals("SUNNY")) {
//
//                        System.out.println("The request contains mutually exclusive properties: [SUNNY, SQUARE]\n" +
//                                "There are no numbers with these properties.");
//                        //Resetting values
//                        propertyToSearchInUppercase = "";
//                        propertyToSearchInUppercase2 = "";
//                        continue;
//                    }

                }

                if (inputNumber < 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                } else if (consecutiveNum < 0) {
                    System.out.println("The second parameter should be a natural number.");
                }

            } else if (!(inputNumberStringStart.isEmpty())) {
                try {
                    inputNumber = Long.parseLong(inputNumberStringStart);
                    confirmedOnlyOneNumber = true;
                } catch (NumberFormatException e) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }
            }


            if (inputNumberStringStart.equals("")) {
                System.out.println("\n" + welcomeMessageTwo);
                continue;
            } else if (inputNumber < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
                continue;
            } else if (inputNumber == 0) {
                System.out.println("Goodbye!");
                break;
            } else {
                for (int i = 0; i <= consecutiveNum; i++) {
                    //Checking and printing if the number is Odd or Even
                    if (inputNumber % 2 == 0) {
                        isEven = true;
                    } else {
                        isOdd = true;
                    }

                    //Checking if the number is a buzz number
                    if (inputNumber % 7 == 0 || inputNumber % 10 == 7) {
                        isBuzzNumber = true;
                    } else {
                        isBuzzNumber = false;
                    }


                    //
                    String inputNumberString = String.valueOf(inputNumber);
                    ArrayList<String> splitterText = new ArrayList<>();
                    String[] splitter = inputNumberString.split("");

                    //Loop for adding the numbers to a String list
                    for (String n : splitter) {
                        splitterText.add(n);
                    }


                    //Checking if the number is Duck
                    isDuck = false;
                    for (int k = 0; k < splitter.length; k++) {
                        if (k == 0 && splitter[0].contains("0")) {
                            isDuck = false;
                        } else {
                            if (splitter[k].contains("0")) {
                                isDuck = true;
                                break;
                            }
                        }
                    }

                    //Appending the array from end to start, also acquiring the sum and
                    // calculating the product from the number to verify if the number is spy
                    for (int j = splitter.length - 1; j >= 0; j--) {
                        sumDigits += Long.parseLong(splitter[j]);
                        productDigits *= Long.parseLong(splitter[j]);
                        sb.append(splitter[j]);
                    }

                    //Checking if the word is palindromic
                    if (inputNumberString.equals(sb.toString())) {
                        isPalindromic = true;
                    } else {
                        isPalindromic = false;
                    }

                    //Grabbing the first number of the inputNumber
                    long firstDigit = 0;
                    long inputNumberDigit = inputNumber;
                    while (inputNumberDigit > 0) {
                        firstDigit = inputNumberDigit % 10;
                        inputNumberDigit /= 10;
                    }

                    //Grabbing the last number of inputNumber
                    long inputNumberDigitLast = inputNumber;
                    long lastNumberDigit = inputNumberDigitLast % 10;

                    //Converting first digit and last digit to integer
                    String firstAndLastString = String.valueOf(firstDigit) + String.valueOf(lastNumberDigit);
                    int firstAndLastNum = Integer.parseInt(firstAndLastString);

                    //Checking if the number is gapful
                    if (inputNumber >= 100 && inputNumber % firstAndLastNum == 0) {
                        isGapful = true;
                    }

                    //Verifying if the number is a spy number
                    if (sumDigits == productDigits) {
                        isSpy = true;
                    }

                    //Verifying if the number is a square number
                    if (inputNumber == 2) {
                        isSquare = false;
                    } else if (Math.sqrt(inputNumber) % 1 == 0) {
                        isSquare = true;
                    }

                    //Verifying if the number is a sunny number
                    double sunnyNumber = 1.0 * inputNumber + 1;
                    if (Math.sqrt(sunnyNumber) % 1 == 0) {
                        isSunny = true;
                    }

                    int counter = 1;
                    //Verifying if the number is a jumping number
                    for (int k = 0; k < splitter.length; k++) {

                        if (splitter.length == 1) {
                            isJumping = true;
                            break;
                        }

                        int number = Integer.parseInt(splitter[k]);
                        int numberCounter = Integer.parseInt(splitter[counter]);


                        if (counter == splitter.length - 1) {
                            if (Math.abs(number - numberCounter) == 1) {
                                isJumping = true;
                            } else {
                                isJumping = false;
                                break;
                            }
                            break;
                        }

                        if (Math.abs(number - numberCounter) == 1) {
                            isJumping = true;
                            counter++;
                        } else {
                            isJumping = false;
                            break;
                        }
                    }

                    double numberFour = 4;
                    double isItHappy = 0;
                    double happyOrSad = 0;
                    double entireNumber = 1.0 * inputNumber;
                    //Verifying if the number is either a Happy or Sad number
                    for (int l = 0; l <= splitterText.size(); l++) {
                        if (l == splitterText.size()) {
                            if (happyOrSad == 1) {
                                isHappy = true;
                                break;
                            } else if (happyOrSad == numberFour || happyOrSad == isItHappy || happyOrSad == entireNumber) {
                                isHappy = false;
                                isSad = true;
                                break;
                            } else {
                                if (isItHappy == 0) {
                                    isItHappy = happyOrSad;
                                }
                                int happyOrSadInt = (int) happyOrSad;
                                String happyOrSadString = String.valueOf(happyOrSadInt);
                                String[] happyOrSadArray = happyOrSadString.split("");
                                splitterText.clear();

                                for (int m = 0; m < happyOrSadArray.length; m++) {
//                                    if (happyOrSadArray.length > splitter.length){
//                                        System.out.println("error");
//                                        l = -1;
//                                        break;
//                                    }
                                    splitterText.add(happyOrSadArray[m]);

                                }
                                happyOrSad = 0;
                                l = -1;
                                continue;
                            }
                        }


                        if (Math.pow(Double.parseDouble(splitterText.get(l)), 2) == 0) {
                            continue;
                        } else {
                            happyOrSad += Math.pow(Double.parseDouble(splitterText.get(l)), 2);
                        }


                    }

                    //Format the number with commas
                    formattedNumber = formatter.format(inputNumber);

                    //This is for when there's only a number on the input
                    // (only one number with no number parameters or requirements)
                    if (confirmedOnlyOneNumber) {
                        //Printing properties of the input number
                        System.out.println("Properties of " + formattedNumber);
                        System.out.println("even: " + isEven);
                        System.out.println("odd: " + isOdd);
                        System.out.println("buzz: " + isBuzzNumber);
                        System.out.println("duck: " + isDuck);
                        System.out.println("palindromic: " + isPalindromic);
                        System.out.println("gapful: " + isGapful);
                        System.out.println("spy: " + isSpy);
                        System.out.println("sunny: " + isSunny);
                        System.out.println("square: " + isSquare);
                        System.out.println("jumping: " + isJumping);
                        System.out.println("happy: " + isHappy);
                        System.out.println("sad: " + isSad);
                        //Resetting values
                        sb.setLength(0);
                        isOdd = false;
                        isEven = false;
                        isBuzzNumber = false;
                        isDuck = false;
                        isPalindromic = false;
                        isGapful = false;
                        startingNumber = 0;
                        confirmedOnlyOneNumber = false;
                        isSpy = false;
                        sumDigits = 0;
                        productDigits = 1;
                        isSunny = false;
                        isSquare = false;
                        isJumping = false;
                        counter = 1;
                        threeOrMoreConditions = false;
                        isHappy = false;
                        isSad = false;
                        isItHappy = 0;
                        happyOrSad = 0;
                        entireNumber = 1.0 * inputNumber;
                        splitterText.clear();
                        bannedNumber = false;
                    }

                    //This is for when there's a number and the user has given a number parameter
                    else if (consecutiveNum >= 0) {
                        //Declaring variables, empty strings
                        String buzz = "";
                        String duck = "";
                        String gapful = "";
                        String palindrome = "";
                        String odd = "";
                        String even = "";
                        String spy = "";
                        String sunny = "";
                        String square = "";
                        String jumping = "";
                        String happy = "";
                        String sad = "";

                        List<String> conditions = new ArrayList<>();

                        if (isBuzzNumber) {
                            conditions.add("buzz");
                        }
                        if (isDuck) {
                            conditions.add("duck");
                        }
                        if (isGapful) {
                            conditions.add("gapful");
                        }
                        if (isPalindromic) {
                            conditions.add("palindromic");
                        }
                        if (isOdd) {
                            conditions.add("odd");
                        }
                        if (isEven) {
                            conditions.add("even");
                        }
                        if (isSpy) {
                            conditions.add("spy");
                        }
                        if (isSunny) {
                            conditions.add("sunny");
                        }
                        if (isSquare) {
                            conditions.add("square");
                        }
                        if (isJumping) {
                            conditions.add("jumping");
                        }
                        if (isHappy) {
                            conditions.add("happy");
                        }
                        if (isSad) {
                            conditions.add("sad");
                        }

                        String joinedConditions = String.join(", ", conditions);

                        //Printing the number with their conditions, the later only printing the condition that
                        //a user asks specifically
                        if (propertyToSearch.equals("no parameter")) {
                            System.out.println(inputNumber + " is " + joinedConditions);
                            i++;
                        } else {
                            sbInput = sbInput.append(propertyToSearch);
                        }

                        //Giving the twoValuesOrMore variable the value of sbInput, so it doesnt dissapear
                        twoValuesOrMore = joinedConditions;
                        String[] splitArray = twoValuesOrMore.split(", ");
                        Arrays.sort(splitArray);

                        //if the number don't have preferred properties and only banned, then it must verify that the number
                        //satisfies the requirements
                        if (sbInput.toString().isEmpty() && bannedWords.size() >= 1) {
                            for (String word : conditions) {
                                if (bannedWords.toString().toUpperCase().contains(word.toUpperCase())) {
                                    bannedNumber = true;
                                    break;
                                } else {
                                    sbInput.append(word).append(", ");
//                                    splitArray = sbInput.toString().split(", ");
                                    splitArray = sbInput.toString().split(", ");
                                    Arrays.sort(splitArray);
                                    twoValuesOrMore = String.join(", ", splitArray);
                                }
                            }
                        } else {
                            twoValuesOrMore = joinedConditions;
                            splitArray = twoValuesOrMore.split(", ");
                            Arrays.sort(splitArray);
                            twoValuesOrMore = String.join(", ", splitArray);
                        }

                        bannedNumber:
                        {
                            if (bannedNumber) {
                                break bannedNumber;
                            }


                            String[] expectedWords = twoValuesOrMore.split(", ");
                            String[] wordsFound = joinedConditions.split(", ");
                            Arrays.sort(expectedWords);
                            Arrays.sort(wordsFound);

                            //Printing ONLY if the number has the parameters specified by the user
                            counterWords = 0;

                            for (String word : expectedWords) {
                                if (bannedWords.contains(word.toUpperCase())) {
                                    bannedNumber = true;
                                }
                                if (Arrays.asList(wordsFound).contains(word)) {
                                    counterWords++;
                                }
                            }

                            //Ideas:
                            //1- if-else condition with the code below, just that in this case is 'if the bannedWords
                            //list is not empty, then do certain conditions, otherwise execute the already existing code
//                        if (bannedNumber) {
//                            break outer;
//                        }


                            //Check here!!
                            outer:
                            {
                                if (counterWords >= 3) {
                                    threeOrMoreConditions = true;
                                }

                                if (Arrays.toString(wordsFound).equals(Arrays.toString(splitArray)) && expectedWords.length >= 2 && bannedWords.size() >= 1) {
                                    System.out.println(inputNumber + " is " + joinedConditions);
                                    i++;
                                } else if (!Arrays.toString(wordsFound).equals(Arrays.toString(splitArray)) && expectedWords.length >= 2 && bannedWords.size() >= 1) {
                                    break outer;
                                } else if (bannedWords.size() >= 1 && !bannedNumber) {
                                    System.out.println(inputNumber + " is " + joinedConditions);
                                    i++;
                                } else if (counterWords == expectedWords.length && threeOrMoreConditions) {
                                    System.out.println(inputNumber + " is " + joinedConditions);
                                    i++;
                                } else if (counterWords < 3 && expectedWords.length >= 3) {
                                    break outer;
                                } //This is for when it has 2 parameter for a number
                                else if (joinedConditions.contains(propertyToSearch) && joinedConditions.contains(propertyToSearchTwo) && !threeOrMoreConditions) {
                                    System.out.println(inputNumber + " is " + joinedConditions);
                                    i++;

                                } //This is only for when there is only 1 written parameter for a number
                                else if (joinedConditions.contains(propertyToSearch) && propertyToSearchTwo.equals("") && !threeOrMoreConditions) {
                                    System.out.println(inputNumber + " is " + joinedConditions);
                                    i++;
                                }

                            }
                        }

                        //If the number don't meet the requirements then the counter 'i' decreases and the inputNumber
                        //value increases by one
                        i--;
                        inputNumber += 1;


                        //Resetting values
                        sbInput.setLength(0);
                        sb.setLength(0);
                        isOdd = false;
                        isEven = false;
                        isBuzzNumber = false;
                        isDuck = false;
                        isPalindromic = false;
                        isGapful = false;
                        firstDigit = 0;
                        inputNumberDigit = 0;
                        lastNumberDigit = 0;
                        inputNumberDigitLast = 0;
                        startingNumber = 0;
                        isSpy = false;
                        sumDigits = 0;
                        productDigits = 1;
                        isSunny = false;
                        isSquare = false;
                        isJumping = false;
                        counter = 1;
                        threeOrMoreConditions = false;
                        isHappy = false;
                        isSad = false;
                        isItHappy = 0;
                        happyOrSad = 0;
                        entireNumber = 1.0 * inputNumber;
                        splitterText.clear();
                        bannedNumber = false;

                    }

                }
                consecutiveNum = 0;
            }

        }

    }


}


//}



