package ex06;

import java.util.ArrayList;
import java.util.List;

import ex06.entities.Language;

public class TestLanguage {
    public static void main(String[] args) {
        List<Language> linguagens = new ArrayList<Language>();
        linguagens.add(new Language());
        linguagens.add(new Language(8.0f));
        linguagens.add(new Language("C#"));
        linguagens.add(new Language("EcmaScript", 6f));
        linguagens.add(new Language("Python", 3.10f));
        linguagens.forEach((lang) -> {
            System.out.print(lang);
    });
    }
}
