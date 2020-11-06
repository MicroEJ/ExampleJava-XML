# Overview

This project example shows how to parse an XML resource. It details how to use **KXml**, an **XML Pull** parser available from MicroEJ Central Repository.

For more information about XML pull parsing, please refer to http://www.xmlpull.org.


### Requirements

- MicroEJ SDK 5.x (tested on MicroEJ SDK 5.2.0)

### Project structure

- `src/`
  - Java sources
  - XML resources
- `module.ivy` : [Module description file](https://docs.microej.com/en/latest/ApplicationDeveloperGuide/mmm.html#module-description-file)
- `CHANGELOG.md`
- `LICENCE.md`
- `README.md` : This

### Configuration

This project has **KXmlParser** already added to its dependencies. To add **KXmlParser** to your own project, add the following line to your `module.ivy` or your `ivy.xml`:
``<dependency org="org.kxml2" name="kxml2" rev="2.3.2"/>``
You can look at this project's `module.ivy` file to see where to add the dependency line.

## Usage
To launch the application, right-click on the project, select _Run as_, _MicroEJ Application_ and choose a valid Platform in the menu. For more information on running this application on a hardware device, please refer to the "Getting started" tutorial on https://developer.microej.com/get-started/.

## Changes
- Simple example

## License
See the license file `LICENSE.md` located at the root of this repository.

---
_Markdown_  
_Copyright 2014-2020 MicroEJ Corp. All rights reserved._  
_Use of this source code is governed by a BSD-style license that can be found with this software._  
