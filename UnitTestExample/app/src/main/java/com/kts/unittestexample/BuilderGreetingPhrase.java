package com.kts.unittestexample;

public class BuilderGreetingPhrase {

    Phrases phrases;

    BuilderGreetingPhrase (Phrases phrases){
        this.phrases = phrases;
    }

    String get(){
        return phrases.getHello();
    }

    String get(int hour){
        if (hour >= 3 && hour <= 11){
            return phrases.getMorning();
        }else if (hour >= 12 && hour <= 16){
            return phrases.getAfternoon();
        } else if (hour >= 17 && hour <= 23){
            return phrases.getEvening();
        } else return phrases.getNight() ;

    }
}
