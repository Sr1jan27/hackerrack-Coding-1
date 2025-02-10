import java.util.*;

public class ProductSuggestion {

    public static List<List<String>> getProductSuggestions(List<String> products, String search) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        
        // Convert list to array, sort it, and maintain the product list
        Collections.sort(products);
        
        for (int i = 0; i < products.size(); i++) {
            map.put(products.get(i), i);
        }

        String key = "";
        for (char c : search.toCharArray()) {
            key += c;
            String ceiling = map.ceilingKey(key);
            String floor = map.floorKey(key + "~");
            if (ceiling == null || floor == null) break;
            res.add(products.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }

        while (res.size() < search.length()) res.add(new ArrayList<>());
        
        return res;
    }
}





// Question 

// For an array of n strings products and a word to search, search, design a system that, when each character of the searched word is typed, suggests at most three product names from the products array. The suggested products should share a common prefix with the searched word. If more than three products exist with a common prefix, report the three product names that appear first in lexicographical order.

// Return the suggested products, which will be a list of lists after each character of the searched word is typed.

// Note: A string x is considered lexicographically smaller than another string y if x will occur before y in the English dictionary.

// Example

// Suppose n = 5, products = ["carpet", "cart", "car", "camera", "crate"], and search = "camera".

// Search Prefix

// C

// Matches

// Lexicographically