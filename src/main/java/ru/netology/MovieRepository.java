package ru.netology;

public class MovieRepository {
    private String[] movies = new String[0];

    // Метод для сохранения нового фильма
    public void save(String movie) {
        String[] tmp = new String[movies.length + 1];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    // Метод для удаления фильма по идентификатору (индексу)
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

    // Метод для получения всех фильмов
    public String[] getMovies() {
        return movies;
    }
}



