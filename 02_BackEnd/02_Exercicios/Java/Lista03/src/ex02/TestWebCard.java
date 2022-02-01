package ex02;

import java.util.ArrayList;
import java.util.List;

import ex02.entities.BirthdayCard;
import ex02.entities.ChristmasCard;
import ex02.entities.ValentinesDayCard;
import ex02.entities.WebCard;

public class TestWebCard {
    public static void main(String[] args) {
        List<WebCard> webCards = new ArrayList<WebCard>();
        String addressee = "Lucas";
        webCards.add(new ValentinesDayCard(addressee));
        webCards.add(new ChristmasCard(addressee));
        webCards.add(new BirthdayCard(addressee));

        for(WebCard webCard : webCards){
            webCard.showMessage();
        }
    }
}
