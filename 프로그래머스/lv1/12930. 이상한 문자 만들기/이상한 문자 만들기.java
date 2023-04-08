class Solution {
         public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] card = s.split(" ", -1);
        String[] cardgroup;
        String[] returngroup = new String[card.length];

        for (int i = 0; i < card.length; i++) {
            cardgroup = card[i].split("");
            for (int j = 0; j < cardgroup.length; j++) {
                if (j % 2 == 0) {
                    answer.append(cardgroup[j].toUpperCase());
                } else {
                    answer.append(cardgroup[j].toLowerCase());
                }
            }
            returngroup[i] = answer.toString();
            answer = new StringBuilder();
        }

        for (int k = 0; k < returngroup.length; k++) {
            if (k == 0) {
                answer.append(returngroup[k]);
            } else {
                answer.append(" ").append(returngroup[k]);
            }
        }
        return answer.toString();
    }
}