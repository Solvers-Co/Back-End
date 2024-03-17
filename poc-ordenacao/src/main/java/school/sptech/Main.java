package school.sptech;

import java.time.LocalDate;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Publicacao posts[] = {
                new Publicacao("h1", "teste", 2, 3, LocalDate.of(2020,10,1)),
                new Publicacao("h2", "teste", 3, 2, LocalDate.of(2021,9,10)),
                new Publicacao("h3", "teste", 5, 4, LocalDate.of(2020,12,11)),
                new Publicacao("h4", "teste", 5, 7, LocalDate.of(2019,1,19))
        };
        Publicacao post = new Publicacao();

        post.publicacaoMaisRecente(posts);
    }
}