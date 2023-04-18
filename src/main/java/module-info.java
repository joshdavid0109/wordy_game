module com.java.fingrp7_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.xml.crypto;
    requires java.sql;
    requires rt;

    opens com.java.fingrp7_java to javafx.fxml;
    exports com.java.fingrp7_java;
}