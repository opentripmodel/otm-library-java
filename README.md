# OTM Java Library

This Java library provides convenient tools and data structures for working with the Open Trip Model (OTM) version 5. It aims to simplify the integration of OTM data into Java-based applications, making it easier for shippers, carriers, software vendors, OEMs, and truck manufacturers to leverage real-time logistic trip data.

## About OTM

The Open Trip Model (OTM) specification is a lightweight data model designed to facilitate the exchange of real-time logistic trip data over the internet between various parties. Its goal is to streamline communication and enable the creation of multi-brand applications and services within the logistics and traffic ecosystem.

You can download the OpenAPI specification for OTM v5 [here](link to OpenAPI specification - replace with actual link).

## Features

This library offers:

* **Data model classes:** Java classes representing the core OTM entities (e.g., Trip, Location, Event). 
* **Parsing/Serialization utilities:** Functionality to easily convert between OTM JSON and Java objects. 

* **Support for OTM version 5.**

## Getting Started

### Prerequisites

* Java Development Kit (JDK) 8 or higher

### Installation

You can include this library in your project using Maven.

**Maven:**

```xml
<dependency>
    <groupId>[your group ID]</groupId>
    <artifactId>[your artifact ID]</artifactId>
    <version>[your version]</version>
</dependency>