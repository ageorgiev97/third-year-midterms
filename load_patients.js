document.onload = loadXMLDoc

class Patient {
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    toString() {
        return this.firstName + " " + this.lastName;
    }
}

var patients = [];

function showAllPatients() {
    var patientsHTML = ""
    var tag = "<li class=\"list-group-item\">";
    patients.forEach(function (patient) {
        patientsHTML += tag + patient.toString() + "</li>";
    });
    document.getElementById("main-list").innerHTML = patientsHTML;
}


function addPatient() {
    var firstName = document.getElementById('firstName').value;
    var lastName = document.getElementById('secondName').value;

    patients.push(new Patient(firstName, lastName));
    showAllPatients();
}

function parsePatientsXML(xml) {
    // alert(xml)
    var parser = new DOMParser();
    var txt = "";
    var xmlDoc = parser.parseFromString(xml, "text/xml");
    // alert(xmlDoc.getElementsByTagName("firt-name")[1].childNodes[0].nodeValue)
    x = xmlDoc.getElementsByTagName("firt-name");
    y = xmlDoc.getElementsByTagName("second-name");

    for (i = 0; i < x.length; i++) {
        patients.push(new Patient(x[i].childNodes[0].nodeValue, y[i].childNodes[0].nodeValue))
    }
    showAllPatients();
    // alert(patients);
}

function loadXMLDoc() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            parsePatientsXML(this.responseText);
        }
    };
    xhttp.open("GET", "patients.xml", true);
    xhttp.send();
}