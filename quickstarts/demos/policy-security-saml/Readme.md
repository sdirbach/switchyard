Introduction
============
This quickstart demonstrates how policy can be used to control the security characteristics of a
service invocation.  The only service in the application is a Bean service called "WorkService".
SSL is used for "confidentiality", and SAML Assertion is used for "clientAuthentication".


Running the quickstart
======================

EAP
----------
1. Start JBoss EAP in standalone mode:

        ${AS}/bin/standalone.sh

2. Build and deploy the quickstart

        mvn install -Pdeploy

3. Execute the test. (See "Options" section below.)

4. Check the server console for output from the service.

5. Undeploy the application

        mvn clean -Pdeploy



Wildfly
----------


1. Start Wildfly in standalone mode :

        ${AS}/bin/standalone.sh

2. Build and deploy the demo :

        mvn install -Pdeploy -Pwildfly

3. Execute the test. (See "Options" section below.)

4. Check the server console for output from the service.

5. Undeploy the application

        mvn clean -Pdeploy -Pwildfly

Warning --> Wildfly 8.0.0 When the application is undeployed, it is required to restart the server to get all the undeployment changes done.



Options
=======

When running with no options:

    mvn exec:java

You will be hitting the http (non-SSL) URL, and see this in your log:

    Caused by: org.switchyard.exception.SwitchYardException: Required policies have not been provided: clientAuthentication confidentiality

When running with this option:

    mvn exec:java -Dexec.args="confidentiality clientAuthentication" -Djavax.net.ssl.trustStore=connector.jks

You will be hitting the https (SSL) URL and providing authentication information, and see this in your log:

    :: WorkService :: Received work command => CMD-1398967051060 (caller principal=UserPrincipal@1045975928[name=admin])

    (Because the WorkService is secured, you will see the not-null principal.)

You can play with the exec.args and only specify one of "confidentiality" or "clientAuthentication". I bet you can guess what will happen... ;)
