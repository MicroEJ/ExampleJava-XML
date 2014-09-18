# Overview
This eclipse project presents how to parse XML in MicroEJ environment. It details how to use **XML Pull** parsers like **KXmlParser** and **MXParser**.

For more information about XML pull parsing, please refer to http://www.xmlpull.org.


### Requirements

- JRE 7 x86
- MicroEJ 3.0 at least

### Project structure

- `src/`
  - Java sources
  - XML resources
- `dist/`: when `build.ant` is called, a zip containing the project is created in this folder
- `launches/`: MicroEJ launches
- `lib/`: XML parsers libraries (available at http://www.xmlpull.org/impls.shtml)
- `build.ant`: ant build file meant to archive this project
- `LICENCE.md`
- `README.md`

### Configuration
Two different parsers are available: **KXmlParser** and **MXParser**. To switch between these parsers, open the build path (Right-click on the project, _Build Path_, _Configure Build Path_, _Libraries_), choose between `kxml2-2.3.0.jar` (KXmlParser) and `xpp3_min-1.1.4c.jar` (MXParser), remove the other one.

## Usage
To launch the application, right-click on the project, select _Run as_, _MicroEJ Application_ and choose _ReadPoem (Simulation)_. Another launcher is available to execute on the target board.

## Changes
- Simple example

## License
See the license file `LICENSE.md` located at the root of this repository.
