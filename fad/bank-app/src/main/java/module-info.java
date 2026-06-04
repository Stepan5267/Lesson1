module ru.zelmex.bankapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.desktop;
    requires org.hibernate.validator;
    requires org.postgresql.jdbc;
    requires jakarta.validation;

    opens ru.zelmex.bankapp to javafx.fxml;
    opens ru.zelmex.bankapp.model to org.hibernate.orm.core, javafx.base;
    exports ru.zelmex.bankapp;
    exports ru.zelmex.bankapp.controller.user;
    opens ru.zelmex.bankapp.controller.user to javafx.fxml;
    opens ru.zelmex.bankapp.util to org.hibernate.orm.core;
    exports ru.zelmex.bankapp.controller.exercise;
    opens ru.zelmex.bankapp.controller.exercise to javafx.fxml;
    exports ru.zelmex.bankapp.controller.record;
}