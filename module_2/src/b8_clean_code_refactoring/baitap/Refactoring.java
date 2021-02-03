package b8_clean_code_refactoring.baitap;

class TennisGame {
    static String getPlayerResult(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Deuce";
        }
    }

    public static String getTotalResult(String firstPlayerName, String secondPlayerName,
                                        int firstPlayerScore, int secondPlayerScore) {
        String totalResult = "";

        if (firstPlayerScore == secondPlayerScore) {
            totalResult = getPlayerResult(firstPlayerScore);
            if (firstPlayerScore < 4) totalResult += "-All";
        } else if (firstPlayerScore >= 4 || secondPlayerScore >= 4) {
            int differentScore = firstPlayerScore - secondPlayerScore;
            if (differentScore == 1) totalResult = "Advantage player1";
            else if (differentScore == -1) totalResult = "Advantage player2";
            else if (differentScore >= 2) totalResult = "Win for player1";
            else totalResult = "Win for player2";
        } else {
            String firstPlayerResult = getPlayerResult(firstPlayerScore);
            String secondPlayerResult = getPlayerResult(secondPlayerScore);
            totalResult = firstPlayerResult + "-" + secondPlayerResult;
        }
        return totalResult;
    }
}


public class Refactoring {
    public static void main(String[] args) {
        TennisGame game = new TennisGame();
        System.out.println(game.getTotalResult("Code", "Gym",
                3, 3));
    }
}
