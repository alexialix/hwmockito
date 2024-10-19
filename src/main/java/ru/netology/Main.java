package ru.netology;

public class Main {
    public static void main(String[] args) {
        MovieManager manager = new MovieManager();

        // Добавление фильмов
        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель «Белград»");

        // Получение всех фильмов
        System.out.println("Все фильмы:");
        for (String movie : manager.findAll()) {
            System.out.println(movie);
        }

        // Удаление фильма по индексу
        manager.removeById(1); // Удаление "Вперёд"

        // Получение последних добавленных фильмов
        System.out.println("\nПоследние фильмы:");
        for (String movie : manager.findLast()) {
            System.out.println(movie);
        }
    }
}
