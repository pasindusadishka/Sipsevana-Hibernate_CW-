


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = getClass().getResource("view/DashBordForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dashboard");
        primaryStage.show();
    }


    /*public static void main(String[] args) {
        Programs entity=new Programs();

        entity.setId("P-005");
        entity.setProgram("sdadad");
        entity.setDuration("sada");
        entity.setFee(63464);

        *//*Session session = FactoryConfiguration.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();*//*

        Session session = FactoryConfiguration.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        List<Registration> list=null;
        Query registration = session.createQuery("from Registration order by regNo DESC ");
        list=registration.getResultList();
        System.out.println(list.isEmpty());
        System.out.println(list);
        transaction.commit();
        session.close();
    }*/

}


/*
* hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
hibernate.connection.driver_class=com.mysql.cj.jdbc.Driver
hibernate.connection.url=jdbc:mysql://localhost:3306/sipsevana
hibernate.connection.username=root
hibernate.connection.password=1234
hibernate.show_sql=true
hibernate.hbm2ddl.auto=update*/