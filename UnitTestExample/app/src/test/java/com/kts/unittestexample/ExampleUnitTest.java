package com.kts.unittestexample;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    private Phrases phrasesStub = mock(Phrases.class);

    public ExampleUnitTest() {
        when(phrasesStub.getEvening()).thenReturn("Good evening");
        when(phrasesStub.getAfternoon()).thenReturn("Good afternoon");
        when(phrasesStub.getHello()).thenReturn("Good day");
        when(phrasesStub.getMorning()).thenReturn("Good morning");
        when(phrasesStub.getNight()).thenReturn("Good night");


    }

    @Test
    public void BuilderGreetingPhrase_get_test() {
        BuilderGreetingPhrase builderGreetingPhrase = new BuilderGreetingPhrase(phrasesStub);
        assertEquals("Good day", builderGreetingPhrase.get());
    }

    @Test
    public void BuilderGreetingPhrase_getMorning_test() {
        BuilderGreetingPhrase builderGreetingPhrase = new BuilderGreetingPhrase(phrasesStub);
        assertEquals("Good morning", builderGreetingPhrase.get(3));
        assertEquals("Good morning", builderGreetingPhrase.get(11));
    }

    @Test
    public void BuilderGreetingPhrase_getEvening_test() {
        BuilderGreetingPhrase builderGreetingPhrase = new BuilderGreetingPhrase(phrasesStub);
        assertEquals("Good evening", builderGreetingPhrase.get(17));
        assertEquals("Good evening", builderGreetingPhrase.get(23));
    }

    @Test
    public void BuilderGreetingPhrase_getAfternoon_test() {
        BuilderGreetingPhrase builderGreetingPhrase = new BuilderGreetingPhrase(phrasesStub);
        assertEquals("Good afternoon", builderGreetingPhrase.get(12));
        assertEquals("Good afternoon", builderGreetingPhrase.get(16));
    }

    @Test
    public void BuilderGreetingPhrase_getNight_test() {
        BuilderGreetingPhrase builderGreetingPhrase = new BuilderGreetingPhrase(phrasesStub);
        assertEquals("Good night", builderGreetingPhrase.get(24));
        assertEquals("Good night", builderGreetingPhrase.get(2));
        assertEquals("Good night", builderGreetingPhrase.get(0));
    }
}