# MauchienWurtz_CPOA_2020
Projet CPOA IUT Metz 2020/2021

Lien Trello :
https://trello.com/b/0b4I5POB/projet-cpoa

Pour les TD, nous avons utilisées JDK 15 et JavaFX 15
Pour installer JavaFX15:
  -télécharger JavaFX15 dans la section "Latest Release" : https://gluonhq.com/products/javafx/
  -installation sur Eclipse : Window -> Preferences -> Java -> Build Path -> User Libraries -> New "javafx-15" puis Add External JARs et ajouter les jars du /bin dans le fichier JavaFX15
  -Ajout au projet : clique-droit -> Properties -> Java Build Path -> Libraries -> Modulepath -> Add Library -> User Library -> javafx-15
  -Lancement : Run -> Run Configurations -> Arguments -> VM arguments -> copier-coller :
  --module-path"C:\Program Files\Java\javafx-sdk-15\lib" --addmodules=javafx.controls,javafx.fxml
  (Mettez votre propre chemins d'accès)
