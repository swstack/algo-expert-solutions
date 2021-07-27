package algo.expert.solutions.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneNumberMnemonics {

    Map<String, List<String>> keys = Map.of(
            "1", List.of("1"),
            "2", List.of("a", "b", "c"),
            "3", List.of("d", "e", "f"),
            "4", List.of("g", "h", "i"),
            "5", List.of("j", "k", "l"),
            "6", List.of("m", "n", "o"),
            "7", List.of("p", "q", "r", "s"),
            "8", List.of("t", "u", "v"),
            "9", List.of("w", "x", "y", "z"),
            "0", List.of("0")
    );

    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        ArrayList<String> results = new ArrayList<>();
        rec(phoneNumber, "", results, phoneNumber.length());
        System.out.println(results);
        return results;
    }

    void rec(String phoneNumber, String currentPerm, ArrayList<String> results, int targetSize) {

        if (phoneNumber.length() > 0) {
            String nextDigit = phoneNumber.substring(0, 1);
            String remainingPhoneNumber = phoneNumber.substring(1);

            System.out.println(String.format("current: %s", currentPerm));
            System.out.println(String.format("next digit: %s", nextDigit));
            System.out.println(String.format("remainingPhoneNumber: %s", remainingPhoneNumber));

            for (String c : keys.get(nextDigit)) {
                String nextPerm = currentPerm + c;
                rec(remainingPhoneNumber, nextPerm, results, targetSize);
            }
        }

        if (currentPerm.length() == targetSize) {
            results.add(currentPerm);
        }
    }
}
