module com.aks.stick_hero_ap {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.aks.stick_hero_ap to javafx.fxml;
    exports com.aks.stick_hero_ap;
}