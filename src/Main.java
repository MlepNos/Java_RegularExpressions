import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String string = "I am a String. Yes, I am.";
        System.out.println(string);

        String yourString = string.replaceAll("I","You");
        System.out.println(yourString);


        String alphanumeric = "abcdeFFF123abcGhhijjjkkkkl89za";
        System.out.println(alphanumeric.replaceAll(".","Y")); // "." is a wildcart for any Character
        System.out.println(alphanumeric.replaceAll("^abcdeFF","YYY")); // starts from looking from the start of the string ^ means the start of the line

        String alphanumeric2 = "abcdeFFF123GhhijabcdeFFjjkkkkl89z";
        System.out.println(alphanumeric.replaceAll("^abcdeFF","YYY"));

        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcdeFF")); //the strings as a whole must match
        System.out.println(alphanumeric.matches("abcdeFFF123abcGhhijjjkkkkl89za"));


        System.out.println(alphanumeric.replaceAll("kl89z$","THE END")); // $ means only replace it if its really the end

        System.out.println(alphanumeric.replaceAll("[abc]","X")); // will replace all a,b,c int string with X

        System.out.println(alphanumeric.replaceAll("[abc]","I replaced a letter here")); // will replace all a,b,c int string with X

        System.out.println(alphanumeric.replaceAll("[abc][dG]","X"));// if any of the a,b or c are followed by F or 1 it will replace

        System.out.println(".".repeat(40));
        System.out.println("Harry".replaceAll("[Hh]arry","Harry"));
        System.out.println("harry".replaceAll("[Hh]arry","Harry"));

        System.out.println(".".repeat(40));
        String newalphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(newalphanumeric.replaceAll("[^ej]","X")); // if ^ is in the [] it negates it.


        System.out.println(".".repeat(40));
        System.out.println("Original String:"+ newalphanumeric);
        System.out.println(newalphanumeric.replaceAll("[abcdef345678]","X")); //Long version
        System.out.println(newalphanumeric.replaceAll("[a-f3-8]","X")); //Short version
        System.out.println(newalphanumeric.replaceAll("[a-fA-F3-8]","X")); //Short version with uppercases

        System.out.println(newalphanumeric.replaceAll("(?i)[a-f3-8]","X")); //(?i) is ignoring case sensitivity,Short version with uppercases


        System.out.println(".".repeat(40));
        System.out.println("Original String:"+ newalphanumeric);
        System.out.println(newalphanumeric.replaceAll("[0-9]","X")); //long version for numbers
        System.out.println(newalphanumeric.replaceAll("\\d","X")); //short version for numbers


        System.out.println(".".repeat(40));
        System.out.println("Original String:"+ newalphanumeric);
        System.out.println(newalphanumeric.replaceAll("\\D","X")); //short version for all non digits
        System.out.println(".".repeat(40));

        String hasWhiteSpace = "I Have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s","")); //replaces all whitespaces
        System.out.println(hasWhiteSpace.replaceAll("\t","X"));

        System.out.println(hasWhiteSpace.replaceAll("\\S","")); // replaced all non whitespaces


        System.out.println(".".repeat(40));
        //System.out.println("Original String:"+ newalphanumeric);
        System.out.println(hasWhiteSpace.replaceAll("\\w","X"));  //everything except the whitepsaces replaced
        System.out.println(hasWhiteSpace.replaceAll("\\b","X"));  //each word will be surrounded by X

        System.out.println(".".repeat(40));
        //QUANTIFIERS
        String thirdalphanumeric  ="abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdalphanumeric.replaceAll("^abcDeee","YYY"));
        System.out.println(thirdalphanumeric.replaceAll("^abcDe{3}","YYY")); //it needs in total 3 e's
        System.out.println(thirdalphanumeric.replaceAll("^abcDe{1,3}","YYY")); //it needs in total between 1 and 3 e's

        System.out.println(thirdalphanumeric.replaceAll("^abcDe+","YYY")); // all e's after abdDe

        System.out.println(".".repeat(40));
        String fourthdalphanumeric  ="abcDF12Ghhiiiijkl99z";
        System.out.println(fourthdalphanumeric.replaceAll("^abcDe*","YYY")); // looking for abcD and includes e
        System.out.println(fourthdalphanumeric.replaceAll("h+i*j","Y")); // looking for abcD and includes e


        System.out.println(".".repeat(40));
        String myName  ="Mehmet Kaan Asik";
        System.out.println(myName.replaceAll("(?i)ka+n", "XXXX"));

        String Test  ="aassssadff";
        System.out.println(Test.replaceAll("a+s+d*", "XXXXXXX")); //d* means zero or more occurance of d

        System.out.println(".".repeat(40));
        StringBuilder htmlText =  new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a Paragraph about something</p>");
        htmlText.append("<p>This is another Paragraph about something else</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary</p>");

        String h2Pattern = "<h2>";  // ".*<h2>.*" there can be anything before <h2> or after if we used it like this matcher.matches would be true
        Pattern pattern = Pattern.compile(h2Pattern,Pattern.CASE_INSENSITIVE );
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset(); // we have to reset the matcher because we can use it only once
        int count =0;
        while (matcher.find()){
            count++;
            System.out.println("Occurrence: " + count + " : " + matcher.start() +" to " + matcher.end());
        }

        System.out.println(".".repeat(40));

        String h2GroupPattern = "(<h2>.*?</h2>)"; // "(<h2>.*?</h2>)" turns it into lazy quantifier
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);

        while (groupMatcher.find()){
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        System.out.println(".".repeat(40));

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);
        while (h2TextMatcher.find()){
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        System.out.println(".".repeat(40));
        // "abc" means "a" and "b" and "c"
        System.out.println("harry".replaceAll("[H|h]arry","Larry")); // if the h is capital OR lowercase
        System.out.println("Harry".replaceAll("[H|h]arry","Larry"));

        System.out.println(".".repeat(40));
        //[^abc] means not
        String tvTest = "tstvtkt";
        //String tNotVRegExp = "t[^v]"; //t that arent followed by a t
        String tNotVRegExp = "t(?!v)"; //lookahead
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);
        count=0;

        while(tNotVMatcher.find()){
            count++;
            System.out.println("Occurence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }
        // t(?=v) all the matches of t followed by v, bu we did not want to include v in the match
        System.out.println(".".repeat(40));
        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$  ----------> US Phone Number (800) 123-4567
        String phone1 = "1234567890"; //Should not match
        String phone2 = "(123) 456-7890"; //match
        String phone3 = "123 456-7890";//Should not match
        String phone4 = "(123)456-7890";//Should not match

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        String testchar = "(())" ;
        System.out.println(testchar.matches("^[\\(]{2}[\\)]{2}"));

        System.out.println(".".repeat(40));

        // ^4[0-9]{12}([0-9]{3})?$ ----------> Visa Credit Numbers
        String visa1 = "4444444444444"; //match
        String visa2 = "5444444444444"; //Should not match
        String visa3 = "4444444444444444";// match
        String visa4 = "4444";//Should not match

        System.out.println("visa1 = " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 = " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 = " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 = " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));
    }
}