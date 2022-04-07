# Betrayal Stats Helper

"Betrayal at the House on the Hill" is a boardgame played with 3-6 players. Every player has his own character with a name and stats with different values. Initially the players try to explore the house on the hill. The floor of the mansion will expand with player turns and events will happen. These events lead to character stat changes. After certain requirements are met, the next phase will be initiated: the Haunt appears. One of the players get's Haunted (by the house?) and betrays the other players. The game is then continued with a new set of rules for both the Haunt and the Survivors based on certain variables.

This app will help track your characters stats during the game.
(Since the original stat trackers have been slightly unpractical in multiple ways)

## Starting the app

To start the (front end of the) app you will need Node.js installed and use the following commands in a terminal:

```
cd client
```

```
npm install
```

```
npm run dev
```

A Gradle wrapper is able to start the backend. The following command should be used in a separate terminal:

```
./gradlew run
```

Right now the app loads and saves characters from a local mySQL database. This one is not initiated locally and can be made by importing the files provided in .......
A future improvement I am working on is to set up the database automatically.
