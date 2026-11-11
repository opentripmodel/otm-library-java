# OTM Carbon Footprint (CO₂) profile

This toolkit implements the **OTM Carbon Footprint profile** for the standardized exchange of
CO₂ emission data in transport, as developed within the
[DALTI](https://www.dalti.nl/) program and maintained by
[SUTC](https://www.sutc.nl/) on the
[Semantic Treehouse](https://sutc.semantic-treehouse.nl/specifications).

> ⚠️ **Draft status** — the Carbon Footprint profile is still a *work in progress* at the OTM
> working group (see the
> [profile documentation](https://www.opentripmodel.org/docs/profiles/carbon-footprint)).
> This implementation follows the draft message models and the DALTI "Uniforme kernset CO₂e".
> The embedded JSON schemas (`src/main/resources/CarbonFootprint*Schema_0.1`) should be
> regenerated from the Semantic Treehouse once the profile is formally released.

## Scope

Two sub-profiles automate the information exchange between a carrier's TMS and a CO₂
calculation platform:

1. **CO₂ Calculation Input** — the trip data a TMS sends to the calculation platform: journey
   (load/unload stops with locations and times), vehicle, cargo and energy consumption.
2. **CO₂ Calculation Result** — the calculated emissions the platform returns to the carrier:
   total CO₂e emission, emission intensity and full transparency on the calculation method.

Reporting CO₂ emissions onwards to the customer (e.g. on the invoice) is out of scope.

## Model additions

Both sub-profiles are built around the standard OTM `trip` entity. The energy and emission
data travel as **context events** on the trip:

| Type | Purpose |
|---|---|
| `FuelConsumedEvent` | Energy (fuel/electricity/…) consumed by a vehicle, towed unit or hub over a period. Input for the CO₂ calculation. |
| `EmissionEvent` | A calculated CO₂e emission result (total + intensity) with its calculation method. |
| `EmissionCalculationMethod` | Transparency on the calculation: framework (e.g. GLEC 3.1), ISO reference (e.g. ISO 14083:2023), distance allocation (GCD/SFD), granularity, data classification (bronze…gold+) and the primary/modelled/default data distribution. |

Supporting enums: `EmissionDataType`, `EmissionDataGranularity`, `EmissionDataClassification`,
`DistanceAllocationMethod`. The existing `Fuel` enum is reused for energy sources.

`FuelConsumedEvent` and `EmissionEvent` follow the event types of the same name in the
**OTM 5.7 specification** (`eventType` discriminators `fuelConsumedEvent` / `emissionEvent`,
required `amount`, optional `fuel`/`method` and vehicle/consignment associations). The
kernset-specific fields that are not (yet) in the core specification — `periodStart`/`periodEnd`,
`emissionFactorStandard`, `emissionIntensity`, `calculationMethod` and the hub `location`
association — are Carbon Footprint profile extensions, marked as such in the Javadoc.

## Usage

Validate a trip before sending it to a calculation platform:

```java
import otm.profile.profiles.carbonfootprint.CarbonFootprintInputProfileValidator;

CarbonFootprintInputProfileValidator validator = new CarbonFootprintInputProfileValidator();
ValidationResult result = validator.validate(trip);

System.out.println(result); // pass/fail with reasons
```

Validate a result message received from a calculation platform:

```java
CarbonFootprintResultProfileValidator validator = new CarbonFootprintResultProfileValidator();
ValidationResult result = validator.validate(trip);
```

A runnable example that builds a compliant input and result trip, serializes them and
validates them:

```sh
mvn compile exec:java -Dexec.mainClass=otm.examples.CarbonFootprintExample
```

## Mapping of the DALTI kernset onto OTM

### Input dataset (Transportdata / Energiedata)

| Kernset element | OTM mapping |
|---|---|
| Identifier (bedrijf/order/zending) | `trip.id`, `trip.name`, consignment ids, `externalAttributes` |
| Opdrachtgever | `trip.actors[]` |
| Laad-/loslocatie (landcode, postcode) | stop `location.administrativeReference` (`country`, `postalCode` required) |
| Laad-/losadres (plaats/straat/geo) | `administrativeReference` fields / `geoReference` (conditional) |
| Voertuig-ID (kenteken) | `trip.vehicle.entity.licensePlate` (required) |
| Modaliteit | `trip.transportMode` (required) |
| Laaddatum | load stop `startTime` (required) |
| Laadeenheid (eenheid + aantal) | consignment `goods[]` (`quantity`, `weight`/`grossWeight`) |
| Energieverbruik (soort, aantal, normering, periode) | `FuelConsumedEvent` in `trip.contextEvents` (required) |
| Hubdata (HOC energieverbruik) | `FuelConsumedEvent` with a `location` association |
| Afstand (op stopniveau) | not yet in the core model — use `externalAttributes` (see *Known gaps*) |
| TOC / Transport type (cargo/container) | `externalAttributes` (see *Known gaps*) |

### Result dataset

| Kernset element | OTM mapping |
|---|---|
| Totale CO₂ emissie | `EmissionEvent.amount` (required) |
| Totale CO₂ emissie-intensiteit | `EmissionEvent.emissionIntensity` |
| Periode | `EmissionEvent.periodStart` / `periodEnd` (required) |
| Framework/versie, ISO-versie | `calculationMethod.framework` / `isoReference` (required) |
| Allocatie afstand methode (GCD/SFD) | `calculationMethod.distanceAllocationMethod` (required) |
| Data detailniveau | `calculationMethod.granularity` (required) |
| Data classificatie (brons…goud+) | `calculationMethod.dataClassification` (required) |
| Data type verdeling (primary/modelled/default) | `calculationMethod.dataTypeDistribution` |
| Voertuig-/hub-uitstoot | `EmissionEvent` with `vehicle` / `location` association |

## Known gaps (pending profile finalization)

Not every kernset element maps one-to-one onto the current OTM model; the OTM documentation
notes this may lead to proposed changes to the core `trip` model. Until then:

- **Distance per stop** ("Afstand, aantal kms") — no field on the stop action; if needed, use
  `externalAttributes` on the stop.
- **TOC** (Transport Operation Category, e.g. lane) — carrier's own choice; use
  `trip.externalAttributes.transportOperationCategory`.
- **Transport type** (cargo/container) — use `externalAttributes` on the vehicle or trip.
- **CO₂e/ton.km target (CPI)** on the input side — optional in the kernset; use
  `externalAttributes` when agreed between parties.

These conventions will be replaced by the formally released message model of the profile.
