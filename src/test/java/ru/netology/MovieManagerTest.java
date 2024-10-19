package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private MovieManager manager;

    @BeforeEach
    public void setUp() {
        manager = new MovieManager();
    }

    @Test
    public void testAddAndFindAll() {
        manager.add("Бладшот");
        manager.add("Вперёд");
        String[] expected = {"Бладшот", "Вперёд"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testFindLast() {
        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель «Белград»");
        String[] expected = {"Отель «Белград»", "Вперёд", "Бладшот"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testFindLastWithLimit() {
        manager = new MovieManager(2);
        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель «Белград»");
        String[] expected = {"Отель «Белград»", "Вперёд"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testRemoveById() {
        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.removeById(0);
        String[] expected = {"Вперёд"};
        assertArrayEquals(expected, manager.findAll());
    }
}
