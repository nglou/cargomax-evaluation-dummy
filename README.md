# cargomax-evaluation-dummy

This is ported from http://jira.champ.aero/browse/CSP-122310

## Overview of solution:

To be able to properly test BPE interfaces with the Sabre Endpoint, a dummy webservice has been created to imitate the same requests / responses of this activity. No changes were done at CSP end regarding wsdl / xsd definitions.

Installation instructions:

1. Export the eclipse maven project from its SVN location
    http://svn.champ.aero/subversion/repo/CSP/trunk/csp-mvn-modules-pom/csp-build-post-pom/csp-ws-pom/cargomax-evaluation-dummy/
2. Run "mvn clean install" on the pom.xml
3. Get the generated WAR file and deploy to your tomcat installation
4. A successful install would land you into the main page like below when viewed from browser:

<picture>

## Relevant CSP program.ini settings:

1. url and schemaUrl needs to point to your tomcat installation 

```ini
[CargoMaxBpe]
BpeEvaluation=Y
url=http://tomcatserver:port/cargomax-evaluation-dummy/BookingEvaluationService
exportCurrency=USD
schemaValidation=Y
schemaUrl=http://tomcatserver:port/cargomax-evaluation-dummy/BookingEvaluationService?xsd=1
username=user
password=pass
AdhocEvaluationBehaviour=Y
hubStationForBPE=AUH
targetnamespace=http://webservices.sabre.com/cargo/BookingTypes/v1
tries=5
reviewRequestSenderThreadInterval=30
connectTimeout=3000
requestTimeout=5000
priceClassNoEval=DENSE
bpeToleranceCheck=3000;20
defaultAcceptanceMinutes=360
```

```ini
[CargoMaxBooking]
hostCarriers=XS
```

## Usage instructions: 

Change urls to point to correct server of your installation)
1. Use SoapUI to send sample requests. The wsdl urls can be used to create the SoapUI project; http://tomcatserver:port/cargomax-evaluation-dummy/BookingEvaluationService?wsdl
2. All back and forth requests / responses are listed in the main page; http://tomcatserver:port/cargomax-evaluation-dummy
3. Configure your Cargospot installation as mentioned on previous section to point it to the dummy webservice
4. Trigger BPE communication from CSP bookings as SOP, the current default response status would be used on the responses.
