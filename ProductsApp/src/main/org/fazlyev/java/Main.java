import DAO.IngridientDAO;
import DAO.RecipeDAO;
import Models.RecipeCathegory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().addAnnotatedClass(IngridientDAO.class).addAnnotatedClass(RecipeDAO.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            RecipeDAO recipe1 = RecipeDAO.builder()
                    .category(RecipeCathegory.BREAKFAST)
                    .calories(100)
                    .kitchen("Russian")
            .build();


            IngridientDAO ingridient1= IngridientDAO.builder()
                    .name("Яичница")
                    .proteins(25)
                    .fat(10)
                    .carbonates(6)
                    .amount(3)
                    .measure("шт.")
                    .build();

            IngridientDAO ingridient2= IngridientDAO.builder()
                    .name("Хлеб")
                    .proteins(13)
                    .fat(20)
                    .carbonates(45)
                    .amount(1)
                    .measure("кусочек.")
                    .build();

            recipe1.setIngridientsDAOList(new ArrayList<>(List.of(ingridient1,ingridient2)));
            ingridient2.setRecipeDAOList(new ArrayList<>(Collections.singletonList(recipe1)));
            ingridient1.setRecipeDAOList(new ArrayList<>(Collections.singletonList(recipe1)));

            session.persist(recipe1);
            session.persist(ingridient1);
            session.persist(ingridient2);

            System.out.println(recipe1.getIngridientsDAOList());

//            пример связывания актеров и фильма
//            Movie movie = new Movie("Pulp Fiction", 1994);
//            Actor actor1 = new Actor("Ashot", 23);
//            Actor actor2 = new Actor("Sergo", 12);
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
//
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.persist(movie);
//            session.persist(actor1);
//            session.persist(actor2);

//            вывод списка актеров для фильма
/*            Movie movie = session.get(Movie.class, 1);
            System.out.println(movie.getActors());*/

//            добавление нового фильма и связывание его с существующим актером
 /*           Movie movie2 = new Movie("Friday_13",1980);
            Actor actor = session.get(Actor.class,2);

//            так как актер в Persistant состоянии (отслеживается Hibernate), то сохранять снова его не нужно
            actor.getMovies().add(movie2);
            movie2.setActors(new ArrayList<>(Collections.singletonList(actor)));
            session.persist(movie2);*/

//            удаление фильма у существующего актера
//            Actor actor =  session.get(Actor.class,1);
//            Movie movieToRemove = actor.getMovies().get(0);
//
//            actor.getMovies().remove(0);
//            movieToRemove.getActors().remove(actor);
//
            session.getTransaction().commit();
        }
    }
}
