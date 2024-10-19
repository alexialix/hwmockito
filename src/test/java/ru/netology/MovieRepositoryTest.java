package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieRepositoryTest {

    private MovieManager manager;

    @BeforeEach
    public void setUp() {
        manager = new MovieManager();
    }

    @Test
    public void testAddAndFindAll() {
        // Добавляем фильмы
        manager.add("Бладшот");
        manager.add("Вперёд");
        String[] expected = {"Бладшот", "Вперёд"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testFindLast() {
        // Добавляем фильмы
        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель «Белград»");
        String[] expected = {"Отель «Белград»", "Вперёд", "Бладшот"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testFindLastWithLimit() {
        // Создаем менеджера с лимитом
        manager = new MovieManager(2);
        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель «Белград»");
        String[] expected = {"Отель «Белград»", "Вперёд"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testRemoveById() {
        // Добавляем фильмы и удаляем один из них
        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.removeById(0);
        String[] expected = {"Вперёд"};
        assertArrayEquals(expected, manager.findAll());
    }

    // Пример использования Mockito (если необходимо имитировать внешние зависимости)
    @Test
    public void testMocking() {
        MovieManager mockManager = Mockito.mock(MovieManager.class);

        // Настройка поведения мока
        Mockito.when(mockManager.findAll()).thenReturn(new String[]{"Тестовый фильм"});

        // Проверка, что возвращает мок
        assertArrayEquals(new String[]{"Тестовый фильм"}, mockManager.findAll());
    }
}


