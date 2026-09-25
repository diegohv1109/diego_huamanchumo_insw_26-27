import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import com.uem.Searcher;

public class SearcherTestCase {
    public Searcher searcher;

    @BeforeEach 

    public void setUp() {
       searcher = new Searcher();    
    }

    @Test 
    public void searchExactPhraseTest () {
        List<String> frases = List.of("Hola, me llamo Diego", "Buenos dias", "Buenas tardes", "Buenas noches");
        assertTrue(Searcher.searchExactPhrase("Hola, me llamo Diego", frases));
        assertFalse(Searcher.searchExactPhrase("No existe la frase", frases));
    }

    @Test 
    public void searchWordTest() {
        List<String> palabras = List.of("futbol", "balon", "cine", "ordenador");
        assertTrue(searcher.searchWord("futbol", palabras));
        assertFalse(searcher.searchWord("hola", palabras));
    }

    @Test 
    public void getWordByIndexTest() {
        List<String> palabrasIndice = List.of("hola", "colegio", "movil", "playa");
        assertEquals("colegio", searcher.getWordByIndex(palabrasIndice, 1));
    }

    @Test 
    public void searchByPrefixTest() {
        List<String> palabrasPre = List.of("Diego", "Pablo", "Marcos", "Javier");
        assertEquals(List.of("Diego"), searcher.searchByPrefix("Di", palabrasPre));
    }

    @Test 
    public void filterByKeywordTest() {
        List<String> palabrasKey = List.of("caballo", "camello", "caracol", "colonia", "perro", "escalera");
        assertEquals(List.of("caballo", "camello", "caracol", "escalera"), searcher.filterByKeyword("ca", palabrasKey));
    }
}
