//At a lemonade stand, each lemonade costs $5.
//
// Customers are standing in a queue to buy from you, and order one at a time (i
//n the order specified by bills).
//
// Each customer will only buy one lemonade and pay with either a $5, $10, or $2
//0 bill. You must provide the correct change to each customer, so that the net tr
//ansaction is that the customer pays $5.
//
// Note that you don't have any change in hand at first.
//
// Return true if and only if you can provide every customer with correct change
//.
//
//
//
//
// Example 1:
//
//
//Input: [5,5,5,10,20]
//Output: true
//Explanation:
//From the first 3 customers, we collect three $5 bills in order.
//From the fourth customer, we collect a $10 bill and give back a $5.
//From the fifth customer, we give a $10 bill and a $5 bill.
//Since all customers got correct change, we output true.
//
//
//
// Example 2:
//
//
//Input: [5,5,10]
//Output: true
//
//
//
// Example 3:
//
//
//Input: [10,10]
//Output: false
//
//
//
// Example 4:
//
//
//Input: [5,5,10,10,20]
//Output: false
//Explanation:
//From the first two customers in order, we collect two $5 bills.
//For the next two customers in order, we collect a $10 bill and give back a $5
//bill.
//For the last customer, we can't give change of $15 back because we only have t
//wo $10 bills.
//Since not every customer received correct change, the answer is false.
//
//
//
//
// Note:
//
//
// 0 <= bills.length <= 10000
// bills[i] will be either 5, 10, or 20.
//
//
//
//
//
// Related Topics Greedy


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // not Map, not switch
/*    Success:
    Runtime:3 ms, faster than 26.93% of Java online submissions.
    Memory Usage:47.9 MB, less than 12.91% of Java online submissions.*/
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    // no Map, but switch
/*    Success:
    Runtime:3 ms, faster than 26.93% of Java online submissions.
    Memory Usage:48.3 MB, less than 5.27% of Java online submissions.*/
/*    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            switch(bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    if (five == 0) return false;
                    five--;
                    ten++;
                    break;
                case 20:
                    if (ten > 0 && five > 0) {
                        five--;
                        ten--;
                    } else if (five > 2) {
                        five = five - 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }*/


//used Map and switch
/*    Success:
    Runtime:12 ms, faster than 9.47% of Java online submissions.
    Memory Usage:40.6 MB, less than 38.05% of Java online submissions.*/
/*    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> cashier = new HashMap<>();
        cashier.put(5, 0);
        cashier.put(10, 0);
        cashier.put(20, 0);
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    cashier.put(5, cashier.get(5) + 1);
                    break;
                case 10:
                    if (cashier.get(5) > 0) {
                        cashier.put(10, cashier.get(10) + 1);
                        cashier.put(5, cashier.get(5) - 1);
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (cashier.get(10) > 0 && cashier.get(5) > 0) {
                        cashier.put(20, cashier.get(20) + 1);
                        cashier.put(10, cashier.get(10) - 1);
                        cashier.put(5, cashier.get(5) - 1);
                    }
                    else if (cashier.get(5) > 2) {
                        cashier.put(20, cashier.get(20) + 1);
                        cashier.put(5, cashier.get(5) - 3);
                    }
                    else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
