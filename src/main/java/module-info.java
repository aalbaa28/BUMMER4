module ehu.eus.bummer4 {

    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires okhttp3;
    requires com.google.gson;
    requires javafx.web;

    opens ehu.eus.bummer4.domain to com.google.gson;
    exports ehu.eus.bummer4.domain;
    exports ehu.eus.bummer4;
    opens ehu.eus.bummer4 to javafx.fxml;


}