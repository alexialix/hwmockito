package ru.netology;

public class MovieManager {
    private String[] movies = new String[0]; // Хранение фильмов
    private int limit; // Лимит для последних фильмов

    // Конструктор по умолчанию с лимитом в 5 фильмов
    public MovieManager() {
        this.limit = 5;
    }

    // Конструктор с возможностью задания лимита
    public MovieManager(int limit) {
        this.limit = limit;
    }

    // Метод для добавления нового фильма
    public void add(String movie) {
        String[] tmp = new String[movies.length + 1];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    // Метод для получения всех фильмов в порядке добавления
    public String[] findAll() {
        return movies;
    }

    // Метод для получения последних фильмов в обратном порядке (с учетом лимита)
    public String[] findLast() {
        int resultLength = Math.min(movies.length, limit);
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }

    // Метод для удаления фильма по индексу
    public void removeById(int id) {
        if (id < 0 || id >= movies.length) {
            throw new IllegalArgumentException("Индекс вне диапазона");
        }
        String[] tmp = new String[movies.length - 1];
        int copyToIndex = 0;
        for (int i = 0; i < movies.length; i++) {
            if (i != id) {
                tmp[copyToIndex] = movies[i];
                copyToIndex++;
            }
        }
        movies = tmp;
    }
}
