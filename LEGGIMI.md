# Geda Industry

Mod tecnologica Fabric per Minecraft Java 26.3 (Java 25+), ispirata a Immersive Engineering e Thermal Expansion.
Il piano completo è in `CLAUDE.md`.

## Cosa c'è ora
**Tappa 1 – metalli**
- Stagno: minerale (normale e di ardesia, tra Y -32 e 96), grezzo, lingotto, pepita, polvere, blocchi.
- Acciaio: lingotto, pepita, blocco. Per ora si fa nell'altoforno partendo da un lingotto di ferro.

**Tappa 2 – attrezzi e componenti**
- **Martello da ingegnere**: martello + lingotto = piastra; martello + metallo grezzo = polvere.
  Resta nella griglia e perde 1 di durabilità a ogni uso (128 usi).
- **Tagliafili**: tagliafili + piastra = 2 fili (rame, oro, acciaio).
- **Bacchette**: 2 lingotti in colonna = 4 bacchette (ferro, acciaio).
- **Ingranaggi**: 4 piastre attorno a una bacchetta (ferro, bronzo, acciaio).
- **Bronzo**: 3 polvere di rame + 1 polvere di stagno = 4 polvere di bronzo, poi in fornace.
- Polveri di ferro, rame, oro, stagno, bronzo: in fornace tornano lingotti.

Tutto si trova nella scheda creativa "Geda Industry".

## Come provarla
1. Apri questa cartella con IntelliJ IDEA (File > Open).
2. Nel pannello Gradle a destra fai doppio clic su `Tasks > fabric > runClient`.

Da terminale: `.\gradlew.bat runClient` per provarla, `.\gradlew.bat build` per creare il .jar in `build/libs/`.
