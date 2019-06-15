# SpringFX

SpringFX (library for hybrid Spring Boot and JavaFX applications).

## Installation

### Maven

```xml
<repositories>
    <repository>
        <id>oss-bedra-net</id>
        <url>http://oss.bedra.net/repository/maven-public</url>
    </repository>
</repositories>

<dependency>
    <groupId>net.bedra.maciej</groupId>
    <artifactId>springfx</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

```gradle
repositories {
    maven {
        url('http://oss.bedra.net/repository/maven-public')
    }
}

dependencies {
    compile('net.bedra.maciej:springfx:1.0.0')
}
```

## About

Library was developed to make hybrid desktop JavaFX and Spring Boot applications easier to create. Main functionality is based on FXML views provider to avoid cross associations between FXML controllers. Every single controller that needs to load FXML view/component will store only one injected Java object (bean) that is responsible for serving ready to use FXML view. In the future releases more and more code boilerplate connected with creation of hybrid JavaFX and Spring Boot will be added.

My other repository [springfx_template](https://github.com/MashMB/springfx_template) shows in details how to use **SpringFX** library. This repository can be used as an flagship template for the new projects (like [Spring Initializr](https://start.spring.io/)). If there will be a lot of interest on this library I will prepare website for automatic project initialization.

Components of library are described in **Releases** section below, for detailed description you need download API documentation that can be found here: [SpringFX API documentation](https://github.com/MashMB/springfx/tree/master/releases/1.0.0/docs).

## Releases

### Release 1.0.0

- FXMLProvider:
  - getApplicationContext (get application context created from Spring Boot annotations config context)
  - getPrimaryStage (get primary stage of JavaFX saved in FXML views provider that represents main window of application)
  - addView (add new FXML view to FXML views provider collection)
  - getView (get FXML view from FXML views provider collection)
  - loadScene (load FXML view to the whole window that is marked as JavaFX primary stage)
  - loadView (load FXML view to any compatible JavaFX component)
  - setLanguagePack (set resource bundle for FXML provider and transfer it to FXML views controllers)
  - setPrimaryStage (set primary stage of JavaFX in FXML views provider that represents main window of application)

- ColorsPalette:
  - addColor (add new color to application colors palette)
  - getColor (get color saved in application colors palette)

## LICENSE

The MIT License (MIT)

Copyright (c) 2019 Maciej Bedra

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.