**Table of Contents**  *generated with [MarkdownTocGenerator](https://github.com/YuraAAA/Markdown-Toc-Generator/)
- [ Markdown-Toc-Generator](#markdown-toc-generator)
- [ How to use](#how-to-use)
  - [ Requirements](#requirements)
  - [ Usage](#usage)
    - [ Download](#download)
    - [ Options](#options)
      - [ Required options](#required-options)
      - [ Optional options](#optional-options)
    - [ Run](#run)
  - [ Create your own build](#create-your-own-build)
    - [ Requirements](#requirements)
    - [ Build](#build)




# Markdown-Toc-Generator
Generator of TOC (Table of content) for github readme.md file based on java

# How to use

## Requirements

Make sure you have installed java.
Go to console and type:
```sh
java -version
```

output:
```sh
java -version
java version "1.8.0_66"
Java(TM) SE Runtime Environment (build 1.8.0_66-b18)
Java HotSpot(TM) 64-Bit Server VM (build 25.66-b18, mixed mode)
```

## Usage

### Download

Download toc-generator.jar from root folder of this repository

### Options

All options set in next format:

-Dkey=value

#### Required options

Library uses two required options:

* src    - String, path to the source file
* target - String, path to the output file

#### Optional options

* deepLevel - Number, by default set to 4. Depth of constructed tree. 
   Minimal - 1, Maximal - 6
* replaceAt - String, by default is {toc.placeholder}. Place for TOC
* skipAltH1 - Boolean, by default false. Indicate about skip underline '=' header H1 format
* skipAltH2 - Boolean, by default false. Indicate about skip underline '-' header H2 format

### Run

Common format:
java ...args... -jar toc-generator.jar

For example,

```sh
java -Dsrc="readme.md" -Dtarget="readme_new.md" -DdeepLevel=6  -DskipAltH2=true -jar toc-generator.jar
```

You can see next output:
```sh
Configuration successfully created.
Configuration{source='readme.md', dest='readme_new.md', replaceAt='{toc.placeholder}', deepLevel=6, skipAltH1=false, skipAltH2=true}
```

Next progress output:
```sh
Progress 98,36 %
```

Next you can see created structure:

```
Structure:
- [ Markdown-Toc-Generator](#markdown-toc-generator)
- [ How to use](#how-to-use)
  - [ Requirements](#requirements)
  - [ Usage](#usage)
    - [ Download](#download)
    - [ Options](#options)
      - [ Required options](#required-options)
      - [ Optional options](#optional-options)
    - [ Run](#run)
  - [ Create your own build](#create-your-own-build)
    - [ Requirements](#requirements)
    - [ Build](#build)
```

If no errors was occurred, file will be generated and you can see
```sh
Done
```

## Create your own build

You can create your own jar.

### Requirements

Make sure you have maven and jdk installed.

```sh
javac -version
javac 1.8.0_31
```

```sh
mvn -version
Apache Maven 3.3.3 (7994120775791599e205a5524ec3e0dfe41d4a06; 2015-04-22T14:57:3
7+03:00)
Maven home: C:\apache-maven-3.3.3
Java version: 1.8.0_31, vendor: Oracle Corporation
Java home: C:\Program Files\Java\jdk1.8.0_31\jre
Default locale: ru_RU, platform encoding: Cp1251
OS name: "windows 8.1", version: "6.3", arch: "amd64", family: "dos"
```

### Build

```sh
mvn clean install
```

After maven build you will see toc-generator.jar in root folder (and in /target folder) of project.

