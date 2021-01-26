# Java-oblig-1

## Teori

### Oppgave 1.1

Forklar hva kommandoene java og javac gjør.

### Oppgave 1.2

Forklar hva JRE (Java Runtime Environment) og JDK (Java Development Kit) er.

### Oppgave 1.3

Hva er en variabel?

### Oppgave 1.4

Forklar forskjellen på en klasse og et objekt. Vis gjerne et lite eksempel på hvordan man definerer en klasse, og oppretter et objekt.

### Oppgave 1.5

Hva er feil med denne koden?

```java
for (i = 0; i < 10; i++) {
  int sum;
  sum = sum + 1;
}
System.out.println("Sum is " + sum);
```

## Programmering

Dere skal kun benytte en teksteditor samt kommandolinja til å kompilere og kjøre koden dere lager i denne obligatoriske oppgaven. Altså ikke benytte IntelliJ eller lignende IDE'er. Dette gjør at dere får et forhold til hvordan Java-programmer kompileres før de kjører. Det er tilstrekkelig å levere .java filene dere lager, det er ikke nødvendig å levere de kompilerte .class filene.

### Oppgave 2.1

Lag programmet Hello World! ved hjelp av din favoritt teksteditor, og kjør dette ved hjelp av Java SDK i terminalen/kommandolinja.

### Oppgave 2.2

Gravitasjonen på månen er ca. 17 prosent av jordens. Skriv et program som beregner din vekt på månen.

### Oppgave 2.3

I denne oppgaven skal du lage to klasser, og vise at du kan lage en klasse og opprette nye objekter av denne klassen.

a - Lag en klasse som representerer en planet. Det vi ønsker å vite om en planet er navn, radius og gravitasjon (den skal altså ha disse instansvariablene). En planet skal kunne opprettes ved hjelp av en konstruktør på følgende måte:

```java
Planet mars = new Planet("Mars", 3389.5, 3.711);
```

Husk å gjøre instansvariablene private, og lag get- og set-metoder for disse. Da får vi en innkapsling (ett av prinsippene i OOP) av disse.

b - En klasse kalt "Oppgave2_3.java" som benytter Planet-klassen du akkurat har laget. Denne må ha en main-metode slik at du får kjørt den. Du skal her instansierernoen Planet-objekter og deretter skrive ut informasjon om disse til terminalen på følgende måte:
```
Planeten Mars har en radius på 3389.5 km og en gravitasjon på 3.711 m/s2
```

## Bousoppgaver
### Bonusoppgave 3.1
Du skal gjenbruke Planet-klassen du laget i oppgave 2.3 og lage en ny klasse som tar input fra terminalen til å opprette et objekt av Planet-klassen.

Lag en klasse med en main-metode som tar input fra terminalen. Det enkleste er nok å benytte Scanner (Lenker til en ekstern side.)-klassen som finnes i Java til dette. Benytt så inputen du får til å registrere data om en planet, opprette et planet objekt, og til slutt skrive ut data om denne.

En kjøring av programmet i terminalen vil se omtrent slik ut:

```
Skriv inn navn på planeten: Saturn
Skriv inn radius på planeten: 58232
Skriv inn gravitasjonen på planeten: 10.44

Saturn har en ratius på 58232.0 km og en gravitasjon på 10.44 m/s^2
```

### Bonusoppgave 3.2

Utvid bonusoppgave 3.1 til å kunne registrere et vilkårlig antall planeter etter hverandre. Sørg for å kunne avslutte applikasjonen.

### Bonusoppgave 3.3

Utvid bonusoppgave 3.2 til å holde på alle planetene du registrerer. Mellom hver registrering, legg til muligheten for å liste ut de planetene som er registrert tidligere, slette eller oppdatere en av dem, eller starte en ny registrering.
