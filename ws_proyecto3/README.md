# Proyecto Parcial 3 - Batallas  Pokemon

Instrucciones para clonar el proyecto y correrlo:

1. **Clonar** el repositorio (ws_proyecto3) con Git:
```
git clone --no-checkout https://github.com/AngMolGo/MPOO_2024_2 temp-repo
cd temp-repo/
git sparse-checkout init --cone
git sparse-checkout set ws_proyecto3
git checkout main
mv ws_proyecto3 ../angmolgo_ws_proyecto3
cd ..
rm -rf temp-repo/
```
2. **Correr** el programa:
```
cd angmolgo_ws_proyecto3
javac *.java src/*/*.java -d bin/
java -cp bin Proyecto3