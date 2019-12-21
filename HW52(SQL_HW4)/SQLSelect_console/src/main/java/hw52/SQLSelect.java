package hw52;

import java.sql.*;

public class SQLSelect {
    public static void main(String[] args) {
        String connString = "jdbc:mysql://localhost/movies?serverTimezone=Europe/Kiev&characterEncoding=utf8";
        String user = "root";
        String DbPassword = "";
        try (Connection conn = DriverManager.getConnection(connString, user, DbPassword)) {

            Statement stmt = conn.createStatement();
            System.out.println("Содержание таблицы 'Фильмы':");
            ResultSet resultSet = stmt.executeQuery("SELECT movies.movie_id, director_id, title, release_year, rating, plot, movie_length from movies.movies");
            printSet(resultSet);

            System.out.println();
            System.out.println("Содержание таблицы 'Фильмы', отсортированное по названию (в порядке возрастания):");
            resultSet = stmt.executeQuery("SELECT movies.movie_id, director_id, title, release_year, rating, plot, movie_length from movies.movies order by title");
            printSet(resultSet);

            System.out.println();
            System.out.println("Содержание таблицы 'Фильмы', отсортированное по названию (в порядке убывания):");
            resultSet = stmt.executeQuery("SELECT movies.movie_id, director_id, title, release_year, rating, plot, movie_length from movies.movies order by title desc");
            printSet(resultSet);

            System.out.println();
            System.out.println("Содержание таблицы 'Фильмы', отсортированное по году выпуска (в порядке возрастания):");
            resultSet = stmt.executeQuery("SELECT movies.movie_id, director_id, title, release_year, rating, plot, movie_length from movies.movies order by release_year");
            printSet(resultSet);

            System.out.println();
            System.out.println("Содержание таблицы 'Фильмы', отсортированное по году выпуска (в порядке убывания):");
            resultSet = stmt.executeQuery("SELECT movies.movie_id, director_id, title, release_year, rating, plot, movie_length from movies.movies order by release_year desc");
            printSet(resultSet);

            System.out.println();
            System.out.println("Содержание таблицы 'Фильмы', отсортированное по рейтингу (в порядке возрастания):");
            resultSet = stmt.executeQuery("SELECT movies.movie_id, director_id, title, release_year, rating, plot, movie_length from movies.movies order by rating");
            printSet(resultSet);

            System.out.println();
            System.out.println("Содержание таблицы 'Фильмы', отсортированное по рейтингу (в порядке убывания):");
            resultSet = stmt.executeQuery("SELECT movies.movie_id, director_id, title, release_year, rating, plot, movie_length from movies.movies order by rating desc");
            printSet(resultSet);

            System.out.println();
            System.out.println("Фильмы, выпущенные в прошлом году:");
            resultSet = stmt.executeQuery("SELECT movies.movie_id, director_id, title, release_year, rating, plot, movie_length from movies.movies where release_year = year(now())-1");
            printSet(resultSet);

            System.out.println();
            System.out.println("Фильмы с жанром 'комедия':");
            resultSet = stmt.executeQuery("select * from movies.movies join movies.movies_genres  on movies.movie_id = movies_genres.movie_id join movies.genres g on movies_genres.genre_id = g.genre_id where genre_name like 'комедия'");
            printSet(resultSet);

            System.out.println();
            System.out.println("Фильмы, в которых играла Софи Лорен:");
            resultSet = stmt.executeQuery("select * from movies.movies join movies.movies_actors on movies.movie_id = movies_actors.movie_id join movies.actors on movies_actors.actor_id = actors.actor_id where first_name like 'Софи' and last_name like 'Лорен'");
            printSet(resultSet);

            System.out.println();
            System.out.println("Фильмы, продюссером которых является Стивен Спилберг:");
            resultSet = stmt.executeQuery("select * from movies.movies join movies.directors on movies.director_id = directors.director_id where first_name like 'Стивен' and last_name like 'Спилберг'");
            printSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printSet(ResultSet resultSet) throws SQLException {
        System.out.format("|%s|%s| %30s | %4s |%s| %30s | %s |\n", "Код фильма", "Продюссер", "Название фильма", "Год", "Рейтинг", "Сюжет", "Длительность");
        while (resultSet.next()) {
            System.out.format("| %8d | %7d | %30s | %4d | %5d | %30s | %12s |\n",
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getTime(7));
        }
    }
}
