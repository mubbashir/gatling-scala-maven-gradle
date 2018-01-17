# gatling demo with both maven and gradle

* Simple showcase of gatling which cane build by either maven or gradle

## Gradle

To test it out using gadle, simply execute the following command to specify a Simulation
    ```bash
    $  ./gradlew gatlingRun-com.test.computerdatabase.BasicSimulation
    ```
or simply: `./gradlew gatlingRun`

### Reports (via gradle)

Open `build/reports/gatling/${SIMULATION_TIMESTAMP}/index.html`

![smaple report](./doc_resources/gatling_report.jpg "Sample Report")

## Maven

To test it out using maven, simply execute the following command to specify a Simulation
    ```bash
    $mvn gatling:test -Dgatling.simulationClass=computerdatabase.BasicSimulation
    ```
or simply: `$mvn gatling:test`

### Reports (via maven)

Open `target/gatling/results//${SIMULATION_TIMESTAMP}/index.html`

## Virtual User setting

Currently it's specified within [simulation itsel](./src/test/gatling/simulations/com/test/computerdatabase/BasicSimulation.scala)