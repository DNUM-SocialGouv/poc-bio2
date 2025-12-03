1) Création de l'image Docker, à la racine du projet : 

docker build -t poc-bio2 .

   
2) Les variables d'environnement suivantes sont nécessaires pour les étapes suivantes :

PRO_SANTE_CONNECT_CLIENT_ID
PRO_SANTE_CONNECT_CLIENT_SECRET


3) Lancement du container avec les valeurs suivantes 

- PRO_SANTE_CONNECT_CLIENT_ID=XXX
- PRO_SANTE_CONNECT_CLIENT_SECRET=YYY
   
docker run -d -p 8080:8080 -e PRO_SANTE_CONNECT_CLIENT_ID=XXX -e PRO_SANTE_CONNECT_CLIENT_SECRET=YYY poc-bio2


4) Le endpoint "actuator" est disponible sur :

/actuator/health


5) Le point d'entrée pour tester PSC est sur :

/psc/link
