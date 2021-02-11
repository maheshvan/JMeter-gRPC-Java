# JMeter-gRPC-Java

Objective is to able to send DATA to gRPC server using JMeter

Since JMeter is a Java open-source tool, Written all the Sampler code in Java, a custom-built sampler program to send DATA to gRPC powered micro services, cause no supporting plugins available for sending data in gRPC format using JMeter.

Below steps are required to load test a gRPC application:

      .Writing a gRPC client in Java
      .Writing a JMeter custom sampler in Java
      .Exporting project jar to JMeter external library folder
      .Using the custom Java Request sampler inside JMeter
      
pom.xml is included in the project, In the generated Sources folder, six Java classes will be generated for the given proto file. which are generate data access classes.

