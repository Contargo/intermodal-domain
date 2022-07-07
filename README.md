Intermodal Domain
========================

**Note: As of 07.07.2022 this project is no longer actively maintained and therefore archived.**

[![](https://jitpack.io/v/Contargo/intermodal-domain.svg)](https://jitpack.io/#Contargo/intermodal-domain)

This project includes part of the old Contargo Business Domain 
as well as an API of DIN SPEC 91073 also known as DIGIT. 


## Getting started

Using the `intermodal-domain` as a library in your project, means
simply including it as a Maven dependency. We recommend using
[Jitpack](https://jitpack.io) to resolve the dependency:

```xml
<dependency>
  <!-- From Jitpack-repo -->
  <groupId>com.github.Contargo</groupId>
  <artifactId>intermodal-domain</artifactId>
  <version>${SOME-TAG}</version>
</dependency>
```

### How To Find The Right Class
If you are looking for a certain class you can use the text search 
and enter possible synonyms in English or German. Some classes contain 
synonyms e.g. a swap body is called Wechselbrücke in German but possible 
synonyms are Wechselbehälter and Wechselaufbau which are tagged as 
`@synonym_german` in the `SwapBody` class. 

Every class contains information about its affiliation tagged with 
`@source`. This can either be DIGIT, Contargo Domain or Contargo 
specific for additional enhancements which are not an official part 
of DIN SPEC 91073.

### How To Create An Object

To create an object you have to use the specific `Builder` of that 
object. Every builder is located in the corresponding class. Some 
classes that have mandatory fields contain an additional `StepBuilder`. 
Other than the normal `Builder` the `StepBuilder` will enforce the order 
in which fields are set until all fields that are part of the minimum 
requirements are set. Afterwards optional fields can be set in any order.

A new builder object is usually created with `newStepBuilder()` when mandatory 
fields are available. If a class does not have any minimal requirements 
the `newBuilder()` method is used instead. The example below shows how 
a `RegistrationVehicle` object is created with all of its possible 
information. If you are unsure on how to build a certain object 
or which fields exist and how they can be set you can take a look 
at its test class for more examples.

```java 
RegistrationVehicle registrationVehicle = RegistrationVehicle.newStepBuilder()
                .withTruck(...)
                .withDriver(...)
                .withHaulierClient(...)
                .withHaulierRealizing(...)
                .withDeliveryTime(...)
                .withLuOrder(...)
                .withChassis(...)
                .buildAndValidate();
```

### How To Check Validity
The validity of an object can be checked with the `buildAndValidate()` 
method. This is done to make sure all the minimum requirements of an 
object as specified in the DIGIT are set. If you do not want to check 
the validity of the object before you built it you can use the `build()` 
method instead. The minimum requirements of each class are document in 
the javadoc with the tag `@minimum_requirement`.

### How To Copy An Object

If you want to copy an object you can do so by adding it as an argument 
to the `newBuilder` method. This will create a new builder object which 
can be altered before building.
```java 
Barge copiedBarge = Barge.newBuilder(barge).buildAndValidate();
```

### How To Use Units And Unit Conversion
In some cases an information might be in a certain unit as shown above 
with the measurements of a barge. Since the DIGIT specifies the required 
unit the value will be converted if necessary. This means you can set your 
value in a different unit supported by the API as shown in the example below.

```java 
Barge.newBuilder()
.withLength(300.0, FOOT) // <-- will be converted to metres automatically
.buildAndValidate();
```

### How To Use Container Size Type Information
If you are building an ``Container`` object its ``size`` and ``type`` 
 will be calculated by its ``sizeType`` automatically. 
 
 ```java 
 Container.newBuilder()
 .withSizeType("45G0")
 ...
 ```

### How To Map Objects To JSON
The API uses [Jackson Annotations](https://github.com/FasterXML/jackson-annotations/wiki/Jackson-Annotations) to ensure the correct serialization/deserialization of its objects. To map objects to json and vice versa please use [Jackson Databind](https://github.com/FasterXML/jackson-databind).

Now you should be good to go for tagging types or linking to the
domain definitions (interfaces) from your source code.

### View locally

You may also build and read the Javadoc documentation locally,
using:

```bash
mvn javadoc:javadoc
```

You should be able to locally view the `target/site/apidocs/index.html`
document in any web browser.

## License

This project is distributed under the Apache 2.0 License. The full set of
terms and conditions can be seen in the [LICENSE](LICENSE) file.

Happy hacking!
