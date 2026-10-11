# Geda Industry — piano della mod

Mod tecnologica per Minecraft Java, ispirata a Immersive Engineering e Thermal Expansion.
**Obiettivo finale:** partire a mani nude e arrivare, un passo alla volta, a una fabbrica capace di
produrre in modo massivo e automatico **qualsiasi oggetto del gioco**.

Questo file è la mappa del progetto: ogni nuova funzione va prima inserita qui, poi costruita.
Lingua del progetto: italiano (nomi nel gioco in `it_it.json` e `en_us.json`, id in inglese).

---

## 1. Principi di design

1. **Progressione a ere.** Ogni era sblocca la successiva: le macchine di un'era si costruiscono con
   i materiali prodotti dall'era precedente. Niente scorciatoie che saltano un'era.
2. **Ogni processo ha una versione migliore.** Quello che si fa a mano si può poi fare con una macchina,
   poi più velocemente, poi in parallelo, poi senza nessun intervento.
3. **Resa crescente.** Minerale nel forno = 1 lingotto. Frantumatore = 2. Lavatrice + frantumatore = 3.
   Dissolutore chimico = 4. Vale sempre la pena salire di livello.
4. **Tutto automatizzabile.** Ogni macchina accetta oggetti, fluidi ed energia da qualsiasi lato
   (configurabile con la chiave inglese), così si possono collegare in catene.
5. **Compatibilità.** Usare i tag convenzionali `c:` (es. `c:ingots/tin`) così le nostre macchine
   lavorano anche i metalli di altre mod, e viceversa.
6. **Leggibile per chi impara.** Codice semplice, commenti in italiano, una classe per concetto.

---

## 2. Le ere (progressione)

| Era | Nome | Fonte di energia | Cosa sblocca |
|---|---|---|---|
| 0 | **Manuale** | braccia | metalli base, martello, piastre e polveri a mano |
| 1 | **Fornaci** | carbone | altoforno (acciaio), forno a coke, prime leghe |
| 2 | **Vapore e carbone** | combustione | frantumatore, pressa, fonderia di leghe a carbone |
| 3 | **Elettrica** | energia (GE) | generatori, cavi, batterie, macchine elettriche |
| 4 | **Industriale** | energia + fluidi | nastri, tubi, scavatrice, raffineria, plastica, upgrade |
| 5 | **Automazione** | rete | magazzino digitale, autocrafting con schemi |
| 6 | **Fabbrica di massa** | grandi generatori | multiblocchi paralleli, macchine ad alta velocità |
| 7 | **Materia** | reattore | scompositore di materia, scanner, **replicatore** |

L'era 7 è il traguardo: il **Replicatore** produce qualsiasi oggetto già scansionato,
consumando *Materia* ed energia. La Materia si ottiene scomponendo oggetti di scarto.

---

## 3. Minerali e materiali

### 3.1 Minerali nuovi
| Minerale | Altezza (Y) | Rarità | Uso principale | Stato |
|---|---|---|---|---|
| Stagno | -32 → 96 | comune | bronzo, circuiti, latta | ✅ fatto |
| Piombo | -48 → 32 | comune | batterie, schermature, munizioni | ⏳ |
| Argento | -64 → 16 | medio | elettro, circuiti avanzati | ⏳ |
| Nichel | -32 → 48 | medio | invar, costantana | ⏳ |
| Bauxite | 32 → 128 (montagne) | comune | alluminio (cavi, telai leggeri) | ⏳ |
| Uranio | -64 → -16 | raro | reattore (era 6-7) | ⏳ |
| Iridio | -64 → -48 (ardesia) | molto raro | componenti endgame | ⏳ |

Più i minerali vanilla: ferro, rame, oro, carbone, redstone, lapislazzuli, diamante, smeraldo, quarzo.

### 3.2 Forme di ogni metallo
Per ogni metallo (nostro o vanilla): **grezzo, lingotto, pepita, polvere, polvere sporca, piastra,
ingranaggio, bacchetta, filo, blocco, blocco grezzo**. Si generano tutte con lo stesso schema in codice
(una lista di metalli → tutti gli oggetti, texture ricolorate, ricette e tag).

### 3.3 Leghe
| Lega | Ingredienti | Uso |
|---|---|---|
| Acciaio ✅ | ferro + carbone/coke (altoforno) | struttura di tutte le macchine |
| Bronzo ✅ | 3 polvere di rame + 1 polvere di stagno = 4 polvere di bronzo (poi fornace) | ingranaggi era 1-2 |
| Invar | 2 ferro + 1 nichel | componenti termici |
| Elettro | oro + argento | cavi e circuiti avanzati |
| Costantana | rame + nichel | resistenze, bobine |
| Acciaio inox / Titanio rinforzato | era 5+ | macchine veloci |

### 3.4 Materiali speciali
- **Coke** e **creosoto** (forno a coke).
- **Silicio** (dalla sabbia, era 3) → wafer → circuiti.
- **Plastica** (dal petrolio, era 4).
- **Materia** (era 7), unità base per replicare.

---

## 4. Blocchi

- **Minerali e blocchi di metallo** (sezione 3).
- **Blocchi strutturali:** telaio di macchina (base / avanzato / elite), lamiera d'acciaio,
  impalcatura, cemento armato, vetro rinforzato.
- **Macchine** (sezione 6), ognuna un blocco con inventario, interfaccia e lati configurabili.
- **Multiblocchi:** altoforno, forno a coke, grande fonderia, raffineria, reattore. Si costruiscono
  con blocchi strutturali e si attivano col martello, come in Immersive Engineering.

---

## 5. Attrezzi e oggetti utili

| Oggetto | Era | Funzione |
|---|---|---|
| Martello da ingegnere | 0 | in crafting: lingotto → piastra, minerale → polvere; attiva i multiblocchi |
| Tagliafili | 0 | in crafting: piastra → filo |
| Chiave inglese | 1 | ruota le macchine, configura i lati, le smonta senza perdere il contenuto |
| Attrezzi in bronzo e acciaio | 1 | piccone, ascia, pala, spada, zappa |
| Multimetro | 3 | mostra energia e stato di macchine e cavi |
| Trapano e motosega elettrici | 3 | attrezzi a energia, si ricaricano |
| Zaino a batteria / jetpack | 4 | trasporto ed esplorazione |
| Scanner portatile | 7 | registra un oggetto per il replicatore |

---

## 6. Macchine

Ogni macchina esiste in più livelli (base → avanzata → elite → ultimate) che cambiano velocità,
consumo e numero di operazioni in parallelo. Le ricette di ogni macchina sono file JSON in
`data/gedaindustry/recipe/`, così si aggiungono senza toccare il codice.

### Lavorazione dei minerali
- **Frantumatore** — minerale → 2 polveri (+ sottoprodotto raro).
- **Lavatrice** — polvere sporca → polvere pulita (+ fanghi), resa ×3.
- **Dissolutore chimico** — minerale → resa ×4 (era 5).
- **Fornace elettrica** — come la fornace, ma veloce e automatizzabile.
- **Fonderia di leghe** — 2-3 ingredienti → lega.

### Lavorazione dei pezzi
- **Pressa** — lingotto → piastra / ingranaggio / bacchetta (con stampi).
- **Trafila** — piastra → fili.
- **Assemblatore di circuiti** — componenti → circuiti.
- **Centrifuga** — separa i sottoprodotti.
- **Estrattore** — gomma dagli alberi, liquidi dagli oggetti.

### Agricoltura e risorse automatiche
- **Scavatrice (quarry)** — scava un'area e raccoglie tutto.
- **Coltivatore** e **raccoglitore** automatici, **allevatore**, **taglialegna**.
- **Pompa** e **generatore di acqua/lava/pietra**.

### Fabbrica di massa (era 5-7)
- **Assemblatore automatico** — esegue una ricetta di crafting da uno **schema**, all'infinito.
- **Magazzino digitale** — tiene milioni di oggetti in pochi blocchi, con un terminale per cercarli.
- **Gestore ordini** — chiedi "100 circuiti" e la fabbrica calcola e produce tutti i passaggi.
- **Scompositore di materia** — trasforma qualsiasi oggetto in Materia.
- **Scanner** — registra un oggetto e calcola quanta Materia serve per crearlo.
- **Replicatore** — crea qualsiasi oggetto scansionato da Materia + energia.

---

## 7. Energia, logistica e fluidi

- **Unità di energia:** GE (Geda Energy). Per compatibilità con altre mod usare l'API energetica
  standard di Fabric (Team Reborn Energy) quando arriveremo all'era 3.
- **Generatori:** a combustione (carbone, legna), geotermico (lava), solare, eolico, a vapore,
  reattore a uranio (era 6), reattore a fusione (era 7).
- **Cavi** in 4 livelli (rame, oro/elettro, alluminio isolato, superconduttore) con capacità crescente.
- **Batterie** e banchi di accumulo.
- **Logistica oggetti:** nastri trasportatori (era 2-3, visibili come in Immersive Engineering),
  tubi di oggetti con filtri e ordinamento (era 4), rete digitale (era 5).
- **Fluidi:** tubi, serbatoi, pompe. Fluidi propri: creosoto, petrolio, carburante, acido, Materia liquida.

---

## 8. Logiche di funzionamento (codice)

- **Macchina base:** una classe astratta comune (`AbstractMachineBlockEntity`) con inventario,
  buffer di energia, progresso, slot di upgrade, configurazione dei lati. Ogni macchina la estende
  e definisce solo la sua ricetta.
- **Tipi di ricetta:** ogni macchina ha il suo `RecipeType` e serializzatore, letti dai JSON.
- **Upgrade:** velocità, efficienza energetica, parallelo (più operazioni insieme), capacità.
- **Configurazione lati:** ogni faccia può essere ingresso, uscita, entrambi o chiusa; con
  "auto-espulsione" verso il blocco vicino.
- **Multiblocchi:** schema fisso di blocchi verificato quando lo si colpisce col martello;
  diventano un unico blocco logico con un blocco "master".
- **Valore in Materia (era 7):** calcolato automaticamente risalendo le ricette fino ai materiali
  grezzi, con valori base assegnati a mano per minerali, legno, pietra, mob drop.

---

## 9. Roadmap e stato

| Tappa | Contenuto | Stato |
|---|---|---|
| 1 | Stagno, acciaio (provvisorio in altoforno), polvere di ferro, scheda creativa | ✅ provata in gioco |
| 2 | Martello e tagliafili; piastre, ingranaggi, bacchette, fili; polveri; bronzo | 🧪 da provare in gioco |
| 3 | Altri minerali: piombo, argento, nichel, bauxite | ⏳ prossima |
| 4 | Forno a coke e altoforno multiblocco (acciaio vero) | ⏳ |
| 5 | Prima macchina: frantumatore a carbone + classe macchina base | ⏳ |
| 6 | Energia: generatore a combustione, cavi, batteria | ⏳ |
| 7 | Macchine elettriche: fornace, pressa, fonderia di leghe | ⏳ |
| 8 | Logistica: nastri e tubi | ⏳ |
| 9 | Upgrade, scavatrice, automazione delle risorse | ⏳ |
| 10 | Magazzino digitale e autocrafting | ⏳ |
| 11 | Materia, scanner, replicatore | ⏳ |

Regola: **una tappa alla volta**, e ogni tappa si prova in gioco (`runClient`) prima di passare alla successiva.

---

## 10. Note tecniche (per chi scrive il codice)

### Versioni
- Minecraft **26.3**, Fabric Loader 0.19.5, Fabric API 0.161.0+26.3, Java 25+.
- Gradle **9.7.0** (il plugin Loom `1.18-SNAPSHOT` richiede almeno la 9.7.0).
- Nomi Mojang (niente Yarn): `Item.Properties`, `BlockBehaviour.Properties`, `Identifier`, `ResourceKey`.

### Struttura
- Mod id `gedaindustry`, package `com.geda.gedaindustry`, classe principale `GedaIndustry`.
- `item/ModItems`, `block/ModBlocks`, `item/ModCreativeTab`, `world/ModWorldGen`.
- Risorse: `assets/gedaindustry/` (lang, modelli, texture, `items/`, `blockstates/`),
  `data/gedaindustry/` (recipe, loot_table, worldgen), tag in `data/minecraft/` e `data/c/`.

### Formati dati di 26.3 (attenzione, sono cambiati rispetto alle versioni vecchie)
- Ricette: ingredienti come stringhe semplici (`"gedaindustry:tin_ingot"`), risultato `{"id": ..., "count": ...}`.
- Loot table: `"modifier"` invece di `"functions"`; silk touch con `"condition": "minecraft:tool/can_silk_touch"`.
- Minerali nel mondo: cartella `worldgen/feature/` (non più `configured_feature/`), campi
  `size`/`targets` al primo livello (niente `"config"`), `"state"` come stringa semplice.
  `worldgen/placed_feature/` è invariata.
- Blocchi con oggetto: `BlockItemId.create(id, id)` + `useBlockDescriptionPrefix()`.
- Schede creative: `FabricCreativeModeTab.builder()`, eventi in `net.fabricmc.fabric.api.creativetab.v1`.
- Ingredienti tag nelle ricette: stringa `"#c:ingots/tin"` (niente oggetto `{"tag": ...}`).
- Attrezzi che restano nella griglia: override di `getCraftingRemainder(ItemStack)` che restituisce
  `ItemStackTemplate.fromNonEmptyStack(copiaDanneggiata)` oppure `null` (vedi `item/CraftingToolItem`).
- Ogni oggetto registrato con `ModItems.register` finisce in `ModItems.ALL` e quindi nella scheda creativa.
- Le risorse (JSON e texture provvisorie) sono generate da uno script Python fuori dal progetto:
  se le modifichi a mano, avvisa Claude così non le sovrascrive.

### Come provare
- In IntelliJ: pannello Gradle → `Tasks > fabric > runClient`.
- Da terminale: `.\gradlew.bat runClient` (Windows), `.\gradlew.bat build` per il jar in `build/libs/`.
- Se il mondo non si crea, l'errore preciso è in `run/logs/latest.log` (cercare "Registry loading errors").
